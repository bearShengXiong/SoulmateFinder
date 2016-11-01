package com.example.shengxiong.soulmatefinder.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shengxiong.soulmatefinder.BackGroundTask;
import com.example.shengxiong.soulmatefinder.R;

public class MainActivity extends AppCompatActivity {


    private EditText mNameText, mPassWord;
    String login_name, login_pass;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameText = (EditText)findViewById(R.id.editTextName);
        mPassWord = (EditText)findViewById(R.id.editText);
        mStartButton =(Button)findViewById(R.id.startbutton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameText.getText().toString();
                userLogin(view);



            }
        });
    }
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void userReg(View view){
        startActivity(new Intent(this,RegistrationActivity.class));
    }

    public void userLogin(View view){

        login_name = mNameText.getText().toString();
        login_pass = mPassWord.getText().toString();
        setDefaults("username",login_name,this);
        String method = "login";
        BackGroundTask backGroundTask = new BackGroundTask(this);
        backGroundTask.execute(method,login_name,login_pass);
    }

}
