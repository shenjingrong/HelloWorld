package com.example.administrator.helloworld;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragment.PictureInputCellFragment;
import fragment.SimpleTextInputCellFragment;

public class RegisterActivity extends Activity {

    SimpleTextInputCellFragment fragInputCellAccount;
    SimpleTextInputCellFragment fragInputCellPassword;
    SimpleTextInputCellFragment fragInputCellPasswordRepeat;
    PictureInputCellFragment fragmentPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fragInputCellAccount = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_account);
        fragInputCellPassword = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_passwod);
        fragInputCellPasswordRepeat = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_password_repeat);
        fragmentPicture  = (PictureInputCellFragment) getFragmentManager().findFragmentById(R.id.image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragInputCellAccount.setHintText("请输入用户名");
        fragInputCellAccount.setIsPassword(false);
        fragInputCellPassword.setHintText("请输入密码");
        fragInputCellPassword.setIsPassword(true);
        fragInputCellPasswordRepeat.setHintText("请重复输入密码");
        fragInputCellPasswordRepeat.setIsPassword(true);
        fragmentPicture.setLabelText("添加头像");
        fragmentPicture.setHintText("请选择图片");
    }

}
