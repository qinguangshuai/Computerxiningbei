package com.example.socket.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.socket.R;

public class TopViewlian3 extends LinearLayout {
    public TopViewlian3(Context context) {
        this(context, null);
    }

    public TopViewlian3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopViewlian3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_top_lianjieyuan3, this);
    }
}
