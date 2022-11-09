package com.example.socket.custom.people;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.socket.R;

public class TopViewlian4 extends LinearLayout {
    public TopViewlian4(Context context) {
        this(context, null);
    }

    public TopViewlian4(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopViewlian4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.view_top_lianjieyuan4, this);
    }
}
