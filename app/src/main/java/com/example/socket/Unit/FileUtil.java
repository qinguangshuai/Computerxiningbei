package com.example.socket.Unit;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    /**
     * 保存动作数据
     * data 保存的内容
     * time 时间作为txt文件名
     */
    public void saveAction(String data, String time, String folderName) {
        //新建文件夹
        //String folderName = "zhengzhoubei";
        File sdCardDir = new File("/storage/emulated/0/", folderName);
        if (!sdCardDir.exists()) {
            if (!sdCardDir.mkdirs()) {
                try {
                    sdCardDir.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Log.e("swy", "记录所有数据时间: " + time);
        String fileName = getDateTime() + ".txt";

        //新建文件
        File saveFile = new File(sdCardDir, fileName);
        Log.e("swy", "记录 1: " + time);
        try {
            if (!saveFile.exists()) {
                saveFile.createNewFile();
                Log.e("swy", "记录 2: " + time);
            }
            writeData(data, false, saveFile);
            Log.e("swy", "记录 3: " + time);
        } catch (Exception e) {
            //Log.e("swy", "saveAll: " + e.toString());
        }

    }

    public static String getDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        Log.e("MainActivity.class", "getDateTime: " + dateString);
        return dateString;
    }

    /**
     * @param content        写入内容
     * @param isClearContent 是否清楚原来内容 true 覆盖数据 false 累加内容
     */
    //每次都重新写入
    public void writeData(String content, Boolean isClearContent, File saveFile) {
        try {
            if (isClearContent) {
                final FileOutputStream outStream = new FileOutputStream(saveFile);
                try {
                    //内容写入文件
                    outStream.write(content.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("swy", "writeTxtToFile: --------------" + e.toString());
                } finally {
                    try {
                        outStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                //内容追加

                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile, true)));
                    out.write(content + "\r\n");
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        String dateString = formatter.format(currentTime);
        Log.e("MainActivity.class", "getDate: " + dateString);
        return dateString;
    }
}
