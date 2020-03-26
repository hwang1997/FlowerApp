package com.wanghuan.login.my_Page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wanghuan.login.R;

public class my_pwd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pwd);
    }
    public void my_pwd_okBtn(View view){
        Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}
