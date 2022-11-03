package com.example.socket.Tcp;

import android.util.Log;

import com.example.socket.Unit.HexUtil;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpHeplerClient {

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

    public void sendSpeex(final String data, final String path, final String ip, final int port) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Socket name = new Socket(ip, port);
                    OutputStream outputName = name.getOutputStream();
                    OutputStreamWriter outputWriter = new OutputStreamWriter(outputName);
                    BufferedWriter bwName = new BufferedWriter(outputWriter);

                    bwName.write(data);
                    bwName.close();
                    outputWriter.close();
                    outputName.close();
                    name.close();

                    Socket data = new Socket(ip, port);
                    OutputStream outputData = data.getOutputStream();
                    //  /storage/emulated/0/Pictures/Screenshots/Screenshot_20210327-112351.png
                    FileInputStream fileInput = new FileInputStream(path.replace("/root",""));
                    //Log.e("swy", "SendFile: 3"+path.get(i).replace("/root",""));
                    int size = -1;
                    //outputData.write(("NAME"+getDate()+fileName.get(i).substring(fileName.get(i).length()-4)).getBytes());
                    byte[] buffer = new byte[1024];
                    while((size = fileInput.read(buffer, 0, 1024)) != -1){
                        outputData.write(buffer, 0, size);
                    }
                    outputData.close();
                    fileInput.close();
                    data.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("swy", "Exception :" + e.getMessage());
                }

            }
        }.start();
    }
}
