package com.example.socket.Unit;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

/**
 * @author Alan
 * @Company nlscan
 * @date 2018/6/20 20:40
 * @Description:
 */
public class HexUtil {
    private static final String TAG="HexUtil";
    /**
     * 用于建立十六进制字符的输出的小写字符数组
     */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 用于建立十六进制字符的输出的大写字符数组
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};



    public static int convert16to10(String s){
        return Integer.parseInt(s,16)-128;
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data byte[]
     * @return 十六进制char[]
     */
    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data        byte[]
     * @param toLowerCase <code>true</code> 传换成小写格式 ， <code>false</code> 传换成大写格式
     * @return 十六进制char[]
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data     byte[]
     * @param toDigits 用于控制输出的char[]
     * @return 十六进制char[]
     */
    protected static char[] encodeHex(byte[] data, char[] toDigits,int size) {
        int l = size;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
//            out[j++] = ' ';
        }
        return out;
    }


    protected static char[] encodeHex2(byte[] data, char[] toDigits,int size) {
        int l = size;
        char[] out = new char[(l << 1)/2*3];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
            out[j++] = ' ';
        }
        return out;
    }

    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    public static int toInt2(byte[] bytes,int size){
        return Integer.parseInt(new BigInteger((HexUtil.encodeHexStr(bytes,size).replace(
                " ",""
        )),16).toString(10));
    }
    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data byte[]
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data,int size) {
        return encodeHexStr(data, false,size);
    }

    public static String encodeHexStr2(byte[] data,int size) {
        return encodeHexStr2(data, false,size);
    }


    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data        byte[]
     * @param toLowerCase <code>true</code> 传换成小写格式 ， <code>false</code> 传换成大写格式
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data, boolean toLowerCase,int size) {
        return encodeHexStr(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER,size);
    }


    public static String encodeHexStr2(byte[] data, boolean toLowerCase,int size) {
        return encodeHexStr2(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER,size);
    }
    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data     byte[]
     * @param toDigits 用于控制输出的char[]
     * @return 十六进制String
     */
    protected static String encodeHexStr(byte[] data, char[] toDigits,int size) {
        if (data == null) {
            Log.e(TAG,"this data is null.");
            return "";
        }
        return new String(encodeHex(data, toDigits,size));
    }

    /**
     * 带空格的字节数组转16进制字符串
     * @param data
     * @param toDigits
     * @param size
     * @return
     */
    protected static String encodeHexStr2(byte[] data, char[] toDigits,int size) {
        if (data == null) {
            Log.e(TAG,"this data is null.");
            return "";
        }
        return new String(encodeHex2(data, toDigits,size));
    }

    /**
     * 将十六进制字符串转换为字节数组
     *
     * @param data
     * @return
     */
    public static byte[] decodeHex(String data) {
        if (data == null) {
            Log.e(TAG,"this data is null.");
            return new byte[0];
        }
        return decodeHex(data.toCharArray());
    }

    /**
     * 将十六进制字符数组转换为字节数组
     *
     * @param data 十六进制char[]
     * @return byte[]
     * @throws RuntimeException 如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常
     */
    public static byte[] decodeHex(char[] data) {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * 将十六进制字符转换成一个整数
     *
     * @param ch    十六进制char
     * @param index 十六进制字符在字符数组中的位置
     * @return 一个整数
     * @throws RuntimeException 当ch不是一个合法的十六进制字符时，抛出运行时异常
     */
    protected static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    /**
     * 截取字节数组
     *
     * @param src   byte []  数组源  这里填16进制的 数组
     * @param begin 起始位置 源数组的起始位置。0位置有效
     * @param count 截取长度
     * @return
     */
    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);  // bs 目的数组  0 截取后存放的数值起始位置。0位置有效
        return bs;
    }

    /**
     * int转byte数组
     *
     * @param bb
     * @param x
     * @param index 第几位开始
     * @param flag 标识高低位顺序，高位在前为true，低位在前为false
     */
    public static void intToByte(byte[] bb, int x, int index, boolean flag) {
        if (flag) {
            bb[index + 0] = (byte) (x >> 24);
            bb[index + 1] = (byte) (x >> 16);
            bb[index + 2] = (byte) (x >> 8);
            bb[index + 3] = (byte) (x >> 0);
        } else {
            bb[index + 3] = (byte) (x >> 24);
            bb[index + 2] = (byte) (x >> 16);
            bb[index + 1] = (byte) (x >> 8);
            bb[index + 0] = (byte) (x >> 0);
        }
    }

    /**
     * byte数组转int
     *
     * @param bb
     * @param index 第几位开始
     * @param flag 标识高低位顺序，高位在前为true，低位在前为false
     * @return
     */
    public static int byteToInt(byte[] bb, int index, boolean flag) {
        if (flag) {
            return (int) ((((bb[index + 0] & 0xff) << 24)
                    | ((bb[index + 1] & 0xff) << 16)
                    | ((bb[index + 2] & 0xff) << 8)
                    | ((bb[index + 3] & 0xff) << 0)));
        } else {
            return (int) ((((bb[index + 3] & 0xff) << 24)
                    | ((bb[index + 2] & 0xff) << 16)
                    | ((bb[index + 1] & 0xff) << 8)
                    | ((bb[index + 0] & 0xff) << 0)));
        }
    }


    /**
     * 字节数组逆序
     *
     * @param data
     * @return
     */
    public static byte[] reverse(byte[] data) {
        byte[] reverseData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            reverseData[i] = data[data.length - 1 - i];
        }
        return reverseData;
    }

    /**
     * 蓝牙传输 16进制 高低位 读数的 转换
     *
     * @param data 截取数据源，字节数组
     * @param index 截取数据开始位置
     * @param count 截取数据长度，只能为2、4、8个字节
     * @param flag 标识高低位顺序，高位在前为true，低位在前为false
     * @return
     */
    public static long byteToLong(byte[] data, int index, int count, boolean flag) {
        long lg = 0;
        if (flag) {
            switch (count) {
                case 2:
                    lg = ((((long) data[index + 0] & 0xff) << 8)
                            | (((long) data[index + 1] & 0xff) << 0));
                    break;

                case 4:
                    lg = ((((long) data[index + 0] & 0xff) << 24)
                            | (((long) data[index + 1] & 0xff) << 16)
                            | (((long) data[index + 2] & 0xff) << 8)
                            | (((long) data[index + 3] & 0xff) << 0));
                    break;

                case 8:
                    lg = ((((long) data[index + 0] & 0xff) << 56)
                            | (((long) data[index + 1] & 0xff) << 48)
                            | (((long) data[index + 2] & 0xff) << 40)
                            | (((long) data[index + 3] & 0xff) << 32)
                            | (((long) data[index + 4] & 0xff) << 24)
                            | (((long) data[index + 5] & 0xff) << 16)
                            | (((long) data[index + 6] & 0xff) << 8)
                            | (((long) data[index + 7] & 0xff) << 0));
                    break;
            }
            return lg;
        } else {
            switch (count) {
                case 2:
                    lg = ((((long) data[index + 1] & 0xff) << 8)
                            | (((long) data[index + 0] & 0xff) << 0));
                    break;
                case 4:
                    lg = ((((long) data[index + 3] & 0xff) << 24)
                            | (((long) data[index + 2] & 0xff) << 16)
                            | (((long) data[index + 1] & 0xff) << 8)
                            | (((long) data[index + 0] & 0xff) << 0));
                    break;
                case 8:
                    lg = ((((long) data[index + 7] & 0xff) << 56)
                            | (((long) data[index + 6] & 0xff) << 48)
                            | (((long) data[index + 5] & 0xff) << 40)
                            | (((long) data[index + 4] & 0xff) << 32)
                            | (((long) data[index + 3] & 0xff) << 24)
                            | (((long) data[index + 2] & 0xff) << 16)
                            | (((long) data[index + 1] & 0xff) << 8)
                            | (((long) data[index + 0] & 0xff) << 0));
                    break;
            }
            return lg;
        }
    }


    /**

     * 将int类型的数据转换为byte数组

     * 原理：将int数据中的四个byte取出，分别存储

     * @param n int数据

     * @return 生成的byte数组

     */

    public static byte[] intToBytes(int n){
        String s = String.valueOf(n);
        return s.getBytes();
    }

    public static byte[] splicingArrays(byte[]... bytes) {
        int length = 0;
        for (byte[] b : bytes) {
            length += b.length;
        }
        int interimLength = 0;
        byte[] result = new byte[length];
        for (byte[] b : bytes) {
            System.arraycopy(b, 0, result, interimLength, b.length);
            interimLength += b.length;
        }
        return result;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;

        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2){
                sb.append(0);
            }
            sb.append(sTmp.toUpperCase());
        }
        return sb.toString();
    }

    // 短整型转化为字符类型
    public static byte[] toByteArray(short[] src) {

        int count = src.length;
        byte[] dest = new byte[count << 1];
        for (int i = 0; i < count; i++) {
            dest[i * 2] = (byte) (src[i] >> 8);
            dest[i * 2 + 1] = (byte) (src[i] >> 0);
        }

        return dest;
    }

    private static String hexString="0123456789ABCDEF";
    /**
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public static String decode16togbk(String bytes)
    {
        ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);
        //将每2位16进制整数组装成一个字节
        for(int i=0;i<bytes.length();i+=2)
            baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1))));
        String bb = "";
        try {
            bb = new String(baos.toByteArray(), "GB2312");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bb;
    }

    public static String encodegbkto16(String str) {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    public static String hexString2binaryString(String hexString) {
        String bString = "", tmp;
        int index = hexString.length();
        switch (index) {
            case 44:
                hexString = hexString.substring(20, 36);
                if (hexString == null || hexString.length() % 2 != 0)
                    return null;

                for (int i = 0; i < hexString.length(); i++) {
                    tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
                    bString += tmp.substring(tmp.length() - 4);
                }
                break;
            case 46:
                hexString = hexString.substring(20, 36);
                if (hexString == null || hexString.length() % 2 != 0)
                    return null;

                for (int i = 0; i < hexString.length(); i++) {
                    tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
                    bString += tmp.substring(tmp.length() - 4);
                }
                break;
            default:
                bString = "false";
                break;
        }
        return bString;
    }

    public static String hexString2binaryString2(String hexString) {
        String bString = "", tmp;
        int index = hexString.length();
        if (hexString == null || hexString.length() % 2 != 0){
            return null;
        }
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
}
