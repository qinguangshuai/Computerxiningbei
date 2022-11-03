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
public class SevenParkCar extends View {

    private Paint mPaint;
    int disparity = 10;

    public SevenParkCar(Context context) {
        this(context, null);
    }

    public SevenParkCar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SevenParkCar(Context context, AttributeSet attrs, int defStyleAttr) {
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
        mPaint.setColor(Color.parseColor("#C00404"));
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        int height = canvas.getHeight();
        int width = canvas.getWidth();

        ParkDataDao sevenDataDao = new ParkDataDao(getContext());
        List<ParkDataUser> sevenParkcar = sevenDataDao.find("sevenParkcar");
        int size = sevenParkcar.size();
        if (size > 1 && size % 2 == 0) {
            for (int i = 0; i < size; i += 2) {
                String ratioOfGpsPointCar = sevenParkcar.get(i).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar = Float.valueOf(ratioOfGpsPointCar);
                String ratioOfGpsPointCar1 = sevenParkcar.get(i + 1).getRatioOfGpsPointCar();
                Float aDoubleRatioOfGpsPointCar1 = Float.valueOf(ratioOfGpsPointCar1);
                if (aDoubleRatioOfGpsPointCar >= 20 && aDoubleRatioOfGpsPointCar <= 78 && aDoubleRatioOfGpsPointCar1 >= 20 && aDoubleRatioOfGpsPointCar1 <= 78) {
                    canvas.drawLine((205 + (aDoubleRatioOfGpsPointCar - 20) * 9.71f), 150 - disparity, (205 + (aDoubleRatioOfGpsPointCar1 - 20) * 9.71f), 150 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar >= 20 && aDoubleRatioOfGpsPointCar <= 78 && aDoubleRatioOfGpsPointCar1 > 78) {
                    canvas.drawLine((205 + (aDoubleRatioOfGpsPointCar - 20) * 9.71f), 150 - disparity, (205 + (78 - 20) * 9.71f), 150 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 20 && aDoubleRatioOfGpsPointCar1 > 78) {
                    canvas.drawLine((205 + (20 - 20) * 9.71f), 150 - disparity, (205 + (78 - 20) * 9.71f), 150 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar < 20 && aDoubleRatioOfGpsPointCar1 >= 20 && aDoubleRatioOfGpsPointCar1 <= 78) {
                    canvas.drawLine((205 + (20 - 20) * 9.71f), 150 - disparity, (205 + (aDoubleRatioOfGpsPointCar1 - 20) * 9.71f), 150 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 >= 20 && aDoubleRatioOfGpsPointCar1 <= 78 && aDoubleRatioOfGpsPointCar > 78) {
                    canvas.drawLine((205 + (aDoubleRatioOfGpsPointCar1 - 20) * 9.71f), 150 - disparity, (205 + (78 - 20) * 9.71f), 150 - disparity, mPaint);
                } else if (aDoubleRatioOfGpsPointCar1 < 20 && aDoubleRatioOfGpsPointCar >= 20 && aDoubleRatioOfGpsPointCar <= 78) {
                    canvas.drawLine((205 + (20 - 20) * 9.71f), 150 - disparity, (205 + (aDoubleRatioOfGpsPointCar - 20) * 9.71f), 150 - disparity, mPaint);
                }else if (aDoubleRatioOfGpsPointCar1 < 20 && aDoubleRatioOfGpsPointCar > 78) {
                    canvas.drawLine((205 + (20 - 20) * 9.71f), 150 - disparity, (205 + (78 - 20) * 9.71f), 150 - disparity, mPaint);
                }
            }
        }
    }
}
