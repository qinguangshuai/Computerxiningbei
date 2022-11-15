package com.example.socket.udp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.socket.Unit.HexUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpHelperServer {
    private Handler handler = null;
    private DatagramSocket ds = null;

    Thread receiveFileThread;
    private boolean keepRunning = true;
    private static DatagramPacket inpacket, outpacket;
    private byte[] inBuff = new byte[1024];//因为我这里等会接收的数据是1024个字节的数组

    public UdpHelperServer() {
        if (ds == null) {
            try {
                ds = new DatagramSocket(9999);
            } catch (Exception e) {
            }
        } else {
            Log.e("udp", "UdpHelperServer: not null");
        }
    }


    //运行接收端，切记一次
    public void GetRun() {
        receiveFileThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (keepRunning) {
                    getStrMessage();
                }
            }
        });

        receiveFileThread.start();
    }

    //消息队列
    public void GetHandler(Handler handler) {
        this.handler = handler;
    }


    //获取byte流的，单片机用
    public void getMessage() {
        try {
            //1.udpsocket服务对象，使用DatagramSocket创建,可以指明本地IP和端口
            //当然也可以不指明，已测试成功
            //现在仅仅指明手机端口为9999
            //DatagramSocket ds = new DatagramSocket(9999);

            /*接收数据*/
            byte[] recvBuf = new byte[6144];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
            ds.receive(recvPacket);

            String recvStr = HexUtil.bytesToHexString(recvPacket.getData());
            //Log.e("swy",recvStr);
            if (recvStr.contains("5D7D")) {
                Log.e("swy", "UDP talk receive :" + recvStr.substring(0, recvStr.indexOf("5D7D")) + ". Receive Ip: " + recvPacket.getAddress().getHostAddress());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SendMessage(2, recvStr.substring(0, recvStr.indexOf("5D7D")));
                    }
                }).start();
            } else {
                Log.e("swy", "UDP data receive :" + recvStr + ". Receive Ip: " + recvPacket.getAddress().getHostAddress());
            }

//                    show.setText("收到: \t" + recvStr);

            //4.关闭连接
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取bytes流的包，4g用
    public void getStrMessage() {
        try {
            //1.udpsocket服务对象，使用DatagramSocket创建,可以指明本地IP和端口
            //当然也可以不指明，已测试成功
            //现在仅仅指明手机端口为9999
            //DatagramSocket ds = new DatagramSocket(9999);

            /*接收数据*/
            byte[] recvBuf = new byte[6144];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

            ds.receive(recvPacket);
            // 解析数据
            String data = new String(recvPacket.getData(), 0, recvPacket.getLength());
            //Log.e("swy", data + " . Received Ip : " + recvPacket.getSocketAddress());
            if (data.isEmpty()) {

            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SendMessage(2, data);
                    }
                }).start();
            }


//                    show.setText("收到: \t" + recvStr);

            //4.关闭连接
            //ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程停止标志
     *
     * @param keepRunning
     */
    public void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }

    public boolean getKeepRunning() {
        return this.keepRunning;
    }

    void SendMessage(int what, Object obj) {
        if (handler != null) {
            Message.obtain(handler, what, obj).sendToTarget();
        }
    }

    //udp发送数据的时候socket可以不指定端口号和ip，可以在它的集装箱outpacket指定端口号和ip地址
    public void sendStrMessage(final String output_data, final String ip, final int port) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //发送的数据报端口号，ip都指定好了
                try {
                    outpacket = new DatagramPacket(output_data.getBytes(), output_data.getBytes().length, InetAddress.getByName(ip), port);
                    ds.send(outpacket);
                    Log.e("udp", "send: " + output_data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
