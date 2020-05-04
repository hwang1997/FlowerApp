package com.wanghuan.login.frist_Page;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.home;
import com.wanghuan.login.model.Flowers;
import com.wanghuan.login.model.Goods;
import com.wanghuan.login.model.Order;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class goodsOrdersActivity extends AppCompatActivity {
    private TextView orderId;
    private TextView goodsName;
    private TextView goodsPrice;
    private TextView goodsBuyCount;
    private TextView sumPrice;
    private TextView orderName;
    private TextView orderPhone;
    private TextView orderAddress;
    private TextView orderPay;
    private TextView orderState;
    private Button btn_goodsOrder_cancel;
    private Button btn_goodsOrder_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_orders);
        orderId = (TextView) findViewById(R.id.tv_goodsOrder_orderId);
        goodsName = (TextView) findViewById(R.id.tv_goodsOrder_goodName);
        goodsPrice = (TextView) findViewById(R.id.tv_goodsOrder_goodPrice);
        goodsBuyCount = (TextView) findViewById(R.id.tv_goodsOrder_buyCount);
        sumPrice = (TextView) findViewById(R.id.tv_goodsOrder_sumPrice);
        orderName = (TextView) findViewById(R.id.tv_goodsOrder_orderName);
        orderPhone = (TextView) findViewById(R.id.tv_goodsOrder_orderPhone);
        orderAddress = (TextView) findViewById(R.id.tv_goodsOrder_orderAddress);
        orderPay = (TextView) findViewById(R.id.tv_goodsOrder_pay);
        orderState = (TextView) findViewById(R.id.tv_goodsOrder_state);
        btn_goodsOrder_cancel = (Button) findViewById(R.id.btn_goodsOrder_cancel);
        btn_goodsOrder_pay = (Button) findViewById(R.id.btn_goodsOrder_pay);
        initView();
    }


    private void initView(){
        Intent intent = getIntent();
        String goodsId = intent.getStringExtra("goodsId");
        orderId.setText(intent.getStringExtra("orderId"));
        goodsName.setText(intent.getStringExtra("goodsName"));
        goodsPrice.setText(intent.getStringExtra("goodsPrice"));
        goodsBuyCount.setText(intent.getStringExtra("goodsBuyCount"));
        sumPrice.setText(intent.getStringExtra("sumPrice"));
        orderName.setText(intent.getStringExtra("orderName"));
        orderPhone.setText(intent.getStringExtra("orderPhone"));
        orderAddress.setText(intent.getStringExtra("orderAddress"));
        int intOrderPay = Integer.parseInt(intent.getStringExtra("orderPay"));
        int oldCount = Integer.parseInt(intent.getStringExtra("goodsCount"));
        String newCount = String.valueOf(oldCount - Integer.parseInt(goodsBuyCount.getText().toString()));
        if (intOrderPay == 0){
            orderPay.setText("线上支付");
        }else if (intOrderPay == 1){
            orderPay.setText("货到付款");
        }
        int intOrderState = Integer.parseInt(intent.getStringExtra("orderState"));
        if (intOrderState == 0){
            orderState.setText("交易完成");
        }else if (intOrderState == 1){
            orderState.setText("已发货");
        }else if (intOrderState ==2){
            orderState.setText("待支付");
        }else if (intOrderState == 3){
            orderState.setText("待发货");
        }else if (intOrderState == 4){
            orderState.setText("取消订单");
        }
        btn_goodsOrder_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"取消订单",Toast.LENGTH_SHORT).show();
                try {
                    String state = "4";
                    Order order = query(orderId.getText().toString(),state);
                    if (order.getCode() == 0){
                        Toast.makeText(getApplicationContext(),"取消订单成功",Toast.LENGTH_SHORT).show();
                        delay();
                    }else {
                        Toast.makeText(getApplicationContext(),"取消订单失败",Toast.LENGTH_SHORT).show();
                        delay();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"服务器异常，请稍后重试……",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_goodsOrder_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String state = "3";
                    Order order = query(orderId.getText().toString(),state);
                    Flowers flowers = updateCount(goodsId, newCount);
                    if (order.getCode() == 0 || flowers.getCode() == 0){
                        Toast.makeText(getApplicationContext(),"支付成功",Toast.LENGTH_SHORT).show();
                        delay();
                    }else {
                        Toast.makeText(getApplicationContext(),"支付失败",Toast.LENGTH_SHORT).show();
                        delay();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"服务器异常，请稍后重试……",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //定义发送请求的方法  修改订单状态
    private Order query(String orderId, String state) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("state",state);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "orders/updateOrdersState";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        Order order = gson.fromJson(result,Order.class);
        return order;
    }
    //定义发送请求的方法  修改商品数量
    private Flowers updateCount(String goodsId, String goodsCount) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("goodsid",goodsId);
        map.put("goodscount",goodsCount);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "goods/updateGoodsCount";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        Flowers flowers = gson.fromJson(result,Flowers.class);
        return flowers;
    }
    private void delay() {
        Handler handler;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(getApplicationContext(),home.class);
                startActivity(intent1);
                finish();
            }
        }, 2000);
    }
}
