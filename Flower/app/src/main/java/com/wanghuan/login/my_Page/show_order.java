package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;

public class show_order extends AppCompatActivity {
    private TextView orderId;
    private ImageView goodsImage;
    private TextView price;
    private TextView amount;
    private TextView sumPrice;
    private TextView orderName;
    private TextView orderTel;
    private TextView orderAddress;
    private TextView orderPay;
    private TextView orderState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        initView();
        initEven();

    }
    public  void initEven(){
        Intent intent = getIntent();

        orderId.setText(String.valueOf(intent.getStringExtra("orderId").trim()));

//        goodsImage.setImageResource();
        price.setText("185.2");
        amount.setText(intent.getStringExtra("amount"));

        sumPrice.setText(String.valueOf((Float.parseFloat(price.getText().toString())
                * Integer.parseInt(amount.getText().toString()))));
        orderName.setText(intent.getStringExtra("orderName"));
        orderTel.setText(intent.getStringExtra("tel"));
        orderAddress.setText(intent.getStringExtra("address"));
        orderPay.setText(intent.getStringExtra("pay"));
        orderState.setText(intent.getStringExtra("state"));
    }
    public void initView(){
        orderId = (TextView) findViewById(R.id.tv_order_show_id);
        goodsImage = (ImageView) findViewById(R.id.iv_order_show_img);
        price = (TextView) findViewById(R.id.tv_order_show_price);
        amount = (TextView) findViewById(R.id.tv_order_show_count);
        sumPrice = (TextView) findViewById(R.id.tv_order_show_sumPrice);
        orderName = (TextView) findViewById(R.id.tv_order_show_name);
        orderTel = (TextView) findViewById(R.id.tv_order_show_tel);
        orderAddress = (TextView) findViewById(R.id.tv_order_show_address);
        orderPay = (TextView) findViewById(R.id.tv_order_show_pay);
        orderState = (TextView) findViewById(R.id.tv_order_show_state);
    }
}
