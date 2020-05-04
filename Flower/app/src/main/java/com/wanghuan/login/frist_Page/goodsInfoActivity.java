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
import com.wanghuan.login.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class goodsInfoActivity extends AppCompatActivity {
    private ImageView goodsImage;
    private TextView goodsId;
    private TextView goodsName;
    private TextView goodsPrice;
    private TextView goodsCount;
    private TextView goodsDes;
    private Button joinBus;
    private Button buyFast;
    private Button btAdd;
    private Button btSub;
    private EditText edtNumber;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        goodsImage = (ImageView) findViewById(R.id.iv_goodInfo_image);
        goodsId = (TextView) findViewById(R.id.tv_goodInfo_goodId);
        goodsName = (TextView) findViewById(R.id.tv_goodInfo_goodName);
        goodsPrice = (TextView) findViewById(R.id.tv_goodInfo_goodPrice);
        goodsCount = (TextView) findViewById(R.id.tv_goodInfo_goodCount);
        goodsDes = (TextView) findViewById(R.id.tv_goodInfo_goodDes);
        joinBus = (Button) findViewById(R.id.btn_goodInfo_bus);
        buyFast = (Button) findViewById(R.id.btn_goodInfo_buy);

        btAdd = (Button) findViewById(R.id.addbt);
        btSub = (Button) findViewById(R.id.subbt);
        edtNumber = (EditText) findViewById(R.id.edt);
        //通过Intent获取FstFragment页面传过来的商品信息
        goodsId.setText(String.valueOf(intent.getStringExtra("goodsId")));
        goodsName.setText(intent.getStringExtra("goodsName"));
        goodsPrice.setText("￥"+ intent.getStringExtra("goodsPrice"));
        goodsCount.setText(intent.getStringExtra("goodsCount"));
        goodsDes.setText(intent.getStringExtra("goodsDes"));
        Glide.with(getApplicationContext()).load(HttpUtil.BASE_URL+"file/showImageByPath?path="
                +intent.getStringExtra("goodsImage"))
                .error(R.drawable.none).into(goodsImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buyFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //通过Intent将商品参数传给makeOrderActivity
                    Intent intent = new Intent(getApplicationContext(),makeOrderActivity.class);
                    intent.putExtra("goodsId",goodsId.getText()+"");
                    intent.putExtra("goodsName",goodsName.getText());
                    intent.putExtra("goodsCount",goodsCount.getText());
                    intent.putExtra("goodsPrice",goodsPrice.getText().subSequence(1,goodsPrice.length()).toString());
                    intent.putExtra("goodsBuyCount",edtNumber.getText()+"");
                    startActivity(intent);
                    finish();
                }
            }
        });
        joinBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    Toast.makeText(getApplicationContext(), "该功能正在开发中，敬请期待……", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numString = Integer.parseInt(edtNumber.getText().toString());
                if (++numString > 5 ){
                    Toast.makeText(getApplicationContext(),"购买数量必须小于5",Toast.LENGTH_SHORT).show();
                    num = 5;
                }else {
                    num ++;
                }

                edtNumber.setText(String.valueOf(num));
            }
        });
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numString = Integer.parseInt(edtNumber.getText().toString());
                if (--numString <= 0) {
                    Toast.makeText(getApplicationContext(), "最低购买数量为1", Toast.LENGTH_SHORT).show();
                    num = 1;
                } else {
                    num--;
                }
                edtNumber.setText(String.valueOf(num));
            }
        });
    }

    private boolean validate(){
        int goodsBuyCountInt = Integer.parseInt(edtNumber.getText().toString());
        int goodsCountInt = Integer.parseInt(goodsCount.getText().toString());
        if (goodsBuyCountInt > goodsCountInt){
            Toast.makeText(getApplicationContext(),"商品库存不足，剩余"+goodsCountInt+"件，请调整购买数量！",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
