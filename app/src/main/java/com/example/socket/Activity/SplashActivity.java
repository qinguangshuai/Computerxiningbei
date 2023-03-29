package com.example.socket.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.socket.R;
import com.example.socket.Unit.SpUtil;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SplashActivity extends AppCompatActivity {

    private ImageView splash_img;
    long mTime = 1;
    private final int ACTION_REQUEST_PERMISSIONS = 0x001;
    private SpUtil personnelType;
    private String ipAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_img = findViewById(R.id.splash_img);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ipAddress = getIpAddress();
        checkPermissions();

        /*personnelType.setName("机控器");
        personnelType.setStandard("B制式");
        personnelType.setHao("10012");
        personnelType.setPeopleId("0C");
        //863930053981282  0A  10010
        //863930053991117  0B  10011
        //863930054320316  0C  10012
        personnelType.setIMEI("863930054320316");
        personnelType.setBenJi(ipAddress);
        //获取权限成功,跳转
        mhandler.sendEmptyMessageDelayed(0, 1000);*/
        startActivity(new Intent(SplashActivity.this, TalkActivity.class));
        finish();
    }

    private String fileContent = "";

    private void initView() {
        personnelType = new SpUtil(getApplication(), "PersonnelType");
        loadImage(splash_img);
        /*if (!checkPermissions(NEEDED_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS,
                    ACTION_REQUEST_PERMISSIONS);
            mhandler.sendEmptyMessageDelayed(0, 1000);
        }*/
    }

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTime--;
            if (mTime < 0) {
                startActivity(new Intent(SplashActivity.this, TalkActivity.class));
                finish();
            } else {
                //Log.e("北交信通5", mTime5 + "    0");
                mhandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };

    protected boolean checkPermissions(String[] neededPermissions) {
        if (neededPermissions == null || neededPermissions.length == 0) {
            return true;
        }
        boolean allGranted = true;
        for (String neededPermission : neededPermissions) {
            allGranted &= ContextCompat.checkSelfPermission(this, neededPermission) == PackageManager.PERMISSION_GRANTED;
        }
        return allGranted;
    }

    private final String[] NEEDED_PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,//相机
            Manifest.permission.RECORD_AUDIO,//录音
            Manifest.permission.ACCESS_COARSE_LOCATION,//定位
            Manifest.permission.WRITE_SETTINGS,//写入设置
            Manifest.permission.WRITE_EXTERNAL_STORAGE,//写入外部存储
            Manifest.permission.READ_EXTERNAL_STORAGE,//读取外部存储
            Manifest.permission.READ_PHONE_STATE//阅读电话状态
    };

    private void loadImage(ImageView splash_img) {
        String url = "file:///android_asset/bb.gif";
        Glide.with(this)
                .asGif()
                .load(url)
                .into(splash_img);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhandler.removeMessages(0);
    }

    //点击按钮，访问如下方法
    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int i = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[0]);
            int l = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[1]);
            int m = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[2]);
            int a = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[3]);
            int b = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[4]);
            int c = ContextCompat.checkSelfPermission(this, NEEDED_PERMISSIONS[5]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED ||
                    l != PackageManager.PERMISSION_GRANTED ||
                    m != PackageManager.PERMISSION_GRANTED ||
                    a != PackageManager.PERMISSION_GRANTED ||
                    b != PackageManager.PERMISSION_GRANTED ||
                    c != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                startRequestPermission();
            }
        }
    }

    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS, 321);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 321) {
            if (grantResults.length > 0) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    //如果没有获取权限，那么可以提示用户去设置界面--->应用权限开启权限
                    finish();
                } else {
                    //获得SD卡根目录路径   "/sdcard"
                    File sdDir = Environment.getExternalStorageDirectory();
                    //根目录下某个txt文件名
                    File path = new File(sdDir + File.separator
                            + "user.txt");
                    if (Environment.getExternalStorageState()
                            .equals(Environment.MEDIA_MOUNTED)) {
                        fileContent = getFileContent(path);
                        Log.e("读取文件", path.getAbsolutePath());
                        Log.e("读取文件", getFileContent(path));
                    }

                    TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
                    String imei = tm.getDeviceId();
                    //personnelType = new SpUtil(getApplication(), "PersonnelType");
                    //863930053981282  0A  10010
                    //863930053991117  0B  10011
                    //863930054320316  0C  10012
                    String[] split = fileContent.split("-");
                    if (fileContent != null && split.length == 2) {
                        personnelType.setName("机控器");
                        personnelType.setStandard("B制式");
                        personnelType.setHao(split[0].trim());
                        personnelType.setPeopleId(split[1].trim());
                        personnelType.setIMEI(imei);
                        personnelType.setBenJi(ipAddress);
                        //获取权限成功,跳转
                        mhandler.sendEmptyMessageDelayed(0, 1000);
                    }
                }
            }
        }
    }

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

    //读取指定目录下的所有TXT文件的文件内容
    protected String getFileContent(File file) {
        String content = "";
        if (file.isDirectory()) {    //检查此路径名的文件是否是一个目录(文件夹)
            Log.i("zeng", "The File doesn\'t not exist "
                    + file.getName().toString() + file.getPath().toString());
        } else {
            if (file.getName().endsWith(".txt")) {//文件格式为txt文件
                try {
                    InputStream instream = new FileInputStream(file);
                    if (instream != null) {
                        InputStreamReader inputreader
                                = new InputStreamReader(instream, "UTF-8");
                        BufferedReader buffreader = new BufferedReader(inputreader);
                        String line = "";
                        //分行读取
                        while ((line = buffreader.readLine()) != null) {
                            content += line + "\n";
                        }
                        instream.close();        //关闭输入流
                    }
                } catch (java.io.FileNotFoundException e) {
                    Log.d("TestFile", "The File doesn\'t not exist.");
                } catch (IOException e) {
                    Log.d("TestFile", e.getMessage());
                }
            }
        }
        return content;
    }
}