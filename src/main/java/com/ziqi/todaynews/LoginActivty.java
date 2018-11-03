package com.ziqi.todaynews;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivty extends AppCompatActivity {

    private EditText et_user;//用户名输入框
    private EditText et_pass;//密码输入框
    private CheckBox rememberPass;//记住密码
    private CheckBox autoLogin;//自动登录
    private Button login;//登录按钮
    private Button reg;//注册按钮

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private DBHelper dbHelper;
    //private Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        try{
//            Bundle bundle = this.getIntent().getExtras();//新页面接收数据
//            flag  = bundle.getBoolean("flag");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        rememberPass = (CheckBox) findViewById(R.id.cb_rememberPass);
        autoLogin = (CheckBox) findViewById(R.id.cb_autoLogin);
        login = (Button) findViewById(R.id.btn_login);
        reg = (Button) findViewById(R.id.btn_reg);

        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        et_user.setText(sharedPreferences.getString("username",null));
        et_pass.setText(sharedPreferences.getString("password",null));
        rememberPass.setChecked(sharedPreferences.getBoolean("remember",false));
        boolean auto_login = sharedPreferences.getBoolean("autoLogin",false);
//        if(auto_login == true){
//            Intent intent = new Intent(LoginActivty.this,MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = et_user.getText().toString();
                String password = et_pass.getText().toString();

                dbHelper = new DBHelper(getApplicationContext());

                boolean state = dbHelper.login(username,password);

                if(state == true){
                    Toast.makeText(LoginActivty.this, "用户名密码正确", Toast.LENGTH_SHORT).show();

                    if(rememberPass.isChecked()){
                        editor.putString("username",username);
                        editor.putString("password",password);
                        editor.putBoolean("remember",true);
                        editor.commit();
                        if(autoLogin.isChecked()){
                            editor.putBoolean("autoLogin",true);
                            editor.commit();
                        }
                    }
                    Intent intent = new Intent(LoginActivty.this,MainActivity.class);
                    MainActivity.flag = true;
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivty.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    //et_user.setText("");
                    et_pass.setText("");
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivty.this,RegActivity.class);
                startActivity(intent);
            }
        });

    }
}
