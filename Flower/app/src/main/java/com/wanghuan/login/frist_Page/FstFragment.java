package com.wanghuan.login.frist_Page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanghuan.login.R;
import com.wanghuan.login.adapter.FlowerAdapter;
import com.wanghuan.login.model.Flowers;

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
        List<Flowers> flowersList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            flowersList.add(new Flowers(1, "sfdsf", "123", "1",
                    "在我们中国，蔷薇代表爱情、喜庆，年轻男女之间互赠红色蔷薇花，寓意初恋之情。", R.mipmap.flower));
            flowersList.add(new Flowers(2, "sfdsf", "123", "1", "23213", R.mipmap.flower1));
        }
        recycle_fst.setAdapter(new FlowerAdapter(getContext(), flowersList));
    }
}
