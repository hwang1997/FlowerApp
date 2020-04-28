package com.wanghuan.login.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wanghuan.login.R;
import com.wanghuan.login.frist_Page.goodsInfoActivity;
import com.wanghuan.login.model.Flowers;
import com.wanghuan.login.util.HttpUtil;

import java.util.List;
import java.util.Locale;


public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private Context context;
    private List<Flowers.DataBean> mFlowerList;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView flowerName;
        TextView flowerPrice;
        ImageView flowerImage;
        LinearLayout flower_item;

        public ViewHolder(View view) {
            super(view);
            flower_item = (LinearLayout) view.findViewById(R.id.flower_item);
            flowerImage = (ImageView) view.findViewById(R.id.iv_flower_img);
            flowerName = (TextView) view.findViewById(R.id.tv_flower_name);
            flowerPrice = (TextView) view.findViewById(R.id.tv_flower_price);
        }

    }

    public FlowerAdapter(Context context, List<Flowers.DataBean> flowerList) {
        this.context = context;
        mFlowerList = flowerList;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flower_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Flowers.DataBean flowers = mFlowerList.get(position);

          holder.flowerName.setText(flowers.getGoodsname());
          holder.flowerPrice.setText(String.format(Locale.getDefault(),"%1.2f元",flowers.getGoodsprice()));
        Glide.with(context).load(HttpUtil.BASE_URL+"file/showImageByPath?path="+flowers.getGoodsimg()).error(R.drawable.none).into(holder.flowerImage);
        holder.flower_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, goodsInfoActivity.class);
                intent.putExtra("goodsId", flowers.getGoodsid()+"");
                intent.putExtra("goodsName", flowers.getGoodsname());
                intent.putExtra("goodsPrice", flowers.getGoodsprice()+"");
                intent.putExtra("goodsCount", flowers.getGoodscount()+"");
                intent.putExtra("goodsDes", flowers.getGoodsdes());
                intent.putExtra("goodsImage", flowers.getGoodsimg());
                context.startActivity(intent);
            }
        });

    }

    public int getItemCount() {
        return mFlowerList.size();
    }

}
