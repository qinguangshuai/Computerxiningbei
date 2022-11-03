package com.example.socket.Unit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.socket.udp.UdpHelperClient;

import static com.example.socket.Activity.TalkActivity.udpHelperServer;
import static com.example.socket.Unit.HelperPacket.getLocalIpAddress;

public class HeartbeatService extends Service implements Runnable {
    private Thread mThread;
    @Override
    public void onCreate() {
        super.onCreate();
    }
 
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mThread == null) {//如果线程为空 则创建一条
            mThread = new Thread(this);
            mThread.start();
        }
    }
 
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, START_STICKY, startId);
    }
 
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
 
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
 
    @Override
    public void run() {
        // 开始执行后台任务


        while (true) {
            //在此添加执行代码
            udpHelperServer.sendStrMessage("",Content.Ip_Adress,Content.port);
            try {
                Thread.sleep( 5 * 1000);//线程睡眠5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
