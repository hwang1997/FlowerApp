package com.wanghuan.login.frist_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class goodsInfoActivity extends AppCompatActivity {
    private ImageView goodsImage;
    private TextView goodsId;
    private TextView goodsName;
    private TextView goodsPrice;
    private TextView goodsCount;
    private TextView goodsDes;
    private EditText goodsBuyCount;
    private Button joinBus;
    private Button buyFast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();

//        Toast.makeText(getApplicationContext(),intent.getStringExtra("goodsId"),Toast.LENGTH_SHORT).show();
        goodsImage = (ImageView) findViewById(R.id.iv_goodInfo_image);
        goodsId = (TextView) findViewById(R.id.tv_goodInfo_goodId);
        goodsName = (TextView) findViewById(R.id.tv_goodInfo_goodName);
        goodsPrice = (TextView) findViewById(R.id.tv_goodInfo_goodPrice);
        goodsCount = (TextView) findViewById(R.id.tv_goodInfo_goodCount);
        goodsDes = (TextView) findViewById(R.id.tv_goodInfo_goodDes);
        joinBus = (Button) findViewById(R.id.btn_goodInfo_bus);
        buyFast = (Button) findViewById(R.id.btn_goodInfo_buy);

        goodsImage.setImageResource(R.mipmap.flower);
        goodsId.setText(String.valueOf(intent.getStringExtra("goodsId").trim()));
        goodsName.setText(intent.getStringExtra("goodsName"));
        goodsPrice.setText("￥" + intent.getStringExtra("goodsPrice"));
        goodsCount.setText(intent.getStringExtra("goodsCount"));
        goodsDes.setText(intent.getStringExtra("goodsDes"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        buyFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "立即购买", Toast.LENGTH_SHORT).show();
            }
        });
        joinBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Bus> busList = new ArrayList<>();

                goodsBuyCount = (EditText) findViewById(R.id.tv_goodInfo_goodBuyCount);

                int goodsId1 = Integer.parseInt(goodsId.getText().toString());
                String goodsBuyCount1 = goodsBuyCount.getText().toString();


                Toast.makeText(getApplicationContext(), "加入购物车", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
