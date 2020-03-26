package com.wanghuan.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;


public class login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private String usernameStr;
    private String passwordStr;
    private final int LOGINSUCCESS = 0;
    private final int LOGINNOTFOUND = 1;
    private final int LOGINEXCEPT = 2;
    private final int REGISTERSUCCESS = 3;
    private final int REGISTERNOTFOUND = 4;
    private final int REGISTEREXCEPT = 5;

    @SuppressLint("Handlerleak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case LOGINSUCCESS:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
                case LOGINNOTFOUND:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
                case LOGINEXCEPT:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
                case REGISTERSUCCESS:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
                case REGISTERNOTFOUND:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
                case REGISTEREXCEPT:
                    Toast.makeText(getApplicationContext(),(String)msg.obj,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    public void register(View view){
        Intent intent = new Intent(getApplicationContext(), register.class);
        startActivity(intent);
    }
    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), home.class);
        startActivity(intent);
    }
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.et_user_name);
        password = (EditText) findViewById(R.id.et_psw);
    }

//    public void login(View v){
//        usernameStr = username.getText().toString().trim();
//        passwordStr = password.getText().toString().trim();
//
//        if (usernameStr.equals("") || passwordStr.equals("")){
//            Toast.makeText(login.this, "用户名或密码不能为空",Toast.LENGTH_LONG).show();
//        } else {
//          new Thread()  {
//              private HttpURLConnection connection;
//              @Override
//              public void run(){
//                  try {
//                      String data2 = "username" + URLEncoder.encode(usernameStr,"utf-8")+"&password="+URLEncoder.encode(passwordStr,"utf-8")+"&sign="+URLEncoder.encode("1","utf-8");
//                      connection = HttpConnectionUtils.getConnection(data2);
////                      int code = connection.getResponseCode();
//                      int code = 200;
//                      if (code == 200){
//                          InputStream inputStream = connection.getInputStream();
//                          String str = StreamChangeStrUtils.toChange(inputStream);
//                          Message message = Message.obtain();
//                          message.obj = str;
//                          message.what = REGISTERSUCCESS;
//                          handler.sendMessage(message);
//                      }else {
//                          Message message = Message.obtain();
//                          message.what = REGISTERNOTFOUND;
//                          message.obj = "注册异常……请稍后再试";
//                          handler.sendMessage(message);
//                      }
//                  }catch (Exception e){
//                      e.printStackTrace();
//                      Message message = Message.obtain();
//                      message.what = REGISTEREXCEPT;
//                      message.obj = "服务器异常……请稍后再试";
//                      handler.sendMessage(message);
//                  }
//              }
//          }.start();
//        }
//    }
}
