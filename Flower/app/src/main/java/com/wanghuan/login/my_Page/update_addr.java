package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;

public class update_addr extends AppCompatActivity {
    private EditText addr_address;
    private EditText addr_name;
    private EditText addr_tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_addr);
        initView();
    }
    public void initView(){
        Intent intent = getIntent();
        addr_address = (EditText) findViewById(R.id.et_addr_address);
        addr_name = (EditText) findViewById(R.id.et_addr_name);
        addr_tel = (EditText) findViewById(R.id.et_addr_tel);

        addr_address.setText(intent.getStringExtra("address"));
        addr_name.setText(intent.getStringExtra("name"));
        addr_tel.setText(intent.getStringExtra("tel"));

    }
    public void my_addr_okBtn(View view){

        addr_address = (EditText) findViewById(R.id.et_addr_address);
        addr_name = (EditText) findViewById(R.id.et_addr_name);
        addr_tel = (EditText) findViewById(R.id.et_addr_tel);
        Toast.makeText(getApplicationContext(),addr_name.getText(),Toast.LENGTH_SHORT).show();
        delay();
    }

    private void delay(){
        Handler handler;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },2000);
    }
}
