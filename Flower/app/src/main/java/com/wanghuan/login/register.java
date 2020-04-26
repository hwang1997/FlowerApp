package com.wanghuan.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.model.User;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;


public class register extends AppCompatActivity {
    private EditText loginId;
    private EditText userName;
    private EditText psw;
    private EditText pswAgain;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginId = (EditText) findViewById(R.id.et_loginId);
        userName = (EditText) findViewById(R.id.et_user_name);
        psw = (EditText) findViewById(R.id.et_psw);
        pswAgain = (EditText) findViewById(R.id.et_psw_again);
        btn_register = (Button) findViewById(R.id.btn_register);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginIdStr = loginId.getText().toString();
                String userNameStr = userName.getText().toString();
                String pswStr = psw.getText().toString();
                String role = "1";
                if (validate()){
                    try {
                        User user = register(loginIdStr, userNameStr, pswStr, role);
                        if (user.getCode() == 0){
                            Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT).show();
                            delay();
                        }else {
                            Toast.makeText(getApplicationContext(), user.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "服务器异常，请稍后重试！", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    public Boolean validate(){
        String loginIdStr = loginId.getText().toString();
        String userNameStr = userName.getText().toString();
        String pswStr = psw.getText().toString();
        String pswAgainStr = pswAgain.getText().toString();
        if ("".equals(loginIdStr)){
            Toast.makeText(getApplicationContext(), "登陆账号不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }else if (loginIdStr.length() < 6){
            Toast.makeText(getApplicationContext(), "登陆账号大于6位！", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(userNameStr)){
            Toast.makeText(getApplicationContext(), "用户名不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(pswStr) || "".equals(pswAgainStr)){
            Toast.makeText(getApplicationContext(), "密码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }else if (pswStr.length() < 4 || pswAgainStr.length() <6){
            Toast.makeText(getApplicationContext(), "密码长度应大于6位！", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!pswStr.equals(pswAgainStr)){
            Toast.makeText(getApplicationContext(), "两次密码不一致！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public User register(String loginId, String userName, String pwd, String role) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("loginId", loginId);
        map.put("userName", userName);
        map.put("userPassword", pwd);
        map.put("role", role);
        String url = HttpUtil.BASE_URL + "users/insertUsers";
        String result = HttpUtil.getInfo(url, map);
        Gson gson = new Gson();
        User user = gson.fromJson(result, User.class);
        return user;
    }
    private void delay() {
        Handler handler;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
