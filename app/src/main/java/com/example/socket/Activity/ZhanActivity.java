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
import com.example.socket.custom.TopViewdiaochezhang;
import com.example.socket.custom.TopViewjiche;
import com.example.socket.custom.TopViewlian1;
import com.example.socket.custom.TopViewlian2;
import com.example.socket.custom.TopViewlian3;
import com.example.socket.custom.TopViewlian4;
import com.example.socket.custom.move.ControlTranslation;
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
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ZhanActivity extends AppCompatActivity implements View.OnClickListener {

    private XiNingBeiMap mXiningbeimap;
    private ChangFengMap mChangfengmap;
    private BaiLiMap mBailimap;
    private TopViewjiche mTrain;
    private TopViewdiaochezhang mTransferpeople;
    private TopViewlian1 mPeopleone;
    private TopViewlian2 mPeopletwo;
    private TopViewlian3 mPeoplethree;
    private TopViewlian4 mPeoplefour;
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
    boolean aaa = false;
    private ChangFengMap mchangfengmap;
    private BaiLiMap mbailimap;
    private XiNingBeiMap mxiningbeimap;
    private SpUtil mControlMap;
    private SpUtil mPeople0, mPeople1, mPeople2, mPeople3, mPeople4;
    private String ratioOfGpsPoint;
    private double mRatioOfGpsTrackCar;

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
        mTrain = findViewById(R.id.trainbig);
        mTransferpeople = findViewById(R.id.diaochezbig);
        mPeopleone = findViewById(R.id.peobigo);
        mPeopletwo = findViewById(R.id.peobigtw);
        mPeoplethree = findViewById(R.id.peobigth);
        mPeoplefour = findViewById(R.id.peobigf);
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

        mchangfengmap = findViewById(R.id.changfengmap);
        mbailimap = findViewById(R.id.bailimap);
        mxiningbeimap = findViewById(R.id.xiningbeimap);

        aaa = true;

    }

    private void getSp() {
        mControlMap = new SpUtil(getApplicationContext(), "controlmap");
        mControlMap.setName("zheng");

        //控制人员显示
        mPeople0 = new SpUtil(getApplicationContext(), "people0");
        mPeople1 = new SpUtil(getApplicationContext(), "people1");
        mPeople2 = new SpUtil(getApplicationContext(), "people2");
        mPeople3 = new SpUtil(getApplicationContext(), "people3");
        mPeople4 = new SpUtil(getApplicationContext(), "people4");
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ZhanchangWrap zhanchangWrap) {
        ratioOfGpsPoint = zhanchangWrap.getRatioOfGpsTrackCar();
        mRatioOfGpsTrackCar = zhanchangWrap.getRatioOfGpsPointCar();
        ControlTranslation.proplrMove1(mControlMap,mTrain, ratioOfGpsPoint, mRatioOfGpsTrackCar, 35, 95);
        ControlTranslation.proplrMove1(mPeople0, mTransferpeople, TalkActivity.mRatioOfGpsTrackCar20, TalkActivity.mGpsPistanceCar20, 35, 95);

        ControlTranslation.proplrMove1(mPeople1, mPeopleone, TalkActivity.mRatioOfGpsTrackCar01, TalkActivity.mGpsPistanceCar01, 35, 95);
        ControlTranslation.proplrMove1(mPeople2, mPeopletwo, TalkActivity.mRatioOfGpsTrackCar02, TalkActivity.mGpsPistanceCar02, 35, 95);
        ControlTranslation.proplrMove1(mPeople3, mPeoplethree, TalkActivity.mRatioOfGpsTrackCar03, TalkActivity.mGpsPistanceCar03, 35, 95);
        ControlTranslation.proplrMove1(mPeople4, mPeoplefour, TalkActivity.mRatioOfGpsTrackCar04, TalkActivity.mGpsPistanceCar04, 35, 95);

        Log.e("chuanzhi：", ratioOfGpsPoint + "  ：  " + mRatioOfGpsTrackCar);
        String mMControlMapName = mControlMap.getName();
        if (mMControlMapName.equals("zheng")) {
            mxiningbeimap.setVisibility(View.VISIBLE);
            mchangfengmap.setVisibility(View.GONE);
            mbailimap.setVisibility(View.GONE);
        } else if(mMControlMapName.equals("cf")){
            mxiningbeimap.setVisibility(View.GONE);
            mchangfengmap.setVisibility(View.VISIBLE);
            mbailimap.setVisibility(View.GONE);
        }else {
            mxiningbeimap.setVisibility(View.GONE);
            mchangfengmap.setVisibility(View.GONE);
            mbailimap.setVisibility(View.VISIBLE);
        }

        if (mPeople0.getName().equals(mMControlMapName) && !TalkActivity.mRatioOfGpsTrackCar20.equals("-1")) {
            mTransferpeople.setVisibility(View.VISIBLE);
        } else {
            mTransferpeople.setVisibility(View.GONE);
        }
        if (mPeople1.getName().equals(mMControlMapName) && !TalkActivity.mRatioOfGpsTrackCar01.equals("-1")) {
            mPeopleone.setVisibility(View.VISIBLE);
        } else {
            mPeopleone.setVisibility(View.GONE);
        }
        if (mPeople2.getName().equals(mMControlMapName) && !TalkActivity.mRatioOfGpsTrackCar02.equals("-1")) {
            mPeopletwo.setVisibility(View.VISIBLE);
        } else {
            mPeopletwo.setVisibility(View.GONE);
        }
        if (mPeople3.getName().equals(mMControlMapName) && !TalkActivity.mRatioOfGpsTrackCar03.equals("-1")) {
            mPeoplethree.setVisibility(View.VISIBLE);
        } else {
            mPeoplethree.setVisibility(View.GONE);
        }
        if (mPeople4.getName().equals(mMControlMapName) && !TalkActivity.mRatioOfGpsTrackCar04.equals("-1")) {
            mPeoplefour.setVisibility(View.VISIBLE);
        } else {
            mPeoplefour.setVisibility(View.GONE);
        }
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