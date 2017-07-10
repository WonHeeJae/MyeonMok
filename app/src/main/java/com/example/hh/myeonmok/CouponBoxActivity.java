package com.example.hh.myeonmok;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.hh.myeonmok.Adapter.CouponListAdapter;
import com.example.hh.myeonmok.Adapter.StoreListAdapter;

/**
 * 쿠폰 목록 액티비티 클래스
 * @author WooTaeYoung
 * @since 2017-07-09 일요일
 */
public class CouponBoxActivity extends AppCompatActivity {
    RecyclerView coupon_list_recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_box);
        /* 액션바 뒤로가기 버튼 */
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        /* 코드 구현 부분 */
        coupon_list_recyclerView = (RecyclerView) findViewById(R.id.coupon_list_recyclerView);

        // RecyclerView 의 아이템 레이아웃을 설정
        layoutManager = new LinearLayoutManager(this);
        coupon_list_recyclerView.setLayoutManager(layoutManager);
        // RecyclerView 에 표시될 아답터 지정
        adapter = new CouponListAdapter(this);
        coupon_list_recyclerView.setAdapter(adapter);
    }
}
