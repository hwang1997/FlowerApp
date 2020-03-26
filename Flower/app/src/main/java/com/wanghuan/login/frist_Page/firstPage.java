package com.wanghuan.login.frist_Page;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.wanghuan.login.R;

import com.wanghuan.login.adapter.FruitAdapter;
import com.wanghuan.login.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class firstPage extends AppCompatActivity {
//    private List<Flowers> flowersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private  List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_SHORT).show();


//        initFruits();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_fst);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        FruitAdapter adapter = new FruitAdapter(fruitList);
//        recyclerView.setAdapter(adapter);
//        Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_SHORT).show();
//        initFlowers();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_fst);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        FlowerAdapter adapter = new FlowerAdapter(flowersList);
//        recyclerView.setAdapter(adapter);
//        Toast.makeText(getApplicationContext(),flowersList.size(),Toast.LENGTH_SHORT).show();
    }
//    private void initFlowers(){
//        for (int i = 0; i < 10; i++){
//            Flowers flower1 = new Flowers(
//                    202001,"陌上花开","145.9","34","热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱","flower");
//            flowersList.add(flower1);
//            Flowers flower2 = new Flowers(
//                    202002,"星空物语","145.9","34","热情、热爱着您　我爱你、热恋, 希望与你泛起激情的爱","flower1");
//            flowersList.add(flower2);
//        }
//    }
    private void initFruits(){
        for (int i = 0; i < 10; i++){
            Fruit apple = new Fruit("Apple", R.mipmap.flower);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.mipmap.flower1);
            fruitList.add(banana);
        }
    }
}
