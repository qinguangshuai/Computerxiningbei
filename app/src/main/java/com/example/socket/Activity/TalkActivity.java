package com.example.socket.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socket.Bean.Pocket;
import com.example.socket.Bean.TestPocket;
import com.example.socket.Bean.InitializationParkGPSUser;
import com.example.socket.Bean.ZhanchangWrap;
import com.example.socket.IO.GPIO;
import com.example.socket.R;
import com.example.socket.Record.Logger;
import com.example.socket.Record.RecordConfig;
import com.example.socket.Record.RecordManager;
import com.example.socket.Record.RecordResultListener;
import com.example.socket.Record.RecordSoundSizeListener;
import com.example.socket.Record.RecordState;
import com.example.socket.Record.RecordStateListener;
import com.example.socket.Speex.SpeexUtil;
import com.example.socket.Tcp.TcpHelperServer;
import com.example.socket.Unit.ButtonUtils;
import com.example.socket.Unit.CombineCommend;
import com.example.socket.Unit.Content;
import com.example.socket.Unit.FileUtil;
import com.example.socket.Unit.HeartbeatService;
import com.example.socket.Unit.HelperPacket;
import com.example.socket.Unit.HexUtil;
import com.example.socket.Unit.MultiAudioMixer;
import com.example.socket.Unit.SpUtil;
import com.example.socket.Unit.ZhiIndex;
import com.example.socket.adapter.AFactory;
import com.example.socket.adapter.DetailAdapter;
import com.example.socket.custom.dao.ParkDataDao;
import com.example.socket.custom.dao.ParkDataUser;
import com.example.socket.custom.move.ControlTranslation;
import com.example.socket.custom.people.TopViewdiaochezhang;
import com.example.socket.custom.people.TopViewjiche;
import com.example.socket.custom.people.TopViewlian1;
import com.example.socket.custom.people.TopViewlian2;
import com.example.socket.custom.people.TopViewlian3;
import com.example.socket.custom.people.TopViewlian4;
import com.example.socket.custom.data.Point3d;
import com.example.socket.custom.move.ControlTranslationsmall;
import com.example.socket.custom.track.TrackDataUtil;
import com.example.socket.custom.xiningbei.BaiLiMapsmall;
import com.example.socket.custom.xiningbei.ChangFengMapsmall;
import com.example.socket.custom.xiningbei.XiNingBeiMapsmall;
import com.example.socket.database.DiaoDan;
import com.example.socket.database.DiaoDanDatabase;
import com.example.socket.udp.UdpHelperServer;
import com.nononsenseapps.filepicker.BuildConfig;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import util.ByteUtil;

public class TalkActivity extends SerialPortActivity implements View.OnClickListener {

    private String mEncodeHexStr, mMControlMapName, mPeopleId2, mHead, mEnd;
    private String mTime232;
    private SpUtil mCqncast;
    private boolean shi = false;
    private boolean wu = false;
    private boolean san = false;
    private boolean yi = false;
    private SpUtil mReceive1, mReceive2, mReceive3, mCar;
    private String receiveSum;
    private SpUtil mUrgentState;
    private String mCarGps = "";
    private String mCarSuLv = "";
    private TextView zhuyishixiang, track_talk;
    private RecyclerView cur_recy;
    private TextView cur_total, cur_gou;
    private TextView cur_dang, current_adjustment;
    private TextView cur_danhao, cur_jiche, cur_bianzhiren, cur_diaochezhang, cur_jihuacontent, cur_jihuatime, cur_zhuyishixiang;
    private ImageView cur_img, cur_xie;
    private LinearLayout location_lin;
    private ListDatabase listDatabase;
    private TextView curDanhao;
    private Typeface fromAsset;
    private Pocket pocket = null;
    public static PopupWindow popWindow;
    private static final int REQUEST_SELECT_DEVICE = 1;
    private int mGetGudaoOfGpsPoint = 0;
    private double getRatioOfGpsPoint = 0.0;
    private String mRatioOfGpsTrackCar = "";
    private Double mGpsPistanceCar = 0.0;
    private double mGetRatioOfGpsPointCar;
    public SpUtil mControlMap;
    private SpUtil mPeople0, mPeople1, mPeople2, mPeople3, mPeople4;
    public static String mRatioOfGpsTrackCar20 = "-1";
    public static String mRatioOfGpsTrackCar01 = "-1";
    public static String mRatioOfGpsTrackCar02 = "-1";
    public static String mRatioOfGpsTrackCar03 = "-1";
    public static String mRatioOfGpsTrackCar04 = "-1";
    public static Double mGpsPistanceCar20 = 0.0;
    public static Double mGpsPistanceCar01 = 0.0;
    public static Double mGpsPistanceCar02 = 0.0;
    public static Double mGpsPistanceCar03 = 0.0;
    public static Double mGpsPistanceCar04 = 0.0;
    public static int gouName;
    public static String switchType;
    public static String switchTime;
    private FileUtil fileUtil;
    private boolean lingClear = false;
    private Handler mhandler1;
    private Handler mhandler0;
    private Handler mhandler2;
    private Handler mhandler3;
    private Handler mhandler4;
    private String gouName1;
    private static int gouN;
    private TopViewjiche train;
    private TopViewdiaochezhang diaochez;
    private TopViewlian1 lianpeopleo;
    private TopViewlian2 lianpeopletw;
    private TopViewlian3 lianpeopleth;
    private TopViewlian4 lianpeoplef;
    private BaiLiMapsmall mBailimapsmall;
    private XiNingBeiMapsmall mXiningbeimapsmall;
    private ChangFengMapsmall mChangfengmapsmall;
    boolean mControlLocation = false;
    private List<Double> mZhiList = new ArrayList<>();
    private ParkDataDao parkDataDao;
    private List<ParkDataUser> mParkcar;
    private boolean controlYiChe = false;
    private boolean mJieShiChe = false;
    private boolean mJieWuChe = false;
    private boolean mJieSanChe = false;
    private boolean mJieYiChe = false;
    private int signalling1 = 0;
    private String signallingCF = "";
    private CountDownTimer countDownTimer;
    private String state;
    private TextView mCheShuTest, mJuLiTest;

