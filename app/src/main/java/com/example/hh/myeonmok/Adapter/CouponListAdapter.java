package com.example.hh.myeonmok.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hh.myeonmok.Dialog.CouponDialog;
import com.example.hh.myeonmok.R;

/**
 * RecyclerView 에 사용될 아답터
 * @author  WooTaeYoung
 * @since 2017-07-09 일요일
 */

public class CouponListAdapter extends RecyclerView.Adapter<CouponListAdapter.ViewHolder> {

    /* DB 연동 전 사용되는 더미 배열 값 */
    private String[] titles = {"생선판매점", "의류판매점", "치킨판매점", "애완용품샵", "육류판매점", "맛나분식집"};
    private String[] dates = {"2017-07-09 ~ 2017-07-12", "2017-07-09 ~ 2017-07-14", "2017-07-09 ~ 2017-07-16", "2017-07-09 ~ 2017-07-18", "2017-07-09 ~ 2017-07-20", "2017-07-09 ~ 2017-07-22"};
    private boolean[] use_state = {false, false, false, true, true, false};
    private Context mContext = null; // 쿠폰 사용확인 다이얼로그에서 사용

    public CouponListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CouponListAdapter.ViewHolder holder, final int position) {
        /* 뷰 값 설정 */
        holder.tvCouponTitle.setText(titles[position]);
        holder.tvCouponOutDate.setText(dates[position]);
        // 사용된 쿠폰인지 아닌지 판단 (DB 연동이 안되어 있으므로 더미 배열 값 사용
        if (!use_state[position]) {
            holder.btnCouponUseState.setText("사용");
        }
        else {
            holder.btnCouponUseState.setText("쿠폰 보기");
        }
        holder.btnCouponUseState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선택된 쿠폰이 사용된 쿠폰이 아니면 사용할 것인지 묻는 다이얼로그 표시
                if (!use_state[position]) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle(titles[position]);
                    builder.setMessage("해당 쿠폰을 사용 하시겠습니까?");
                    builder.setPositiveButton("사용", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            holder.btnCouponUseState.setText("쿠폰 보기");
                            use_state[position] = true;
                            // 여기에 DB관련 코드 작성

                            //
                        }
                    });
                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    // 쿠폰 표시
                    CouponDialog dialog = new CouponDialog(mContext, titles[position], dates[position]);
                    dialog.init();
                    dialog.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    /**
     * 뷰 홀더
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCouponTitle;
        public TextView tvCouponOutDate;
        public Button btnCouponUseState;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCouponTitle = (TextView) itemView.findViewById(R.id.tvCouponTitle_ccl);
            tvCouponOutDate = (TextView) itemView.findViewById(R.id.tvCouponOutDate_ccl);
            btnCouponUseState = (Button) itemView.findViewById(R.id.btnCouponUseState_ccl);
        }
    }
}
