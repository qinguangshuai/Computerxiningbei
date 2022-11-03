package com.example.socket.Unit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import static android.content.Context.WIFI_SERVICE;

public class HelperPacket {

    //API版本23以下时调用此方法进行检测
//因为API23后getNetworkInfo(int networkType)方法被弃用
    public static void checkState_23(Context context) {
        //步骤1：通过Context.getSystemService(Context.CONNECTIVITY_SERVICE)获得ConnectivityManager对象
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //步骤2：获取ConnectivityManager对象对应的NetworkInfo对象
        //NetworkInfo对象包含网络连接的所有信息
        //步骤3：根据需要取出网络连接信息
        //获取WIFI连接的信息
        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        Boolean isWifiConn = networkInfo.isConnected();

        //获取移动数据连接的信息
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        Boolean isMobileConn = networkInfo.isConnected();
        Log.e("swy", "Wifi是否连接:" + isWifiConn);
        Log.e("swy", "移动数据是否连接:" + isMobileConn);
    }

    // API 23及以上时调用此方法进行网络的检测
    // getAllNetworks() 在API 21后开始使用
    //步骤非常类似
    public static void checkState_23orNew(Context context) {
        //获得ConnectivityManager对象
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        //获取所有网络连接的信息
        Network[] networks = connMgr.getAllNetworks();
        //用于存放网络连接信息
        StringBuilder sb = new StringBuilder();
        //通过循环将网络信息逐个取出来
        for (int i = 0; i < networks.length; i++) {
            //获取ConnectivityManager对象对应的NetworkInfo对象
            NetworkInfo networkInfo = connMgr.getNetworkInfo(networks[i]);
            sb.append(networkInfo.getTypeName() + " connect is " + networkInfo.isConnected());
        }
    }


    public static String GetIpAddress(String str, Context context) {
        String result = "";
        if (str.matches("wifi")) {
            result = GetWifiIpAddress(context);
        } else if (str.matches("ip")) {
            result = getLocalIpAddress();
        }
        return result;
    }


