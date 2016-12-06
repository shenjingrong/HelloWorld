package fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.helloworld.R;

import java.io.IOException;

/**
 * Created by Administrator on 2016/12/5.
 */

public class PictureInputCellFragment extends Fragment{
    int REQUESTCODE_CEMERA = 1;
    int REQUESTCODE_ALBUM = 2;
    ImageView imageView;
    TextView labelText;
    TextView hintText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inputcell_pitcure,container);

        imageView  = (ImageView) view.findViewById(R.id.image);
        labelText = (TextView) view.findViewById(R.id.label);
        hintText = (TextView) view.findViewById(R.id.hint);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageViewClick();
            }
        });

        return view;
    }

    public void setLabelText(String label){
        labelText.setText(label);
    }
    public void setHintText(String hint){
        hintText.setHint(hint);
    }
    void onImageViewClick(){
        String[] items={
                "拍照",
                "相册"
        };
        new AlertDialog.Builder(getActivity())
                .setTitle(labelText.getText())
                .setItems(items,new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                takePhoto();
                                break;
                            case 1:
                                pickFromAlbum();
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setNegativeButton("取消",null)
                .show();
    }
    public void takePhoto(){
        Intent itnt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(itnt,REQUESTCODE_CEMERA);
    }
    public void pickFromAlbum(){
        Intent itnt = new Intent(Intent.ACTION_GET_CONTENT);
        itnt.setType("image/*");
        startActivityForResult(itnt,REQUESTCODE_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(resultCode == Activity.RESULT_CANCELED) return;
            if(requestCode == REQUESTCODE_CEMERA){
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bmp);
            }else if(requestCode == REQUESTCODE_ALBUM){
                try {
                    Bitmap bmp = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),data.getData());
                    imageView.setImageBitmap(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
