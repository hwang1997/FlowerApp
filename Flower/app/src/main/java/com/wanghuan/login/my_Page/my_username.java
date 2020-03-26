package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wanghuan.login.R;


public class my_username extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_username);
    }

    public void my_username_okBtn(View view){
//        Intent intent = new Intent(getApplicationContext(), home.class);
//        startActivity(intent);
        Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
        finish();
    }
}
