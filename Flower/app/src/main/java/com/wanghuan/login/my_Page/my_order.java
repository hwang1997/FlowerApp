package com.wanghuan.login.my_Page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.adapter.OrderAdapter;
import com.wanghuan.login.model.Order;
import com.wanghuan.login.util.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class my_order extends AppCompatActivity {
    private List<Order.DataBean> orderList = new ArrayList<>();
    private LinearLayout linearLayout;
    private LinearLayout my_order_lauout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        linearLayout = (LinearLayout) findViewById(R.id.show_order_none);
        my_order_lauout = (LinearLayout) findViewById(R.id.my_order_lauout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    private void initView(){
        SharedPreferences getUser = getSharedPreferences("user",Context.MODE_PRIVATE);
        String userIdStr = String.valueOf(getUser.getInt("userId",0));
        try {
            Order order = queryOrderByUserId(userIdStr);
            if (order.getCode() == 0){
                for (int i = 0; i < order.getData().size(); i++){
                    orderList.add(order.getData().get(i));
                }
                if (order.getData().size() == 0){
                    linearLayout.setVisibility(View.VISIBLE);
                    my_order_lauout.setBackgroundColor(Color.parseColor("#fdfdfe"));
                }
                OrderAdapter adapter = new OrderAdapter(my_order.this, R.layout.order_item, orderList);
                ListView listView = (ListView) findViewById(R.id.list_view_order);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Order.DataBean order = orderList.get(position);
                        Intent intent = new Intent(getApplicationContext(),show_order.class);
                        intent.putExtra("orderId",String.valueOf(order.getOrderid()));
                        intent.putExtra("goodsId",String.valueOf(order.getGoods().get(0).getGoodsid()));
                        intent.putExtra("goodsCount",String.valueOf(order.getGoods().get(0).getGoodscount()));

                        intent.putExtra("goodsName",order.getGoods().get(0).getGoodsname());
                        intent.putExtra("goodsImg",order.getGoods().get(0).getGoodsimg());
                        intent.putExtra("goodsPrice",String.valueOf(order.getGoods().get(0).getGoodsprice()));
                        intent.putExtra("buyCount",order.getBuycount());
                        intent.putExtra("sumPrice",String.valueOf(Integer.parseInt(order.getBuycount()) * order.getGoods().get(0).getGoodsprice()));
                        intent.putExtra("orderName",order.getOrdername());
                        intent.putExtra("orderPhone",order.getOrderphone());
                        intent.putExtra("orderAddress",order.getOrderaddress());
                        intent.putExtra("orderPay",String.valueOf(order.getPay()));
                        intent.putExtra("orderState",String.valueOf(order.getState()));
                        startActivity(intent);
                        finish();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"服务器异常，请稍后再试……",Toast.LENGTH_SHORT).show();
        }
    }

    //显示订单信息
    private Order queryOrderByUserId(String userId) throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("userId",userId);
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "orders/selectByUserId";
        String result = HttpUtil.getInfo(url,map);
        Gson gson = new Gson();
        Order order = gson.fromJson(result,Order.class);
        return order;
    }
}
