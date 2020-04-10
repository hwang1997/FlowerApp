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
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.frist_Page.goodsInfoActivity;
import com.wanghuan.login.model.Flowers;

import java.util.List;


public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private Context context;
    private List<Flowers> mFlowerList;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView flowerId;
        TextView flowerName;
        TextView flowerPrice;
        TextView flowerDes;
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

    public FlowerAdapter(Context context, List<Flowers> flowersList) {
        this.context = context;
        mFlowerList = flowersList;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flower_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Flowers flowers = mFlowerList.get(position);


//        holder.flowerImage.setImageResource((Integer.parseInt(flowers.getPic())));
//        holder.flowerId.setText(flowers.getGood_id());
        holder.flowerName.setText(flowers.getGood_name());
        holder.flowerPrice.setText(flowers.getPrice());
//        holder.flowerDes.setText(flowers.getDes());
        holder.flowerImage.setImageResource(flowers.getPic());

        holder.flower_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, goodsInfoActivity.class);
                intent.putExtra("goodsImage", flowers.getPic());
                intent.putExtra("goodsId", flowers.getGood_id() + "");
                intent.putExtra("goodsName", flowers.getGood_name());
                intent.putExtra("goodsPrice", flowers.getPrice());
                intent.putExtra("goodsCount", flowers.getCount());
                intent.putExtra("goodsDes", flowers.getDes());
                intent.putExtra("flowerList", mFlowerList.get(position));
                context.startActivity(intent);
//                Toast.makeText(context,flowers.getGood_name(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return mFlowerList.size();
    }

}
