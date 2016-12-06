package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import com.example.administrator.helloworld.R;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/12/5.
 */
public class SimpleTextInputCellFragment extends Fragment{
    TextInputLayout edit_layout;
    EditText edit_text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_inputcell_simpletext,container);
        edit_layout = (TextInputLayout) view.findViewById(R.id.til_text);
        edit_text = (EditText) view.findViewById(R.id.edit_text);
        return view;
    }
    public void setHintText(String hintText){
        edit_layout.setHint(hintText);
    }
    public void setIsPassword(boolean isPassword){
        if(isPassword){
            edit_text.setInputType(EditorInfo.TYPE_CLASS_TEXT|EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        }else{
            edit_text.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        }

    }
}
