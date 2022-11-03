package com.example.socket.Tcp;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.socket.Activity.TalkActivity;
import com.example.socket.Unit.HexUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpHelperServer {

    private ServerSocket server;
    private Handler handler = null;

    public TcpHelperServer(Handler handler){
        this.handler = handler;
        int port = 9999;
        while(port > 9000){
            try {
                server = new ServerSocket(port);
                break;
            } catch (Exception e) {
                port--;
            }
        }
        SendMessage(1, port);
        Thread receiveFileThread = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    getMessage();
                    //getSpeex();
                }
            }
        });
        receiveFileThread.start();
    }

    public void getMessage() {
                    try {
                        Socket name = server.accept();
                        InputStream nameStream = name.getInputStream();
                        /*InputStreamReader streamReader = new InputStreamReader(nameStream);
                        BufferedReader br = new BufferedReader(streamReader);
                        String fileName = br.readLine();
                        Log.e("swy", "getMessage run 3: " + fileName);*/
                        byte[] buff = new byte[1024];
                        int n =-1;
                        //这个类就跟StringBuffer作用类似，可以动态的扩展字节数组的大小
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        n = nameStream.read(buff);
                        baos.write(buff, 0, n);
                        Log.e("swy", "getMessage run 3: "+ name.getInetAddress()+"-----"+server.getInetAddress() + HexUtil.bytesToHexString(baos.toByteArray()));
                        SendMessage(2,HexUtil.bytesToHexString(baos.toByteArray()));

                        /*br.close();
                        streamReader.close();
                        nameStream.close();
                        name.close();*/


            /*Socket data = server.accept();
            InputStream dataStream = data.getInputStream();
            String savePath = Environment.getExternalStorageDirectory().getPath() + "/" + fileName;
            FileOutputStream file = new FileOutputStream(savePath, false);
            byte[] buffer = new byte[1024];
            int size = -1;
            while ((size = dataStream.read(buffer)) != -1){
                file.write(buffer, 0 ,size);
            }
            file.close();
            dataStream.close();
            data.close();
            SendMessage(0, fileName + "接收完成");*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
    }

    public void sendMessage(final byte[] data, final String ip, final int port) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Socket name = new Socket(ip, port);
                    OutputStream outputName = name.getOutputStream();
                    outputName.write(data);
                    Log.e("swy", "SendFile: " + HexUtil.bytesToHexString(data));
                    //Log.e("swy", "SendFile: " + data);
                    outputName.close();

                    //name.close();
                    /*OutputStreamWriter outputWriter = new OutputStreamWriter(outputName);
                    BufferedWriter bwName = new BufferedWriter(outputWriter);
                    Log.e("swy", "SendFile: "+ s);
                    bwName.write(s);
                    bwName.close();
                    outputWriter.close();
                    outputName.close();
                    name.close();*/
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("swy", "Exception :" + e.getMessage());
                }

            }
        }.start();
    }

    public void getSpeex() {
        try {

            Socket name = server.accept();
            InputStream nameStream = name.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(nameStream);
            BufferedReader br = new BufferedReader(streamReader);
            String fileName = br.readLine();
            br.close();
            streamReader.close();
            nameStream.close();
            name.close();


            Socket data = server.accept();
            InputStream dataStream = data.getInputStream();
            String savePath = "/mnt/sdcard/" + fileName;
            FileOutputStream file = new FileOutputStream(savePath, false);
            byte[] buffer = new byte[1024];
            int size = -1;
            while ((size = dataStream.read(buffer)) != -1){
                file.write(buffer, 0 ,size);
            }
            file.close();
            dataStream.close();
            data.close();
            SendMessage(0, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void SendMessage(int what, Object obj){
        if (handler != null){
            Message.obtain(handler, what, obj).sendToTarget();
        }
    }
}
