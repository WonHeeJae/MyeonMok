package com.example.hh.myeonmok.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hh.myeonmok.R;

/**
 * 쿠폰관리 액티비티에 사용될 RecyclerView Adapter
 * @author WooTaeYoung
 * @since 2017-07-11 화요일
 */

public class CouponManagementListAdapter extends RecyclerView.Adapter<CouponManagementListAdapter.ViewHolder> {

    /* DB 연동 전 사용되는 더미 배열 값 */
    private int[] nos = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private String[] titles = {"생선판매점", "의류판매점", "치킨판매점", "애완용품샵", "육류판매점", "맛나분식집", "제일분식집", "면목식당", "면목음식집", "해피마트"};
    private String[] dates = {"2017-07-09 ~ 2017-07-12", "2017-07-09 ~ 2017-07-14", "2017-07-09 ~ 2017-07-16", "2017-07-09 ~ 2017-07-18", "2017-07-09 ~ 2017-07-20", "2017-07-09 ~ 2017-07-22", "2017-07-09 ~ 2017-07-24", "2017-07-09 ~ 2017-07-26", "2017-07-09 ~ 2017-07-28", "2017-07-09 ~ 2017-07-30"};
    private boolean[] use_state = {false, false, false, true, true, false, true, false, true, true};

    @Override
    public CouponManagementListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_management_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CouponManagementListAdapter.ViewHolder holder, int position) {
        /* 뷰 값 설정 */
        holder.tvCouponNo.setText(String.valueOf(nos[position]));
        holder.tvCouponName.setText(titles[position]);
        holder.tvCouponDate.setText(dates[position]);
        if (use_state[position])
            holder.tvCouponUse.setText("완료");
        else
            holder.tvCouponUse.setText("사용중");
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    /**
     * 뷰 홀더
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCouponNo;
        public TextView tvCouponName;
        public TextView tvCouponDate;
        public TextView tvCouponUse;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCouponNo = (TextView) itemView.findViewById(R.id.tvCouponNo_cml);
            tvCouponName = (TextView) itemView.findViewById(R.id.tvCouponName_cml);
            tvCouponDate = (TextView) itemView.findViewById(R.id.tvCouponDate_cml);
            tvCouponUse = (TextView) itemView.findViewById(R.id.tvCouponUse_cml);
        }
    }
}
