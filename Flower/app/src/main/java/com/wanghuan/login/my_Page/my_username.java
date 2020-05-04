package com.wanghuan.login.my_Page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.model.User;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;


public class my_username extends AppCompatActivity {
    private EditText newUsername;
    private Button btn_updateUsername;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_username);
        newUsername = (EditText) findViewById(R.id.et_user_name);
        btn_updateUsername = (Button) findViewById(R.id.btn_updateUsername);
        intent = getIntent();
        String newUsernameHint = intent.getStringExtra("userName");
        newUsername.setHint(newUsernameHint);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");

        btn_updateUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsernameStr = newUsername.getText().toString();
                if (validate()) {
                    try {
                        User user = changeUsername(userId, newUsernameStr);
                        if (user.getCode() == 0) {
                            intent.putExtra("name", newUsernameStr);
                            setResult(0, intent);
                            Toast.makeText(getApplicationContext(), "修改成功！", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "修改失败！", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "服务器异常，请重新操作!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validate() {
        String newUsernameStr = newUsername.getText().toString();
        if ("".equals(newUsernameStr)) {
            Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    //修改用户名
    public User changeUsername(String userId, String newUserName) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("user_name", newUserName);
        String url = HttpUtil.BASE_URL + "users/changeUsername";
        String result = HttpUtil.getInfo(url, map);
        Gson gson = new Gson();
        User user = gson.fromJson(result, User.class);
        return user;
    }

}
