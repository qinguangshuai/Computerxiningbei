package com.example.socket.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.socket.Bean.ZhanchangWrap;
import com.example.socket.R;
import com.example.socket.custom.park.EightParkCar;
import com.example.socket.custom.park.EighteenParkCar;
import com.example.socket.custom.park.ElevenParkCar;
import com.example.socket.custom.park.FifteenParkCar;
import com.example.socket.custom.park.FiveParkCar;
import com.example.socket.custom.park.FourParkCar;
import com.example.socket.custom.park.FourteenParkCar;
import com.example.socket.custom.park.NineParkCar;
import com.example.socket.custom.park.NineteenParkCar;
import com.example.socket.custom.park.OneParkCar;
import com.example.socket.custom.park.SevenParkCar;
import com.example.socket.custom.park.SeventeenParkCar;
import com.example.socket.custom.park.SixParkCar;
import com.example.socket.custom.park.SixteenParkCar;
import com.example.socket.custom.park.TenParkCar;
import com.example.socket.custom.park.ThirteenParkCar;
import com.example.socket.custom.park.ThreeParkCar;
import com.example.socket.custom.park.TwelveParkCar;
import com.example.socket.custom.park.TwoParkCar;
import com.example.socket.custom.people.DrawCar;
import com.example.socket.custom.people.TransferPeople;
import com.example.socket.custom.people.TransferPeopleFour;
import com.example.socket.custom.people.TransferPeopleOne;
import com.example.socket.custom.people.TransferPeopleThree;
import com.example.socket.custom.people.TransferPeopleTwo;
import com.example.socket.custom.xiningbei.BaiLiMap;
import com.example.socket.custom.xiningbei.ChangFengMap;
import com.example.socket.custom.xiningbei.XiNingBeiMap;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ZhanActivity extends AppCompatActivity implements View.OnClickListener {

    private XiNingBeiMap mXiningbeimap;
    private ChangFengMap mChangfengmap;
    private BaiLiMap mBailimap;
    private DrawCar mTrain;
    private TransferPeople mTransferpeople;
    private TransferPeopleOne mPeopleone;
    private TransferPeopleTwo mPeopletwo;
    private TransferPeopleThree mPeoplethree;
    private TransferPeopleFour mPeoplefour;
    private OneParkCar mOneParkCar;
    private TwoParkCar mTwoParkCar;
    private ThreeParkCar mThreeParkCar;
    private FourParkCar mFourParkCar;
    private FiveParkCar mFiveParkCar;
    private SixParkCar mSixParkCar;
    private SevenParkCar mSevenParkCar;
    private EightParkCar mEightParkCar;
    private NineParkCar mNineParkCar;
    private TenParkCar mTenParkCar;
    private ElevenParkCar mElevenParkCar;
    private TwelveParkCar mTwelveParkCar;
    private ThirteenParkCar mThirteenParkCar;
    private FourteenParkCar mFourteenParkCar;
    private FifteenParkCar mFifteenParkCar;
    private SixteenParkCar mSixteenParkCar;
    private SeventeenParkCar mSeventeenParkCar;
    private EighteenParkCar mEighteenParkCar;
    private NineteenParkCar mNineteenParkCar;

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
        mXiningbeimap = findViewById(R.id.xiningbeimap);
        mChangfengmap = findViewById(R.id.changfengmap);
        mBailimap = findViewById(R.id.bailimap);
        mTrain = findViewById(R.id.train);
        mTransferpeople = findViewById(R.id.transferpeople);
        mPeopleone = findViewById(R.id.peopleone);
        mPeopletwo = findViewById(R.id.peopletwo);
        mPeoplethree = findViewById(R.id.peoplethree);
        mPeoplefour = findViewById(R.id.peoplefour);
        //停留车控件
        mOneParkCar = findViewById(R.id.oneParkCar);
        mTwoParkCar = findViewById(R.id.twoParkCar);
        mThreeParkCar = findViewById(R.id.threeParkCar);
        mFourParkCar = findViewById(R.id.fourParkCar);
        mFiveParkCar = findViewById(R.id.fiveParkCar);
        mSixParkCar = findViewById(R.id.sixParkCar);
        mSevenParkCar = findViewById(R.id.sevenParkCar);
        mEightParkCar = findViewById(R.id.eightParkCar);
        mNineParkCar = findViewById(R.id.nineParkCar);
        mTenParkCar = findViewById(R.id.tenParkCar);
        mElevenParkCar = findViewById(R.id.elevenParkCar);
        mTwelveParkCar = findViewById(R.id.twelveParkCar);
        mThirteenParkCar = findViewById(R.id.thirteenParkCar);
        mFourteenParkCar = findViewById(R.id.fourteenParkCar);
        mFifteenParkCar = findViewById(R.id.fifteenParkCar);
        mSixteenParkCar = findViewById(R.id.sixteenParkCar);
        mSeventeenParkCar = findViewById(R.id.seventeenParkCar);
        mEighteenParkCar = findViewById(R.id.eighteenParkCar);
        mNineteenParkCar = findViewById(R.id.nineteenParkCar);
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