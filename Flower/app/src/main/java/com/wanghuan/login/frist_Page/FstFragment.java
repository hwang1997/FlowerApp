package com.wanghuan.login.frist_Page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wanghuan.login.R;
import com.wanghuan.login.adapter.FlowerAdapter;
import com.wanghuan.login.model.Flowers;
import com.wanghuan.login.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class FstFragment extends Fragment {
    RecyclerView recycle_fst;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_first, container, false);
        recycle_fst = view.findViewById(R.id.recycle_fst);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recycle_fst.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        List<Flowers.DataBean> flowersList = new ArrayList<>();
        try {
            Flowers str = query();
            if (str.getCode() == 0){
                for (int i = 0;i<str.getData().size();i++) {
                    flowersList.add(str.getData().get(i));
                }
                System.out.println(flowersList);
                recycle_fst.setAdapter(new FlowerAdapter(getContext(), flowersList));

            }else {
                Toast.makeText(getContext(),"获取商品信息失败！",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(),"服务器异常！",Toast.LENGTH_SHORT).show();
        }
    }
    private Flowers query() throws Exception{
        //定义发送请求的URL
        String url = HttpUtil.BASE_URL + "goods/queryAllForApp";
        String result = HttpUtil.queryAllGoods(url);
        Gson gson = new Gson();
        Flowers flowers = gson.fromJson(result,Flowers.class);
        return flowers;

    }
}
