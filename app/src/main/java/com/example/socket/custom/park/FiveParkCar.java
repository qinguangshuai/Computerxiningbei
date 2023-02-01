package com.example.socket.custom.park;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.socket.custom.dao.ParkDataDao;
import com.example.socket.custom.dao.ParkDataUser;

import java.util.List;

/**
 * @date 2020/8/10 16:33
 * 5道停留车
 */
public class FiveParkCar extends View {

    private Paint mPaint;
    int disparity = 10;

    public FiveParkCar(Context context) {
        this(context, null);
    }

    public FiveParkCar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FiveParkCar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //创建一个画笔
        mPaint = new Paint(Paint.DITHER_FLAG);
        //设置非填充
        mPaint.setStyle(Paint.Style.STROKE);
        //笔宽5像素
        mPaint.setStrokeWidth(20);
        //设置为红笔
        mPaint.setColor(Color.parseColor("#FD9DA8"));
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        int height = canvas.getHeight();
        int width = canvas.getWidth();

        ParkDataDao fiveDataDao = new ParkDataDao(getContext());
        List<ParkDataUser> fiveParkcar = fiveDataDao.find("fiveParkcar");
        int size = fiveParkcar.size();
        if (size > 1 && size % 2 == 0) {
            for (int i = 0; i < size; i += 2) {
                String ratioOfGpsPointCar = fiveParkcar.get(i).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar = Float.valueOf(ratioOfGpsPointCar);
                String ratioOfGpsPointCar1 = fiveParkcar.get(i + 1).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar1 = Float.valueOf(ratioOfGpsPointCar1);
                if (aDoubleRatioOfGpsPointCar >= 6 && aDoubleRatioOfGpsPointCar <= 93 && aDoubleRatioOfGpsPointCar1 >= 6 && aDoubleRatioOfGpsPointCar1 <= 93) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar - 6) * 2.94f), 300 - disparity, (384 + (aDoubleRatioOfGpsPointCar1 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar >= 6 && aDoubleRatioOfGpsPointCar <= 93 && aDoubleRatioOfGpsPointCar1 > 93) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar - 6) * 2.94f), 300 - disparity, (384 + (93 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 6 && aDoubleRatioOfGpsPointCar1 > 93) {
                    canvas.drawLine((384 + (6 - 6) * 2.94f), 300 - disparity, (384 + (93 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 6 && aDoubleRatioOfGpsPointCar1 >= 6 && aDoubleRatioOfGpsPointCar1 <= 93) {
                    canvas.drawLine((384 + (6 - 6) * 2.94f), 300 - disparity, (384 + (aDoubleRatioOfGpsPointCar1 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 >= 6 && aDoubleRatioOfGpsPointCar1 <= 93 && aDoubleRatioOfGpsPointCar > 93) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar - 6) * 2.94f), 300 - disparity, (384 + (93 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 < 6 && aDoubleRatioOfGpsPointCar > 93) {
                    canvas.drawLine((384 + (6 - 6) * 2.94f), 300 - disparity, (384 + (93 - 6) * 2.94f), 300 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 < 6 && aDoubleRatioOfGpsPointCar >= 6 && aDoubleRatioOfGpsPointCar <= 93) {
                    canvas.drawLine((384 + (6 - 6) * 2.94f), 300 - disparity, (384 + (aDoubleRatioOfGpsPointCar - 6) * 2.94f), 300 - disparity, mPaint);
                }
            }
        }
    }
}
