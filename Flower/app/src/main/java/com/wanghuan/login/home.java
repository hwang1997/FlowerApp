package com.wanghuan.login;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.wanghuan.login.bus_Page.BusFragment;
import com.wanghuan.login.frist_Page.FstFragment;
import com.wanghuan.login.my_Page.MyFragment;
import com.wanghuan.login.my_Page.my_addr;
import com.wanghuan.login.my_Page.my_pwd;
import com.wanghuan.login.my_Page.my_username;

import java.util.ArrayList;
import java.util.List;


public class home extends FragmentActivity implements View.OnClickListener {
    private CountDownTimer timer;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private LinearLayout mTabFst;
    private LinearLayout mTabBus;
    private LinearLayout mTabMy;

    private ImageButton mImgFst;
    private ImageButton mImgBus;
    private ImageButton mImgMy;

    public void MyUsername(View view){
        Intent intent = new Intent(getApplicationContext(), my_username.class);
        startActivity(intent);
    }
    public void MyPsw(View view){
        Intent intent1 = new Intent(getApplicationContext(), my_pwd.class);
        startActivity(intent1);
    }
    public void MyAddr(View view){
        Intent intent2 = new Intent(getApplicationContext(), my_addr.class);
        startActivity(intent2);
    }
    public void logout(View view){
        Intent intent5 = new Intent(getApplicationContext(), login.class);
        startActivity(intent5);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        initEvents();
        selectTab(0);
        initDatas();

    }

    private void initDatas(){
        mFragments = new ArrayList<>();
        mFragments.add(new FstFragment());
        mFragments.add(new BusFragment());
        mFragments.add(new MyFragment());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initEvents(){
        mImgFst.setOnClickListener(this);
        mImgBus.setOnClickListener(this);
        mImgMy.setOnClickListener(this);
    }
    private void initViews(){
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabFst = (LinearLayout) findViewById(R.id.id_tab_fst);
        mTabBus = (LinearLayout) findViewById(R.id.id_tab_bus);
        mTabMy = (LinearLayout) findViewById(R.id.id_tab_my);

        mImgFst = (ImageButton) findViewById(R.id.id_tab_fst_img);
        mImgBus = (ImageButton) findViewById(R.id.id_tab_bus_img);
        mImgMy = (ImageButton) findViewById(R.id.id_tab_my_img);
    }
    public void onClick(View view){
        resetImgs();
        switch (view.getId()){
            case R.id.id_tab_fst_img:
                selectTab(0);
                break;
            case R.id.id_tab_bus_img:
                selectTab(1);
                break;
            case R.id.id_tab_my_img:
                selectTab(2);
                break;
        }
    }
    private void selectTab(int i){
        resetImgs();
        switch (i){
            case 0:
                mImgFst.setImageResource(R.mipmap.tab_fst_pressed);
                Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                mImgBus.setImageResource(R.mipmap.tab_bus_pressed);
                Toast.makeText(getApplicationContext(),"222",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                mImgMy.setImageResource(R.mipmap.tab_my_pressed);
                Toast.makeText(getApplicationContext(),"333",Toast.LENGTH_SHORT).show();
                break;
        }
        mViewPager.setCurrentItem(i);
    }
    private void resetImgs(){
        mImgFst.setImageResource(R.mipmap.tab_fst_normal);
        mImgBus.setImageResource(R.mipmap.tab_bus_normal);
        mImgMy.setImageResource(R.mipmap.tab_my_normal);
    }

}
