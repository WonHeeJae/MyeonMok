package com.example.hh.myeonmok.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hh.myeonmok.R;

/**
 * Created by wooty on 2017-07-08.
 */

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder> {

    /* 이 배열은 테스트를 위한 더미값 입니다. */
    private String[] titles = {"생선판매점", "의류판매점", "치킨판매점", "애완용품샵", "육류판매점", "맛나분식집"};
    private String[] phones = {"031-635-1111", "031-635-2222", "031-635-3333", "031-635-4444", "031-635-5555", "031-635-6666"};
    private String[] holidays = {"연중무휴", "연중무휴", "연중무휴", "연중무휴", "연중무휴", "연중무휴"};
    private boolean[] favorites = {true, true, false, false, true, false};
    private int[] images = {R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.store_image_imgView.setImageResource(images[position]);
        holder.store_title_tv.setText(titles[position]);
        holder.store_phone_tv.setText(phones[position]);
        holder.store_holiday_tv.setText(holidays[position]);
        holder.store_favorite_tgbtn.setChecked(favorites[position]);
        holder.store_favorite_tgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                }

            }
        });
        holder.store_location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked Location Pos: " + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.store_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked Infomation Pos: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView store_image_imgView;
        public TextView store_title_tv;
        public TextView store_phone_tv;
        public TextView store_holiday_tv;
        public Button store_location_btn;
        public Button store_info_btn;
        public ToggleButton store_favorite_tgbtn;

        public ViewHolder(View itemView) {
            super(itemView);

            store_image_imgView = (ImageView) itemView.findViewById(R.id.ivImage_scl);
            store_title_tv = (TextView) itemView.findViewById(R.id.tvTitle_scl);
            store_phone_tv = (TextView) itemView.findViewById(R.id.tvPhone_scl);
            store_holiday_tv = (TextView) itemView.findViewById(R.id.tvHoliday_scl);
            store_location_btn = (Button) itemView.findViewById(R.id.btnStoreLocation_scl);
            store_info_btn = (Button) itemView.findViewById(R.id.btnStoreInfo_scl);
            store_favorite_tgbtn = (ToggleButton) itemView.findViewById(R.id.tgbtnFavorite);
        }
    }

}