    private void sendMessage(String msg, Pocket p) {
        pocket.setType("command");
        //signalling1 += 1;
        p.setDataMessage(msg);
        p.setSignalling(signalling1);
        udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), Content.Ip_Adress, Content.port);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), Content.Ip_Adress, Content.port);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), Content.Ip_Adress, Content.port);
    }

    @Override
    protected void onDataReceived(byte[] buffer, int size, int type) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (type) {
                    case 485:
                        char[] chars485 = HexUtil.encodeHex(buffer);
                        mEncodeHexStr = ByteUtil.bytes2HexString(buffer, size);
                        Log.i("testData", "485数据: " + mEncodeHexStr);

                        //获取系统时间
                        SimpleDateFormat formatter485 = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
                        Date curDate485 = new Date(System.currentTimeMillis());
                        String time485 = formatter485.format(curDate485);

                        if (mEncodeHexStr.length() >= 12) {
                            mHead = mEncodeHexStr.substring(0, 12);
                            mEnd = mEncodeHexStr.substring(mEncodeHexStr.length() - 4, mEncodeHexStr.length());

                            if (mHead.equals("24474E524D43") && !mEnd.equals("0D0A")) {
                                //receive1 += mEncodeHexStr;
                                mReceive1.setName(mEncodeHexStr);
                            } else if (!mHead.equals("24474E524D43") && !mEnd.equals("0D0A")) {
                                //receive2 += mEncodeHexStr;
                                mReceive2.setName(mEncodeHexStr);
                            } else if (!mHead.equals("24474E524D43") && mEnd.equals("0D0A")) {
                                //receive3 += mEncodeHexStr;
                                mReceive3.setName(mEncodeHexStr);
                            }
                            String nameReceive1 = mReceive1.getName();
                            String nameReceive2 = mReceive2.getName();
                            String nameReceive3 = mReceive3.getName();
                            receiveSum = nameReceive1 + nameReceive2 + nameReceive3;
                            int length = receiveSum.length();
                            Log.e("receive", receiveSum + "    " + length);
                        }

                        if (receiveSum != null) {
                            if (receiveSum.length() >= 130) {
                                Log.i("receive4", receiveSum);
                                String receiveHead = receiveSum.substring(0, 12);
                                String receiveEnd = receiveSum.substring(receiveSum.length() - 4, receiveSum.length());
                                if (receiveHead.equals("244750524D43") && receiveEnd.equals("0D0A")) {//24474E524D43
                                    //16进制转换为字符串
                                    String data485 = HexUtil.hexStr2Str(receiveSum);
                                    String[] split485 = data485.split(",");
                                    Log.e("data485数据", data485 + "  " + split485.length);
                                    if (data485.indexOf("$GPRMC") != -1 && split485[2].equals("A") && split485.length == 13) {//$GNRMC
                                        if (data485.indexOf(",N,") != -1 && data485.indexOf(",E,") != -1) {
                                            //获取纬度
                                            String latitude = split485[3];
                                            //获取经度
                                            String longitude = split485[5];
                                            //地面速率
                                            mCarSuLv = split485[7];
                                            Log.i("TAGhexcomma", "    " + latitude);
                                            Log.i("TAGhexcomma", "    " + longitude);
                                            //DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。
                                            //DecimalFormat 包含一个模式 和一组符号
                                            boolean weidu = isDoubleOrFloat(latitude);
                                            boolean jingdu = isDoubleOrFloat(longitude);
                                            if (latitude != null && longitude != null && weidu && jingdu) {
                                                String lathead = latitude.substring(0, 2);
                                                String latend = latitude.substring(2, latitude.length());
                                                String lonhead = longitude.substring(0, 3);
                                                String lonend = longitude.substring(3, longitude.length());
                                                double lathead1 = Double.valueOf(lathead);
                                                double latend1 = Double.valueOf(latend);
                                                double a1 = latend1 / 60 + lathead1;
                                                double lonhead1 = Double.valueOf(lonhead);
                                                double lonend1 = Double.valueOf(lonend);
                                                double b1 = lonend1 / 60 + lonhead1;
                                                String a2 = String.valueOf(a1);
                                                String b2 = String.valueOf(b1);
                                                String lat1 = a2.substring(a2.indexOf(".") + 1);
                                                String lon1 = b2.substring(b2.indexOf(".") + 1);
                                                Log.e("弯点", "弯点a1: " + a1 + " ");
                                                Log.e("弯点", "弯点b1: " + b1 + " ");

                                                //大圆盘坐标减去与实际坐标的差值
                                                //double a1 = a11 - 0.000017;
                                                //double b1 = b11 - 0.000021;

                                                //计算股道
                                                mGetGudaoOfGpsPoint = GetGudaoOfGpsPoint(b1, a1);
                                                trackXianShi(mGetGudaoOfGpsPoint);
                                                mRatioOfGpsTrackCar = String.valueOf(mGetGudaoOfGpsPoint);
                                                Point3d point3d = new Point3d();
                                                point3d.setX(b1);
                                                point3d.setY(a1);
                                                mGetRatioOfGpsPointCar = GetRatioOfGpsPoint(point3d, mGetGudaoOfGpsPoint);

                                                DecimalFormat df = new DecimalFormat("###.000000");
                                                String lat = df.format(Double.valueOf(a1));
                                                String lon = df.format(Double.valueOf(b1));
                                                Double value1 = Double.valueOf(lat);
                                                Double value2 = Double.valueOf(lon);
                                                mCar.setLat(lat + "");
                                                mCar.setLon(lon + "");
                                                Log.e("股道", "股道: " + lat + "  " + lon + "    " + mGetGudaoOfGpsPoint);
                                                mCarGps = lat + "-" + lon;
                                                DecimalFormat df1 = new DecimalFormat("#####0.00%");
                                                DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
                                                df1.setDecimalFormatSymbols(symbols1);
                                                String ratioOfGpsPoint = df1.format(mGetRatioOfGpsPointCar);
                                                String gpsPoint = ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("."));
                                                mGpsPistanceCar = Double.valueOf(gpsPoint);
                                                if (mRatioOfGpsTrackCar.equals("-1")) {
                                                    EventBus.getDefault().post(new ZhanchangWrap("-1", mGpsPistanceCar));
                                                } else {
                                                    EventBus.getDefault().post(new ZhanchangWrap(mRatioOfGpsTrackCar, mGpsPistanceCar));
                                                }

                                                Log.e("测试", trackNumber + "   0    " + mGetRatioOfGpsPointCar + "    0");//计算十五三车
                                                distanceControl(trackNumber, mGetRatioOfGpsPointCar, lat, lon);
                                            }
                                        }
                                    } else {
                                        mCarGps = "00.000000-000.000000";
                                    }
                                } else if (receiveHead.equals("24474E524D43") && receiveEnd.equals("0D0A")) {
                                    //16进制转换为字符串
                                    String data485 = HexUtil.hexStr2Str(receiveSum);
                                    String[] split485 = data485.split(",");
                                    if (data485.indexOf("$GNRMC") != -1) {
                                        if (data485.indexOf(",N,") != -1 && data485.indexOf(",E,") != -1) {
                                            Log.i("data485", "    " + data485);
                                            String GGA = data485.substring(0, data485.indexOf(","));
                                            //String n = $GPGGA.substring($GPGGA.indexOf(",", $GPGGA.indexOf(",") + 1) + 1);
                                            //获取纬度
                                            String latitude = data485.substring(data485.indexOf(",", data485.indexOf(",") + 1) + 3, data485.indexOf(",N"));
                                            Log.i("TAGhexcomma", "    " + latitude);
                                            //获取经度
                                            String longitude = data485.substring(data485.indexOf("N,") + 2, data485.indexOf(",E"));
                                            Log.i("TAGhexcomma", "    " + longitude);
                                            //DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。
                                            //DecimalFormat 包含一个模式 和一组符号
                                            boolean weidu = isDoubleOrFloat(latitude);
                                            boolean jingdu = isDoubleOrFloat(longitude);
                                            if (latitude != null && longitude != null && weidu && jingdu) {
                                                String lathead = latitude.substring(0, 2);
                                                String latend = latitude.substring(2, latitude.length());
                                                String lonhead = longitude.substring(0, 3);
                                                String lonend = longitude.substring(3, longitude.length());
                                                double lathead1 = Double.valueOf(lathead);
                                                double latend1 = Double.valueOf(latend);
                                                double a1 = latend1 / 60 + lathead1;
                                                double lonhead1 = Double.valueOf(lonhead);
                                                double lonend1 = Double.valueOf(lonend);
                                                double b1 = lonend1 / 60 + lonhead1;
                                                String a2 = String.valueOf(a1);
                                                String b2 = String.valueOf(b1);

                                                String lat1 = a2.substring(a2.indexOf(".") + 1);
                                                String lon1 = b2.substring(b2.indexOf(".") + 1);

                                                    /*String ma = lat.substring(lat.length() - 4, lat.length());
                                                    String mb = lon.substring(lon.length() - 4, lon.length());
                                                    float mvalue1 = Float.valueOf(ma);
                                                    float mvalue2 = Float.valueOf(mb);*/
                                                Log.e("弯点", "弯点a1: " + a1 + " ");
                                                Log.e("弯点", "弯点b1: " + b1 + " ");
                                                //股道号
                                                //mJuli.setText(getGudaoOfGpsPoint + "");
                                                mGetGudaoOfGpsPoint = GetGudaoOfGpsPoint(b1, a1);
                                                track_talk.setText(mGetGudaoOfGpsPoint + "股道");
                                                Log.e("股道", "股道: " + mGetGudaoOfGpsPoint + " ");
                                                mRatioOfGpsTrackCar = String.valueOf(mGetGudaoOfGpsPoint);
                                                Point3d point3d = new Point3d();
                                                point3d.setX(b1);
                                                point3d.setY(a1);
                                                mGetRatioOfGpsPointCar = GetRatioOfGpsPoint(point3d, mGetGudaoOfGpsPoint);

                                                DecimalFormat df = new DecimalFormat("###.000000");
                                                String lat = df.format(Double.valueOf(a1));
                                                String lon = df.format(Double.valueOf(b1));
                                                Double value1 = Double.valueOf(lat);
                                                Double value2 = Double.valueOf(lon);
                                                mCar.setLat(lat + "");
                                                mCar.setLon(lon + "");
                                                Log.e("股道", "股道: " + lat + "  " + lon);
                                                mCarGps = lat + "-" + lon;
                                                DecimalFormat df1 = new DecimalFormat("#####0.00%");
                                                DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
                                                df1.setDecimalFormatSymbols(symbols1);
                                                String ratioOfGpsPoint = df1.format(mGetRatioOfGpsPointCar);
                                                String gpsPoint = ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("."));
                                                mGpsPistanceCar = Double.valueOf(gpsPoint);

                                                /*DecimalFormat df = new DecimalFormat("#.000000");
                                                String lat = df.format(Double.valueOf(latDifference)).substring(df.format(Double.valueOf(latDifference)).indexOf(".") + 1);
                                                String lon = df.format(Double.valueOf(lonDifference)).substring(df.format(Double.valueOf(lonDifference)).indexOf(".") + 1);
                                                Double value1 = Double.valueOf(lat);
                                                Double value2 = Double.valueOf(lon);
                                                String latCar = lathead + "." + lat;
                                                String lonCar = lonhead + "." + lon;
                                                //mGpsDao.add(a2, b2);
                                                DecimalFormat df1 = new DecimalFormat("#####0.00%");
                                                DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
                                                df1.setDecimalFormatSymbols(symbols1);
                                                String ratioOfGpsPoint = df1.format(mGetRatioOfGpsPointCar);
                                                String gpsPoint = ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("."));
                                                mGpsPistanceCar = Double.valueOf(gpsPoint);*/

                                                if (mRatioOfGpsTrackCar.equals("-1")) {
                                                    EventBus.getDefault().post(new ZhanchangWrap("-1", mGpsPistanceCar));
                                                } else {
                                                    EventBus.getDefault().post(new ZhanchangWrap(mRatioOfGpsTrackCar, mGpsPistanceCar));
                                                }
                                                //计算十五三车
                                                Log.e("测试", trackNumber + mGetRatioOfGpsPointCar);//计算十五三车
                                                distanceControl(trackNumber, mGetRatioOfGpsPointCar, lat, lon);
                                            }
                                        }
                                    } else {
                                        mCarGps = "00.000000-000.000000";
                                    }
                                }
                                receiveSum = "";
                                mReceive1.setName("");
                                mReceive2.setName("");
                                mReceive3.setName("");
                            }
                        }
                        break;
                    case 232:
                        //01为4G，02为DMR
                        char[] chars232 = HexUtil.encodeHex(buffer);
                        mEncodeHexStr = ByteUtil.bytes2HexString(buffer, size);
                        Log.i("232数据", "232数据:" + mEncodeHexStr);

                        //获取系统时间
                        SimpleDateFormat formatter232 = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
                        Date curDate232 = new Date(System.currentTimeMillis());
                        mTime232 = formatter232.format(curDate232);
                        String[] xinLingSplit = mEncodeHexStr.split("A5");
                        String mSpliLing = xinLingSplit[xinLingSplit.length - 1];
                        Log.i("232信令", "232信令:" + xinLingSplit[xinLingSplit.length - 1]);
                        fileUtil.saveAction("时间：" + fileUtil.getDate() + "----" + mEncodeHexStr, "zhengzhou", "Signalling_zhengzhou");

                        if (xinLingSplit.length >= 0 && mSpliLing.length() >= 6) {
                            String function2 = "";
                            //调号
                            String signature = mSpliLing.substring(0, 2);
                            //人员号
                            mPeopleId2 = mSpliLing.substring(2, 4);
                            if (mSpliLing.length() >= 10) {
                                state = mSpliLing.substring(8, 10);
                            }

                            if (xinLingSplit.length >= 2) {
                                String s = xinLingSplit[xinLingSplit.length - 1];
                                if (s.substring(2, 4).equals("90") && s.length() >= 6) {
                                    if (xinLingSplit[xinLingSplit.length - 2].length() >= 4) {
                                        function2 = xinLingSplit[xinLingSplit.length - 2].substring(4, 6);
                                    }
                                } else {
                                    if (s.length() >= 6) {
                                        function2 = xinLingSplit[xinLingSplit.length - 1].substring(4, 6);
                                    }
                                }
                            } else {
                                if (xinLingSplit[xinLingSplit.length - 1].length() >= 6) {
                                    function2 = xinLingSplit[xinLingSplit.length - 1].substring(4, 6);
                                }
                            }

                            String totalDmr = mPeopleId2 + signature + function2 + "03";
                            mCqncast.setName(totalDmr);

                            if (pocket == null) {
                                pocket = new Pocket();
                            }
                            //多方
                            //p.setTypes("command");
                            pocket.setTime(System.currentTimeMillis());
                            pocket.setIpAdress(benJi);
                            pocket.setImei(imei);
                            pocket.setGroup(group);
                            pocket.setUserCode(hao);
                            pocket.setPeopleId(mPeopleId2);
                            pocket.setState(state);

                            switch (function2) {
                                //59摘钩
                                case "59":
                                    pocket.setType("ZhaiGPS");
                                    break;
                                //5A挂钩
                                case "5A":
                                    pocket.setType("GuaGPS");
                                    break;
                                //启动
                                case "41":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    sendMessage("qidong", pocket);
                                    break;
                                //推进
                                case "43":
                                    //sendMessage(mConversationId, totalDmr);
                                    //tuijin();
                                    mControlLocation = true;
                                    sendMessage("tuijin", pocket);
                                    break;
                                case "71":
                                    //sendMessage(mConversationId, totalDmr);
                                    //mAdvancedmr.setName("false");
                                    //停车
                                    mJieShiChe = false;
                                    mJieWuChe = false;
                                    mJieSanChe = false;
                                    mJieYiChe = false;
                                    yi = false;
                                    san = false;
                                    wu = false;
                                    shi = false;
                                    lingClear = false;
                                    mControlLocation = false;
                                    sendMessage("tingche", pocket);
                                    break;
                                //减速
                                case "21":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    sendMessage("jiansu", pocket);
                                    break;
                                //十车
                                case "27":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    mJieShiChe = true;
                                    sendMessage("shiche", pocket);
                                    break;
                                //五车
                                case "25":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    mJieShiChe = true;
                                    mJieWuChe = true;
//                                    pocket.setDataMessage("wuche");
                                    sendMessage("wuche", pocket);
                                    break;
                                //三车
                                case "23":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    mJieShiChe = true;
                                    mJieWuChe = true;
                                    mJieSanChe = true;
                                    sendMessage("sanche", pocket);
                                    break;
                                //一车
                                case "26":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    mJieShiChe = true;
                                    mJieWuChe = true;
                                    mJieSanChe = true;
                                    mJieYiChe = true;
                                    sendMessage("yiche", pocket);
                                    break;
                                //连接
                                case "45":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    sendMessage("lianjie", pocket);
                                    break;
                                //溜放
                                case "47":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    sendMessage("liufang", pocket);
                                    break;
                                case "94"://领车
                                    //sendMessage(mConversationId, totalDmr);
                                    if (!mPeopleId2.equals("20")) {
                                        if (lingClear == false) {
                                            sendMessage("lingche", pocket);
                                            lingClear = true;
                                        }
                                    }
                                    break;
                                case "9A"://领车完毕
                                    //sendMessage(mConversationId, totalDmr);
                                    //收到领车指令后计算领车员与机车的经纬度差
                                    //紧急停车
                                    //停车股道号
                                    sendMessage("lingchewanbi", pocket);
                                    break;
                                case "73":
                                    lingClear = false;
                                    signallingCF = xinLingSplit[xinLingSplit.length - 1];
                                    sendMessage("jinjitingche", pocket);
                                    mUrgentState.setName("8");
                                    mUrgentState.setStandard("制动员" + mPeopleId2 + "号");
                                    break;
                                //解锁
                                case "75":
                                    //sendMessage(mConversationId, totalDmr);
                                    //qidong();
                                    if (!xinLingSplit[xinLingSplit.length - 1].equals(signallingCF)) {
                                        sendMessage("jiesuo", pocket);
                                        signallingCF = xinLingSplit[xinLingSplit.length - 1];
                                    }
                                    mUrgentState.setName("9");
                                    mUrgentState.setStandard("");
                                    break;
                                case "9E":
                                    sendMessage("zhuyizhuyi", pocket);
                                    break;
                                case "9F":
                                    sendMessage("tingchetingche", pocket);
                                    break;
                                case "81":
                                    sendMessage("zhuyishiche", pocket);
                                    break;
                                case "82":
                                    sendMessage("zhuyiwuche", pocket);
                                    break;
                                case "83":
                                    sendMessage("zhuyisanche", pocket);
                                    break;
                                case "84":
                                    sendMessage("zhuyiyiche", pocket);
                                    break;
                                case "99":
                                    //几调几号
                                    pocket.setPeopleId(signature + "-" + mPeopleId2);
                                    sendMessage("diaohao", pocket);
                                    break;
                                default:
                                    //sendMessage(mConversationId, totalDmr);
                                    break;
                            }
                            /*if (mEncodeHexStr != null && mEncodeHexStr.length() >= 8 && mEncodeHexStr.length() <= 14) {
                                //调号
                                String signature = mEncodeHexStr.substring(2, 4);
                                //人员号
                                mPeopleId2 = mEncodeHexStr.substring(4, 6);
                                String function2 = mEncodeHexStr.substring(6, 8);
                                String totalDmr = mPeopleId2 + signature + function2 + "03";
                                mCqncast.setName(totalDmr);

                                if (pocket == null) {
                                    pocket = new Pocket();
                                }
                                //多方
                                //p.setTypes("command");
                                pocket.setTime(System.currentTimeMillis());
                                pocket.setIpAdress(benJi);
                                pocket.setImei(imei);
                                pocket.setGroup(group);
                                pocket.setPeopleId(mPeopleId2);
                                pocket.setType("command");

                                switch (function2) {
                                    //启动
                                    case "41":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("qidong", pocket);
                                        break;
                                    //推进
                                    case "43":
                                        //sendMessage(mConversationId, totalDmr);
                                        //tuijin();
                                        sendMessage("tuijin", pocket);
                                        break;
                                    case "71":
                                        //sendMessage(mConversationId, totalDmr);
                                        //mAdvancedmr.setName("false");
                                        //停车
                                        san = false;
                                        wu = false;
                                        shi = false;
                                        yi = false;

                                        sendMessage("tingche", pocket);
                                        break;
                                    //减速
                                    case "21":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("jiansu", pocket);
                                        break;
                                    //十车
                                    case "27":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("shiche", pocket);
                                        break;
                                    //五车
                                    case "25":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        pocket.setDataMessage("wuche");
                                        sendMessage("wuche", pocket);
                                        break;
                                    //三车
                                    case "23":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("sanche", pocket);
                                        break;
                                    //一车
                                    case "26":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("yiche", pocket);
                                        break;
                                    //连接
                                    case "45":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("lianjie", pocket);
                                        break;
                                    //溜放
                                    case "47":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("liufang", pocket);
                                        break;
                                    case "94"://领车
                                        //sendMessage(mConversationId, totalDmr);
                                        sendMessage("lingche", pocket);
                                        break;
                                    case "9A"://领车完毕
                                        //sendMessage(mConversationId, totalDmr);
                                        //收到领车指令后计算领车员与机车的经纬度差
                                        //紧急停车
                                        //停车股道号
                                        sendMessage("lingchewanbi", pocket);
                                        break;
                                    case "73":
                                        jinji = 1;
                                        sendMessage("jinjitingche", pocket);
                                        mUrgentState.setName("8");
                                        mUrgentState.setStandard("制动员" + mPeopleId2 + "号");
                                        break;
                                    //解锁
                                    case "75":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        //if (jinji == 1) {
                                        //jinji++;
                                        sendMessage("jiesuo", pocket);
                                        //}
                                        mUrgentState.setName("9");
                                        mUrgentState.setStandard("");
                                        break;
                                    case "9E":
                                        sendMessage("zhuyizhuyi", pocket);
                                        break;
                                    case "9F":
                                        sendMessage("tingchetingche", pocket);
                                        break;
                                    case "81":
                                        sendMessage("zhuyishche", pocket);
                                        break;
                                    case "82":
                                        sendMessage("zhuyiwuche", pocket);
                                        break;
                                    case "83":
                                        sendMessage("zhuyisanche", pocket);
                                        break;
                                    case "84":
                                        sendMessage("zhuyiyiche", pocket);
                                        break;
                                    default:
                                        //sendMessage(mConversationId, totalDmr);
                                        break;
                                }
                            } else if (mEncodeHexStr != null && mEncodeHexStr.length() > 22) {
                                //A501014901010EA501019901010E
                                //调号
                                String signature = mEncodeHexStr.substring(16, 18);
                                //人员号
                                mPeopleId2 = mEncodeHexStr.substring(18, 20);
                                String function2 = mEncodeHexStr.substring(20, 22);
                                String totalDmr = mPeopleId2 + signature + function2 + "03";
                                mCqncast.setName(totalDmr);
                                if (pocket == null) {
                                    pocket = new Pocket();
                                }
                                //多方
                                //p.setTypes("command");
                                pocket.setTime(System.currentTimeMillis());
                                pocket.setIpAdress(benJi);
                                pocket.setImei(imei);
                                pocket.setPeopleId(mPeopleId2);
                                pocket.setUserCode(hao);
                                pocket.setType("command");
                                switch (function2) {
                                    case "99":
                                        //几调几号
                                        pocket.setPeopleId(signature + "-" + mPeopleId2);
                                        sendMessage("diaohao", pocket);
                                        break;
                                    case "81":
                                        //注意十车
                                        sendMessage("zhuyishiche", pocket);
                                        break;
                                    case "82":
                                        //注意五车
                                        sendMessage("zhuyiwuche", pocket);
                                        break;
                                    case "83":
                                        //注意三车
                                        sendMessage("zhuyisanche", pocket);
                                        break;
                                    case "84":
                                        //注意一车
                                        sendMessage("zhuyiyiche", pocket);
                                        break;
                                    //十车
                                    case "27":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("shiche", pocket);
                                        break;
                                    //五车
                                    case "25":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("wuche", pocket);
                                        break;
                                    //三车
                                    case "23":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("sanche", pocket);
                                        break;
                                    //一车
                                    case "26":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("yiche", pocket);
                                        break;
                                    //减速
                                    case "21":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("jiansu", pocket);
                                        break;
                                    //启动
                                    case "41":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("qidong", pocket);
                                        break;
                                    //推进
                                    case "43":
                                        //sendMessage(mConversationId, totalDmr);
                                        //tuijin();
                                        sendMessage("tuijin", pocket);
                                        break;
                                    //连接
                                    case "45":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("lianjie", pocket);
                                        break;
                                    //溜放
                                    case "47":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        sendMessage("liufang", pocket);
                                        break;
                                    case "94"://领车
                                        //sendMessage(mConversationId, totalDmr);
                                        sendMessage("lingche", pocket);
                                        break;
                                    case "9A"://领车完毕
                                        //sendMessage(mConversationId, totalDmr);
                                        //收到领车指令后计算领车员与机车的经纬度差
                                        //紧急停车
                                        //停车股道号
                                        sendMessage("lingchewanbi", pocket);
                                        break;
                                    case "73":
                                        jinji = 1;
                                        sendMessage("jinjitingche", pocket);
                                        mUrgentState.setName("8");
                                        mUrgentState.setStandard("制动员" + mPeopleId2 + "号");
                                        break;
                                    //解锁
                                    case "75":
                                        //sendMessage(mConversationId, totalDmr);
                                        //qidong();
                                        //if (f == 1) {
                                        //jinji++;
                                        sendMessage("jiesuo", pocket);
                                        //}
                                        mUrgentState.setName("9");
                                        mUrgentState.setStandard("");
                                        break;
                                    case "9E":
                                        sendMessage("zhuyizhuyi", pocket);
                                        break;
                                    case "9F":
                                        sendMessage("tingchetingche", pocket);
                                        break;
                                }
                            }*/
                        }
                        break;
                }
            }
        });
    }

    private void trackXianShi(int getGudaoOfGpsPoint) {
        switch (getGudaoOfGpsPoint) {
            case -1:
                track_talk.setText("正在定位中...");
                break;
            case 6:
                track_talk.setText("货1");
                break;
            case 7:
                track_talk.setText("货2");
                break;
            case 8:
                track_talk.setText("货3");
                break;
            case 9:
                track_talk.setText("长丰线");
                break;
            case 10:
                track_talk.setText("长丰线");
                break;
            case 11:
                track_talk.setText("园1");
                break;
            case 12:
                track_talk.setText("园2");
                break;
            case 13:
                track_talk.setText("煤2");
                break;
            case 14:
                track_talk.setText("煤1");
                break;
            case 15:
                track_talk.setText("百立线");
                break;
            case 16:
                track_talk.setText("物1");
                break;
            case 17:
                track_talk.setText("物2");
                break;
            case 18:
                track_talk.setText("物3");
                break;
            case 19:
                track_talk.setText("物4");
                break;
            default:
                track_talk.setText(mGetGudaoOfGpsPoint + "股道");
                break;
        }
    }

    /*
     * 是否为浮点数？double或float类型。
     * @param str 传入的字符串。
     * @return 是浮点数返回true,否则返回false。
     */
    public static boolean isDoubleOrFloat(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    boolean flag = true;
    private int pttOn = 0;//是否通话中标志
    final static RecordManager recordManager = RecordManager.getInstance();

    Context context;
    Long time2 = 0L;
    Long time = 0L;
    Long currenttime = 0L;

    ArrayList<String> list = new ArrayList<>();//信令列表，用来判断的
    ArrayList<String> listhistory = new ArrayList<>();//信令列表，历史记录
    public static ArrayList<String> recall_listhistory = new ArrayList<>();////信令列表，接收回传的信令
    public static String zhishiTrans, caozuoyuan, currnumber, peopleId, benJi, imei, hao, signatureId, diaohao = "";//四个sp内容
    public static String group;
    private List<String> mList = new ArrayList<>();//调单部分内容
    private int mVehicleCommander = 0;
    public static Location location;

    public static String Ip_Adress = "36.110.196.90", static_local_ipAdress = "";//默认服务器ip，本地地址
    public static int port = 55001;//默认服务器端口号
    public static String JKQ_Ip_Adress = "192.168.1.44";
    public static int JKQ_Port = 9999;

    private Handler handler;
    private TcpHelperServer tcpHelperServer;
    public static UdpHelperServer udpHelperServer;//udp发送端和接收都在一起用一个端口
    static boolean io = false;
    String path;
    static AudioTrack audioTrack;

    CombineCommend combineCommend = new CombineCommend();
    //多方
    static HashMap<Integer, Pocket> map = new HashMap<>();//单片机单方通讯
    static ArrayList<TestPocket> audio_map1 = new ArrayList<>();//多方第一人
    static ArrayList<TestPocket> audio_map2 = new ArrayList<>();//多方第二人
    static ArrayList<TestPocket> audio_map3 = new ArrayList<>();//多方第三人
    static ArrayList<TestPocket> audio_map4 = new ArrayList<>();//多方第四人
    static HashMap<String, Boolean> end_status = new HashMap<>();//同话状态
    static int[] audio_map_status = new int[4];//多方通话语音table，其中任意一个大于7就会进入播放

    private String[] ipAddress_saved = new String[5];//公网固定ip
    //private String[] ipAddress_domnic2 = new String[4];
    static ArrayList<String> ipAddress_domnic = new ArrayList<>();//公网动态ip

    SharedPreferences sp;
    //static HashMap<Integer, Pocket> map = new HashMap<>();
    //超过4之后每次检测缺少的。

    static int max = 100;
    static boolean end = false;
    static int index = 0;
    String fileName = null;
    private SpeexUtil speex;
    private AudioManager audioManager;

    public SoundPool soundPool;
    private int di;
    private BroadcastReceiver mb;
    private String Ip_status = "ip";//分辨是4g还是wifi
    private SpUtil mSpPersonnelType;
    //private String currnumber, caozuoyuan, zhishiTrans;
    public static boolean diaochezhang_premiss = true;
    private boolean Lock_key = true;

    boolean batterry = false;
    private int change = 0;
    private String name2;
    public static ArrayList<String> gou_list = new ArrayList<>();

    private String TAG = "TalkActivity: ";
    private final int REQUESTCODE = 100;

    private void checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "没有权限进行申请");
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.READ_PHONE_STATE}, REQUESTCODE);
        } else {
            Log.i(TAG, "已经有权限");
            TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            imei = tm.getDeviceId();
            Log.e("测试语音", "PDManager onConnectionState = " + imei + "---");
        }
    }

    //人员定位
    Runnable member_location_rrr = new Runnable() {
        @Override
        public void run() {
            if (location != null) {
                DecimalFormat df = new DecimalFormat("#.000000");
                String lat = df.format(location.getLatitude()).substring(df.format(location.getLatitude()).indexOf(".") + 1);
                String lon = df.format(location.getLongitude()).substring(df.format(location.getLongitude()).indexOf(".") + 1);
                if (lat.matches("000000")) {
                } else {
                    //sendMessage(currnumber + "-说话GPS-" + lat + "-" + lon);
                }
            }

            handler_xintiao.postDelayed(this, 3000);
        }
    };
    //handler_xintiao.postDelayed(member_location_rrr, 5000);//心跳
    public static String time_date = "";
    private FileInputStream mIs1;
    private FileInputStream mIs2;
    public String mName;
    private DetailAdapter detailAdapter;
    private String gouTotal;
    private String trackNumber = "0";

    //调单显示方法
    public void DisplayDiaodanLayout(String str, String gouNumber, String mTime) {
        Log.e("swy", str);
        String trackPark;
        String stringPark;
        mList = new ArrayList<>();
        ArrayList<String> diaocan_list = new ArrayList<>();
        try {
            diaocan_list.addAll(combineCommend.Decode_diaodan(str));
            //mList.add(diaocan_list.get(2) + "第" + diaocan_list.get(5) + "号  机车: " + diaocan_list.get(11) + "\r\n" + "编制人: " + diaocan_list.get(8) + "--调车长: " + diaocan_list.get(9) + "\r\n" + "计划内容: " + diaocan_list.get(10) + "\r\n" + "计划时间: 自" + diaocan_list.get(6).substring(0, 2) + "时" + diaocan_list.get(6).substring(2, 4) + "分" + "至" + diaocan_list.get(7).substring(0, 2) + "时" + diaocan_list.get(6).substring(2, 4) + "分");

            for (int i = 0; i < Integer.valueOf(diaocan_list.get(2)); i++) {
                mList.add(i + 1 + "," + diaocan_list.get(13 + (i * 3)) + "," + diaocan_list.get(14 + (i * 3)).substring(0, 1) + "," + diaocan_list.get(14 + (i * 3)).substring(1) + "," + diaocan_list.get(15 + (i * 3)));//红色 #FF0000 //牡丹红 #FF00FF
            }
            gouTotal = diaocan_list.get(2);
            //设置layoutmanager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.scrollToPositionWithOffset(mTopPosition, 0);
            //layoutManager.setStackFromEnd(true);
            cur_recy.setLayoutManager(layoutManager);
            Log.e("最大值qgs", gouNumber);
            //设置adapter
            detailAdapter = new DetailAdapter(this, mList, str, gouNumber, gouTotal, mTime);
            cur_recy.setAdapter(detailAdapter);
            detailAdapter.setMsg(mList, gouNumber, str, gouTotal, mTime);
            detailAdapter.notifyDataSetChanged();
            //解决闪烁
            //cur_recy.getItemAnimator().setChangeDuration(0);
            //cur_dang.setText("1");
            DecimalFormat df = new DecimalFormat("#0000");
            String format = df.format(Double.valueOf(diaocan_list.get(5)));
            curDanhao.setText(format);
            cur_danhao.setText(format);
            cur_jiche.setText(diaocan_list.get(3));
            cur_bianzhiren.setText(diaocan_list.get(8));
            cur_diaochezhang.setText(diaocan_list.get(9));
            cur_jihuacontent.setText(diaocan_list.get(10));
            cur_jihuatime.setText(diaocan_list.get(6).substring(0, 2) + ":" + diaocan_list.get(6).substring(2, 4) + "-" + diaocan_list.get(7).substring(0, 2) + ":" + diaocan_list.get(7).substring(2, 4));
            String danZhu = diaocan_list.get(12).replace("\n", "");
            if (danZhu.equals("")) {
                cur_zhuyishixiang.setText("无");
            } else {
                cur_zhuyishixiang.setText(danZhu);
            }
            cur_total.setText(mList.size() + "");

            if (gouNumber.equals("")) {
                cur_dang.setText("0");
                trackPark = mList.get(0);
                /*stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                trackNumber = stringPark;
                Log.e("调单显示方法", trackPark + "  " + stringPark + "  " + trackNumber);*/
                if (trackPark.contains("道")) {
                    stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                    trackNumber = stringPark;
                } else if (trackPark.contains("货1")) {
                    trackNumber = 6 + "";
                } else if (trackPark.contains("货2")) {
                    trackNumber = 7 + "";
                } else if (trackPark.contains("货3")) {
                    trackNumber = 8 + "";
                } else if (trackPark.contains("III")) {
                    trackNumber = "3";
                }
            } else {
                String[] split = gouNumber.split("-");
                int length = split.length;
                cur_dang.setText(length + "");
                trackPark = mList.get(length);
                /*stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                trackNumber = stringPark;
                Log.e("调单显示方法", trackPark + "  " + stringPark + "  " + trackNumber);*/
                if (trackPark.contains("道")) {
                    stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                    trackNumber = stringPark;
                    Log.e("调单显示方法", trackPark + "  " + stringPark + "  " + trackNumber);
                } else if (trackPark.contains("货1")) {
                    //stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                    trackNumber = 6 + "";
                    Log.e("调单显示方法", trackNumber);
                } else if (trackPark.contains("货2")) {
                    //stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                    trackNumber = 7 + "";
                    Log.e("调单显示方法", trackNumber);
                } else if (trackPark.contains("货3")) {
                    //stringPark = trackPark.split(",")[1].substring(0, trackPark.split(",")[1].indexOf("道"));
                    trackNumber = 8 + "";
                    Log.e("调单显示方法", trackNumber);
                }
            }
        } catch (Exception e) {
        }
    }

    //心跳
    Handler handler_xintiao = new Handler();
    public static int xintiao_index = 2;
    private int xintiao_count = 0;
    public static ArrayList<String> xintiao_list = new ArrayList<>();
    Runnable xintiaorunnable = new Runnable() {
        @Override
        public void run() {
            if (xintiao_index == 1) {
                handler_xintiao.removeCallbacks(xintiaorunnable);
                // sendMessage("1");
                xintiao_list.add("1");
                handler_xintiao.postDelayed(this, 5000);
            } else {
                xintiao_count = 0;
                xintiao_list.clear();
                handler_xintiao.removeCallbacks(xintiaorunnable);
            }

        }
    };
    //按键结束狗调用判断
    Runnable send_over_rrr = new Runnable() {
        @Override
        public void run() {
            lingche_count = 0;
            if (send_over == 1) {
            } else {
                playVideo("error");
            }
        }
    };

    int send_over = 0;

    private void playVideo(String s) {
        if (player != null) {
        } else {
            player = new MediaPlayer();
        }
        switch (s) {
            case "send":
                send_over = 1;
                player = MediaPlayer.create(this, R.raw.send);
                break;
            case "y":
                player = MediaPlayer.create(this, R.raw.yellow);
                break;
            case "g":
                player = MediaPlayer.create(this, R.raw.green);
                break;
            case "r":
                player = MediaPlayer.create(this, R.raw.red);
                break;
            case "error":
                player = MediaPlayer.create(this, R.raw.error2);
                break;
            case "注意注意":
                player = MediaPlayer.create(this, R.raw.zhuyizhuyi);
                break;
            case "停车停车":
                player = MediaPlayer.create(this, R.raw.tingchetingche);
                break;
            case "挂钩":
                player = MediaPlayer.create(this, R.raw.guagou);
                break;
            case "摘勾":
                player = MediaPlayer.create(this, R.raw.zhaigou);
                break;
        }
        try {
            player.start();
            player.setOnCompletionListener(mCompletionListener);
        } catch (Exception e) {

        }
    }

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    mediaPlayer.release();
                    mediaPlayer = null;
                    System.out.println("------------------------stopstop----------------------");
                }
            } catch (Exception e) {
            }
        }
    };

    private String s2 = "";

    private void stopVideo() {
        try {
            if (player != null) {


                //player.prepare();
                player.stop();
                System.out.println("------------------------stopok1----------------------");
                player.reset();
                System.out.println("------------------------stopok3----------------------");
                player.release();
                System.out.println("------------------------stopok4----------------------");
                player = null;
                System.out.println("------------------------stopok5----------------------");
            } else {
            }

        } catch (Exception e) {
            System.out.println("------------------------stopfalse----------------------");
        }
        Runtime.getRuntime().gc();
    }

    volatile MediaPlayer player = null;

    //控制
    String gpioValue = "";
    FileReader fileReader;
    BufferedReader reader;
    private IOReadThread ioReadThread;

    /**
     * 隐藏状态栏和导航栏
     *
     * @param show boolean类型，true:显示  false ：隐藏
     */
    private void setSystemUIVisible(boolean show) {
        if (show) {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            uiFlags |= 0x00001000;
            getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        } else {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            uiFlags |= 0x00001000;
            getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }
    }

    private HashMap<Integer, ArrayList<Point3d>> gps = new HashMap<>();

    private void addLoc() {
        gps = TrackDataUtil.getGps();
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

    private Handler handlerQunZu = new Handler();
    private Runnable rQunZu = new Runnable() {
        @Override
        public void run() {
            if (mQunZu.equals("")) {
                if (pocket == null) {
                    pocket = new Pocket();
                }
                pocket.setTime(System.currentTimeMillis());
                pocket.setIpAdress(benJi);
                pocket.setImei(imei);
                pocket.setPeopleId(peopleId);
                pocket.setUserCode(hao);
                pocket.setGroup(group);
                pocket.setType("login");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
                handlerQunZu.postDelayed(rQunZu, 2000);
                Log.e("login", "55");
            } else {
                handlerQunZu.removeCallbacks(rQunZu);
                Toast.makeText(TalkActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                Log.e("login", "66");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk2);
        Log.e(TAG, "onCreate: ");
        AFactory.sTalkActivity = this;
        setSystemUIVisible(false);
        checkPermission();
        fileUtil = new FileUtil();
        db = Room.databaseBuilder(getApplication(),
                DiaoDanDatabase.class, "Diaodan_Database")
                .fallbackToDestructiveMigration()
                .build();
        trackNumber = "0";
        repeatSignalling = -1;
        controlYiChe = false;
        mJieShiChe = false;
        mJieWuChe = false;
        mJieSanChe = false;
        mJieYiChe = false;
        mStartHandler.sendEmptyMessageDelayed(0, 1000);
        parkDataDao = new ParkDataDao(TalkActivity.this);
        mSpPersonnelType = new SpUtil(getApplication(), "PersonnelType");
        caozuoyuan = mSpPersonnelType.getName();
        zhishiTrans = mSpPersonnelType.getStandard();
        signatureId = mSpPersonnelType.getSignatureId();
        peopleId = mSpPersonnelType.getPeopleId();
        benJi = mSpPersonnelType.getBenJi();
        group = mSpPersonnelType.getGroup();
        imei = mSpPersonnelType.getIMEI();
        hao = mSpPersonnelType.getHao();

        mCqncast = new SpUtil(getApplicationContext(), "cqncast");
        mReceive1 = new SpUtil(getApplicationContext(), "receive1");
        mReceive2 = new SpUtil(getApplicationContext(), "receive2");
        mReceive3 = new SpUtil(getApplicationContext(), "receive3");
        mCar = new SpUtil(getApplicationContext(), "car");

        //查看机控器是否处于紧急停车状态
        mUrgentState = new SpUtil(getApplicationContext(), "UrgentState");
        mUrgentState.setName("9");
        mUrgentState.setStandard("制动员");

        if (pocket == null) {
            pocket = new Pocket();
        }

        init();

        /*mDistanceDian = getDistance(Double.valueOf("36.662304"), Double.valueOf("101.769892"), Double.valueOf("36.661457"), Double.valueOf("101.770176"));
        Log.e("mDistanceDian", mDistanceDian+"");*/
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
        di = soundPool.load(this, R.raw.di, 1);//滴
        sp = getSharedPreferences("swy", Context.MODE_PRIVATE); //私有数据

        if (speex == null) {
            //speex编解码
            speex = new SpeexUtil();
            //speex.init();
            Log.e("swy", "onCreate: " + speex.getFrameSize());
        }

        ipAddress_domnic.clear();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        //tv_iplocal.setText("本机IP: " + HelperPacket.GetIpAddress(Ip_status, TalkActivity.this) + "   端口: " + msg.obj.toString());
                        break;
                    case 1:
                        //audioTrack.write(DecodeAudio(msg.obj.toString().getBytes()), 0, speex.getFrameSize());
                        break;
                    case 2:
                        //appendMsg(msg.obj.toString());
                        appendRawMsg(msg.obj.toString());
                        break;
                }
            }
        };

        //ipAddress_saved[4] = HelperPacket.GetIpAddress(Ip_status,TalkActivity.this);
        //tcpHelperServer = new TcpHelperServer(handler);
        //startService(new Intent(this, UDPClient.class));

        addLoc();
        getSp();
        mb = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()) {
                    case WifiManager.NETWORK_STATE_CHANGED_ACTION:
                        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                        imei = tm.getDeviceId();
                        mSpPersonnelType.setIMEI(imei);
                        imei = mSpPersonnelType.getIMEI();
                        Log.e("swy", "网络已连接" + imei);
                        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                        NetworkInfo gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                        //Log.e("swy", "网络状态改变:" + wifi.isConnected() + " 4g:" + gprs.isConnected());
                        NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
                        //checkState_23(TalkActivity.this);
                        if (wifi.isConnected()) {
                            Ip_status = "wifi";
                        } else if (gprs.isConnected()) {
                            Ip_status = "ip";
                        }
                        benJi = HelperPacket.GetIpAddress(Ip_status, TalkActivity.this);
                        ipAddress_saved[4] = benJi;
                        Log.e("swy", "网络ip :" + benJi);
                        mSpPersonnelType.setBenJi(benJi);
                        benJi = mSpPersonnelType.getBenJi();
                        if (pocket == null) {
                            pocket = new Pocket();
                        }
                        pocket.setTime(System.currentTimeMillis());
                        pocket.setIpAdress(benJi);
                        pocket.setImei(imei);
                        pocket.setPeopleId(peopleId);
                        pocket.setUserCode(hao);
                        pocket.setGroup(group);
                        pocket.setType("login");
                        udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
                        break;
                    case "adjustment"://调单显示
                        mName = intent.getStringExtra("name");
                        Log.i("接收广播", "成功:" + mName);
                        try {
                            listDatabase = new ListDatabase();
                            listDatabase.execute();
                            Log.i("接收广播2", "成功");
                            //调用 CountDownTimer 对象的 start() 方法开始倒计时，也不涉及到线程处理
                        } catch (Exception e) {
                        }
                        break;
                    case "HookElimination"://消钩
                        name2 = intent.getStringExtra("name2");
                        Log.i("接收广播", "成功:" + name2);
                        try {
                            if (gjhId.equals(mGjhId)) {
                                listDatabase = new ListDatabase();
                                listDatabase.execute();
                            }
                            Log.i("接收广播2", "成功");
                            //调用 CountDownTimer 对象的 start() 方法开始倒计时，也不涉及到线程处理
                        } catch (Exception e) {
                        }
                        break;
                }
            }
        };

        IntentFilter mif = new IntentFilter();
        mif.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);//监听wifi是开关变化的状态
        mif.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);//监听wifi连接状态广播,是否连接了一个有效路由
        mif.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);//监听wifi列表变化（开启一个热点或者关闭一个热点）
        mif.addAction("adjustment");
        mif.addAction("HookElimination");
        registerReceiver(mb, mif);
        //startService(new Intent(this, HeartbeatService.class));
        handler.post(runnable);//心跳

        //发送机车、检测人员位置
        mHandler.postDelayed(mRunnable, 1500);
        //Intent intent = new Intent(TalkActivity.this,SendActivity.class);
        //startActivity(intent);

        /*if (pocket == null) {
            pocket = new Pocket();
        }
        pocket.setTime(System.currentTimeMillis());
        pocket.setIpAdress(benJi);
        pocket.setImei(imei);
        pocket.setType("ComputerPowerOn");
        udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Ip_Adress, port);*/

        mGpsHandler.postDelayed(mGpsRunnable, 3000);

        try {
            udpHelperServer = new UdpHelperServer();
            udpHelperServer.GetRun();//udp运行接收端
            udpHelperServer.GetHandler(handler);//运行消息传递
        } catch (Exception e) {

        }

        GPIO.gpio_crtl_in(130, 1);
        ioReadThread = new IOReadThread();//监听pe2io口
        ioReadThread.start();

        initRecord();
        initMic();

        /*mGetGudaoOfGpsPoint = GetGudaoOfGpsPoint(101.767853,36.661936);
        track_talk.setText(mGetGudaoOfGpsPoint + "股道");
        mRatioOfGpsTrackCar = String.valueOf(mGetGudaoOfGpsPoint);
        Point3d point3d = new Point3d();
        point3d.setX(101.767853);
        point3d.setY(36.661936);
        mGetRatioOfGpsPointCar = GetRatioOfGpsPoint(point3d, mGetGudaoOfGpsPoint);
        Log.e("自测", mGetGudaoOfGpsPoint + "  " + mGetRatioOfGpsPointCar);*/
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            /*String carLat = mCar.getLat();
            String carLon = mCar.getLon();
            if (carLat != null && carLon != null) {
                DecimalFormat df = new DecimalFormat("#.000000");
                String lat = df.format(Double.valueOf(carLat)).substring(df.format(Double.valueOf(carLat)).indexOf(".") + 1);
                String lon = df.format(Double.valueOf(carLon)).substring(df.format(Double.valueOf(carLon)).indexOf(".") + 1);
                String total = "0A-机车GPS-" + lat + "-" + lon;
                PocketMessage pocketMessage = new PocketMessage();
                pocketMessage.setTime(System.currentTimeMillis());
                pocketMessage.setIpAdress(static_local_ipAdress);
                pocketMessage.setData(total);
                pocketMessage.setPeopleId("0A");
                pocketMessage.setType("gps");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocketMessage), Ip_Adress, port);
            }*/
        }
    };

    String mQunZu = "";

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //心跳
            //心跳
            if (pocket == null) {
                pocket = new Pocket();
            }
            //单片机
            //p.setNum(cao);
            //多方
            pocket.setType("heartbeat");
            pocket.setTime(System.currentTimeMillis());
            pocket.setIpAdress(benJi);
            pocket.setPeopleId(peopleId);
            pocket.setImei(TalkActivity.imei);
            pocket.setDataMessage("");
            pocket.setUserCode(hao);
            pocket.setGroup(TalkActivity.group);
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            handler.postDelayed(this, 14000);
            if (mQunZu.equals("")) {
                if (pocket == null) {
                    pocket = new Pocket();
                }
                pocket.setTime(System.currentTimeMillis());
                pocket.setIpAdress(benJi);
                pocket.setImei(imei);
                pocket.setPeopleId(peopleId);
                pocket.setUserCode(hao);
                pocket.setGroup(group);
                pocket.setType("login");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
                Log.e("测试登录", mQunZu + "    000");
            }
        }
    };

    @Override
    protected void onRestart() {
        if (soundPool != null) {
            Log.e(TAG, "onRestart: ");
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            di = soundPool.load(this, R.raw.di, 1);
        }

        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    private String mTime;
    private String gjhId = "";
    private int mTopPosition = 0;

    private class ListDatabase extends AsyncTask<Void, Void, String> {

        private String str;
        private List<DiaoDan> users;
        private String gou_number;

        @Override
        protected String doInBackground(Void... params) {
            gou_list.clear();
            users = db.DiaodanDAO().findByTime();
            if (users.size() > 0) {
                str = users.get(0).getStr();
                gou_number = users.get(0).getGou_number();
                mTime = users.get(0).getCurrent_time();
                gjhId = users.get(0).getGjhId();
                String[] gouNumberSplit = gou_number.split("-");
                if (gouNumberSplit.length > 1) {
                    mTopPosition = gouNumberSplit.length;
                } else {
                    mTopPosition = 0;
                }
                Log.e("gou_number测试", "" + gou_number + "    " + gouNumberSplit.length);
            }
            return str;
        }

        @Override
        protected void onPostExecute(String details) {
            if (users.size() > 0) {
                cur_recy.setVisibility(View.VISIBLE);
                current_adjustment.setVisibility(View.VISIBLE);
                cur_xie.setVisibility(View.VISIBLE);
                cur_dang.setVisibility(View.VISIBLE);
                cur_total.setVisibility(View.VISIBLE);
                cur_gou.setVisibility(View.VISIBLE);
                cur_img.setVisibility(View.GONE);
                //cur_dang.setText("1");
                //cur_total.setText(users.size() + "");
                //gou_number.split()
                DisplayDiaodanLayout(details, gou_number, mTime);
            } else {
                cur_danhao.setText("- -");
                cur_jiche.setText("- -");
                cur_bianzhiren.setText("- -");
                cur_diaochezhang.setText("- -");
                cur_jihuacontent.setText("- -");
                cur_zhuyishixiang.setText("- -");
                cur_jihuatime.setText("- -");
                curDanhao.setText("- -");
                cur_recy.setVisibility(View.GONE);
                current_adjustment.setVisibility(View.GONE);
                cur_xie.setVisibility(View.GONE);
                cur_dang.setVisibility(View.GONE);
                cur_total.setVisibility(View.GONE);
                cur_gou.setVisibility(View.GONE);
                cur_img.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onResume() {
        if (soundPool == null) {
            Log.e(TAG, "onResume: ");
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            di = soundPool.load(this, R.raw.di, 1);
        }
        super.onResume();
//        doStop();
        initRecordEvent();
        Log.e(TAG, "onResume: ");
        //startActivity(new Intent(TalkActivity.this,PointActivity.class));
        listDatabase = new ListDatabase();
        listDatabase.execute();
        handlerQunZu.postDelayed(rQunZu, 2000);
    }

    @Override
    protected void onPause() {
        if (soundPool != null) {
            Log.e(TAG, "onPause: ");
            soundPool.release();
        }

        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        if (soundPool != null) {
            Log.e(TAG, "onStop: ");
            soundPool.release();
        }
        super.onStop();
//        doStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        if (soundPool != null) {
            Log.e(TAG, "onDestroy: ");
            soundPool.release();
        }
        unregisterReceiver(mb);
        stopService(new Intent(this, HeartbeatService.class));
        super.onDestroy();
        mHandler.removeCallbacks(mRunnable);
//        doStop();
        Log.e(TAG, "onDestroy: ");
        mGpsHandler.removeCallbacks(mGpsRunnable);
        handlerQunZu.removeCallbacks(rQunZu);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("swy", "onKeyDown: " + keyCode + "--------" + event.getAction());
        if (keyCode == 285 && event.getAction() == KeyEvent.ACTION_DOWN) {
            doPlay();
            return true;
        }

        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.e("swy", "onKeyUp: " + keyCode + "--------" + event.getAction());
        if (keyCode == 285 && event.getAction() == KeyEvent.ACTION_UP) {
            doStop();
            return true;
        }
        return false;
    }

    /*@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        System.out.println("Key pressed. event.getKeyCode() => " + event.getKeyCode() + ", event.getAction() => " + event.getAction() + ", event.getRepeatCount() => " + event.getRepeatCount());
        switch (event.getKeyCode()) {
            case 83:
                tvState.setText("ssssss");
                break;
        }
        return true;
    }*/

    @Override
    public void onClick(View v) {
        if (pocket == null) {
            pocket = new Pocket();
        }
        //多方
        //p.setTypes("command");
        pocket.setTime(System.currentTimeMillis());
        pocket.setIpAdress(benJi);
        soundPool.play(di, 1.0f, 1.0f, 2, 0, 1);
        switch (v.getId()) {
            case R.id.location_lin:
                if (ButtonUtils.isFastClick()) {
                    showPopwindow();
                }
                break;
        }
    }

    boolean aaa = false;

    public void showPopwindow() {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.pw_search_engine, null);

        popWindow = new PopupWindow(customView, ViewGroup.LayoutParams.MATCH_PARENT, 440);
        popWindow.setAnimationStyle(R.style.pop_anim);//动画
        popWindow.setFocusable(false);
        popWindow.setOutsideTouchable(false);
        popWindow.showAtLocation(customView, Gravity.BOTTOM, 0, 0);//展示


        train = customView.findViewById(R.id.train);
        diaochez = customView.findViewById(R.id.diaochez);
        lianpeopleo = customView.findViewById(R.id.peopleo);
        lianpeopletw = customView.findViewById(R.id.peopletw);
        lianpeopleth = customView.findViewById(R.id.peopleth);
        lianpeoplef = customView.findViewById(R.id.peoplef);
        diaochez.setVisibility(View.GONE);
        lianpeopleo.setVisibility(View.GONE);
        lianpeopletw.setVisibility(View.GONE);
        lianpeopleth.setVisibility(View.GONE);
        lianpeoplef.setVisibility(View.GONE);

        mChangfengmapsmall = customView.findViewById(R.id.changfengmapsmall);
        mBailimapsmall = customView.findViewById(R.id.bailimapsmall);
        mXiningbeimapsmall = customView.findViewById(R.id.xiningbeimapsmall);

        Log.e("chua", mRatioOfGpsTrackCar + "   " + mGpsPistanceCar + "    " + mControlMap + "     ");
        aaa = true;

        Handler handlerPop = new Handler();
        Runnable runnablePop = new Runnable() {
            @Override
            public void run() {
                ControlTranslationsmall.proplrMove1(mControlMap, train, mRatioOfGpsTrackCar, mGpsPistanceCar, 20, 18);
                ControlTranslationsmall.proplrMove1(mPeople0, diaochez, mRatioOfGpsTrackCar20, mGpsPistanceCar20, 20, 18);
                ControlTranslationsmall.proplrMove1(mPeople1, lianpeopleo, mRatioOfGpsTrackCar01, mGpsPistanceCar01, 20, 18);
                ControlTranslationsmall.proplrMove1(mPeople2, lianpeopletw, mRatioOfGpsTrackCar02, mGpsPistanceCar02, 20, 18);
                ControlTranslationsmall.proplrMove1(mPeople3, lianpeopleth, mRatioOfGpsTrackCar03, mGpsPistanceCar03, 20, 18);
                ControlTranslationsmall.proplrMove1(mPeople4, lianpeoplef, mRatioOfGpsTrackCar04, mGpsPistanceCar04, 20, 18);
                mMControlMapName = mControlMap.getName();
                Log.e("showPopwindow: ", mMControlMapName);
                if (mMControlMapName.equals("zheng")) {
                    mXiningbeimapsmall.setVisibility(View.VISIBLE);
                    mChangfengmapsmall.setVisibility(View.GONE);
                    mBailimapsmall.setVisibility(View.GONE);
                } else if (mMControlMapName.equals("cf")) {
                    mXiningbeimapsmall.setVisibility(View.GONE);
                    mChangfengmapsmall.setVisibility(View.VISIBLE);
                    mBailimapsmall.setVisibility(View.GONE);
                } else {
                    mXiningbeimapsmall.setVisibility(View.GONE);
                    mChangfengmapsmall.setVisibility(View.GONE);
                    mBailimapsmall.setVisibility(View.VISIBLE);
                }
                handlerPop.postDelayed(this, 1000);
            }
        };
        handlerPop.postDelayed(runnablePop, 1000);

        customView.findViewById(R.id.wheel_picker_address_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ButtonUtils.isFastClick()) {
                    popWindow.dismiss();
                }
                //弹窗关闭  dismiss()时恢复原样
            }
        });
        customView.findViewById(R.id.enlarge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popWindow.dismiss();
                if (ButtonUtils.isFastClick()) {
                    Intent newIntent = new Intent(getApplication(), ZhanActivity.class);
                    startActivityForResult(newIntent, REQUEST_SELECT_DEVICE);
                }
            }
        });
    }

    //
    public void doPlay() {
        pttOn = 1;//通话中标志位
        if (flag == true) {
            recordManager.start();//录音开始
        } else {
            playVideo("error");
        }
    }

    public void doStop() {
        flag = true;
        recordManager.stop();//录音开始
        pttOn = 0;//通话中标志位
    }

    //录音准备
    private void initRecord() {
        recordManager.init(this.getApplication(), BuildConfig.DEBUG);
        recordManager.changeRecordConfig(recordManager.getRecordConfig().setSampleRate(16000));
        recordManager.changeRecordConfig(recordManager.getRecordConfig().setEncodingConfig(AudioFormat.ENCODING_PCM_16BIT));

        recordManager.changeFormat(RecordConfig.RecordFormat.PCM);
        //String recordDir =
        //        Environment.getExternalStorageDirectory().getAbsolutePath() + "/record/";
        //Log.e("swy", recordDir);
        //recordManager.changeRecordDir(recordDir);

        initRecordEvent();
    }

    private void initRecordEvent() {
        recordManager.setRecordStateListener(new RecordStateListener() {
            @Override
            public void onStateChange(RecordState state) {
                Log.e("swy", state.name());
            }

            @Override
            public void onError(String error) {
                Logger.i("swy", "onError %s", error);
            }
        });
        recordManager.setRecordSoundSizeListener(new RecordSoundSizeListener() {
            @Override
            public void onSoundSize(int soundSize) {
//
                //Log.e("swy", "onSoundSize: "+ String.format(Locale.getDefault(), "声音大小：%s db", soundSize));
            }
        });
        recordManager.setRecordResultListener(new RecordResultListener() {
            @Override
            public void onResult(File result) {
                Log.e("swy", "result wocao");
//                Toast.makeText(TalkActivity.this, "录音文件： " + result.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                path = result.getAbsolutePath();
            }
        });
//        recordManager.setRecordFftDataListener(new RecordFftDataListener() {
//            @Override
//            public void onFftData(byte[] data) {
//                audioView.setWaveData(data);
//            }
//        });
    }

    //打开mic
    private void initMic() {
        recordManager.changeFormat(RecordConfig.RecordFormat.PCM);
        int bufferSize = AudioTrack.getMinBufferSize(16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM);
        //audioTrack.play();
    }

    boolean isPlaying = false;
    boolean isStop = true;

    //播放准备
    private Runnable playPCMRecord = new Runnable() {
        @Override
        public void run() {
            int bufferSize = AudioTrack.getMinBufferSize(16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 16000, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM);
            FileInputStream fis = null;
            Log.e("swy", "lei" + bufferSize);
            try {
                audioTrack.play();
                fis = new FileInputStream(path);

                byte[] buffer = new byte[bufferSize];
                int len = 0;
                isPlaying = true;
                int length = 0;
                while ((len = fis.read(buffer)) != -1 && !isStop) {
//                    Log.d(TAG, "playPCMRecord: len " + len);
                    Log.e("swy", "zuile" + len + "cao" + Arrays.toString(buffer));
                    audioTrack.write(buffer, 0, len);
                    length += len;
//                    composeData(buffer);
                }
            } catch (Exception e) {
                Log.e("swy", "playPCMRecord: e : " + e);
            } finally {
                isPlaying = false;
                isStop = false;
                if (audioTrack != null) {
                    audioTrack.stop();
                    audioTrack = null;
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    private String message;
    private ListTopDatabase listTopDatabase;

    private class ListTopDatabase extends AsyncTask<Void, Void, String> {

        private List<DiaoDan> danAll;

        @Override
        protected String doInBackground(Void... voids) {
            danAll = db.DiaodanDAO().findByTime();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = format.format(date);
            String substring = time.substring(0, 2);
            for (int i = 0; i < danAll.size(); i++) {
                String current_time = danAll.get(i).getCurrent_time();
                db.DiaodanDAO().updateCurTime(substring + current_time, current_time);
            }
            Log.e("测试", message + "");
            //long time = System.currentTimeMillis();
            db.DiaodanDAO().updateTime(time, message);
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                listDatabase = new ListDatabase();
                listDatabase.execute();
                //调用 CountDownTimer 对象的 start() 方法开始倒计时，也不涉及到线程处理
            } catch (Exception e) {
            }
        }
    }

    public static String toUtf8(String str) {
        String result = null;
        try {
            result = new String(str.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    private class ReadDatabase extends AsyncTask<Void, Void, String> {

        private List<DiaoDan> users;

        @Override
        protected String doInBackground(Void... params) {
            users = db.DiaodanDAO().findByTime();
            for (DiaoDan temp : users) {
                db.DiaodanDAO().delete(temp);
            }
            return "";
        }

        @Override
        protected void onPostExecute(String details) {

        }
    }

    private int mInitializationGPS = 0;
    private boolean controlParkingCar = true;

    private void getParkingCar(String info, int initializationGPS, String getsGpsLat, String getsGpsLon, String geteGpsLat, String geteGpsLon) {
        if (controlParkingCar) {
            parkDataDao.del(info);
            controlParkingCar = false;
        }
        Double getsGpsLatDouble = Double.valueOf(getsGpsLat);
        Double getsGpsLonDouble = Double.valueOf(getsGpsLon);
        Double geteGpsLatDouble = Double.valueOf(geteGpsLat);
        Double geteGpsLonDouble = Double.valueOf(geteGpsLon);
        Point3d point3d = new Point3d();
        point3d.setX(getsGpsLonDouble);
        point3d.setY(getsGpsLatDouble);
        double getRatioOfGpsPoint = GetRatioOfGpsPoint(point3d, initializationGPS);
        DecimalFormat df1 = new DecimalFormat("#####0.00%");
        DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
        df1.setDecimalFormatSymbols(symbols1);
        String ratioOfGpsPoint = df1.format(getRatioOfGpsPoint);
        Double ratioOfGpsPointd = Double.valueOf(ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("%")));
        Point3d point3d1 = new Point3d();
        point3d1.setX(geteGpsLonDouble);
        point3d1.setY(geteGpsLatDouble);
        double getRatioOfGpsPoint1 = GetRatioOfGpsPoint(point3d1, initializationGPS);
        String ratioOfGpsPoint1 = df1.format(getRatioOfGpsPoint1);
        Double ratioOfGpsPointd1 = Double.valueOf(ratioOfGpsPoint1.substring(0, ratioOfGpsPoint1.indexOf("%")));
        parkDataDao.add(info, mInitializationGPS + "", getsGpsLonDouble + "", getsGpsLatDouble + "", ratioOfGpsPointd);
        parkDataDao.add(info, mInitializationGPS + "", geteGpsLonDouble + "", geteGpsLatDouble + "", ratioOfGpsPointd1);
        Log.e("测试停留车", ratioOfGpsPointd + "    " + ratioOfGpsPointd1);
        Intent in = new Intent("ParkingCar");
        LocalBroadcastManager.getInstance(context).sendBroadcast(in);
    }

    //解析原始数据
    public void appendRawMsg(String s) {
        io = true;
        try {
            Pocket strbean = JSONArray.parseObject(s, Pocket.class);//将数据流整合成包
            Log.e("解析原始数据", strbean.getGroup() + "  " + strbean.getPeopleId() + "  " + strbean.getType());
            fileUtil.saveAction("时间：" + fileUtil.getDate() + "----" + strbean.getDataMessage() + "----" + strbean.getPeopleId() + "----" + peopleId + "----" + strbean.getType(), "zhengzhou", "Adjustment_zhengzhou");
            switch (strbean.getType()) {
                case "DeleteInitializationParkGPS":
                    String deleteTrack = strbean.getDataMessage();
                    Log.e("huo", deleteTrack);
                    switch (deleteTrack) {
                        case "1道":
                            parkDataDao.del("oneParkcar");
                            break;
                        case "2道":
                            parkDataDao.del("twoParkcar");
                            break;
                        case "3道":
                            parkDataDao.del("threeParkcar");
                            break;
                        case "4道":
                            parkDataDao.del("fourParkcar");
                            break;
                        case "5道":
                            parkDataDao.del("fiveParkcar");
                            break;
                        case "货1":
                            parkDataDao.del("sixParkcar");
                            break;
                        case "货2":
                            parkDataDao.del("sevenParkcar");
                            break;
                        case "货3":
                            parkDataDao.del("eightParkcar");
                            break;
                        case "长丰线左":
                            parkDataDao.del("nineParkcar");
                            break;
                        case "长丰线右":
                            parkDataDao.del("tenParkcar");
                            break;
                        case "园1":
                            parkDataDao.del("elevenParkcar");
                            break;
                        case "园2":
                            parkDataDao.del("twelveParkcar");
                            break;
                        case "煤2":
                            parkDataDao.del("thirteenParkcar");
                            break;
                        case "煤1":
                            parkDataDao.del("fourteenParkcar");
                            break;
                        case "百立":
                            parkDataDao.del("fifteenParkcar");
                            break;
                        case "物1":
                            parkDataDao.del("sixteenParkcar");
                            break;
                        case "物2":
                            parkDataDao.del("seventeenParkcar");
                            break;
                        case "物3":
                            parkDataDao.del("eighteenParkcar");
                            break;
                        case "物4":
                            parkDataDao.del("nineteenParkcar");
                            break;
                        default:
                            parkDataDao.del("oneParkcar");
                            parkDataDao.del("twoParkcar");
                            parkDataDao.del("threeParkcar");
                            parkDataDao.del("fourParkcar");
                            parkDataDao.del("fiveParkcar");
                            parkDataDao.del("sixParkcar");
                            parkDataDao.del("sevenParkcar");
                            parkDataDao.del("eightParkcar");
                            parkDataDao.del("nineParkcar");
                            parkDataDao.del("tenParkcar");
                            parkDataDao.del("twelveParkcar");
                            parkDataDao.del("thirteenParkcar");
                            parkDataDao.del("fourteenParkcar");
                            parkDataDao.del("fifteenParkcar");
                            parkDataDao.del("sixteenParkcar");
                            parkDataDao.del("seventeenParkcar");
                            parkDataDao.del("eighteenParkcar");
                            parkDataDao.del("nineteenParkcar");
                    }
                    Intent inDelete = new Intent("ParkingCar");
                    LocalBroadcastManager.getInstance(context).sendBroadcast(inDelete);
                    break;
                case "AddYiChe":
                    controlYiChe = true;
                    break;
                case "RemoveYiChe":
                    controlYiChe = false;
                    break;
                case "parkingCar":
                    controlParkingCar = true;
                    String dataMessage2 = strbean.getDataMessage();
                    Log.e("解析数据", dataMessage2 + "");
                    if (!dataMessage2.equals("")) {
                        List<InitializationParkGPSUser> mInitializationParkGPSUsers = JSON.parseArray(dataMessage2, InitializationParkGPSUser.class);
                        for (int i = 0; i < mInitializationParkGPSUsers.size(); i++) {
                            String track = mInitializationParkGPSUsers.get(i).getTrack();
                            String getsGpsLat = mInitializationParkGPSUsers.get(i).getsGpsLat();
                            String getsGpsLon = mInitializationParkGPSUsers.get(i).getsGpsLon();
                            String geteGpsLat = mInitializationParkGPSUsers.get(i).geteGpsLat();
                            String geteGpsLon = mInitializationParkGPSUsers.get(i).geteGpsLon();
                            Log.e("解析数据", track + "    " + getsGpsLat + "    " + getsGpsLon + "    " + geteGpsLat + "    " + geteGpsLon);
                            switch (track) {
                                case "1道":
                                    mInitializationGPS = 1;
                                    getParkingCar("oneParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "2道":
                                    mInitializationGPS = 2;
                                    getParkingCar("twoParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "3道":
                                    mInitializationGPS = 3;
                                    getParkingCar("threeParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "4道":
                                    mInitializationGPS = 4;
                                    getParkingCar("fourParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "5道":
                                    mInitializationGPS = 5;
                                    getParkingCar("fiveParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "货1":
                                    mInitializationGPS = 6;
                                    getParkingCar("sixParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "货2":
                                    mInitializationGPS = 7;
                                    getParkingCar("sevenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "货3":
                                    mInitializationGPS = 8;
                                    getParkingCar("eightParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "长丰线左":
                                    mInitializationGPS = 9;
                                    getParkingCar("nineParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "长丰线右":
                                    mInitializationGPS = 10;
                                    getParkingCar("tenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "园1":
                                    mInitializationGPS = 11;
                                    getParkingCar("elevenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "园2":
                                    mInitializationGPS = 12;
                                    getParkingCar("twelveParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "煤2":
                                    mInitializationGPS = 13;
                                    getParkingCar("thirteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "煤1":
                                    mInitializationGPS = 14;
                                    getParkingCar("fourteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "百立":
                                    mInitializationGPS = 15;
                                    getParkingCar("fifteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "物1":
                                    mInitializationGPS = 16;
                                    getParkingCar("sixteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "物2":
                                    mInitializationGPS = 17;
                                    getParkingCar("seventeenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "物3":
                                    mInitializationGPS = 18;
                                    getParkingCar("eighteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                case "物4":
                                    mInitializationGPS = 19;
                                    getParkingCar("nineteenParkcar", mInitializationGPS, getsGpsLat, getsGpsLon, geteGpsLat, geteGpsLon);
                                    break;
                                default:
                                    mInitializationGPS = 0;
                            }
                        }
                    } else {

                    }
                    break;
                case "DeleteDataBase":
                    signalling1 = 0;
                    mVehicleCommander = 0;
                    trackNumber = "0";
                    ReadDatabase readDatabase = new ReadDatabase();
                    readDatabase.execute();
                    Intent in = new Intent("adjustment");
                    sendBroadcast(in);
                    break;
                case "SwitchOrderAdjustment":
                    String dataMessage1 = strbean.getDataMessage();
                    JSONObject jsonObject = JSONObject.parseObject(dataMessage1);
                    switchType = (String) jsonObject.get("type");
                    switchTime = (String) jsonObject.get("time");
                    gouName1 = (String) jsonObject.get("gouName");
                    gouN = Integer.valueOf(gouName1);
                    Log.e("switchTime", switchTime + "  " + mTime);
                    if (switchTime.equals(mTime)) {
                        if (switchType.equals("up")) {
                            gouName = gouN--;
                        } else {
                            gouName = gouN;
                        }
                    } else {
                        gouName = 0;
                    }
                    Log.e("效果", gouName + "");
                    break;
                case "GPS":
                    String dataMessage = strbean.getDataMessage();
                    String a = dataMessage.substring(0, dataMessage.indexOf("-"));
                    String b = dataMessage.substring(dataMessage.indexOf("-") + 1);
                    Double a1 = Double.valueOf(a);
                    Double b1 = Double.valueOf(b);
                    switch (strbean.getPeopleId()) {
                        case "20":
                            mTime0 = 10;
                            //计算股道
                            int mGetGudaoOfGpsPoint20 = GetGudaoOfGpsPoint(b1, a1);
                            Log.e("股道", "股道: " + mGetGudaoOfGpsPoint20 + " ");
                            mRatioOfGpsTrackCar20 = String.valueOf(mGetGudaoOfGpsPoint20);
                            Point3d point3d = new Point3d();
                            point3d.setX(b1);
                            point3d.setY(a1);
                            Double mGetRatioOfGpsPointCar20 = GetRatioOfGpsPoint(point3d, mGetGudaoOfGpsPoint20);
                            Log.e("机车运行轨迹：", mRatioOfGpsTrackCar20 + "  ：  " + mGetRatioOfGpsPointCar20);

                            DecimalFormat df1 = new DecimalFormat("#####0.00%");
                            DecimalFormatSymbols symbols1 = new DecimalFormatSymbols();
                            df1.setDecimalFormatSymbols(symbols1);
                            String ratioOfGpsPoint = df1.format(mGetRatioOfGpsPointCar20);
                            String gpsPoint = ratioOfGpsPoint.substring(0, ratioOfGpsPoint.indexOf("."));
                            mGpsPistanceCar20 = Double.valueOf(gpsPoint);
                            mhandler0 = new Handler() {
                                @Override
                                public void handleMessage(@NonNull Message msg) {
                                    super.handleMessage(msg);
                                    mTime0--;
                                    if (mTime0 < 0) {
                                        Log.e("fffff", mTime0 + "  ");
                                        if (aaa == true) {
                                            diaochez.setVisibility(View.GONE);
                                            mRatioOfGpsTrackCar20 = "-1";
                                        }
                                    } else {
                                        if (aaa == true) {
                                            if (mPeople0.getName().equals(mMControlMapName) && !mRatioOfGpsTrackCar20.equals("-1")) {
                                                diaochez.setVisibility(View.VISIBLE);
                                            } else {
                                                diaochez.setVisibility(View.GONE);
                                                mRatioOfGpsTrackCar20 = "-1";
                                            }
                                        }
                                        sendEmptyMessageDelayed(0, 40000);
                                    }
                                }
                            };
                            mhandler0.sendEmptyMessageDelayed(0, 4000);
                            break;
                        case "01":
                            mTime1 = 10;
                            //计算股道
                            int mGetGudaoOfGpsPoint01 = GetGudaoOfGpsPoint(b1, a1);
                            Log.e("股道", "股道: " + mGetGudaoOfGpsPoint01 + " ");
                            mRatioOfGpsTrackCar01 = String.valueOf(mGetGudaoOfGpsPoint01);
                            Point3d point3d01 = new Point3d();
                            point3d01.setX(b1);
                            point3d01.setY(a1);
                            Double mGetRatioOfGpsPointCar01 = GetRatioOfGpsPoint(point3d01, mGetGudaoOfGpsPoint01);
                            Log.e("机车运行轨迹：", mRatioOfGpsTrackCar01 + "  ：  " + mGetRatioOfGpsPointCar01);

                            DecimalFormat df101 = new DecimalFormat("#####0.00%");
                            DecimalFormatSymbols symbols01 = new DecimalFormatSymbols();
                            df101.setDecimalFormatSymbols(symbols01);
                            String ratioOfGpsPoint01 = df101.format(mGetRatioOfGpsPointCar01);
                            String gpsPoint01 = ratioOfGpsPoint01.substring(0, ratioOfGpsPoint01.indexOf("."));
                            mGpsPistanceCar01 = Double.valueOf(gpsPoint01);
                            mhandler1 = new Handler() {
                                @Override
                                public void handleMessage(@NonNull Message msg) {
                                    super.handleMessage(msg);
                                    mTime1--;
                                    if (mTime1 < 0) {
                                        Log.e("fffff", mTime1 + "  ");
                                        if (aaa == true) {
                                            lianpeopleo.setVisibility(View.GONE);
                                            mRatioOfGpsTrackCar01 = "-1";
                                        }
                                    } else {
                                        Log.e("fffff1", mTime1 + "  0");
                                        if (aaa == true) {
                                            if (mPeople1.getName().equals(mMControlMapName) && !mRatioOfGpsTrackCar01.equals("-1")) {
                                                lianpeopleo.setVisibility(View.VISIBLE);
                                            } else {
                                                lianpeopleo.setVisibility(View.GONE);
                                                mRatioOfGpsTrackCar01 = "-1";
                                            }
                                        }
                                        sendEmptyMessageDelayed(0, 40000);
                                    }
                                }
                            };
                            mhandler1.sendEmptyMessageDelayed(0, 4000);
                            break;
                        case "02":
                            mTime2 = 10;
                            //计算股道
                            int mGetGudaoOfGpsPoint02 = GetGudaoOfGpsPoint(b1, a1);
                            Log.e("股道", "股道: " + mGetGudaoOfGpsPoint02 + " ");
                            mRatioOfGpsTrackCar02 = String.valueOf(mGetGudaoOfGpsPoint02);
                            Point3d point3d02 = new Point3d();
                            point3d02.setX(b1);
                            point3d02.setY(a1);
                            Double mGetRatioOfGpsPointCar02 = GetRatioOfGpsPoint(point3d02, mGetGudaoOfGpsPoint02);
                            Log.e("机车运行轨迹：", mRatioOfGpsTrackCar02 + "  ：  " + mGetRatioOfGpsPointCar02);

                            DecimalFormat df102 = new DecimalFormat("#####0.00%");
                            DecimalFormatSymbols symbols02 = new DecimalFormatSymbols();
                            df102.setDecimalFormatSymbols(symbols02);
                            String ratioOfGpsPoint02 = df102.format(mGetRatioOfGpsPointCar02);
                            String gpsPoint02 = ratioOfGpsPoint02.substring(0, ratioOfGpsPoint02.indexOf("."));
                            mGpsPistanceCar02 = Double.valueOf(gpsPoint02);

                            mhandler2 = new Handler() {
                                @Override
                                public void handleMessage(@NonNull Message msg) {
                                    super.handleMessage(msg);
                                    mTime2--;
                                    if (mTime2 < 0) {
                                        Log.e("fffff", mTime2 + "  ");
                                        if (aaa == true) {
                                            lianpeopletw.setVisibility(View.GONE);
                                            mRatioOfGpsTrackCar02 = "-1";
                                        }
                                    } else {
                                        Log.e("fffff1", mTime2 + "  0");
                                        if (aaa == true) {
                                            if (mPeople2.getName().equals(mMControlMapName) && !mRatioOfGpsTrackCar02.equals("-1")) {
                                                lianpeopletw.setVisibility(View.VISIBLE);
                                            } else {
                                                lianpeopletw.setVisibility(View.GONE);
                                                mRatioOfGpsTrackCar02 = "-1";
                                            }
                                        }
                                        sendEmptyMessageDelayed(0, 40000);
                                    }
                                }
                            };
                            mhandler2.sendEmptyMessageDelayed(0, 4000);
                            break;
                        case "03":
                            mTime3 = 10;
                            //计算股道
                            int mGetGudaoOfGpsPoint03 = GetGudaoOfGpsPoint(b1, a1);
                            Log.e("股道", "股道: " + mGetGudaoOfGpsPoint03 + " ");
                            mRatioOfGpsTrackCar03 = String.valueOf(mGetGudaoOfGpsPoint03);
                            Point3d point3d03 = new Point3d();
                            point3d03.setX(b1);
                            point3d03.setY(a1);
                            Double mGetRatioOfGpsPointCar03 = GetRatioOfGpsPoint(point3d03, mGetGudaoOfGpsPoint03);
                            Log.e("机车运行轨迹：", mRatioOfGpsTrackCar03 + "  ：  " + mGetRatioOfGpsPointCar03);

                            DecimalFormat df103 = new DecimalFormat("#####0.00%");
                            DecimalFormatSymbols symbols03 = new DecimalFormatSymbols();
                            df103.setDecimalFormatSymbols(symbols03);
                            String ratioOfGpsPoint03 = df103.format(mGetRatioOfGpsPointCar03);
                            String gpsPoint03 = ratioOfGpsPoint03.substring(0, ratioOfGpsPoint03.indexOf("."));
                            mGpsPistanceCar03 = Double.valueOf(gpsPoint03);

                            mhandler3 = new Handler() {
                                @Override
                                public void handleMessage(@NonNull Message msg) {
                                    super.handleMessage(msg);
                                    mTime3--;
                                    if (mTime3 < 0) {
                                        Log.e("fffff", mTime3 + "  ");
                                        if (aaa == true) {
                                            lianpeopleth.setVisibility(View.GONE);
                                            mRatioOfGpsTrackCar03 = "-1";
                                        }
                                    } else {
                                        Log.e("fffff1", mTime3 + "  0");
                                        if (aaa == true) {
                                            if (mPeople3.getName().equals(mMControlMapName) && !mRatioOfGpsTrackCar03.equals("-1")) {
                                                lianpeopleth.setVisibility(View.VISIBLE);
                                            } else {
                                                lianpeopleth.setVisibility(View.GONE);
                                                mRatioOfGpsTrackCar03 = "-1";
                                            }
                                        }
                                        sendEmptyMessageDelayed(0, 40000);
                                    }
                                }
                            };
                            mhandler3.sendEmptyMessageDelayed(0, 4000);
                            break;
                        case "04":
                            mTime4 = 10;

                            //计算股道
                            int mGetGudaoOfGpsPoint04 = GetGudaoOfGpsPoint(b1, a1);
                            Log.e("股道", "股道: " + mGetGudaoOfGpsPoint04 + " ");
                            mRatioOfGpsTrackCar04 = String.valueOf(mGetGudaoOfGpsPoint04);
                            Point3d point3d04 = new Point3d();
                            point3d04.setX(b1);
                            point3d04.setY(a1);
                            Double mGetRatioOfGpsPointCar04 = GetRatioOfGpsPoint(point3d04, mGetGudaoOfGpsPoint04);
                            Log.e("机车运行轨迹：", mRatioOfGpsTrackCar04 + "  ：  " + mGetRatioOfGpsPointCar04);

                            DecimalFormat df104 = new DecimalFormat("#####0.00%");
                            DecimalFormatSymbols symbols04 = new DecimalFormatSymbols();
                            df104.setDecimalFormatSymbols(symbols04);
                            String ratioOfGpsPoint04 = df104.format(mGetRatioOfGpsPointCar04);
                            String gpsPoint04 = ratioOfGpsPoint04.substring(0, ratioOfGpsPoint04.indexOf("."));
                            mGpsPistanceCar04 = Double.valueOf(gpsPoint04);

                            mhandler4 = new Handler() {
                                @Override
                                public void handleMessage(@NonNull Message msg) {
                                    super.handleMessage(msg);
                                    mTime4--;
                                    if (mTime4 < 0) {
                                        Log.e("fffff", mTime4 + "  ");
                                        if (aaa == true) {
                                            lianpeoplef.setVisibility(View.GONE);
                                            mRatioOfGpsTrackCar04 = "-1";
                                        }
                                    } else {
                                        Log.e("fffff1", mTime4 + "  0");
                                        if (aaa == true) {
                                            if (mPeople4.getName().equals(mMControlMapName) && !mRatioOfGpsTrackCar04.equals("-1")) {
                                                lianpeoplef.setVisibility(View.VISIBLE);
                                            } else {
                                                lianpeoplef.setVisibility(View.GONE);
                                                mRatioOfGpsTrackCar04 = "-1";
                                            }
                                        }
                                        sendEmptyMessageDelayed(0, 40000);
                                    }
                                }
                            };
                            mhandler4.sendEmptyMessageDelayed(0, 4000);
                            break;
                    }
                    break;
                case "login":
                    group = strbean.getGroup();
                    mSpPersonnelType.setGroup(group);
                    group = mSpPersonnelType.getGroup();
                    mQunZu = group;
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    if (pocket == null) {
                        pocket = new Pocket();
                    }
                    pocket.setTime(System.currentTimeMillis());
                    pocket.setIpAdress(benJi);
                    pocket.setImei(imei);
                    pocket.setPeopleId(peopleId);
                    pocket.setGroup(group);
                    pocket.setUserCode(hao);
                    pocket.setType("ComputerPowerOn");
                    udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
                    break;
                case "Topping"://调车长设置置顶调单
                    message = strbean.getDataMessage();
                    try {
                        listTopDatabase = new ListTopDatabase();
                        listTopDatabase.execute();
                    } catch (Exception e) {
                    }
                    break;
                case "examine_phone"://开机检测提女
                    repeatSignalling = -1;
                    if (pocket == null) {
                        pocket = new Pocket();
                    }
                    //多方
                    //p.setTypes("command");
                    pocket.setTime(System.currentTimeMillis());
                    pocket.setIpAdress(benJi);
                    String ipAdress = strbean.getIpAdress();
                    String name = mUrgentState.getName();
                    String standard = mUrgentState.getStandard();
                    pocket.setDataMessage(name + standard);
                    pocket.setImei(imei);
                    pocket.setGroup(group);
                    pocket.setUserCode(hao);
                    pocket.setPeopleId(peopleId);
                    pocket.setType("examine");
                    udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), ipAdress, JKQ_Port);
                    break;
                case "Measuring":
                    //推进后的测机
                    composeMeasuring(strbean);
                    break;
                case "HookElimination"://销钩
                    composeAdjustment(strbean);
                    break;
                case "CancleHookElimination"://撤回销钩
                    composeAdjustment(strbean);
                    break;
                case "OrderAdjustment"://调单
                    composeAdjustment(strbean);
                    break;
                case "command_phone":
                    composeDataCommend(strbean);//解析信令
                    break;
                case "audio"://语音
                    if (!strbean.getPeopleId().contains("差转台")) {
                        flag = false;
                        //多方内网
                        //composeDataRaw(strbean);
                        //多方公网
                        Log.e("swy", "appendRawMsg 1: " + strbean.getIpAdress() + "------" + benJi);
                        if (!strbean.getIpAdress().matches(benJi)) {
                            if (!ipAddress_domnic.isEmpty()) {
                                if (!ipAddress_domnic.contains(strbean.getIpAdress())) {
                                    ipAddress_domnic.add(strbean.getIpAdress());
                                }

                            } else {
                                ipAddress_domnic.add(strbean.getIpAdress());
                            }
                            composeDataPublic2(strbean);//解析音频
                        } else {

                        }
                        Log.e("swy", "appendRawMsg 3: " + ipAddress_domnic.toString());
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e("qgs", e + "");
        }
    }

    private String dateString = "";
    public String input = "", danhao = "", diaohaoReceiver = "", commandString = "";
    DiaoDanDatabase db = null;
    private String mGjhId = "";

    private class InsertDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String time1 = format.format(date);
            String time = time1.substring(2);
            Log.e("time", time);
            //long time = HookElimination;
            int bydanhao = db.DiaodanDAO().findBydanhao(danhao);
            if (bydanhao > 0) {
                if (commandString.equals("03")) {
                    gjhId = mGjhId;
                    int byGjhId = db.DiaodanDAO().findByGjhId(mGjhId);
                    //db.DiaodanDAO().updateChongStr03(input, dateString, time, "", danhao);
                    if (byGjhId > 0) {

                    } else {
                        DiaoDan diaodan = new DiaoDan(input, dateString, danhao, "", "1", time, mGjhId);
                        db.DiaodanDAO().insert(diaodan);
                    }
                } else {
                    List<DiaoDan> by = db.DiaodanDAO().findByGjId(mGjhId);
                    if (by.size() == 1) {
                        String gjhId = by.get(0).getGjhId();
                        db.DiaodanDAO().updateChongStr04(input, dateString, dateString, gjhId);
                    }
                }
            } else {
                gjhId = mGjhId;
                DiaoDan diaodan = new DiaoDan(input, dateString, danhao, "", "1", time, mGjhId);
                db.DiaodanDAO().insert(diaodan);
                Intent in = new Intent("adjustment");
                in.putExtra("name", input);
                //in.putExtra("gouNnumberDeta", gouNnumberDeta);
                //sendBroadcast(in);
                LocalBroadcastManager.getInstance(TalkActivity.this).sendBroadcast(in);
            }

            if (pocket == null) {
                pocket = new Pocket();
            }
            pocket.setTime(System.currentTimeMillis());
            pocket.setIpAdress(TalkActivity.benJi);
            pocket.setDataMessage(diaohaoReceiver + "," + danhao + "," + dateString);
            pocket.setGroup(group);
            pocket.setUserCode(hao);
            pocket.setGjhId(mGjhId);
            pocket.setPeopleId(TalkActivity.peopleId);
            pocket.setType("OrderAdjustmentReply");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            return input;
        }

        @Override
        protected void onPostExecute(String details) {
            //调单
            Intent in = new Intent("adjustment");
            in.putExtra("name", details);
            sendBroadcast(in);
        }
    }

    private String[] alpha = new String[200];
    String reply;

    //测机
    private void composeMeasuring(Pocket strbean) {
        String dataMessage = strbean.getDataMessage();
        String ipAdress = strbean.getIpAdress();
        String peopleId = strbean.getPeopleId();
        if (peopleId.equals("20") && dataMessage.equals("1")) {
            //调车长
            reply = getReply(peopleId, "90");
        } else {
            //制动员
            reply = getReply(peopleId, "60");
        }
        sendHexString(reply.replaceAll("\\s*", ""), "232");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String substring;
    private String[] gouSplit;
    private String gouXiao;
    private String sTime;
    private UpdateXiaoDatabase updateXiaoDatabase;

    //调单
    private void composeAdjustment(Pocket strbean) {
        String another_data = strbean.getDataMessage();
        mGjhId = strbean.getGjhId();
        Log.e("调单", another_data);
        //fileUtil.saveAction("时间：" + fileUtil.getDate() + "----" + another_data + "----" + mGjhId + "----" + peopleId + "----" + strbean.getType(), "zhengzhou", "Adjustment_zhengzhou");
        if (another_data.length() >= 4 && another_data.substring(0, 4).matches("DD99")) {
            /*DeleteDatabase deleteDatabase = new DeleteDatabase();
            deleteDatabase.execute();*/
            input = another_data;//整个调单数据
            commandString = another_data.substring(8, 10);//命令字
            dateString = another_data.substring(14, 26);//调单时间
            diaohaoReceiver = another_data.substring(40, 42);//调号
            danhao = another_data.substring(44, 46);
            FindAllDatabase findAllDatabase = new FindAllDatabase();
            findAllDatabase.execute();
        } else if (another_data.contains("BJXT") && another_data.contains(",")) {
            alpha = another_data.split(",");
            Integer mVehicle = Integer.valueOf(alpha[4]);
            String mCommander = mList.get(mVehicle - 1);
            Log.e("调单", mCommander);
            String[] mGouContent = mCommander.split(",");
            String mSymbol = mGouContent[2];
            String mNumber = mGouContent[3];
            switch (mSymbol) {
                case "+":
                    Integer.valueOf(mNumber);
                    mVehicleCommander += Integer.valueOf(mNumber);
                    break;
                case "-":
                    mVehicleCommander -= Integer.valueOf(mNumber);
                    break;
            }
            Log.e("调单", mVehicleCommander + "");
            mCheShuTest.setText(mVehicleCommander + "个车");
            mJuLiTest.setText("0米");
            UpdateDatabase updateDatabase = new UpdateDatabase();
            updateDatabase.execute();
        } else if (another_data.contains("JDLT") && another_data.contains(",")) {
            substring = another_data.substring(0, another_data.indexOf(",JDLT"));
            gouSplit = another_data.split(",");
            gouXiao = gouSplit[4];
            System.out.println("-------------------" + alpha + "------------------1");
            System.out.println("-------------------" + alpha + "------------------2");
            //gousumit_list.add(alpha[4]);
            Integer mVehicle = Integer.valueOf(gouSplit[4]);
            String mCommander = mList.get(mVehicle - 1);
            Log.e("调单", mCommander);
            String[] mGouContent = mCommander.split(",");
            String mSymbol = mGouContent[2];
            String mNumber = mGouContent[3];
            switch (mSymbol) {
                case "+":
                    Integer.valueOf(mNumber);
                    mVehicleCommander -= Integer.valueOf(mNumber);
                    break;
                case "-":
                    mVehicleCommander += Integer.valueOf(mNumber);
                    break;
            }
            Log.e("调单", mVehicleCommander + "");
            mCheShuTest.setText(mVehicleCommander + "个车");
            if (gouSplit.length > 0) {
                sTime = gouSplit[gouSplit.length - 1];
                System.out.println("-------------------" + sTime + "------------------121212");
            }
            updateXiaoDatabase = new UpdateXiaoDatabase();
            updateXiaoDatabase.execute();
        }
    }

    private class UpdateXiaoDatabase extends AsyncTask<Void, Void, String> {

        private List<DiaoDan> users;
        String gou_num;
        String getCurrent_time;
        String other = "";

        @Override
        protected String doInBackground(Void... params) {
            int byGjhId = db.DiaodanDAO().findByGjhId(mGjhId);
            if (byGjhId > 0) {
                List<DiaoDan> byGjId = db.DiaodanDAO().findByGjId(mGjhId);
                for (DiaoDan temp : byGjId) {
                    if (gouSplit[5].matches(temp.getCurrent_time())) {
                        DiaoDan diaodan = temp;
                        gou_num = diaodan.getGou_number();
                        getCurrent_time = diaodan.getCurrent_time();
                        Log.e("Talk测试111", gou_num + "  " + getCurrent_time);
                        if (gou_num.length() > 0 && gou_num != null) {
                            String[] split = gou_num.split("-");
                            if (split != null && split.length > 0) {
                                if (split.length > 0) {
                                    for (int i = 0; i < split.length; i++) {
                                        if (!split[i].equals(gouXiao)) {
                                            other += split[i] + "-";
                                        }
                                    }
                                }
                            }
                        } else {
                            Log.e("Talk测试111", " 无销钩数据 ");
                        }
                    }
                }
                db.DiaodanDAO().updateGouNumber(other, sTime);
                return other;
            } else {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String details) {
            if (!gjhId.equals("") && !mGjhId.equals("")) {
                if (gjhId.equals(mGjhId)) {
                    if (details.equals("")) {
                        cur_dang.setText("0");
                    } else {
                        String[] split = details.split("-");
                        int length = split.length;
                        cur_dang.setText(length + "");
                    }
                    mTopPosition = Integer.valueOf(gouSplit[4]) - 1;
                    Intent in2 = new Intent("HookElimination");
                    in2.putExtra("name2", details);
                    sendBroadcast(in2);
                }
            }
        }
    }

    private class FindAllDatabase extends AsyncTask<Void, Void, String> {

        private List<DiaoDan> all;

        @Override
        protected String doInBackground(Void... params) {
            all = db.DiaodanDAO().findByTime();
            return "";
        }

        @Override
        protected void onPostExecute(String details) {
            if (all.size() == 1) {
                String gou_number = all.get(0).getGou_number();
                int length = gou_number.split("-").length;
                Log.e("调单测试", length + "    " + mList.size());
                if (mList.size() == length) {
                    if (countDownTimer != null) {
                        countDownTimer.onFinish();
                        countDownTimer.cancel();
                    }
                    DeleteDatabase deleteDatabase = new DeleteDatabase();
                    deleteDatabase.execute();
                    InsertDatabase addDatabase = new InsertDatabase();
                    addDatabase.execute();
                    Log.e("调单测试", "通过");
                } else {
                    InsertDatabase addDatabase = new InsertDatabase();
                    addDatabase.execute();
                }
            } else {
                InsertDatabase addDatabase = new InsertDatabase();
                addDatabase.execute();
            }
        }
    }

    String detailsDan;
    long djsCountDownTimer = 1000 * 60 * 10;

    private class UpdateDatabase extends AsyncTask<Void, Void, String> {

        private List<DiaoDan> sizeAll;

        @Override
        protected String doInBackground(Void... params) {
            String allUsers = "";
            String every_add = alpha[4] + "-";
            sizeAll = db.DiaodanDAO().getAll();
            int byGjhId = db.DiaodanDAO().findByGjhId(mGjhId);
            if (byGjhId > 0) {
                List<DiaoDan> byGjId = db.DiaodanDAO().findByGjId(mGjhId);
                for (DiaoDan temp : byGjId) {
                    if (alpha[5].matches(temp.getCurrent_time())) {
                        DiaoDan diaodan = temp;
                        diaodan.setGou_number(temp.gou_number + every_add);
                        db.DiaodanDAO().updateDiaodan(diaodan);
                        allUsers = diaodan.gou_number;
                        detailsDan = diaodan.str;
                    }
                }
            }
            return allUsers;
        }

        @Override
        protected void onPostExecute(String details) {
            String[] split = details.split("-");
            int length = split.length;
            if (length == mList.size()) {
                if (sizeAll.size() == 1) {
                    countDownTimer = new CountDownTimer(djsCountDownTimer, 1000) {
                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            Log.e("倒计时", "完成");
                            DeleteDatabase deleteDatabase = new DeleteDatabase();
                            deleteDatabase.execute();
                            Intent in2 = new Intent("HookElimination");
                            in2.putExtra("name2", details);
                            sendBroadcast(in2);
                        }
                    }.start();
                } else {
                    DeleteDatabase deleteDatabase = new DeleteDatabase();
                    deleteDatabase.execute();
                }
            }
            if (!gjhId.equals("") && !mGjhId.equals("")) {
                if (gjhId.equals(mGjhId)) {
                    mTopPosition = Integer.valueOf(alpha[4]);
                    cur_dang.setText(length + "");
                    Intent in2 = new Intent("HookElimination");
                    in2.putExtra("name2", details);
                    sendBroadcast(in2);
                }
            }

        }

    }

    private class DeleteDatabase extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            //List<DiaoDan> users = db.DiaodanDAO().findByTime();
            //String detailsDan = users.get(0).getStr();
            db.DiaodanDAO().deleteStr(detailsDan);
            trackNumber = "0";
            return "";
        }

        @Override
        protected void onPostExecute(String details) {
            /*Intent in2 = new Intent("HookElimination");
            sendBroadcast(in2);*/
        }
    }

    private int repeatSignalling = -1;

    //信令
    private void composeDataCommend(Pocket strbean) {
        //Log.e("swy", "composeDataCommend: "+ strbean.getAnother_data());
        soundIdMap.clear();
        Log.e("提女", strbean.getDataMessage() + "    " + strbean.getType() + "    " + strbean.getSignalling());
        int signalling = strbean.getSignalling();
        signalling1 = signalling;
        if (signalling != repeatSignalling) {
            String titlePosition = strbean.getPeopleId();
            switch (strbean.getDataMessage()) {
                case "tingche0":
                    mControlLocation = false;
                    String replyTingChe = getReply(titlePosition, "71");
                    sendHexString(replyTingChe.replaceAll("\\s*", ""), "232");
                    break;
                case "qidong0":
                    String replyQiDong = getReply(titlePosition, "41");
                    sendHexString(replyQiDong.replaceAll("\\s*", ""), "232");
                    break;
                case "jiansu0":
                    String replyJianSu = getReply(titlePosition, "21");
                    sendHexString(replyJianSu.replaceAll("\\s*", ""), "232");
                    break;
                case "shiche0":
                    String replyShiChe = getReply(titlePosition, "27");
                    sendHexString(replyShiChe.replaceAll("\\s*", ""), "232");
                    break;
                case "wuche0":
                    String replyWuChe = getReply(titlePosition, "25");
                    sendHexString(replyWuChe.replaceAll("\\s*", ""), "232");
                    break;
                case "sanche0":
                    String replySanChe = getReply(titlePosition, "23");
                    sendHexString(replySanChe.replaceAll("\\s*", ""), "232");
                    break;
                case "yiche0":
                    String replyYiChe = getReply(titlePosition, "26");
                    sendHexString(replyYiChe.replaceAll("\\s*", ""), "232");
                    break;
                case "lianjie0":
                    mControlLocation = true;
                    String replyLianJie = getReply(titlePosition, "45");
                    sendHexString(replyLianJie.replaceAll("\\s*", ""), "232");
                    break;
                case "liufang0":
                    mControlLocation = true;
                    String replyLiuFang = getReply(titlePosition, "47");
                    sendHexString(replyLiuFang.replaceAll("\\s*", ""), "232");
                    break;
                case "tuijin0":
                    mControlLocation = true;
                    String replyTuiJin = getReply(titlePosition, "43");
                    sendHexString(replyTuiJin.replaceAll("\\s*", ""), "232");
                    break;
                case "jiesuo0":
                    String replyJieSuo = getReply(titlePosition, "75");
                    sendHexString(replyJieSuo.replaceAll("\\s*", ""), "232");
                    break;
                case "jinjitingche0":
                    String replyJinJiTingChe = getReply(titlePosition, "73");
                    sendHexString(replyJinJiTingChe.replaceAll("\\s*", ""), "232");
                    break;
                case "lingche0":
                    String replyLingChe = getReply(titlePosition, "49");
                    sendHexString(replyLingChe.replaceAll("\\s*", ""), "232");
                    break;
            }
            new PlayThread().run();
            repeatSignalling = signalling;
        }
    }

    public String getReply(String peopleId, String instructions) {
        String form = "A501" + peopleId + instructions + "01" + "01";
        String data = form.replaceAll(" ", "");
        int total = 0;
        for (int i = 0; i < data.length(); i += 2) {
            //strB.append("0x").append(strData.substring(i,i+2));  //0xC30x3C0x010x120x340x560x780xAA
            total = total + Integer.parseInt(data.substring(i, i + 2), 16);
        }
        //noTotal为累加和取反加一
        int noTotal = ~total + 1;
        Log.i("total", String.valueOf(noTotal));
        //负整数时，前面输入了多余的 FF ，没有去掉前面多余的 FF，按并双字节形式输出
        //0xFF会像转换成0x000000FF后再进行位运算
        String hex = Integer.toHexString(noTotal).toUpperCase();
        Log.i("TAGhex1", hex);
        String key = hex.substring(hex.length() - 2);
        Log.i("TAG校验码key", key);
        Log.i("TAGhex2", key);
        //将求得的最后两位拼接到setup字符串后面
        String cumulative = data + key;
        Log.i("TAGhex3", cumulative);
        return cumulative;
    }

    //单片机解析
    private void composeData(Pocket p) {
        if (p.isEnd() && p.getNum() == 0) {
            end = false;
            index = 0;
            map.clear();
            //Message.obtain(new Handler(), 1, "1111").sendToTarget();
            max = 1000;
            io = false;
        }

        if (!p.isEnd()) {
            Log.e("swy", "If is not end 1: " + p.isEnd());
            map.put(p.getNum(), p);
            Log.e("swy", "If is not end 2: " + p.getNum());
            if (map.size() >= 7) {
                Log.e("swy", "If is not end 3: " + map.size());
                for (int i = 0; i < map.size(); i++) {
                    if (map.get(index) != null) {
                        Log.e("swy", "If is not end 4+1: " + index);
                        audioTrack.write(DecodeAudio(map.get(index).getData()), 0, speex.getFrameSize());
                        index++;
                        Log.e("swy", "write" + index);
                        break;
                    } else {
                        Log.e("swy", "If is not end 4+2: " + index);
                        index++;
                    }
                }
            }
        } else {
            end = true;
            max = p.getNum();
            Log.e("swy", "end" + max);
        }

        Log.e("swy", "map" + map.size() + ":index" + index);

        if (end && index <= max - 5) {
            try {
//                audioTrack.write(map.get(max-=5).getData(),0,640);
//                audioTrack.write(map.get(max-=4).getData(),0,640);
//                audioTrack.write(map.get(max-=3).getData(),0,640);
//                audioTrack.write(map.get(max-=2).getData(),0,640);
//                audioTrack.write(map.get(max-=1).getData(),0,640);
//                audioTrack.write(map.get(max).getData(),0,640);
            } catch (Exception e) {
                Log.e("swy", "zuile");
            }

            Log.e("swy", "reset");
            end = false;
            index = 0;
            map.clear();
            //Message.obtain(new Handler(), 1, "1111").sendToTarget();
            ;
            max = 1000;
            io = false;
        } else if (end) {
            Log.e("swy", "reset");
            end = false;
            index = 0;
            map.clear();
            //Message.obtain(new Handler(), 1, "1111").sendToTarget();
            ;
            max = 1000;
            io = false;
        }

    }

    //多方公网（现用）
    private void composeDataPublic2(Pocket p) {

        //确定谁的音频该录入哪个map
        if (!ipAddress_domnic.isEmpty()) {
            if (p.getIpAdress().matches(ipAddress_domnic.get(0))) {
                Log.e("bjxttest", "If is end 0: " + p.getDataMessage());
                if (p.isEnd()) {
                    audio_map1.clear();
                    ipAddress_domnic.remove(0);
                    Log.e("swy", "If is end 0: " + audio_map1.size());
                } else {
                    TestPocket testPocket = new TestPocket(DecodeAudio(p.getData()));
                    audio_map1.add(testPocket);
                }
            } else if (p.getIpAdress().matches(ipAddress_domnic.get(1))) {
                if (p.isEnd()) {
                    audio_map2.clear();
                    ipAddress_domnic.remove(1);
                    Log.e("swy", "If is end 1: " + audio_map2.size());
                } else {
                    TestPocket testPocket = new TestPocket(DecodeAudio(p.getData()));
                    audio_map2.add(testPocket);
                    //Log.e("swy", "If is end 222: " + audio_map2.size());
                }
            } else if (p.getIpAdress().matches(ipAddress_domnic.get(2))) {
                if (p.isEnd()) {
                    audio_map3.clear();
                    ipAddress_domnic.remove(2);
                    Log.e("swy", "If is end 2: " + audio_map3.size());
                } else {
                    TestPocket testPocket = new TestPocket(DecodeAudio(p.getData()));
                    audio_map3.add(testPocket);
                }
            } else if (p.getIpAdress().matches(ipAddress_domnic.get(3))) {
                if (p.isEnd()) {
                    audio_map4.clear();
                    ipAddress_domnic.remove(3);
                    Log.e("swy", "If is end 3: " + audio_map4.size());
                } else {
                    TestPocket testPocket = new TestPocket(DecodeAudio(p.getData()));
                    audio_map4.add(testPocket);
                }
            }
        }


        //boolean end_statu = (end_status.get(ipAddress_saved[0]) && end_status.get(ipAddress_saved[1]) && end_status.get(ipAddress_saved[2]) && end_status.get(ipAddress_saved[3]));
        int[] Mapsize = GetMapSize();//音频流数据源多少
        Log.e("swy", "If is not end 4+1: " + Mapsize[0]);
        //Log.e("swy", "If is not end 1: " + end_statu + "------" + end_status.get("192.168.3.192") + "----" + end_status.get("192.168.3.223"));
        if (/*!end_statu && */Mapsize[0] > 0/*(audio_map1.size() >= 7 || audio_map2.size() >= 7)*/) {
            //Log.e("swy", "If is not end 3: " + audio_map1.size());
            try {
                Log.e("swy", "If is not end 4+1: " + Mapsize[0]);
                short[][] bMulRoadAudioes = new short[Mapsize[0]][320];//合成音频用

                MultiAudioMixer addAudioMixer = MultiAudioMixer.createDefaultAudioMixer();

                //多方音频合成
                switch (Mapsize[0]) {
                    case 1:
                        bMulRoadAudioes[0] = GetWhichMapData(Mapsize[1]);
                        break;
                    case 2:
                        bMulRoadAudioes[0] = GetWhichMapData(Mapsize[1]);
                        bMulRoadAudioes[1] = GetWhichMapData(Mapsize[2]);
                        break;
                    case 3:
                        bMulRoadAudioes[0] = GetWhichMapData(Mapsize[1]);
                        bMulRoadAudioes[1] = GetWhichMapData(Mapsize[2]);
                        bMulRoadAudioes[2] = GetWhichMapData(Mapsize[3]);
                        break;
                    default:
                        break;
                }
                //bMulRoadAudioes[1] = audio_map2.get(0).getData();
                Log.e("swy", "write in audio 1: ");
                audioTrack.write(HelperPacket.SelfmixRawAudioShorts(bMulRoadAudioes), 0, speex.getFrameSize());
                //audioTrack.write(addAudioMixer.mixRawAudioBytes(bMulRoadAudioes), 0, speex.getFrameSize());
                //audioTrack.write(audio_map1.get(0).getData(), 0, speex.getFrameSize());
                Log.e("swy", "write in audio 2:");
                //再改吧，应该是谁播了谁-1，现在是全减一
                if (!audio_map1.isEmpty()) {
                    audio_map1.remove(0);
                }
                if (!audio_map2.isEmpty()) {
                    audio_map2.remove(0);
                }
                if (!audio_map3.isEmpty()) {
                    audio_map3.remove(0);
                }
                if (!audio_map4.isEmpty()) {
                    audio_map4.remove(0);
                }
                index++;
                Log.e("swy", "write in audio 3:" + index);
            } catch (Exception e) {

            }

        } else if (ipAddress_domnic.isEmpty()) {
            end = true;
            max = p.getNum();
            Log.e("swy", "end" + max);
        }

        //Log.e("swy", "audio_map1 :" + audio_map1.size() + ":index" + index);

        if (end && index <= max - 5) {
            try {
//                audioTrack.write(map.get(max-=5).getData(),0,640);
//                audioTrack.write(map.get(max-=4).getData(),0,640);
//                audioTrack.write(map.get(max-=3).getData(),0,640);
//                audioTrack.write(map.get(max-=2).getData(),0,640);
//                audioTrack.write(map.get(max-=1).getData(),0,640);
//                audioTrack.write(map.get(max).getData(),0,640);
            } catch (Exception e) {
                Log.e("swy", "zuile");
            }

            Log.e("swy", "reset");
            end = false;
            index = 0;
            //audio_map1.clear();
            //Message.obtain(new Handler(), 1, "1111").sendToTarget();
            max = 1000;
            io = false;
            flag = true;
        } else if (end) {
            Log.e("swy", "reset");
            end = false;
            index = 0;
            //audio_map1.clear();
            //Message.obtain(new Handler(), 1, "1111").sendToTarget();
            max = 1000;
            io = false;
            flag = true;
        }

    }

    private String totalPCM;

    public void composeDataPublic1(Pocket p) throws Exception {
        //一次读取多一点 2k
        byte[] buffer1 = new byte[2048];
        byte[] buffer2 = new byte[2048];
        //待输出数据
        byte[] buffer3 = new byte[2048];
        String ipAdress = p.getIpAdress();
        if (ipAdress.equals("192.168.1.127")) {
            String s1 = p.getData().toString();
            mIs1 = new FileInputStream(s1);
        } else if (ipAdress.equals("192.168.1.129")) {
            String s2 = p.getData().toString();
            mIs2 = new FileInputStream(s2);
        }
        short temp2, temp1;//   两个short变量相加 会大于short   声音
        int temp;
        boolean end1 = false, end2 = false;
        while (!end1 || !end2) {
            if (!end1) {
                end1 = (mIs1.read(buffer1) == -1);
//            音乐的pcm数据  写入到 buffer3
                System.arraycopy(buffer1, 0, buffer3, 0, buffer1.length);

            }
            if (!end2) {
                end2 = (mIs2.read(buffer2) == -1);
                int voice = 0;//声音的值  跳过下一个声音的值    一个声音 2 个字节
                for (int i = 0; i < buffer2.length; i += 2) {
//                    或运算
                    temp1 = (short) ((buffer1[i] & 0xff) | (buffer1[i + 1] & 0xff) << 8);
                    temp2 = (short) ((buffer2[i] & 0xff) | (buffer2[i + 1] & 0xff) << 8);
                    temp = (int) (temp1 * 100 + temp2 * 100);//音乐和 视频声音 各占一半
                    if (temp > 32767) {
                        temp = 32767;
                    } else if (temp < -32768) {
                        temp = -32768;
                    }
                    buffer3[i] = (byte) (temp & 0xFF);
                    buffer3[i + 1] = (byte) ((temp >>> 8) & 0xFF);
                }
                audioTrack.write(buffer3, 0, speex.getFrameSize());
            }
        }
    }

    //获取音频源数据
    private short[] GetWhichMapData(int status) {
        short[] results = new short[320];
        switch (status) {
            case 0:
                results = audio_map1.get(0).getData();
                Log.e("swy", "GetWhichMapData 1: ");
                break;
            case 1:
                results = audio_map2.get(0).getData();
                Log.e("swy", "GetWhichMapData 2: ");
                break;
            case 2:
                results = audio_map3.get(0).getData();
                Log.e("swy", "GetWhichMapData 3: ");
                break;
            case 3:
                results = audio_map4.get(0).getData();
                Log.e("swy", "GetWhichMapData 4: ");
                break;
        }
        return results;
    }

    //获取音频源数量
    private int[] GetMapSize() {
        int[] result = new int[5];
        int n = 1;
        audio_map_status[0] = audio_map1.size();
        audio_map_status[1] = audio_map2.size();
        audio_map_status[2] = audio_map3.size();
        audio_map_status[3] = audio_map4.size();
        for (int i = 0; i < audio_map_status.length; i++) {
            if (audio_map_status[i] >= 7) {
                result[0]++;
                result[n] = i;
                n++;
            }
            Log.e("Swy", "GetMapSize  index: " + i + " : " + audio_map_status[i] + ". Result : " + result[1]);
        }
        return result;
    }

    private short[] DecodeAudio(byte[] data) {
        /**
         * 解码
         */
        //Log.e("swy", "DecodeAudio 1: " + data.length + "----------");
        short[] rcvProcessedData = new short[speex.getFrameSize()];
        //byte[]  rawData= new byte[320];
        //System.arraycopy(data, 0, rawData, 0, data.length);
        //Log.e("swy", "DecodeAudio 2: " + data.length + "----------");
        int desize = speex.decode(data, rcvProcessedData, data.length);

        Log.e("swy", "DecodeAudio : " + data.length + "----------" + desize);
        return rcvProcessedData;
    }

    //加载音频文件
    LinkedHashMap<Integer, Integer> soundIdMap = new LinkedHashMap<>();

    private Integer[] loadRaw(SoundPool soundPool, Context context, int raw) {
        int soundId = soundPool.load(context, raw, 1);
        int duration = getMp3Duration(context, raw);
        return new Integer[]{soundId, duration};
    }

    //获取音频文件的时长
    private int getMp3Duration(Context context, int rawId) {
        try {
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + rawId);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //音频播放线程
    private class PlayThread extends Thread {
        @Override
        public void run() {
            Set<Integer> soundIdSet = soundIdMap.keySet();
            for (Integer soundId : soundIdSet) {
                soundPool.play(soundId, 1.0f, 1.0f, 2, 0, 1);
                try {
                    //获取当前音频的时长
                    Thread.sleep(soundIdMap.get(soundId));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void init() {
        //swy
        if (caozuoyuan.matches("调车长")) {
            currnumber = "20";
            diaochezhang_premiss = true;
            /*bt_tigou_send.setEnabled(false);
            bt_zhaigou_send.setEnabled(false);*/
            //sendMessage("7");
            /*XintiaoReadThread xintiaoReadThread = new XintiaoReadThread();
            xintiaoReadThread.start();*/
        } else {
        }

        track_talk = findViewById(R.id.track_talk);
        zhuyishixiang = findViewById(R.id.zhuyishixiang);
        zhuyishixiang.setMovementMethod(ScrollingMovementMethod.getInstance());

        TextView bianhao = findViewById(R.id.bianhao);
        bianhao.setText(hao);
        cur_danhao = findViewById(R.id.danhao);
        cur_jiche = findViewById(R.id.jiche);
        cur_bianzhiren = findViewById(R.id.bianzhiren);
        cur_diaochezhang = findViewById(R.id.diaochezhang);
        cur_jihuacontent = findViewById(R.id.jihuacontent);
        cur_jihuatime = findViewById(R.id.jihuatime);
        cur_zhuyishixiang = findViewById(R.id.zhuyishixiang);
        cur_img = findViewById(R.id.cur_img);
        current_adjustment = findViewById(R.id.current_adjustment);
        location_lin = findViewById(R.id.location_lin);
        location_lin.setOnClickListener(this);

        TextClock textclock = findViewById(R.id.textclock);
        textclock.setFormat24Hour("yyyy-MM-dd HH:mm:ss");

        cur_recy = findViewById(R.id.cur_recy);

        curDanhao = findViewById(R.id.cur_danhao);
        cur_dang = findViewById(R.id.cur_dang);
        cur_total = findViewById(R.id.cur_total);
        cur_xie = findViewById(R.id.cur_xie);
        cur_gou = findViewById(R.id.cur_gou);
        //TextView cur_xie = findViewById(R.id.cur_xie);
        AssetManager assets = getAssets();
        fromAsset = Typeface.createFromAsset(assets, "fonts/HanyiSentySpringBrush.ttf");
        curDanhao.setTypeface(fromAsset);
        cur_dang.setTypeface(fromAsset);
        cur_total.setTypeface(fromAsset);
        //cur_xie.setTypeface(fromAsset);
        mCheShuTest = findViewById(R.id.cheshutest);
        mJuLiTest = findViewById(R.id.julitest);
        mCheShuTest.setText(mVehicleCommander + "个车");
        mJuLiTest.setText("0米");
        handler_xintiao.postDelayed(member_location_rrr, 5000);//心跳
    }

    int lingche_count = 0, shiche_index = 0;

    //pe5//检测sql口
    private class IOReadThread extends Thread {
        @Override
        public void run() {
            super.run();
            String[] last = {"1", "1"};//pe5置高，相同不处理，不同处理
            while (!isInterrupted()) {
                try {
                    // 定义路径
                    String gpioPath = "/sys/class/gpio/gpio130/value";
                    // 创建接收缓冲区
                    char[] buffer = new char[2048];
                    fileReader = new FileReader(gpioPath);
                    reader = new BufferedReader(fileReader);
                    reader.read(buffer);
                    gpioValue = buffer[0] + "";
                    last[1] = gpioValue;
                    //Log.e("二宝", gpioValue);

                    if (last[0].matches(last[1])) {
                    } else if (!last[0].matches(last[1]) && gpioValue.matches("0")) {
                        Log.d("error", "0");
                        last[0] = gpioValue;
                        //sendHexString("1002C107000404C1020004A8031003", "232");
                        iohandle.post(iorunnable0);
                    } else if (!last[0].matches(last[1]) && gpioValue.matches("1")) {
                        Log.d("error", "1");
                        last[0] = gpioValue;
                        iohandle.post(iorunnable1);
                        //sendHexString("1002C107000B0BC102000BF9161003", "232");
                    }

                    //Log.e("swy", "GPIOt"+buffer[0]);
                    //gpioValue = buffer[0] + "";
                } catch (IOException e) {
                    Log.d("error", "cat GPIO error");
                    e.printStackTrace();
                }
            }
        }
    }

    //pe2打开通道
    private Handler iohandle = new Handler();
    Runnable iorunnable0 = new Runnable() {
        @Override
        public void run() {
            //mService.userPressDown();
            doPlay();
        }
    };

    Runnable iorunnable1 = new Runnable() {
        @Override
        public void run() {
            //mService.userPressUp();
            doStop();
        }
    };

    private Handler mGpsHandler = new Handler();
    private Runnable mGpsRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mCarGps.equals("")) {
                if (pocket == null) {
                    pocket = new Pocket();
                }
                pocket.setType("GPS");
                pocket.setTime(System.currentTimeMillis());
                pocket.setIpAdress(benJi);
                pocket.setPeopleId(peopleId);
                pocket.setDataMessage(mCarGps);
                pocket.setEnd(false);
                pocket.setNum(0);
                pocket.setGroup(group);
                pocket.setUserCode(hao);
                pocket.setImei(imei);
                pocket.setSpeed(mCarSuLv);
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            }
            mGpsHandler.postDelayed(mGpsRunnable, 3000);
        }
    };

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
                    n = i;
                }
            }
            //mTv3.setText("点到股道距离:     gudao: " + i + "     " + dis);
        }
        if (dis > 5.0) {
            n = -1;
        }
        return n;
    }

    private int mGuDao;

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

    long mTime0 = 6;
    long mTime1 = 6;
    long mTime2 = 6;
    long mTime3 = 6;
    long mTime4 = 6;
    long mStartTime = 20;

    @SuppressLint("HandlerLeak")
    private Handler mStartHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mStartTime--;
            if (mStartTime < 0) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String deviceId = telephonyManager.getDeviceId();
                Log.e("deviceId", deviceId);
                mSpPersonnelType.setIMEI(deviceId);
                imei = mSpPersonnelType.getIMEI();
                benJi = getIpAddress();
                if (pocket == null) {
                    pocket = new Pocket();
                }
                pocket.setTime(System.currentTimeMillis());
                pocket.setIpAdress(benJi);
                pocket.setImei(imei);
                pocket.setPeopleId(peopleId);
                pocket.setUserCode(hao);
                pocket.setGroup(group);
                pocket.setType("login");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            } else {
                mStartHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    public static String getIpAddress() {
        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Log.e("tiwolf", "getIpAddress: 开机获取ip=" + ni.getName());
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {

                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();

                    // 过滤掉127段的ip地址
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        Log.d("tiwolf", "手机IP地址get the IpAddress--> " + hostIp + "");
        return hostIp;
    }

    private void distanceControl(String gd, Double getRatioOfGpsPointCar, String latCar, String lonCar) {
        if (mControlLocation == true) {
            mZhiList.clear();
            switch (gd) {
                case "1":
                    mParkcar = parkDataDao.find("oneParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "2":
                    mParkcar = parkDataDao.find("twoParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "3":
                    mParkcar = parkDataDao.find("threeParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "4":
                    mParkcar = parkDataDao.find("fourParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "5":
                    mParkcar = parkDataDao.find("fiveParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "6":
                    mParkcar = parkDataDao.find("sixParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "7":
                    mParkcar = parkDataDao.find("sevenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "8":
                    mParkcar = parkDataDao.find("eightParkcar");//101.770756  36.659945 十进制度
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "9":
                    mParkcar = parkDataDao.find("nineParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "10":
                    mParkcar = parkDataDao.find("tenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "11":
                    mParkcar = parkDataDao.find("elevenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "12":
                    mParkcar = parkDataDao.find("twelveParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "13":
                    mParkcar = parkDataDao.find("thirteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "14":
                    mParkcar = parkDataDao.find("fourteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "15":
                    mParkcar = parkDataDao.find("fifteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "16":
                    mParkcar = parkDataDao.find("sixteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "17":
                    mParkcar = parkDataDao.find("seventeenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "18":
                    mParkcar = parkDataDao.find("eighteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
                case "19":
                    mParkcar = parkDataDao.find("nineteenParkcar");
                    Parkcar(getRatioOfGpsPointCar, latCar, lonCar, gd);
                    break;
            }
        }
    }

    private void Parkcar(Double getRatioOfGpsPointCar, String latCar, String lonCar, String gd) {
        if (mParkcar.size() > 0) {
            for (int j = 0; j < mParkcar.size(); j++) {
                String ratioOfGpsPointCar = mParkcar.get(j).getRatioOfGpsPointCar();
                mZhiList.add(Double.valueOf(ratioOfGpsPointCar));
            }
            int minIndex = ZhiIndex.getMinIndex(mZhiList);
            int maxIndex = ZhiIndex.getMaxIndex(mZhiList);
            Double minRatioOfGpsPointCar = Double.valueOf(mParkcar.get(minIndex).getRatioOfGpsPointCar());
            String minLat = mParkcar.get(minIndex).getLat();
            String minLon = mParkcar.get(minIndex).getLon();
            Double maxRatioOfGpsPointCar = Double.valueOf(mParkcar.get(maxIndex).getRatioOfGpsPointCar());
            String maxLat = mParkcar.get(maxIndex).getLat();
            String maxLon = mParkcar.get(maxIndex).getLon();
            Log.e("mZhiList", "mZhiList: " + maxIndex + "  " + minIndex);
            distance(getRatioOfGpsPointCar, minRatioOfGpsPointCar, maxRatioOfGpsPointCar, latCar, lonCar, minLat, minLon, maxLat, maxLon);
        } else {
            Log.e("mZhiList", "停留车有问题");//101.770756  36.659945 十进制度
            switch (gd) {//经度lon000.000000   纬度lat00.000000
                case "8":
                    distanceJinTouXian(latCar, lonCar, "101.770756", "36.659945");
                    break;
            }
        }
    }

    private Double mDistanceDian, distance;

    private void distance(double getRatioOfGpsPointCar, double minRatioOfGpsPointCar, double maxRatioOfGpsPointCar, String latCar, String lonCar, String minLat, String minLon, String maxLat, String maxLon) {
        if (pocket == null) {
            pocket = new Pocket();
        }
        pocket.setTime(System.currentTimeMillis());
        pocket.setIpAdress(benJi);
        pocket.setImei(imei);
        pocket.setPeopleId(peopleId);
        pocket.setUserCode(hao);
        pocket.setGjhId("");
        pocket.setType("AutomaticBroadcasting");
        //计算两点的距离
        if (getRatioOfGpsPointCar > minRatioOfGpsPointCar && getRatioOfGpsPointCar > maxRatioOfGpsPointCar) {
            mDistanceDian = getDistance(Double.valueOf(maxLon), Double.valueOf(maxLat), Double.valueOf(latCar), Double.valueOf(lonCar));
        } else if (getRatioOfGpsPointCar < minRatioOfGpsPointCar && getRatioOfGpsPointCar < maxRatioOfGpsPointCar) {
            mDistanceDian = getDistance(Double.valueOf(minLon), Double.valueOf(minLat), Double.valueOf(latCar), Double.valueOf(lonCar));
        }
        distance = mDistanceDian - mVehicleCommander * 13;
        Log.i("十五三一车", "西宁测试" + distance);
        mJuLiTest.setText("距停留车" + distance + "米");
        //十五三一车
        if (distance > 105 && distance <= 117 && shi == false && wu == false && san == false) {
            //十车
            Log.i("十五三一车", "西宁测试十车");
            shi = true;
            //if (!mJieShiChe) {
            pocket.setDataMessage("十车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance > 52 && distance <= 62 && wu == false && san == false) {
            //五车
            Log.i("十五三一车", "西宁测试五车");
            wu = true;
            shi = true;
            //if (!mJieWuChe) {
            pocket.setDataMessage("五车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance > 30 && distance <= 40 && san == false) {
            //三车
            Log.i("十五三一车", "西宁测试三车");
            san = true;
            wu = true;
            shi = true;
            //if (!mJieSanChe) {
            pocket.setDataMessage("三车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance <= 18 && yi == false) {
            //一车
            Log.i("十五三一车", "西宁测试一车");
            yi = true;
            san = true;
            wu = true;
            shi = true;
            if (!mJieYiChe && controlYiChe == true) {
                pocket.setDataMessage("一车");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            }
        }
    }

    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
        float[] results = new float[1];
        Location.distanceBetween(lat1, lon1, lat2, lon2, results);
        return results[0];
    }

    private void distanceJinTouXian(String latCar, String lonCar, String mLat, String mLon) {
        if (pocket == null) {
            pocket = new Pocket();
        }
        pocket.setTime(System.currentTimeMillis());
        pocket.setIpAdress(benJi);
        pocket.setImei(imei);
        pocket.setPeopleId(peopleId);
        pocket.setUserCode(hao);
        pocket.setGjhId("");
        pocket.setType("AutomaticBroadcasting");
        //计算两点的距离
        mDistanceDian = getDistance(Double.valueOf(mLon), Double.valueOf(mLat), Double.valueOf(latCar), Double.valueOf(lonCar));
        distance = mDistanceDian - mVehicleCommander * 13;
        Log.i("十五三一车尽头线", "西宁测试" + distance);
        mJuLiTest.setText("距尽头线" + distance + "米");
        //十五三一车
        if (distance > 105 && distance <= 117 && shi == false && wu == false && san == false) {
            //十车
            Log.i("十五三一车", "西宁测试十车");
            shi = true;
            //if (!mJieShiChe) {
            pocket.setDataMessage("十车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance > 52 && distance <= 62 && wu == false && san == false) {
            //五车
            Log.i("十五三一车", "西宁测试五车");
            wu = true;
            shi = true;
            //if (!mJieWuChe) {
            pocket.setDataMessage("五车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance > 30 && distance <= 40 && san == false) {
            //三车
            Log.i("十五三一车", "西宁测试三车");
            san = true;
            wu = true;
            shi = true;
            //if (!mJieSanChe) {
            pocket.setDataMessage("三车");
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            //}
        } else if (distance <= 18 && yi == false) {
            //一车
            Log.i("十五三一车", "西宁测试一车");
            yi = true;
            san = true;
            wu = true;
            shi = true;
            if (!mJieYiChe && controlYiChe == true) {
                pocket.setDataMessage("一车");
                udpHelperServer.sendStrMessage(JSONObject.toJSONString(pocket), Content.Ip_Adress, Content.port);
            }
        }
    }
}
