package com.example.hh.myeonmok;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hh.myeonmok.Adapter.CouponListAdapter;
import com.example.hh.myeonmok.Adapter.CouponManagementListAdapter;

/**
 * 상인이 사용하는 쿠폰 관리 액티비티
 * @author WooTaeYoung
 * @since 2017-07-11 화요일
 */
public class CouponManagementActivity extends AppCompatActivity {
    RecyclerView coupon_management_recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_management);

         /* 액션바 뒤로가기 버튼 */
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        /* 코드 구현 부분 */
        coupon_management_recyclerView = (RecyclerView) findViewById(R.id.coupon_management_recyclerView);

        // RecyclerView 의 아이템 레이아웃을 설정
        layoutManager = new LinearLayoutManager(this);
        coupon_management_recyclerView.setLayoutManager(layoutManager);
        // RecyclerView 에 표시될 아답터 지정
        adapter = new CouponManagementListAdapter();
        coupon_management_recyclerView.setAdapter(adapter);
    }
}
