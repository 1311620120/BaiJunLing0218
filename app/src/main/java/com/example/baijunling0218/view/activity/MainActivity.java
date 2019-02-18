package com.example.baijunling0218.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.baijunling0218.R;
import com.example.baijunling0218.model.JsonBean;
import com.example.baijunling0218.present.MainPresent;
import com.example.baijunling0218.view.adapter.MyAdapter;
import com.example.baijunling0218.view.interfaces.MainInterfaces;

public class MainActivity extends AppCompatActivity  implements MainInterfaces {


    private MainPresent mainpersent;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }



    private void initData() {

        mainpersent = new MainPresent();
        mainpersent.setView(this);
        mainpersent.login("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E5%8D%AB%E8%A1%A3&page=1&count=30");

        myAdapter = new MyAdapter(MainActivity.this);

    }
    private void initView() {
     RecyclerView   recycler = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(myAdapter);

    }

    @Override
    public void Seccuss(JsonBean bean) {
        myAdapter.setData(bean.getResult());
    }

    @Override
    public void fail(String s) {

    }
     protected  void  onDestory(){
       super.onDestroy();
         mainpersent.dettachView();
     }
}
