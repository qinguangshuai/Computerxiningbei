package com.example.socket.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.socket.Bean.ZhanchangWrap;
import com.example.socket.R;
import com.example.socket.Unit.SpUtil;
import com.example.socket.custom.dao.ParkDataDao;
import com.example.socket.custom.people.TopViewdiaochezhang;
import com.example.socket.custom.people.TopViewjiche;
import com.example.socket.custom.people.TopViewlian1;
import com.example.socket.custom.people.TopViewlian2;
import com.example.socket.custom.people.TopViewlian3;
import com.example.socket.custom.people.TopViewlian4;
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
    private SpUtil mControlMap;
    private SpUtil mPeople0, mPeople1, mPeople2, mPeople3, mPeople4;
    private String mRatioOfGpsPoint;
    private double mRatioOfGpsTrackCar;
    private int a = 0;

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

        aaa = true;
        ParkDataDao dataDao = new ParkDataDao(this);
//        dataDao.add("oneParkcar","1","101.767750","36.662057",61);
//        dataDao.add("oneParkcar","1","101.768745","36.659256",93);
//        dataDao.add("twelveParkcar","1","","","26");
//        dataDao.add("twelveParkcar","1","","","46");
//        dataDao.add("twelveParkcar","1","","","56");
//        dataDao.add("twelveParkcar","1","","","76");
//        dataDao.add("thirteenParkcar","1","","","0");
//        dataDao.add("thirteenParkcar","1","","","60");
//        dataDao.add("thirteenParkcar","1","","","80");
//        dataDao.add("thirteenParkcar","1","","","99");
//        dataDao.add("fourteenParkcar","1","","","50");
//        dataDao.add("fourteenParkcar","1","","","89");
//        dataDao.add("fifteenParkcar","1","","","50");
//        dataDao.add("fifteenParkcar","1","","","89");
//        dataDao.add("sixteenParkcar","1","","","30");
//        dataDao.add("sixteenParkcar","1","","","40");
//        dataDao.add("sixteenParkcar","1","","","50");
//        dataDao.add("sixteenParkcar","1","","","60");
//        dataDao.add("seventeenParkcar","1","","","60");
//        dataDao.add("seventeenParkcar","1","","","70");
//        dataDao.add("eighteenParkcar","1","","","10");
//        dataDao.add("eighteenParkcar","1","","","50");
//        dataDao.add("nineteenParkcar","1","","","0");
//        dataDao.add("nineteenParkcar","1","","","10");
//        dataDao.add("nineteenParkcar","1","","","20");
//        dataDao.add("nineteenParkcar","1","","","40");
//        dataDao.add("nineteenParkcar","1","","","70");
//        dataDao.add("nineteenParkcar","1","","","90");
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
        String name = mControlMap.getName();
        Log.e("撒大大", name);
        if (name.equals("zheng")) {
            mXiningbeimap.setVisibility(View.VISIBLE);
            mChangfengmap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.GONE);
            zhengPark();
        } else if (name.equals("cf")) {
            mXiningbeimap.setVisibility(View.GONE);
            mChangfengmap.setVisibility(View.VISIBLE);
            mBailimap.setVisibility(View.GONE);
            changfengPark();
        } else {
            mXiningbeimap.setVisibility(View.GONE);
            mChangfengmap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.VISIBLE);
            bailiPark();
        }
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ZhanchangWrap zhanchangWrap) {
        mRatioOfGpsPoint = zhanchangWrap.getRatioOfGpsTrackCar();
        mRatioOfGpsTrackCar = zhanchangWrap.getRatioOfGpsPointCar();
        ControlTranslation.proplrMove1(mControlMap, mTrain, mRatioOfGpsPoint, mRatioOfGpsTrackCar, 35, 95);
        ControlTranslation.proplrMove1(mPeople0, mTransferpeople, TalkActivity.mRatioOfGpsTrackCar20, TalkActivity.mGpsPistanceCar20, 35, 95);

        ControlTranslation.proplrMove1(mPeople1, mPeopleone, TalkActivity.mRatioOfGpsTrackCar01, TalkActivity.mGpsPistanceCar01, 35, 95);
        ControlTranslation.proplrMove1(mPeople2, mPeopletwo, TalkActivity.mRatioOfGpsTrackCar02, TalkActivity.mGpsPistanceCar02, 35, 95);
        ControlTranslation.proplrMove1(mPeople3, mPeoplethree, TalkActivity.mRatioOfGpsTrackCar03, TalkActivity.mGpsPistanceCar03, 35, 95);
        ControlTranslation.proplrMove1(mPeople4, mPeoplefour, TalkActivity.mRatioOfGpsTrackCar04, TalkActivity.mGpsPistanceCar04, 35, 95);

        Log.e("chuanzhi：", mRatioOfGpsPoint + "  ：  " + mRatioOfGpsTrackCar);
        String mMControlMapName = mControlMap.getName();
        if (mMControlMapName.equals("zheng")) {
            mXiningbeimap.setVisibility(View.VISIBLE);
            mChangfengmap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.GONE);
            zhengPark();
        } else if (mMControlMapName.equals("cf")) {
            mXiningbeimap.setVisibility(View.GONE);
            mChangfengmap.setVisibility(View.VISIBLE);
            mBailimap.setVisibility(View.GONE);
            changfengPark();
        } else {
            mXiningbeimap.setVisibility(View.GONE);
            mChangfengmap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.VISIBLE);
            bailiPark();
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

    private void zhengPark() {
        mOneParkCar.setVisibility(View.VISIBLE);
        mTwoParkCar.setVisibility(View.VISIBLE);
        mThreeParkCar.setVisibility(View.VISIBLE);
        mFourParkCar.setVisibility(View.VISIBLE);
        mFiveParkCar.setVisibility(View.VISIBLE);
        mSixParkCar.setVisibility(View.VISIBLE);
        mSevenParkCar.setVisibility(View.VISIBLE);
        mEightParkCar.setVisibility(View.VISIBLE);
        mNineParkCar.setVisibility(View.GONE);
        mTenParkCar.setVisibility(View.GONE);
        mElevenParkCar.setVisibility(View.GONE);
        mTwelveParkCar.setVisibility(View.GONE);
        mThirteenParkCar.setVisibility(View.GONE);
        mFourteenParkCar.setVisibility(View.GONE);
        mFifteenParkCar.setVisibility(View.GONE);
        mSixteenParkCar.setVisibility(View.GONE);
        mSeventeenParkCar.setVisibility(View.GONE);
        mEighteenParkCar.setVisibility(View.GONE);
        mNineteenParkCar.setVisibility(View.GONE);
    }

    private void changfengPark() {
        mOneParkCar.setVisibility(View.GONE);
        mTwoParkCar.setVisibility(View.GONE);
        mThreeParkCar.setVisibility(View.GONE);
        mFourParkCar.setVisibility(View.GONE);
        mFiveParkCar.setVisibility(View.GONE);
        mSixParkCar.setVisibility(View.GONE);
        mSevenParkCar.setVisibility(View.GONE);
        mEightParkCar.setVisibility(View.GONE);
        mNineParkCar.setVisibility(View.VISIBLE);
        mTenParkCar.setVisibility(View.VISIBLE);
        mElevenParkCar.setVisibility(View.VISIBLE);
        mTwelveParkCar.setVisibility(View.VISIBLE);
        mThirteenParkCar.setVisibility(View.VISIBLE);
        mFourteenParkCar.setVisibility(View.VISIBLE);
        mFifteenParkCar.setVisibility(View.GONE);
        mSixteenParkCar.setVisibility(View.GONE);
        mSeventeenParkCar.setVisibility(View.GONE);
        mEighteenParkCar.setVisibility(View.GONE);
        mNineteenParkCar.setVisibility(View.GONE);
    }

    private void bailiPark() {
        mOneParkCar.setVisibility(View.GONE);
        mTwoParkCar.setVisibility(View.GONE);
        mThreeParkCar.setVisibility(View.GONE);
        mFourParkCar.setVisibility(View.GONE);
        mFiveParkCar.setVisibility(View.GONE);
        mSixParkCar.setVisibility(View.GONE);
        mSevenParkCar.setVisibility(View.GONE);
        mEightParkCar.setVisibility(View.GONE);
        mNineParkCar.setVisibility(View.GONE);
        mTenParkCar.setVisibility(View.GONE);
        mElevenParkCar.setVisibility(View.GONE);
        mTwelveParkCar.setVisibility(View.GONE);
        mThirteenParkCar.setVisibility(View.GONE);
        mFourteenParkCar.setVisibility(View.GONE);
        mFifteenParkCar.setVisibility(View.VISIBLE);
        mSixteenParkCar.setVisibility(View.VISIBLE);
        mSeventeenParkCar.setVisibility(View.VISIBLE);
        mEighteenParkCar.setVisibility(View.VISIBLE);
        mNineteenParkCar.setVisibility(View.VISIBLE);
    }
}