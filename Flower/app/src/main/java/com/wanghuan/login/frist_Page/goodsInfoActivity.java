package com.wanghuan.login.frist_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wanghuan.login.R;
import com.wanghuan.login.model.Bus;
import com.wanghuan.login.model.Flowers;
import com.wanghuan.login.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class goodsInfoActivity extends AppCompatActivity {
    private ImageView goodsImage;
    private TextView goodsId;
    private TextView goodsName;
    private TextView goodsPrice;
    private TextView goodsCount;
    private TextView goodsDes;
    private EditText goodsBuyCount;
    private Button joinBus;
    private Button buyFast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
//        Toast.makeText(getApplicationContext(),intent.getStringExtra("goodsId"),Toast.LENGTH_SHORT).show();
        goodsImage = (ImageView) findViewById(R.id.iv_goodInfo_image);
        goodsId = (TextView) findViewById(R.id.tv_goodInfo_goodId);
        goodsName = (TextView) findViewById(R.id.tv_goodInfo_goodName);
        goodsPrice = (TextView) findViewById(R.id.tv_goodInfo_goodPrice);
        goodsCount = (TextView) findViewById(R.id.tv_goodInfo_goodCount);
        goodsDes = (TextView) findViewById(R.id.tv_goodInfo_goodDes);
        goodsBuyCount = (EditText) findViewById(R.id.tv_goodInfo_goodBuyCount);
        joinBus = (Button) findViewById(R.id.btn_goodInfo_bus);
        buyFast = (Button) findViewById(R.id.btn_goodInfo_buy);



        goodsId.setText(String.valueOf(intent.getStringExtra("goodsId")));
        goodsName.setText(intent.getStringExtra("goodsName"));
        goodsPrice.setText("￥"+ intent.getStringExtra("goodsPrice"));
        goodsCount.setText(intent.getStringExtra("goodsCount"));
        goodsDes.setText(intent.getStringExtra("goodsDes"));
        Glide.with(getApplicationContext()).load(HttpUtil.BASE_URL+"file/showImageByPath?path="
                +intent.getStringExtra("goodsImage"))
                .error(R.drawable.ic_launcher).into(goodsImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buyFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
//                    Toast.makeText(getApplicationContext(), "立即购买", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),makeOrderActivity.class);
                    intent.putExtra("goodsId",goodsId.getText()+"");
                    intent.putExtra("goodsName",goodsName.getText());
                    intent.putExtra("goodsPrice",goodsPrice.getText().subSequence(1,goodsPrice.length()).toString());
                    intent.putExtra("goodsBuyCount",goodsBuyCount.getText()+"");
                    startActivity(intent);
                }
            }
        });
        joinBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Bus> busList = new ArrayList<>();

                goodsBuyCount = (EditText) findViewById(R.id.tv_goodInfo_goodBuyCount);

                int goodsId1 = Integer.parseInt(goodsId.getText().toString());
                String goodsBuyCount1 = goodsBuyCount.getText().toString();


                Toast.makeText(getApplicationContext(), "该功能正在开发中，敬请期待……", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validate(){
        String goodsBuyCountStr = goodsBuyCount.getText().toString();
        if ("".equals(goodsBuyCountStr)){
            Toast.makeText(getApplicationContext(),"购买数量不能为空！",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
