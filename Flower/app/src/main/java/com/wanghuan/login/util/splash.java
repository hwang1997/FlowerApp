package com.wanghuan.login.util;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.wanghuan.login.R;
import com.wanghuan.login.login;

public class splash extends Activity{
    private TextView textView;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.btn_bar);
        initView();
    }
    private void initView(){

        timer = new CountDownTimer(5000,10) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("跳过" + (millisUntilFinished/1000 + 1));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
                textView.setClickable(true);
            }
        };
        timer.start();
    }
    public void jumpTo(View view){
        Intent intent = new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        if (timer!=null){
            timer.cancel();
        }
        super.onDestroy();
    }
}
