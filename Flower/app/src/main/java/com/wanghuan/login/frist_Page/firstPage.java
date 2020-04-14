package com.wanghuan.login.frist_Page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.wanghuan.login.R;

import java.util.ArrayList;
import java.util.List;

public class firstPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toast.makeText(getApplicationContext(), "111", Toast.LENGTH_SHORT).show();
    }
}
