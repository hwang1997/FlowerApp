package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wanghuan.login.R;
import com.wanghuan.login.util.HttpUtil;

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


    }

    @Override
    protected void onResume() {
        super.onResume();
        initEven();
    }

    public void initEven() {
        Intent intent = getIntent();

        orderId.setText(String.valueOf(intent.getStringExtra("orderId")));
        Glide.with(getApplicationContext()).load(HttpUtil.BASE_URL+"file/showImageByPath?path="
                +intent.getStringExtra("goodsImg"))
                .error(R.drawable.default_img).into(goodsImage);
        price.setText(intent.getStringExtra("goodsPrice"));
        amount.setText(intent.getStringExtra("buyCount"));
        sumPrice.setText(intent.getStringExtra("sumPrice"));
        orderName.setText(intent.getStringExtra("orderName"));
        orderTel.setText(intent.getStringExtra("orderPhone"));
        orderAddress.setText(intent.getStringExtra("orderAddress"));

        Integer orderPayStr = Integer.parseInt(intent.getStringExtra("orderPay"));
        if (orderPayStr == 0){
            orderPay.setText("线上支付");
        }
        if (orderPayStr == 1){
            orderPay.setText("货到付款");
        }
        Integer orderStateStr = Integer.parseInt(intent.getStringExtra("orderState"));
        if (orderStateStr == 0){
            orderState.setText("已完成");
        }
        if (orderStateStr == 1){
            orderState.setText("已发货");
        }
        if (orderStateStr == 2){
            orderState.setText("待支付");
        }
        if (orderStateStr == 3){
            orderState.setText("待发货");
        }
        if (orderStateStr == 4){
            orderState.setText("待收货");
        }
    }

    public void initView() {
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
