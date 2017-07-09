package com.example.hh.myeonmok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener{

    ImageButton btn_market, btn_road, btn_event, btn_food, btn_clothes, btn_vegetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_market = (ImageButton)findViewById(R.id.button1);
        btn_road = (ImageButton)findViewById(R.id.button2);
        btn_event = (ImageButton)findViewById(R.id.button3);
        btn_food = (ImageButton)findViewById(R.id.button4);
        btn_clothes = (ImageButton)findViewById(R.id.button5);
        btn_vegetable = (ImageButton)findViewById(R.id.button6);

        btn_market.setOnClickListener(this);
        btn_road.setOnClickListener(this);
        btn_event.setOnClickListener(this);
        btn_food.setOnClickListener(this);
        btn_clothes.setOnClickListener(this);
        btn_vegetable.setOnClickListener(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.manage_coupon) {
            Log.d("TAG", "CouponBoxActivity.class");
            startActivity(new Intent(this, CouponBoxActivity.class));
        } else if (id == R.id.history_use) {

        } else if (id == R.id.QnA) {

        } else if (id == R.id.setting) {

        }else if (id == R.id.customcenter) {

        } else if (id == R.id.nav_share) {
            Log.d("TAG", "StoreListActivity.class");
            startActivity(new Intent(this, StoreListActivity.class));
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            // 판매점 리스트를 보여주는 액티비티 생성
            Intent intent01 = new Intent(MainActivity.this, StoreListActivity.class);
            startActivity(intent01);
        }
        if(v.getId() == R.id.button2){

        }
        if(v.getId() == R.id.button3){

        }
        if(v.getId() == R.id.button4){

        }
        if(v.getId() == R.id.button5){

        }
        if(v.getId() == R.id.button6){

        }


    }
}