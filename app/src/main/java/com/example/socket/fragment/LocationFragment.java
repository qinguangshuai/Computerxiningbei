package com.example.socket.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socket.R;
import com.example.socket.Unit.SpUtil;
import com.example.socket.Unit.TrackDataUtil;
import com.example.socket.custom.data.Point3d;
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

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationFragment extends Fragment {

    private SpUtil mOnePickLeft, mTwoPickLeft, mThreePickLeft, mFourPickLeft, mFivePickLeft, mSixPickLeft, mSevenPickLeft, mEightPickLeft;
    private SpUtil mNinePickLeft, mTenPickLeft, mElevenpickleft, mTwelvePickLeft, mThirteenPickLeft, mFourteenPickLeft;
    private SpUtil mFifteenPickLeft, mSixteenPickLeft, mSeventeenPickLeft, mEighteenPickLeft, mNineteenPickLeft;
    private SpUtil mOnepickright, mTwopickright, mThreepickright, mFourpickright, mFivepickright, mSixpickright, mSevenpickright, mEightpickright;
    private SpUtil mNinepickright, mTenpickright, mElevenpickright, mTwelvepickright, mThirteenpickright, mFourteenpickright;
    private SpUtil mFifteenPickRight, mSixteenPickRight, mSeventeenPickRight, mEighteenPickRight, mNineteenPickRight;
    private View mView;
    private XiNingBeiMap mXiningbeimap;
    private ChangFengMap mChangfengmap;
    private BaiLiMap mBailimap;
//    private DrawCar mTrain;
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
    private int mGetGudaoOfGpsPoint;
    private String mRatioOfGpsTrackCar, mMControlMapName;
    private double mGetRatioOfGpsPointCar;
    private Double mGpsPistanceCar;
    private SpUtil mControlMap, mMap1, mMap2, mMap3, mMain;
    //机车横向减
    int transverse = 30;
    //人员横向减
    int transverse1 = 15;
    //机车纵向减
    int disparity = 30;
    //人员纵向减
    int disparity1 = 30;
    private int mGuDao;
    HashMap<Integer, ArrayList<Point3d>> gps = new HashMap<>();

    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageWrap msg) {
        String name1 = mMap1.getName();
        String name2 = mMap2.getName();
        String name3 = mMap3.getName();
        mMControlMapName = mControlMap.getName();
        if (mMControlMapName.equals("zheng")) {
            mXiningbeimap.setVisibility(View.VISIBLE);
            mChangfengmap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.GONE);
            mMain.setName("main");
        } else if (mMControlMapName.equals("cf")) {
            mChangfengmap.setVisibility(View.VISIBLE);
            mXiningbeimap.setVisibility(View.GONE);
            mBailimap.setVisibility(View.GONE);
            mMain.setName("changfeng");
        } else if (mMControlMapName.equals("bl")) {
            mBailimap.setVisibility(View.VISIBLE);
            mChangfengmap.setVisibility(View.GONE);
            mXiningbeimap.setVisibility(View.GONE);
            mMain.setName("baili");
        }

        String lat = msg.lat;
        String lon = msg.lon;
        Double latDouble = Double.valueOf(lat);
        Double lonDouble = Double.valueOf(lon);
        Log.i("去干啥", lat + "    " + lon);

        //股道号
        mGetGudaoOfGpsPoint = GetGudaoOfGpsPoint(lonDouble, latDouble);
        mRatioOfGpsTrackCar = String.valueOf(mGetGudaoOfGpsPoint);
        Point3d point3d = new Point3d();
        point3d.setX(lonDouble);
        point3d.setY(latDouble);
        mGetRatioOfGpsPointCar = GetRatioOfGpsPoint(point3d, mGetGudaoOfGpsPoint);

        DecimalFormat df1 = new DecimalFormat("#####0.00%");
        DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
        df1.setDecimalFormatSymbols(symbols1);
        String ratioOfGpsPoint = df1.format(mGetRatioOfGpsPointCar);
        String gpsPoint = ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("."));
        mGpsPistanceCar = Double.valueOf(gpsPoint);
        Log.i("去干啥", mGetGudaoOfGpsPoint + "    " + mRatioOfGpsTrackCar + "    " + mGetRatioOfGpsPointCar + "    " + mGpsPistanceCar);
        ControlTranslation.proplrMove1(mControlMap, mTrain, mRatioOfGpsTrackCar, mGpsPistanceCar, transverse, disparity);
        //distanceControl(mRatioOfGpsTrackCar, mGpsPistanceCar, latDouble, lonDouble);
        refrash();
    }*/

    private void refrash() {
        mOneParkCar.invalidate();
        mTwoParkCar.invalidate();
        mThreeParkCar.invalidate();
        mFourParkCar.invalidate();
        mFiveParkCar.invalidate();
        mSixParkCar.invalidate();
        mSevenParkCar.invalidate();
        mEightParkCar.invalidate();
        mNineParkCar.invalidate();
        mTenParkCar.invalidate();
        mElevenParkCar.invalidate();
        mTwelveParkCar.invalidate();
        mThirteenParkCar.invalidate();
        mFourteenParkCar.invalidate();
        mFifteenParkCar.invalidate();
        mSixteenParkCar.invalidate();
        mSeventeenParkCar.invalidate();
        mEighteenParkCar.invalidate();
        mNineteenParkCar.invalidate();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_location, container, false);
        EventBus.getDefault().register(this);
        initView();
        addLoc();
        return mView;
    }

    private void initView() {
        mXiningbeimap = mView.findViewById(R.id.xiningbeimap);
        mChangfengmap = mView.findViewById(R.id.changfengmap);
        mBailimap = mView.findViewById(R.id.bailimap);
//        mTrain = mView.findViewById(R.id.drawcar);

        mOneParkCar = mView.findViewById(R.id.oneParkCar);
        mTwoParkCar = mView.findViewById(R.id.twoParkCar);
        mThreeParkCar = mView.findViewById(R.id.threeParkCar);
        mFourParkCar = mView.findViewById(R.id.fourParkCar);
        mFiveParkCar = mView.findViewById(R.id.fiveParkCar);
        mSixParkCar = mView.findViewById(R.id.sixParkCar);
        mSevenParkCar = mView.findViewById(R.id.sevenParkCar);
        mEightParkCar = mView.findViewById(R.id.eightParkCar);
        mNineParkCar = mView.findViewById(R.id.nineParkCar);
        mTenParkCar = mView.findViewById(R.id.tenParkCar);
        mElevenParkCar = mView.findViewById(R.id.elevenParkCar);
        mTwelveParkCar = mView.findViewById(R.id.twelveParkCar);
        mThirteenParkCar = mView.findViewById(R.id.thirteenParkCar);
        mFourteenParkCar = mView.findViewById(R.id.fourteenParkCar);
        mFifteenParkCar = mView.findViewById(R.id.fifteenParkCar);
        mSixteenParkCar = mView.findViewById(R.id.sixteenParkCar);
        mSeventeenParkCar = mView.findViewById(R.id.seventeenParkCar);
        mEighteenParkCar = mView.findViewById(R.id.eighteenParkCar);
        mNineteenParkCar = mView.findViewById(R.id.nineteenParkCar);

        //站场图 控制三个布局
        mMain = new SpUtil(getActivity(), "main");
        //控制战场图
        mMap1 = new SpUtil(getActivity(), "map1");
        mMap2 = new SpUtil(getActivity(), "map2");
        mMap3 = new SpUtil(getActivity(), "map3");
        //控制界面显示
        mControlMap = new SpUtil(getActivity(), "controlmap");

        //1道停留车左点
        mOnePickLeft = new SpUtil(getActivity(), "onepickleft");
        //1道停留车右点
        mOnepickright = new SpUtil(getActivity(), "onepickright");
        //2道停留车左点
        mTwoPickLeft = new SpUtil(getActivity(), "twopickleft");
        //2道停留车右点
        mTwopickright = new SpUtil(getActivity(), "twopickright");
        //3道停留车左点
        mThreePickLeft = new SpUtil(getActivity(), "threepickleft");
        //3道停留车右点
        mThreepickright = new SpUtil(getActivity(), "threepickright");
        //4道停留车左点
        mFourPickLeft = new SpUtil(getActivity(), "fourpickleft");
        //4道停留车右点
        mFourpickright = new SpUtil(getActivity(), "fourpickright");
        //5道停留车左点
        mFivePickLeft = new SpUtil(getActivity(), "fivepickleft");
        //5道停留车右点
        mFivepickright = new SpUtil(getActivity(), "fivepickright");
        //6道停留车左点
        mSixPickLeft = new SpUtil(getActivity(), "sixpickleft");
        //6道停留车右点
        mSixpickright = new SpUtil(getActivity(), "sixpickright");
        //7道停留车左点
        mSevenPickLeft = new SpUtil(getActivity(), "sevenpickleft");
        //7道停留车右点
        mSevenpickright = new SpUtil(getActivity(), "sevenpickright");
        //8道停留车左点
        mEightPickLeft = new SpUtil(getActivity(), "eightpickleft");
        //8道停留车右点
        mEightpickright = new SpUtil(getActivity(), "eightpickright");
        //9道停留车左点
        mNinePickLeft = new SpUtil(getActivity(), "ninepickleft");
        //9道停留车右点
        mNinepickright = new SpUtil(getActivity(), "ninepickright");
        //10道停留车左点
        mTenPickLeft = new SpUtil(getActivity(), "tenpickleft");
        //10道停留车右点
        mTenpickright = new SpUtil(getActivity(), "tenpickright");
        //11道停留车左点
        mElevenpickleft = new SpUtil(getActivity(), "elevenpickleft");
        //11道停留车右点
        mElevenpickright = new SpUtil(getActivity(), "elevenpickright");
        //12道停留车左点
        mTwelvePickLeft = new SpUtil(getActivity(), "twelvepickleft");
        //12道停留车右点
        mTwelvepickright = new SpUtil(getActivity(), "twelvepickright");
        //13道停留车左点
        mThirteenPickLeft = new SpUtil(getActivity(), "thirteenpickleft");
        //13道停留车右点
        mThirteenpickright = new SpUtil(getActivity(), "thirteenpickright");
        //14道停留车左点
        mFourteenPickLeft = new SpUtil(getActivity(), "fourteenpickleft");
        //14道停留车右点
        mFourteenpickright = new SpUtil(getActivity(), "fourteenpickright");
        //15道停留车左点
        mFifteenPickLeft = new SpUtil(getActivity(), "fifteenpickleft");
        //15道停留车右点
        mFifteenPickRight = new SpUtil(getActivity(), "fifteenpickright");
        //16道停留车左点
        mSixteenPickLeft = new SpUtil(getActivity(), "sixteenpickleft");
        //16道停留车右点
        mSixteenPickRight = new SpUtil(getActivity(), "sixteenpickright");
        //17道停留车左点
        mSeventeenPickLeft = new SpUtil(getActivity(), "seventeenpickleft");
        //17道停留车右点
        mSeventeenPickRight = new SpUtil(getActivity(), "seventeenpickright");
        //18道停留车左点
        mEighteenPickLeft = new SpUtil(getActivity(), "eighteenpickleft");
        //18道停留车右点
        mEighteenPickRight = new SpUtil(getActivity(), "eighteenpickright");
        //19道停留车左点
        mNineteenPickLeft = new SpUtil(getActivity(), "nineteenpickleft");
        //19道停留车右点
        mNineteenPickRight = new SpUtil(getActivity(), "nineteenpickright");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void addLoc() {
        gps = TrackDataUtil.getGps();
    }

    public double DistanceOfPointToLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double jl = 0.0, A = 0.0, B = 0.0, C = 0.0, d = 0.0, d1 = 0.0, d2 = 0.0, x = 0.0, y = 0.0;
        A = y2 - y1;
        B = x1 - x2;
        C = x2 * y1 - x1 * y2;
        x = (B * B * x0 - A * B * y0 - A * C) / (A * A + B * B);         //垂足坐标
        y = (A * A * y0 - A * B * x0 - B * C) / (A * A + B * B);         //垂足坐标
        d = Math.abs((A * x0 + B * y0 + C) / Math.sqrt(A * A + B * B));  //点到直线距离
        d1 = Math.sqrt((x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1));   //点到点距离
        d2 = Math.sqrt((x0 - x2) * (x0 - x2) + (y0 - y2) * (y0 - y2));   //点到点距离
        if ((x <= Math.max(x1, x2)) && (x >= Math.min(x1, x2))) {
            jl = d;
        } else {
            jl = Math.min(d1, d2);
        }
        return jl;
    }

    public double GetGpsDistanceOfPointToLine(Point3d p, Point3d p1, Point3d p2) {
        double d = 0.0;
        double c, x1, y1, x2, y2;
        double lat;    //纬度
        double lon;    //经度
        double R = 6371393.0;   //平均半径  数据来源:百度百科
        //平均纬度
        c = (p.X + p1.X + p2.X) / 3.0;
        //经纬度1度对应距离
        lat = 2 * Math.PI * R / 360.0;
        lon = 2 * Math.PI * R * Math.cos(c * Math.PI / 180.0) / 360.0;
        //以米为单位的新坐标
        x1 = (p1.X - p.X) * lat;
        y1 = (p1.Y - p.Y) * lon;
        x2 = (p2.X - p.X) * lat;
        y2 = (p2.Y - p.Y) * lon;
        d = DistanceOfPointToLine(0d, 0d, x1, y1, x2, y2);
        return d;
    }

    public int GetGudaoOfGpsPoint(double x, double y) {
        int i, j, n;
        double dis = 5.0, dd = 0d;
        n = -1;
        Point3d p = new Point3d();
        p.X = x;
        p.Y = y;
        //p.Z = 0d;
        for (i = 1; i <= gps.size(); i++) {
            for (j = 0; j < gps.get(i).size() - 1; j++) {
                dd = GetGpsDistanceOfPointToLine(p, gps.get(i).get(j), gps.get(i).get(j + 1));
                //Log.i(TAG, "dd：" + dd);
                if (dd < dis) {
                    dis = dd;
                    n = i;                              //GPS股道从9开始，UWB股道从4开始
                }
            }
            //mTv3.setText("点到股道距离:     gudao: " + i + "     " + dis);
        }
        if (dis > 5.0) {
            n = -1;
        }
        return n;
    }

    public double GetRatioOfGpsPoint(Point3d p, int gd) {
        //Log.i(TAG, "Point3d：" + p.X);
        //Log.i(TAG, "Point3d：" + p.Y);
        //Log.i(TAG, "gd：" + gd);
        double r = 0d;
        double A, B, C, x, y, x1, x2;
        if (gd >= 0) {
            Point3d p1 = new Point3d();
            Point3d p2 = new Point3d();
            mGuDao = gd;
            int size = gps.get(mGuDao).size();
            p1 = gps.get(mGuDao).get(0);
            p2 = gps.get(mGuDao).get(size - 1);
            //Log.i(TAG, "size：" + size);
            //Log.i(TAG, "p1：" + p1.X);
            //Log.i(TAG, "p2：" + p2.X);
            //p1 = listgpspt[gd][0];
            //p2 = listgpspt[gd][listgpspt[gd].Count - 1];
            A = p2.Y - p1.Y;
            B = p1.X - p2.X;
            C = p2.X * p1.Y - p1.X * p2.Y;
            x = (B * B * p.X - A * B * p.Y - A * C) / (A * A + B * B);         //垂足坐标
            y = (A * A * p.Y - A * B * p.X - B * C) / (A * A + B * B);         //垂足坐标
            DecimalFormat df = new DecimalFormat("#.000000");
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            df.setDecimalFormatSymbols(symbols);
            String chui = df.format(x);
            Double aDouble = Double.valueOf(chui);
            //Log.i(TAG, "x bjxt：" + aDouble);
            x1 = gps.get(mGuDao).get(0).X;
            x2 = gps.get(mGuDao).get(size - 1).X;
            //Log.i(TAG, "x1 bjxt：" + x1);
            //Log.i(TAG, "x2 bjxt：" + x2);
            //x1 = listgpspt[gd][0].X;
            //x2 = listgpspt[gd][listgpspt[gd].Count - 1].X;
            //r = (x1 - x) / (x1 - x2);
            r = (aDouble - x2) / (x1 - x2);
            //Log.i(TAG, "r：" + r);
            //n = (int)Math.Round(r * 100);
        }
        return r;
    }

    //获取最小值下标
    private int getMinIndex(List<Integer> mList) {
        int min = mList.get(0);
        int index = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (min > mList.get(i)) {
                min = mList.get(i);
                index = i;
            }
        }
        return index;
    }

    //获取最小值
    private int getMin(List<Integer> mList) {
        int min = mList.get(0);
        for (int i = 0; i < mList.size(); i++) {
            if (min > mList.get(i)) {
                min = mList.get(i);
            }
        }
        return min;
    }

    //获取最大值下标
    private int getMaxIndex(List<Integer> mList) {
        int max = mList.get(0);
        int index = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (max < mList.get(i)) {
                max = mList.get(i);
                index = i;
            }
        }
        return index;
    }

    //获取最大值
    private int getMax(List<Integer> mList) {
        int max = mList.get(0);
        for (int i = 0; i < mList.size(); i++) {
            if (max > mList.get(i)) {
                max = mList.get(i);
            }
        }
        return max;
    }
}