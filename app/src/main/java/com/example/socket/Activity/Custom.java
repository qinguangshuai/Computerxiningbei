package com.example.socket.Activity;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @date 2021/9/15 9:20
 */
public class Custom extends View {
    public Custom(Context context) {
        this(context, null);
    }

    public Custom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Custom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Log.e("qgs",width+"    "+height);
    }
}
