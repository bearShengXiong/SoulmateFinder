package com.example.shengxiong.soulmatefinder.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.shengxiong.soulmatefinder.BackGroundTask;
import com.example.shengxiong.soulmatefinder.R;

public class RegistrationActivity extends Activity {

    EditText ET_Email, ET_USER_NAME,ET_USER_PASS;
    String user_email,user_name,user_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ET_Email = (EditText)findViewById(R.id.editTextEmail);
        ET_USER_NAME =(EditText)findViewById(R.id.editTextUserName);
        ET_USER_PASS = (EditText)findViewById(R.id.editTextPassWord);
    }
    public void userReg(View view){
        user_email = ET_Email.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        String method = "register";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,user_email,user_name,user_pass);
        finish();

    }
}
