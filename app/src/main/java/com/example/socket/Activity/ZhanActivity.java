package com.example.socket.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.socket.Bean.ZhanchangWrap;
import com.example.socket.R;
import com.example.socket.Unit.SpUtil;
import com.example.socket.custom.move.ControlTranslation;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ZhanActivity extends AppCompatActivity implements View.OnClickListener {

    private View bailimap;
    private View changfengmap;
    private View xiningbeimap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        EventBus.getDefault().register(this);
        initView();
        getSp();
    }

    private void initView() {
        //返回
        ImageView narrow = findViewById(R.id.narrow);
        narrow.setOnClickListener(this);

        bailimap = findViewById(R.id.bailimap);
        changfengmap = findViewById(R.id.changfengmap);
        xiningbeimap = findViewById(R.id.xiningbeimap);


    }

    private void getSp() {

    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ZhanchangWrap zhanchangWrap) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.narrow:
                finish();
                break;
        }
    }
}