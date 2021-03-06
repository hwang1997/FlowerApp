package com.wanghuan.login.my_Page;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.wanghuan.login.R;
import com.wanghuan.login.adapter.AddrAdapter;
import com.wanghuan.login.model.Addr;

import java.util.ArrayList;
import java.util.List;

public class my_addr extends AppCompatActivity {
    private List<Addr> addrList = new ArrayList<>();

    public void MyAdd_addr(View view) {
        Intent intent = new Intent(getApplicationContext(), add_addr.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addr);
        initAddr();
        final AddrAdapter adapter = new AddrAdapter(my_addr.this, R.layout.addr_item, addrList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Addr addr = addrList.get(position);
                Intent intent = new Intent();
                intent.putExtra("address", addr.getAddress());
                intent.putExtra("name", addr.getName());
                intent.putExtra("tel", addr.getTel());
                intent.setClass(getApplicationContext(), update_addr.class);
                Toast.makeText(getApplicationContext(), addr.getName(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void initAddr() {
//        for (int i = 0; i < 10; i++){
        Addr addr1 = new Addr("华凯大厦1103", "张三", "18372608361");
        addrList.add(addr1);
        Addr addr2 = new Addr("胜和广场1101", "李四", "18372608362");
        addrList.add(addr2);
        Addr addr3 = new Addr("第一国际1102", "王五", "13257146379");
        addrList.add(addr3);
//        }
    }
//    public void getIntent(Intent intent){
//        String address = intent.getStringExtra("address");
//        String name = intent.getStringExtra("name");
//        String tel = intent.getStringExtra("tel");
//        Addr addr = new Addr(address, name, tel);
//        addrList.sub(addr);
//    }

//    public void my_addr_okBtn(){
//        Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
//        finish();
//    }

}
