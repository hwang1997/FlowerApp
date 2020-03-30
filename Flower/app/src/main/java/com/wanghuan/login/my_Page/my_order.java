package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.adapter.OrderAdapter;
import com.wanghuan.login.model.Order;

import java.util.ArrayList;
import java.util.List;

public class my_order extends AppCompatActivity {
    private List<Order> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        initOrders();
        OrderAdapter adapter = new OrderAdapter(my_order.this, R.layout.order_item,orderList);

        ListView listView = (ListView) findViewById(R.id.list_view_order);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = orderList.get(position);
                Intent intent = new Intent();
                intent.putExtra("orderId",order.getOrder_id()+"");
//                intent.putExtra("userName",order.getAmount());
                intent.putExtra("orderName",order.getOrder_name());
//                intent.putExtra("goodsImg",order.getOrder_name());
//                intent.putExtra("goodsName",order.getOrder_id());
//                intent.putExtra("price",order.getOrder_id());
                intent.putExtra("tel",order.getPhone());
                intent.putExtra("amount",order.getAmount());
                intent.putExtra("address",order.getAddress());
                intent.putExtra("pay",order.getPay());
                intent.putExtra("state",order.getState());
                intent.setClass(getApplicationContext(),show_order.class);
                startActivity(intent);
            }
        });


    }
    private void initOrders(){
        for (int i = 0; i < 2; i++){
            Order order1 = new Order(123,"3", "张三",
                    "18253628945","华凯大厦1103","现金支付","已付款");
            orderList.add(order1);
            Order order2 = new Order(456,"1", "里斯",
                    "18253645945","华凯大厦1203","线上支付","已发货");
            orderList.add(order2);
        }
    }
}
