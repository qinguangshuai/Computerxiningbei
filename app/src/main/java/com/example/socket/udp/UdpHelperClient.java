package com.example.socket.udp;

import android.os.AsyncTask;
import android.util.Log;

import com.example.socket.Unit.HexUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpHelperClient {
    public void sendMessage(final byte[] s,final String ip, final int port){
        //final DatagramSocket[] ds = new DatagramSocket[1];
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    // 创建发送端Socket对象
                    DatagramSocket ds = new DatagramSocket(9999);
                    // 创建数据，并把数据打包

                    DatagramPacket dp = new DatagramPacket(s, s.length, InetAddress.getByName(ip),
                            port);
                    Log.e("swy", "UdpHelperClient run: "+ HexUtil.bytesToHexString(s));
                    // 调用Socket对象发送方法发送数据包
                    ds.send(dp);
                    // 释放资源
                    ds.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    Log.e("swy","sb"+e.getMessage());
                }

            }
        }.start();
    }


    public void sendStrMessage(final String s,final String ip, final int port){
        //final DatagramSocket[] ds = new DatagramSocket[1];
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    // 创建发送端Socket对象
                    DatagramSocket ds = new DatagramSocket(9999);
                    // 创建数据，并把数据打包

                    DatagramPacket dp = new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName(ip),
                            port);
                    Log.e("swy", "UdpHelperClient run: "+ s);
                    // 调用Socket对象发送方法发送数据包
                    ds.send(dp);
                    // 释放资源
                    ds.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    Log.e("swy","sb"+e.getMessage());
                }

            }
        }.start();
    }

}
