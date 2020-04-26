package com.wanghuan.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.model.User;
import com.wanghuan.login.util.HttpUtil;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {
    private EditText usernameStr;
    private EditText passwordStr;
    private Button loginBtn;

    public void register(View view) {
        Intent intent = new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }


    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameStr = (EditText) findViewById(R.id.et_user_name);
        passwordStr = (EditText) findViewById(R.id.et_psw);

        loginBtn = (Button) findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录校验
                if (validate()) {
                    //如果登录成功
                    //获取用户名、密码
                    String username = usernameStr.getText().toString();
                    String password = passwordStr.getText().toString();
                    try {
                        User user = query(username, password);
                        if (user.getCode() == 0) {
                            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(getApplicationContext(), home.class);
                                    SharedPreferences.Editor editor = getSharedPreferences("user",Context.MODE_PRIVATE).edit();
                                    editor.putInt("userId",user.getData().getUserId());
                                    editor.putString("loginId",user.getData().getLoginId());
                                    editor.putString("userName",user.getData().getUserName());
                                    editor.commit();
                                    startActivity(intent);
                                    finish();
                                }
                            }, 1000);
                        }else{
                            Toast.makeText(getApplicationContext(), user.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "服务器异常，请重新登录！", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    //对用户名、密码进行校验
    private boolean validate(){
        String username = usernameStr.getText().toString().trim();
        String password = passwordStr.getText().toString().trim();

        if (username.equals("")){
            Toast.makeText(getApplicationContext(),"用户名是必填项！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.equals("")){
            Toast.makeText(getApplicationContext(),"密码是必填项！",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    //定义发送请求的方法
    private User query(String username, String password) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("login_id", username);
        map.put("user_password", password);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "users/applogin";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        User user = gson.fromJson(result,User.class);
        return user;

    }

}
