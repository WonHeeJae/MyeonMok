package com.example.hh.myeonmok;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hh.myeonmok.Adapter.StoreListAdapter;

/**
 * 상점 리스트 액티비티
 * @author WooTaeYoung
 * @since 2017-07-08 토요일
 */
public class StoreListActivity extends AppCompatActivity {

    RecyclerView store_list_recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        /* 액션바 뒤로가기 버튼 */
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        /* 코드 구현 부분 */
        store_list_recyclerView = (RecyclerView) findViewById(R.id.store_list_recycleView);

        // RecyclerView 의 아이템 레이아웃을 설정
        layoutManager = new LinearLayoutManager(this);
        store_list_recyclerView.setLayoutManager(layoutManager);
        // RecyclerView 에 표시될 아답터 지정
        adapter = new StoreListAdapter(this);
        store_list_recyclerView.setAdapter(adapter);
    }
}