    public static String GetWifiIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int i = wifiInfo.getIpAddress();
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                ((i >> 24) & 0xFF);
    }

    //获取本地IP
    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("swy", "WifiPreference IpAddress" + ex.toString());
        }
        return null;
    }


    //bMulRoadAudioes为数据源二位数组。
    public static short[] mixRawAudioBytes(short[][] bMulRoadAudioes) {

        if (bMulRoadAudioes == null || bMulRoadAudioes.length == 0)
            return null;

        short[] realMixAudio = bMulRoadAudioes[0];

        if (bMulRoadAudioes.length == 1)
            return realMixAudio;

        for (int rw = 0; rw < bMulRoadAudioes.length; ++rw) {
            if (bMulRoadAudioes[rw].length != realMixAudio.length) {
                Log.e("app", "column of the road of audio + " + rw + " is diffrent.");
                return null;
            }
        }

        //row 代表参与合成的音频数量
        //column 代表一段音频的采样点数，这里所有参与合成的音频的采样点数都是相同的
        int row = bMulRoadAudioes.length;
        int coloum = realMixAudio.length / 2;
        short[][] sMulRoadAudioes = new short[row][coloum];

        //PCM音频16位的存储是大端存储方式，即低位在前，高位在后，例如(X1Y1, X2Y2, X3Y3)数据，它代表的采样点数值就是(（Y1 * 256 + X1）, （Y2 * 256 + X2）, （Y3 * 256 + X3）)
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < coloum; ++c) {
                sMulRoadAudioes[r][c] = (short) ((bMulRoadAudioes[r][c * 2] & 0xff) | (bMulRoadAudioes[r][c * 2 + 1] & 0xff) << 8);
            }
        }

        short[] sMixAudio = new short[coloum];
        int mixVal;
        int sr = 0;
        for (int sc = 0; sc < coloum; ++sc) {
            mixVal = 0;
            sr = 0;
            //这里采取累加法
            for (; sr < row; ++sr) {
                mixVal += sMulRoadAudioes[sr][sc];
            }
            //最终值不能大于short最大值，因此可能出现溢出
            sMixAudio[sc] = (short) (mixVal);
        }

        //short值转为大端存储的双字节序列
        for (sr = 0; sr < coloum; ++sr) {
            realMixAudio[sr * 2] = (byte) (sMixAudio[sr] & 0x00FF);
            realMixAudio[sr * 2 + 1] = (byte) ((sMixAudio[sr] & 0xFF00) >> 8);
        }

        return realMixAudio;
    }


    //bMulRoadAudioes为数据源二位数组。
    public static short[] SelfmixRawAudioShorts(short[][] bMulRoadAudioes) {
        short[] is_null = new short[320];

        if (bMulRoadAudioes == null || bMulRoadAudioes.length == 0) {
            Log.e("swy", "bMulRoadAudioes == null");
            return is_null;

        }

        short[] realMixAudio = bMulRoadAudioes[0];

        if (bMulRoadAudioes.length == 1) {
            Log.e("swy", "bMulRoadAudioes.length == 1");
            return realMixAudio;
        }


        for (int rw = 0; rw < bMulRoadAudioes.length; ++rw) {
            if (bMulRoadAudioes[rw].length != realMixAudio.length) {
                Log.e("swy", "column of the road of audio + " + rw + " is diffrent.");
                return is_null;
            }
        }

        //row 代表参与合成的音频数量
        //column 代表一段音频的采样点数，这里所有参与合成的音频的采样点数都是相同的
        int row = bMulRoadAudioes.length;
        int coloum = realMixAudio.length;
        /*short[][] sMulRoadAudioes = new short[row][coloum];

        Log.e("swy", "SelfmixRawAudioShorts 1 : "+ "row: "+row+",coloum: "+coloum);
        //PCM音频16位的存储是大端存储方式，即低位在前，高位在后，例如(X1Y1, X2Y2, X3Y3)数据，它代表的采样点数值就是(（Y1 * 256 + X1）, （Y2 * 256 + X2）, （Y3 * 256 + X3）)
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < coloum; ++c) {
                sMulRoadAudioes[r][c] = (short) ((bMulRoadAudioes[r][c * 2] & 0xff) | (bMulRoadAudioes[r][c * 2 + 1] & 0xff) << 8);
            }
        }

        Log.e("swy", "SelfmixRawAudioShorts 2");*/
        Log.e("swy", "SelfmixRawAudioShorts 1 : " + "row: " + row + ",coloum: " + coloum);
        short[] sMixAudio = new short[coloum];
        int mixVal;

        for (int sc = 0; sc < coloum; sc++) {
            mixVal = 0;
            //sr = 0;
            //这里采取累加法
            for (int sr = 0; sr < row; sr++) {
                mixVal += bMulRoadAudioes[sr][sc];
                if (mixVal > 32767) {
                    mixVal = 32767;
                } else if (mixVal < -32768) {
                    mixVal = -32768;
                }
            }
            //最终值不能大于short最大值，因此可能出现溢出
            sMixAudio[sc] = (short) (mixVal);
        }

        Log.e("swy", "SelfmixRawAudioShorts 2 : ");
        //short值转为大端存储的双字节序列
        /*for (sr = 0; sr < coloum; ++sr) {
            realMixAudio[sr * 2] = (byte) (sMixAudio[sr] & 0x00FF);
            realMixAudio[sr * 2 + 1] = (byte) ((sMixAudio[sr] & 0xFF00) >> 8);
        }
        Log.e("swy", "SelfmixRawAudioShorts 3 : ");*/
        return sMixAudio;
    }

    public static short remix(short buffer1, short buffer2) {
        int value = buffer1 + buffer2;
        return (short) (value / 2);


    }
}
