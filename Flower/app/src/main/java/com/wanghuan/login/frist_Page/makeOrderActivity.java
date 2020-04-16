package com.wanghuan.login.frist_Page;

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
import com.wanghuan.login.model.Order;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class makeOrderActivity extends AppCompatActivity {
    private TextView goodsId;
    private TextView goodsName;
    private TextView goodsPrice;
    private TextView goodsBuyCount;
    private TextView sumPrice;
    private EditText orderName;
    private EditText orderPhone;
    private EditText orderAddress;
    private EditText orderPay;
    private EditText orderState;
    private Button submitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        goodsId = (TextView) findViewById(R.id.tv_makeOrder_goodId);
        goodsName = (TextView) findViewById(R.id.tv_makeOrder_goodName);
        goodsPrice = (TextView) findViewById(R.id.tv_makeOrder_goodPrice);
        goodsBuyCount = (TextView) findViewById(R.id.tv_makeOrder_buyCount);
        sumPrice = (TextView) findViewById(R.id.tv_makeOrder_sumPrice);
        orderName = (EditText) findViewById(R.id.tv_makeOrder_orderName);
        orderPhone = (EditText) findViewById(R.id.tv_makeOrder_orderPhone);
        orderAddress = (EditText) findViewById(R.id.tv_makeOrder_orderAddress);
        orderPay = (EditText) findViewById(R.id.tv_makeOrder_pay);
        orderState = (EditText) findViewById(R.id.tv_makeOrder_state);
        submitOrder = (Button) findViewById(R.id.btn_makeOrder_submit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        SharedPreferences getUser = getSharedPreferences("user",Context.MODE_WORLD_READABLE);
        String userIdStr = String.valueOf(getUser.getInt("userId",'0')) ;
        String goodsIdStr = intent.getStringExtra("goodsId");
        String goodsNameStr = intent.getStringExtra("goodsName");
        String goodsPriceStr = intent.getStringExtra("goodsPrice");
        String goodsBuyCountStr = intent.getStringExtra("goodsBuyCount");
        String sumPriceStr = String.valueOf(Float.parseFloat(goodsPriceStr) * Integer.parseInt(goodsBuyCountStr));

        goodsId.setText(goodsIdStr);
        goodsName.setText(goodsNameStr);
        goodsPrice.setText(goodsPriceStr);
        goodsBuyCount.setText(goodsBuyCountStr);
        sumPrice.setText("￥"+sumPriceStr+"");


        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    String orderNameStr = orderName.getText().toString();
                    String orderPhoneStr = orderPhone.getText().toString();
                    String orderAddressStr = orderAddress.getText().toString();
                    String orderPayStr = orderPay.getText().toString();
                    String orderStateStr = orderState.getText().toString();
                    try {
                        Toast.makeText(getApplicationContext(),"111111111！",Toast.LENGTH_SHORT).show();
                        Order order = query(userIdStr,goodsIdStr,goodsBuyCountStr,sumPriceStr,orderNameStr
                                ,orderPhoneStr,orderAddressStr,orderPayStr,orderStateStr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
    private boolean validate(){
        String orderNameStr = orderName.getText().toString();
        String orderPhoneStr = orderPhone.getText().toString();
        String orderAddressStr = orderAddress.getText().toString();
        String orderPayStr = orderPay.getText().toString();

        if ("".equals(orderNameStr)){
            Toast.makeText(getApplicationContext(),"收货人姓名不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(orderPhoneStr)){
            Toast.makeText(getApplicationContext(),"手机号不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(orderAddressStr)){
            Toast.makeText(getApplicationContext(),"地址不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }
        if ("".equals(orderPayStr)){
            Toast.makeText(getApplicationContext(),"支付方式不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    //定义发送请求的方法
    private Order query(String userId, String goodsId, String buyCount, String sumPrice,
                        String orderName, String orderPhone, String orderAddress, String pay, String state) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        map.put("buyCount",buyCount);
        map.put("sumPrice",sumPrice);
        map.put("orderName",orderName);
        map.put("orderPhone",orderPhone);
        map.put("orderAddress",orderAddress);
        map.put("pay",pay);
        map.put("state",state);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "orders/makeOrders";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        Order order = gson.fromJson(result,Order.class);
        return order;

    }
}
