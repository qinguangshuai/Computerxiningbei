package com.example.socket;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SocketManager {
    private ServerSocket server;
    private Handler handler = null;

    public SocketManager(Handler handler) {
        this.handler = handler;
        int port = 9999;
        while (port > 9000) {
            try {
                server = new ServerSocket(port);
                break;
            } catch (Exception e) {
                port--;
            }
        }
        SendMessage(1, port);
        Thread receiveFileThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ReceiveFile();
                }
            }
        });
        receiveFileThread.start();
    }

    void SendMessage(int what, Object obj) {
        if (handler != null) {
            Message.obtain(handler, what, obj).sendToTarget();
        }
    }

    void ReceiveFile() {
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
            //SendMessage(2, fileName);
            SendMessage(0, fileName + "接收中");

            Socket data = server.accept();
            InputStream dataStream = data.getInputStream();
            String savePath = Environment.getExternalStorageDirectory().getPath() + "/" + fileName;
            FileOutputStream file = new FileOutputStream(savePath, false);
            byte[] buffer = new byte[1024];
            int size = -1;
            while ((size = dataStream.read(buffer)) != -1) {
                file.write(buffer, 0, size);
            }
            file.close();
            dataStream.close();
            data.close();
            SendMessage(0, fileName + "接收完成");
        } catch (Exception e) {
            SendMessage(0, "接收错误:\n" + e.getMessage());
        }
    }

    public void SendFile(String fileName, String path, String ipAddress, int port) {
        try {
            Socket name = new Socket(ipAddress, port);
            OutputStream outputName = name.getOutputStream();
            OutputStreamWriter outputWriter = new OutputStreamWriter(outputName);
            BufferedWriter bwName = new BufferedWriter(outputWriter);
            Log.e("swy", "SendFile: " + "NAME1" + (getDate() + fileName.substring(fileName.length() - 4)).getBytes().length + getDate() + fileName.substring(fileName.length() - 4));
            bwName.write("NAME1" + (getDate() + fileName.substring(fileName.length() - 4)).getBytes().length + getDate() + fileName.substring(fileName.length() - 4));
            bwName.close();
            outputWriter.close();
            outputName.close();
            name.close();
            SendMessage(0, "正在发送" + fileName);

            Socket data = new Socket(ipAddress, port);
            OutputStream outputData = data.getOutputStream();
            //  /storage/emulated/0/Pictures/Screenshots/Screenshot_20210327-112351.png
            FileInputStream fileInput = new FileInputStream(path.replace("/root", ""));
            //Log.e("swy", "SendFile: 3"+path.get(i).replace("/root",""));
            int size = -1;
            //outputData.write(("NAME"+getDate()+fileName.get(i).substring(fileName.get(i).length()-4)).getBytes());
            Log.e("swy", "getDate: " + (getDate() + fileName.substring(fileName.length() - 4)));
            byte[] buffer = new byte[1024];
            while ((size = fileInput.read(buffer, 0, 1024)) != -1) {
                outputData.write(buffer, 0, size);
            }
            outputData.close();
            fileInput.close();
            data.close();

                /*Socket End = new Socket(ipAddress, port);
                OutputStream outputEnd = End.getOutputStream();
                OutputStreamWriter outputEndWriter = new OutputStreamWriter(outputEnd);
                BufferedWriter bwNEnd = new BufferedWriter(outputEndWriter);
                bwNEnd.write("END");
                bwNEnd.close();
                outputEndWriter.close();
                outputEnd.close();
                End.close();*/

            SendMessage(0, fileName + "  发送完成");
        } catch (Exception e) {
            SendMessage(0, "发送错误:\n" + e.getMessage());
        }
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日HH时mm分ss秒");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String numToHex8(String str) {
        int b = str.getBytes().length;
        return String.format("%02x", b).toUpperCase();// 2表示需要两个16进制数
    }
}
