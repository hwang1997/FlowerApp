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
import com.wanghuan.login.util.ordersIdUtil;

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
        String goodsCount = intent.getStringExtra("goodsCount");
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
                    String orderIdStr = ordersIdUtil.getOrderId();
                    try {
                        Order order = query(orderIdStr,userIdStr,goodsIdStr,goodsBuyCountStr,sumPriceStr,orderNameStr
                                ,orderPhoneStr,orderAddressStr,orderPayStr,orderStateStr);
                        if (order.getCode() == 0){
                            Intent intent1 = new Intent(getApplicationContext(), goodsOrdersActivity.class);
                            intent1.putExtra("orderId",orderIdStr);
                            intent1.putExtra("goodsId",goodsId.getText());
                            intent1.putExtra("goodsName",goodsNameStr);
                            intent1.putExtra("goodsCount",goodsCount);
                            intent1.putExtra("goodsPrice",goodsPriceStr);
                            intent1.putExtra("goodsBuyCount",goodsBuyCountStr);
                            intent1.putExtra("sumPrice",sumPriceStr);
                            intent1.putExtra("orderName",orderNameStr);
                            intent1.putExtra("orderPhone",orderPhoneStr);
                            intent1.putExtra("orderAddress",orderAddressStr);
                            intent1.putExtra("orderPay",orderPayStr);
                            intent1.putExtra("orderState",orderStateStr);
                            startActivity(intent1);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"创建订单失败，请重新操作……",Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"服务器异常，请重新操作……！",Toast.LENGTH_SHORT).show();
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
        }else if (orderPhoneStr.length() != 11){
            Toast.makeText(getApplicationContext(),"手机号码为11位！",Toast.LENGTH_SHORT).show();
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
    private Order query(String orderId,String userId, String goodsId, String buyCount, String sumPrice,
                        String orderName, String orderPhone, String orderAddress, String pay, String state) throws Exception{
        //使用map封装请求参数
        Map<String, String> map = new HashMap<>();
        map.put("orderid",orderId);
        map.put("userid", userId);
        map.put("goodsid", goodsId);
        map.put("buycount",buyCount);
        map.put("sumprice",sumPrice);
        map.put("ordername",orderName);
        map.put("orderphone",orderPhone);
        map.put("orderaddress",orderAddress);
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
