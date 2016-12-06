package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.helloworld.R;

/**
 * Created by Administrator on 2016/12/6.
 */

public class PasswordRecoverStep2Fragment extends Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view  = inflater.inflate(R.layout.fragment_password_recover_step2,container);
        }
        return view;
    }
}
