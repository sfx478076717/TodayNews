package com.ziqi.todaynews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/5/22.
 */

public class RegActivity extends AppCompatActivity {

    private Button btn_regReal;
    private EditText reg_user;
    private EditText reg_pass;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        btn_regReal = (Button) findViewById(R.id.btn_regReal);
        reg_user = (EditText) findViewById(R.id.reg_user);
        reg_pass = (EditText) findViewById(R.id.reg_pass);

        btn_regReal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String username = reg_user.getText().toString();
                String password = reg_pass.getText().toString();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(RegActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    dbHelper = new DBHelper(getApplication());
                    boolean state = dbHelper.register(username,password);
                    if(state == true){
                        Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegActivity.this, "注册失败，请重试。", Toast.LENGTH_SHORT).show();
                    }
                }
 
            }
        });


    }
}

