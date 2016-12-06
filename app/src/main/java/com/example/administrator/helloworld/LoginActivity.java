package com.example.administrator.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import fragment.SimpleTextInputCellFragment;

public class LoginActivity extends Activity {

    TextView tvFogetPassword;
    Button btnRegister;
    Button btnLogin;
    SimpleTextInputCellFragment fragmentUserText;
    SimpleTextInputCellFragment fragmentPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        tvFogetPassword = (TextView) findViewById(R.id.tv_forget_password);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);
        fragmentUserText = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.frag_username);
        fragmentPassword = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.frag_password);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itnt = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(itnt);
            }
        });
        tvFogetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itnt = new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(itnt);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentUserText.setHintText("用户名");
        fragmentUserText.setIsPassword(false);
        fragmentPassword.setHintText("密码");
        fragmentUserText.setIsPassword(true);
    }
}
