package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.model.User;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class my_pwd extends AppCompatActivity {
    private EditText pwd;
    private EditText pwd1;
    private Button btn_changePwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pwd);
        pwd = (EditText) findViewById(R.id.et_changePwd);
        pwd1 = (EditText) findViewById(R.id.et_changePwd1);
        btn_changePwd = (Button) findViewById(R.id.btn_changePwd);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        btn_changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"111111111！",Toast.LENGTH_SHORT).show();
                String pwd = pwd1.getText().toString();
                if (validate()){
                    try {
                        User user = changePwd(userId, pwd);
                        if (user.getCode() == 0){
                            Toast.makeText(getApplicationContext(),"修改成功！",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"修改失败！",Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"服务器异常，请稍后再试……",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validate(){
        String pwdStr = pwd.getText().toString();
        String pwd1Str = pwd1.getText().toString();
        if ("".equals(pwdStr) || "".equals(pwd1Str)){
            Toast.makeText(getApplicationContext(),"密码不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pwdStr.equals(pwd1Str)){
            return true;
        }else{
            Toast.makeText(getApplicationContext(),"密码不一致！",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    //修改密码
    public User changePwd(String userId, String pwd) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("pwd", pwd);
        String url = HttpUtil.BASE_URL + "users/changePwd";
        String result = HttpUtil.getInfo(url, map);
        Gson gson = new Gson();
        User user = gson.fromJson(result,User.class);
        return user;
    }
}
