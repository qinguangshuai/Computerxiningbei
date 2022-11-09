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
 * 1道停留车
 */
public class OneParkCar extends View {

    private Paint mPaint;
    int disparity = 10;

    public OneParkCar(Context context) {
        this(context, null);
    }

    public OneParkCar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneParkCar(Context context, AttributeSet attrs, int defStyleAttr) {
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

        ParkDataDao oneDataDao = new ParkDataDao(getContext());
        List<ParkDataUser> oneParkcar = oneDataDao.find("oneParkcar");
        int size = oneParkcar.size();
        if (size > 1 && size % 2 == 0) {
            for (int i = 0; i < size; i += 2) {
                String ratioOfGpsPointCar = oneParkcar.get(i).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar = Float.valueOf(ratioOfGpsPointCar);
                String ratioOfGpsPointCar1 = oneParkcar.get(i + 1).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar1 = Float.valueOf(ratioOfGpsPointCar1);
                if (aDoubleRatioOfGpsPointCar >= 5 && aDoubleRatioOfGpsPointCar <= 94 && aDoubleRatioOfGpsPointCar1 >= 5 && aDoubleRatioOfGpsPointCar1 <= 94) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar - 5) * 2.88f), 500 - disparity, (384 + (aDoubleRatioOfGpsPointCar1 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar >= 5 && aDoubleRatioOfGpsPointCar <= 94 && aDoubleRatioOfGpsPointCar1 > 94) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar - 5) * 2.88f), 500 - disparity, (384 + (94 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 5 && aDoubleRatioOfGpsPointCar1 > 94) {
                    canvas.drawLine((384 + (5 - 5) * 2.88f), 500 - disparity, (384 + (94 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 5 && aDoubleRatioOfGpsPointCar1 >= 5 && aDoubleRatioOfGpsPointCar1 <= 94) {
                    canvas.drawLine((384 + (5 - 5) * 2.88f), 500 - disparity, (384 + (aDoubleRatioOfGpsPointCar1 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 >= 5 && aDoubleRatioOfGpsPointCar1 <= 94 && aDoubleRatioOfGpsPointCar > 94) {
                    canvas.drawLine((384 + (aDoubleRatioOfGpsPointCar1 - 5) * 2.88f), 500 - disparity, (384 + (94 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 < 5 && aDoubleRatioOfGpsPointCar > 94) {
                    canvas.drawLine((384 + (5 - 5) * 2.88f), 500 - disparity, (384 + (94 - 5) * 2.88f), 500 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 < 5 && aDoubleRatioOfGpsPointCar >= 5 && aDoubleRatioOfGpsPointCar <= 94) {
                    canvas.drawLine((384 + (5 - 5) * 2.88f), 500 - disparity, (384 + (aDoubleRatioOfGpsPointCar - 5) * 2.88f), 500 - disparity, mPaint);
                }
            }
        }
    }
}
