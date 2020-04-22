package com.wanghuan.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wanghuan.login.R;
import com.wanghuan.login.model.Order;
import com.wanghuan.login.util.HttpUtil;

import java.util.List;

public class OrderAdapter extends ArrayAdapter<Order.DataBean> {
    private int resourceId;

    public OrderAdapter(Context context, int textViewResourceId, List<Order.DataBean> dataBeanList) {
        super(context, textViewResourceId, dataBeanList);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Order.DataBean dataBean = getItem(position);
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
//            viewHolder.order_delete = (Button) view.findViewById(R.id.btn_order_delete);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

            viewHolder.goodsName.setText(dataBean.getGoods().get(0).getGoodsname());
            Glide.with(getContext()).load(HttpUtil.BASE_URL + "file/showImageByPath?path="
                    + dataBean.getGoods().get(0).getGoodsimg())
                    .error(R.drawable.none).into(viewHolder.goodsImage);
            viewHolder.goodsPrice.setText(String.valueOf("￥"+Integer.parseInt(dataBean.getBuycount()) * (dataBean.getGoods().get(0).getGoodsprice())));
            viewHolder.orderName.setText(dataBean.getOrdername());
            viewHolder.orderTel.setText(dataBean.getOrderphone());
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
