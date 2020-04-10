package com.wanghuan.login.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.model.Order;

import java.util.List;

public class OrderAdapter extends ArrayAdapter<Order> {
    private int resourceId;

    public OrderAdapter(Context context, int textViewResourceId, List<Order> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Order order = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.goodsName = (TextView) view.findViewById(R.id.tv_order_item_goodsName);
            viewHolder.goodsImage = (ImageView) view.findViewById(R.id.iv_order_item_image);
            viewHolder.goodsPrice = (TextView) view.findViewById(R.id.tv_order_item_price);
            viewHolder.orderName = (TextView) view.findViewById(R.id.tv_order_item_orderName);
            viewHolder.orderTel = (TextView) view.findViewById(R.id.tv_order_item_tel);
            viewHolder.order_delete = (Button) view.findViewById(R.id.btn_order_delete);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.order_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(getItem(position));
                Toast.makeText(getContext(), "删除" + order.getOrder_name(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.goodsName.setText(order.getOrder_name());
//        viewHolder.goodsImage.setImageResource();
        viewHolder.goodsPrice.setText("123.02");
        viewHolder.orderName.setText(order.getOrder_name());
        viewHolder.orderTel.setText(order.getPhone());
//        goodsImage.setImageResource(Integer.parseInt(order.getGood_id().getPic()));
//        goodsPrice.setText(order.getGood_id().getPrice());

        return view;

    }

    class ViewHolder {
        TextView goodsName;
        ImageView goodsImage;
        TextView goodsPrice;
        TextView orderName;
        TextView orderTel;
        Button order_delete;
    }
}
