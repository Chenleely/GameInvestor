package com.example.gameinvestor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    private String userName="";
    private String userPassword="";
    private Button login_button;
    private EditText input_name_editText;
    private EditText input_password_editText;

    private boolean loginCheck(){
        String input_name=input_name_editText.getText().toString();
        String input_password=input_password_editText.getText().toString();
        if(input_name.equals(userName)&&input_password.equals(userPassword)){
            Intent intent=new Intent(MainActivity.this,ClubListActivity.class);
            MainActivity.this.finish();
            startActivity(intent);
            return true;
        }else if (input_name.equals("")||input_password.equals("")){
            Toast.makeText(MainActivity.this,"请输入账户名或密码",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!input_name.equals(userName)||!input_password.equals(userPassword)){
            Toast.makeText(MainActivity.this,"账户名或密码错误",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return false;
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        login_button=(Button) findViewById(R.id.Login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();

            }
        });
        input_name_editText=(EditText) findViewById(R.id.input_user_name);
        input_password_editText=(EditText) findViewById(R.id.input_user_password);
        getSupportActionBar().hide();
    }


}
