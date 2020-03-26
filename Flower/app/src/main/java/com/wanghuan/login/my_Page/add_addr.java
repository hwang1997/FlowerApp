package com.wanghuan.login.my_Page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.adapter.AddrAdapter;
import com.wanghuan.login.model.Addr;

import java.util.ArrayList;
import java.util.List;

public class add_addr extends AppCompatActivity {
    private List<Addr> addrList = new ArrayList<>();
    private EditText et_addr_address;
    private EditText et_addr_name;
    private EditText et_addr_tel;
    private AddrAdapter addrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_addr);

    }
    public void my_add_addr_okBtn(View view){
        et_addr_address = (EditText) findViewById(R.id.et_addr_address);
        et_addr_name = (EditText) findViewById(R.id.et_addr_name);
        et_addr_tel = (EditText) findViewById(R.id.et_addr_tel);
        String address = et_addr_address.getText().toString();
        String name = et_addr_name.getText().toString();
        String tel = et_addr_tel.getText().toString();
        if ("".equals(address) || "".equals(name) || "".equals(tel)){
            Toast.makeText(getApplicationContext(),"地址、姓名、电话不能为空",Toast.LENGTH_SHORT).show();
        }else {
//            Addr addr = new Addr(address, name, tel);
//            addrList.add(addr);


            Intent intent = new Intent(getApplicationContext(),my_addr.class);
            intent.putExtra("address",address);
            intent.putExtra("name",name);
            intent.putExtra("tel",tel);

            startActivity(intent);
            finish();
        }

//        addrAdapter.notifyDataSetChanged();


    }
}
