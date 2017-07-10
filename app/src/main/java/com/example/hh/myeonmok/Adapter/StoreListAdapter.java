package com.example.hh.myeonmok.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hh.myeonmok.R;

/**
 * RecyclerView 에 사용될 아답터
 * @author  WooTaeYoung
 * @since 2017-07-08 토요일
 */

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder> {

    /* DB연결 전 더미 배열 값 사용 */
    private String[] titles = {"생선판매점", "의류판매점", "치킨판매점", "애완용품샵", "육류판매점", "맛나분식집"};
    private String[] phones = {"031-635-1111", "031-635-2222", "031-635-3333", "031-635-4444", "031-635-5555", "031-635-6666"};
    private String[] holidays = {"연중무휴", "연중무휴", "연중무휴", "연중무휴", "연중무휴", "연중무휴"};
    private boolean[] favorites = {true, true, false, false, true, false};
    private int[] images = {R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy, R.drawable.dummy};
    private Context mContext = null; // 다이얼로그 생성시 사용

    public StoreListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        /*  뷰 값 설정 */
        holder.store_image_imgView.setImageResource(images[position]);
        holder.store_title_tv.setText(titles[position]);
        holder.store_phone_tv.setText(phones[position]);
        holder.store_holiday_tv.setText(holidays[position]);
        holder.store_favorite_tgbtn.setChecked(favorites[position]);
        /* 리스너 연결 */
        // 즐겨찾기 버튼
        holder.store_favorite_tgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 체크상태에 따른 즐겨찾기 로직 작성
                if (isChecked) {
                    holder.store_favorite_tgbtn.setBackgroundDrawable(holder.itemView.getResources().getDrawable(android.R.drawable.btn_star_big_on));
                } else {
                    holder.store_favorite_tgbtn.setBackgroundDrawable(holder.itemView.getResources().getDrawable(android.R.drawable.btn_star_big_off));
                }

            }
        });
        // 위치 보기 버튼
        holder.store_location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked Location Pos: " + position, Toast.LENGTH_SHORT).show();
                locationDialog(position).show();
            }
        });
        // 상세 정보 버튼
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

    /**
     * 상점의 위치 정보를 다이얼로그로 나타냄
     * @param position 현재 누른 아이템의 위치
     * @return 다이얼로그 반환
     */
    private Dialog locationDialog(int position) {
        ImageView location_ImageView;
        ImageButton close_imgBtn;
        TextView tvLocation;

        final Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.store_location_dialog_layout);
        //dialog.setCancelable(false); // Back 버튼 방지

        location_ImageView = (ImageView) dialog.findViewById(R.id.location_imgView_sldl);
        close_imgBtn = (ImageButton) dialog.findViewById(R.id.close_imgBtn_sldl);
        tvLocation = (TextView) dialog.findViewById(R.id.tvLocation_sldl);

        tvLocation.setText(titles[position] + " 위치");
        location_ImageView.setImageResource(R.drawable.location_dummy);
        close_imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return dialog;
    }

    /**
     * 뷰 홀더
     */
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
