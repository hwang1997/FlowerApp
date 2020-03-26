package com.wanghuan.login.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.model.Flowers;

import java.util.List;

import static java.security.AccessController.getContext;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private List<Flowers> mFlowerList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView flowerId;
        TextView flowerName;
        TextView flowerPrice;
        TextView flowerDes;
        ImageView flowerImage;

        public ViewHolder(View view){
            super(view);
            flowerImage = (ImageView) view.findViewById(R.id.iv_flower_img);
            flowerName = (TextView) view.findViewById(R.id.tv_flower_name);
            flowerPrice = (TextView) view.findViewById(R.id.tv_flower_price);
        }

    }
    public FlowerAdapter(List<Flowers> flowersList){
        mFlowerList = flowersList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flower_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        Flowers flowers = mFlowerList.get(position);


//        holder.flowerImage.setImageResource((Integer.parseInt(flowers.getPic())));
        holder.flowerId.setText(flowers.getGood_id());
        holder.flowerName.setText(flowers.getGood_name());
        holder.flowerPrice.setText(flowers.getPrice());
        holder.flowerDes.setText(flowers.getDes());
        holder.flowerImage.setImageResource(Integer.parseInt("R.mipmap." + "flowers.getPic()"));

    }
    public int getItemCount(){
        return mFlowerList.size();
    }

}
