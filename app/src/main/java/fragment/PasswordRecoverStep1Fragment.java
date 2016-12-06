package fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.helloworld.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class PasswordRecoverStep1Fragment extends Fragment{
    SimpleTextInputCellFragment fragEmail;
    Button btnNext;
    View view;
    OnGoNextListener onGoNextListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(view ==null){
            view  = inflater.inflate(R.layout.fragment_password_recover_step1,container);
            fragEmail = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.frag_email);
            btnNext = (Button) view.findViewById(R.id.btn_next);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onGoNextListener.onGoNext();
                }
            });
        }

        return view;
    }

    public static interface OnGoNextListener{
        public void onGoNext();
    }

    public void setOnGoNextListener(OnGoNextListener onGoNextlistener){
        this.onGoNextListener = onGoNextListener;
    }
}

