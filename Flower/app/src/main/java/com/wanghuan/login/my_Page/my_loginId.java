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

public class my_loginId extends AppCompatActivity {
    private EditText loginId;
    private Button btn_updateLoginId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login_id);
        loginId = (EditText) findViewById(R.id.et_login_id);
        btn_updateLoginId = (Button) findViewById(R.id.btn_updateLoginId);
        Intent intent = getIntent();
        String loginIdStr = intent.getStringExtra("loginId");
        loginId.setHint(loginIdStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        btn_updateLoginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    String newLoginId = loginId.getText().toString();
                    try {
                        User user = changeLoginId(userId, newLoginId);
                        if (user.getCode() == 0){
                            intent.putExtra("loginId", newLoginId);
                            setResult(0, intent);
                            Toast.makeText(getApplicationContext(), "修改成功！", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "修改失败," + user.getMessage(), Toast.LENGTH_SHORT).show();
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
        String newloginIdStr = loginId.getText().toString();
        if ("".equals(newloginIdStr)) {
            Toast.makeText(getApplicationContext(), "登录账号不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (newloginIdStr.length() < 6 ){
            Toast.makeText(getApplicationContext(), "请输入6-11位数登录账号", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    //修改登录账号
    public User changeLoginId(String userId, String newLoginId) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("loginId", newLoginId);
        String url = HttpUtil.BASE_URL + "users/changeLoginId";
        String result = HttpUtil.getInfo(url, map);
        Gson gson = new Gson();
        User user = gson.fromJson(result, User.class);
        return user;
    }
}
