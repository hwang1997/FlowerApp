package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.frist_Page.goodsOrdersActivity;
import com.wanghuan.login.model.Order;
import com.wanghuan.login.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

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
    private Button btn_showOrder_del;
    private Button btn_showOrder_ok;
    private Button btn_showOrder_goPay;

    private LinearLayout layout_delOrder;
    private LinearLayout layout_okOrder;
    private LinearLayout layout_goPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        initView();
        initEven();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void initEven() {
        Intent intent = getIntent();
        String goodsIdStr = intent.getStringExtra("goodsId");
        String goodsCountStr = intent.getStringExtra("goodsCount");
        orderId.setText(String.valueOf(intent.getStringExtra("orderId")));
        String goodsNameStr = intent.getStringExtra("goodsName");
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
            orderState.setText("交易完成");
            layout_delOrder.setVisibility(View.VISIBLE);//显示删除按钮
        }
        if (orderStateStr == 1){
            orderState.setText("待收货");
            layout_okOrder.setVisibility(View.VISIBLE);//显示收货按钮
        }
        if (orderStateStr == 2){
            orderState.setText("待支付");
            layout_goPay.setVisibility(View.VISIBLE);//显示去支付按钮
        }
        if (orderStateStr == 3){
            orderState.setText("待发货");
        }
        if (orderStateStr == 4){
            orderState.setText("取消订单");
            layout_delOrder.setVisibility(View.VISIBLE);//显示删除按钮
        }
        btn_showOrder_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderIdStr = orderId.getText().toString();
                try {
                    Order order = delOrder(orderIdStr);
                    if (order.getCode() == 0){
                        Toast.makeText(getApplicationContext(),"删除成功！",Toast.LENGTH_SHORT).show();
                        delay();
                    }else {
                        Toast.makeText(getApplicationContext(),"删除失败！",Toast.LENGTH_SHORT).show();
                        delay();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"服务器异常，请稍后重试……",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_showOrder_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderId1 = orderId.getText().toString();
                String state = "0";
                try {
                    Order order = query(orderId1,state);
                    if (order.getCode() == 0){
                        Toast.makeText(getApplicationContext(),"收货成功！", Toast.LENGTH_SHORT).show();
                        delay();
                    }else {
                        Toast.makeText(getApplicationContext(),"收货失败！", Toast.LENGTH_SHORT).show();
                        delay();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"服务器异常，请稍后重试……", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_showOrder_goPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler;
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent1 = new Intent(getApplicationContext(),goPayActivity.class);
                        intent1.putExtra("orderId",orderId.getText());
                        intent1.putExtra("goodsId",goodsIdStr);
                        intent1.putExtra("goodsName",goodsNameStr);
                        intent1.putExtra("goodsPrice",price.getText());
                        intent1.putExtra("goodsCount",goodsCountStr);
                        intent1.putExtra("goodsBuyCount",amount.getText());
                        intent1.putExtra("sumPrice",sumPrice.getText());
                        intent1.putExtra("orderName",orderName.getText());
                        intent1.putExtra("orderPhone",orderTel.getText());
                        intent1.putExtra("orderAddress",orderAddress.getText());
                        intent1.putExtra("orderPay",String.valueOf(orderPayStr));
                        intent1.putExtra("orderState",String.valueOf(orderStateStr));
                        startActivity(intent1);
                    }
                }, 2000);
            }
        });
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
        btn_showOrder_ok = (Button) findViewById(R.id.btn_showOrder_ok);
        btn_showOrder_del = (Button) findViewById(R.id.btn_showOrder_del);
        btn_showOrder_goPay = (Button) findViewById(R.id.btn_showOrder_goPay);
        layout_delOrder = (LinearLayout) findViewById(R.id.layout_delOrder);
        layout_okOrder = (LinearLayout) findViewById(R.id.layout_okOrder);
        layout_goPay = (LinearLayout) findViewById(R.id.layout_goPay);
    }
    //定义发送请求的方法
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
    //定义发送请求的方法
    private Order delOrder(String orderId) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("orderId",orderId);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "orders/deleteByOrderId";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        Order order = gson.fromJson(result,Order.class);
        return order;
    }
    private void delay() {
        Handler handler;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent(getApplicationContext(),my_order.class);
                startActivity(intent1);
                finish();
            }
        }, 2000);
    }
}
