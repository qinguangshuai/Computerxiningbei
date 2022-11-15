package com.example.socket.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.socket.R;

/**
 * 嵌套两个fragment
 * 1.调单显示界面
 * 2.机车运行轨迹界面
 */
public class ComprehensiveActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehensive);
    }
}