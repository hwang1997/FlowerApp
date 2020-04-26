package com.wanghuan.login.my_Page;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wanghuan.login.R;

public class MyFragment extends Fragment {
    private TextView tv_userId;
    private TextView tv_loginId;
    private TextView tv_userName;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my, container, false);
        tv_userId = view.findViewById(R.id.tv_userId);
        tv_loginId = view.findViewById(R.id.tv_loginId);
        tv_userName = view.findViewById(R.id.tv_userName);
        SharedPreferences read = getActivity().getSharedPreferences("user",Context.MODE_PRIVATE);
        tv_userId.setText(String.valueOf(read.getInt("userId",0)));
        tv_loginId.setText(read.getString("loginId",""));
        tv_userName.setText(read.getString("userName",""));
        return view;
    }
    public void tv_loginId(String loginId) {
        tv_userName.setText(loginId);
    }
    public void setTv_userName(String name) {
        tv_userName.setText(name);
    }

}
