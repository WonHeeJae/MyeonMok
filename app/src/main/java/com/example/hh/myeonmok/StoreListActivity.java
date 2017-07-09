package com.example.hh.myeonmok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hh.myeonmok.Adapter.StoreListAdapter;

public class StoreListActivity extends AppCompatActivity {

    RecyclerView store_list_recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);

        store_list_recyclerView = (RecyclerView) findViewById(R.id.store_list_recycleView);

        // RecyclerView 의 아이템 레이아웃을 설정
        layoutManager = new LinearLayoutManager(this);
        store_list_recyclerView.setLayoutManager(layoutManager);
        // RecyclerView 에 표시될 아답터 지정
        adapter = new StoreListAdapter();
        store_list_recyclerView.setAdapter(adapter);
    }
}
