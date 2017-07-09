package com.example.hh.myeonmok.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hh.myeonmok.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 쿠폰 정보를 나타내는 클래스
 * @author WooTaeYoung
 * @since 2017-07-09 일요일
 */
public class CouponDialog extends Dialog {
    private TextView tvTitle;
    private TextView tvOutDate;
    private ImageView imgvBarcode;
    private ImageButton imgbtnClose;

    private Context mContext;
    private WindowManager.LayoutParams params;

    private String mTitle;
    private String mDate;
    private float mBrightness;

    /**
     * CouponDialog 생성자
     * @param _context 컨텍스트
     * @param _title 아이템의 위치
     * @param _date 쿠폰 유효기간
     */
    public CouponDialog(Context _context, String _title, String _date) {
        super(_context);
        this.mContext = _context;
        this.mTitle = _title;
        this.mDate = _date;
        this.params = getWindow().getAttributes();
        this.mBrightness = params.screenBrightness; // 기존 화면 밝기 저장

        this.setContentView(R.layout.cupon_barcode_dialog_layout);
        this.setCancelable(false); // Back버튼과 영역밖 클릭 막기
    }

    /**
     * 쿠폰 다이얼로그를 셋팅합니다.
     */
    public void init() {
        tvTitle = (TextView) findViewById(R.id.tvTitle_cbdl);
        tvOutDate = (TextView)findViewById(R.id.tvCouponOutDate_cbdl);
        imgvBarcode = (ImageView) findViewById(R.id.imgvBarcode_cbdl);
        imgbtnClose = (ImageButton) findViewById(R.id.imgbtnClose_cbdl);

        tvTitle.setText(mTitle);
        tvOutDate.setText(mDate);

        setBarcodeBitmap();

        imgbtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다이얼로그가 꺼질때 기존의 밝기로 돌아옴
                params.screenBrightness = mBrightness;
                getWindow().setAttributes(params);
                dismiss();
            }
        });
    }

    /**
     * 쿠폰 이미지를 표시합니다.
     */
    private void setBarcodeBitmap() {
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            final int WIDTH = 600; //imgvBarcode.getWidth();
            final int HEIGHT = 300; //imgvBarcode.getHeight();
            Log.d("TAG", String.valueOf(WIDTH) + String.valueOf(HEIGHT));
            BitMatrix bytemap = writer.encode(mDate, BarcodeFormat.CODE_128, WIDTH, HEIGHT);
            Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);

            for (int i = 0; i < WIDTH; ++i) {
                for (int j = 0; j < HEIGHT; ++j) {
                    bitmap .setPixel(i, j, bytemap.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            }
            // 이미지뷰에 생성된 바코드 이미지 설정
            imgvBarcode.setImageBitmap(bitmap);
            imgvBarcode.invalidate();
            // 바코드의 원활한 사용을 위해 화면밝기를 최대로 설정
            params.screenBrightness = 1f;
            getWindow().setAttributes(params);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
