package com.example.socket.IO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class GPIO {

    private static String exportPath;
    private static String directionPath;
    private static String valuePath;
    static Process process = null;
    static DataOutputStream dos = null;

    //控制
    String gpioValue = "";
    FileReader fileReader;
    BufferedReader reader;
   //private IOReadThread ioReadThread;
    String pe5in ="";

    public static int gpio_crtl_out(int gpio_number, int level) {
        exportPath = "echo " + gpio_number + " > /sys/class/gpio/export";
        directionPath = "echo out > " + " /sys/class/gpio/gpio" + gpio_number + "/direction";
        valuePath = "echo " + level + " > /sys/class/gpio/gpio" + gpio_number + "/value";
        System.out.printf(exportPath + "\n" + directionPath + "\n" + valuePath + "\n");
        try {
            process = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(process.getOutputStream());
            dos.writeBytes(exportPath + "\n");
            dos.flush();
            dos.writeBytes(directionPath + "\n");
            dos.flush();
            dos.writeBytes(valuePath + "\n");
            dos.flush();
            dos.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return 0;
    }

    public static int gpio_crtl_in(int gpio_number, int level) {
        exportPath = "echo " + gpio_number + " > /sys/class/gpio/export";
        directionPath = "echo in > " + " /sys/class/gpio/gpio" + gpio_number + "/direction";
        valuePath = "echo " + level + " > /sys/class/gpio/gpio" + gpio_number + "/value";
        System.out.printf(exportPath + "\n" + directionPath + "\n" + valuePath + "\n");
        try {
            process = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(process.getOutputStream());
            dos.writeBytes(exportPath + "\n");
            dos.flush();
            dos.writeBytes(directionPath + "\n");
            dos.flush();
            dos.writeBytes(valuePath + "\n");
            dos.flush();
            dos.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return 0;
    }

    public static int gpio_crtl_export(int gpio_number) {
        exportPath = "echo " + gpio_number + " > /sys/class/gpio/export";
        System.out.printf(exportPath + "\n");
        try {
            process = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(process.getOutputStream());
            dos.writeBytes(exportPath + "\n");
            dos.flush();
            dos.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return 0;
    }


    protected void Destroy() {
        try {
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* //pe5
    private class IOReadThread extends Thread {
        @Override
        public void run() {
            super.run();
            String[] last ={"1","1"};
            while (!isInterrupted()) {
                try {
                    // 定义路径
                    String gpioPath = "/sys/class/gpio/gpio133/value";
                    // 创建接收缓冲区
                    char[] buffer = new char[2048];
                    fileReader = new FileReader(gpioPath);
                    reader = new BufferedReader(fileReader);
                    reader.read(buffer);
                    gpioValue = buffer[0] + "";
                    last[1] = gpioValue;
                    if(last[0].matches(last[1])){
                    }else if (!last[0].matches(last[1])){
                        pe5in = gpioValue;
                        last[0] = gpioValue;
                    }
                    //Log.e("swy", "GPIOt"+buffer[0]);
                    //gpioValue = buffer[0] + "";
                } catch (IOException e) {
                    Log.d("error", "cat GPIO error");
                    e.printStackTrace();
                }
            }
        }
    }*/
}