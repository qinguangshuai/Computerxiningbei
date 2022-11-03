package com.example.socket.Unit;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class CombineCommend {
    /**
     * 用于建立十六进制字符的输出的小写字符数组
     */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 用于建立十六进制字符的输出的大写字符数组
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private String TAG = "swy";

    public byte[] main(String command, String trainID, String rearID) {
        String first = tranFirst(trainID, command);
        String second = tranSecond(rearID);
        String aaa = "D5173001021020" + first + "1020" + second;
        String result = "1002" + "D517300102101020" + first + "101020" + second + GetCRC_XMODEM_Str(aaa) + "1003";
        return HexStringToBytes(result);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void main2(String bytes) {
        String result = "";
        String aaa = bytes;
        String bbb = HexUtil.hexString2binaryString(aaa);
        Cet(bbb);
    }

    public void main700(String str) {
        String result = "";
        /*StringBuffer bbb = new StringBuffer();
        for(int i =0; i < str.length()-3;i++){
            if(str.substring(i,i+4).matches("1010")){
                bbb.append("10");
                i = i+3;
            }else {
                bbb.append(str.substring(i,i+4));
                i = i+3;
            }
        }*/
        try {
            str = str.replace("1010", "10");
            Log.d("aaa", str.toString());
            String trainId = str.substring(50, 54) + str.substring(36, 40);
            String rearId = str.substring(48, 50) + str.substring(54, 56) + str.substring(56, 58);
            String windpress = str.substring(44, 48);
            String commend = str.substring(42, 44);
            result = commend + "," + trainId + "," + rearId + "," + windpress;
            Log.d("bbb", result);
        } catch (Exception e) {
        }
        if (result.length() > 12) {
            combineList.add(result);
            Log.d("ccc", combineList.get(0));
        }
    }


    private String tranFirst(String trainID, String command) {
        String result = "1111111100011" + tranJiChe1(trainID.substring(0, 2)) + tranJiChe2(trainID.substring(2, 5)) + tranJiChe2(trainID.substring(5, 8))
                + tranConmend("OtherDevice") + tranConmend(command) + "00000000";
        result = binaryString2hexString(result);
        return result.toUpperCase();
    }

    private String tranSecond(String rearID) {
        Calendar calendar = Calendar.getInstance();
        String year = "" + calendar.get(Calendar.YEAR);
        String month = "" + (calendar.get(Calendar.MONTH) + 1);
        if (month.length() == 1) {
            month = "0" + month;
        }
        String day = "" + calendar.get(Calendar.DAY_OF_MONTH);
        if (day.length() == 1) {
            day = "0" + day;
        }
        String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        String min = "" + calendar.get(Calendar.MINUTE);
        if (min.length() == 1) {
            min = "0" + min;
        }
        String sec = "" + calendar.get(Calendar.SECOND);
        if (sec.length() == 1) {
            sec = "0" + sec;
        }
        String result = "11111111100" + tranLieWei(rearID.substring(0, 3)) + tranLieWei(rearID.substring(3, 6)) + tranYearMinSec(year.substring(2, 4))
                + tranMonth(month) + tranDayHour(day) + tranDayHour(hour) + tranYearMinSec(min)
                + tranYearMinSec(sec) + "0";
        result = binaryString2hexString(result);
        return result.toUpperCase();
    }

    private String tranLieWei(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 9; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;
    }

    private String tranYearMinSec(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 5; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;
    }

    private String tranMonth(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 3; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;
    }

    private String tranDayHour(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 4; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;
    }

    private String tranJiChe1(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 6; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;
    }

    private String tranJiChe2(String str) {
        String result = "";
        int decimal = Integer.parseInt(str);
        ;
        for (int i = 9; i >= 0; i--) {
            result += (decimal >>> i & 1);
        }
        return result;

    }

    /*
     * 55:列尾机车台，
     * */
    private String tranConmend(String str) {
        String result = "";
        switch (str) {
            case "OtherDevice":
                result = "01011111";
                break;
            case "AskForWindPress":
                result = "10010001";
                break;
            case "ConfirmRear":
                result = "10110101";
                break;
            case "RemoveRear":
                result = "10000011";
                break;
        }
        return result;
    }

    private String binaryString2hexString(String bString) {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4) {
            iTmp = 0;
            for (int j = 0; j < 4; j++) {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }

    private String GetCRC_XMODEM_Str(String str) {
        byte[] bytes = HexStringToBytes(str);//16进制字符串转成16进制字符串数组
        int i = CRC16_XMODEM(bytes);//进行CRC—XMODEM校验得到十进制校验数
        String CRC = Integer.toHexString(i);//10进制转16进制
        if (CRC.length() != 4) {
            CRC = "0" + CRC;
        }
        return CRC;
    }


    //TODO 具体的实现CRC_XMODEM的方法
    private int CRC16_XMODEM(byte[] buffer) {
        /* StringUtil.getByteArrayByString();*/

        int wCRCin = 0x0000; // initial value 65535
        int wCPoly = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)
        for (byte b : buffer) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((wCRCin >> 15 & 1) == 1);
                wCRCin <<= 1;
                if (c15 ^ bit)
                    wCRCin ^= wCPoly;
            }
        }
        wCRCin &= 0xffff;
        return wCRCin ^= 0x0000;
    }

    //TODO 此静态方法是实现将16进制的字符串转成byte数组
    public byte[] HexStringToBytes(String src) {
        int len = src.length() / 2;
        byte[] ret = new byte[len];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < len; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

    private byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    public static ArrayList<String> combineList = new ArrayList<String>();
    public static String oncereceive = "";
    private int indexNumber = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String Cet(String str) {
        //Log.e(TAG,"this data is null."+binaryString2hexString(str.substring(8,9)));
        String result = "";
        if (!str.matches("false")) {
            String index = "" + Integer.parseInt(str.substring(8, 9), 2);
            //result = "" + binaryString2hexString(str);
            switch (index) {
                case "0":
                    String cet = "" + Integer.parseInt(str.substring(9, 13), 2);
                    String trainid = "" + Integer.parseInt(str.substring(13, 20), 2) + Integer.parseInt(str.substring(20, 30), 2)
                            + Integer.parseInt(str.substring(30, 40), 2);
                    String high = "" + Integer.parseInt(str.substring(40, 48), 2);
                    String low = "" + Integer.parseInt(str.substring(48, 56), 2);
                    String windpress1 = "" + str.substring(56, 64);
                    result = cet + "," + trainid + "," + high + "," + low + "," + windpress1;
                    if (indexNumber == 0) {
                        oncereceive = result;
                        indexNumber++;
                    }
                    break;
                case "1":
                    String windpress2 = "" + str.substring(9, 11);
                    String rearid = "" + Integer.parseInt(str.substring(11, 21), 2) + Integer.parseInt(str.substring(21, 31), 2);
                    String year = "" + Integer.parseInt(str.substring(31, 37), 2);
                    String month = "" + Integer.parseInt(str.substring(37, 41), 2);
                    String day = "" + Integer.parseInt(str.substring(41, 46), 2);
                    String hour = "" + Integer.parseInt(str.substring(46, 51), 2);
                    String min = "" + Integer.parseInt(str.substring(51, 57), 2);
                    String sec = "" + Integer.parseInt(str.substring(57, 63), 2);
                    result = windpress2 + "," + rearid + "," + year + "," + month + "," + day + "," + hour + "," + min + "," + sec;
                    if (indexNumber == 1) {
                        oncereceive = oncereceive + "," + result;
                        if (oncereceive.length() > 40) {
                            combineList.add(oncereceive);
                        }
                        indexNumber = 0;
                    }
                    break;
            }
            Log.d("send message3", "susseccced  " + oncereceive);
        } else {
            result = "";
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String Lowcommend(String str) {
        String result = "";
        String[] input = str.split(",");
        String index = input[3];
        String windpress = "" + Integer.parseInt(input[4] + input[5], 2);

        switch (index) {
            case "145":
                result = "查询风压-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "146":
                result = "风压-" + "机车号-" + input[1] + "-列尾号-" + input[6] + "-风压值-" + windpress;
                break;
            case "48":
                result = "风压报警-" + "机车号-" + input[1] + "-列尾号-" + input[6] + "-风压值-" + windpress;
                break;
            case "181":
                result = "确认输号-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "182":
                result = "列尾确认完毕-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "131":
                result = "销号-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "122":
                result = "查询日期-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "91":
                result = "列尾等待确认-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "183":
                result = "列尾已连接-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "132":
                result = "销号完毕-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "133":
                result = "已销号-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            case "176":
                result = "电池报警-" + "机车号-" + input[1] + "-列尾号-" + input[6];
                break;
            default:
                result = "无指令返回-";
                break;
        }
        return result;
    }


    public String Lowcommend700(String str) {
        Log.d("ddd", "1");
        String result = "";
        String[] input = str.split(",");
        Log.d("ddd", "2");
        String index = input[0];
        Log.d("ddd", "3");
        String windpress = "" + Integer.parseInt(input[3]);
        Log.d("ddd", "4");
        Log.d("ddd", str);
        String time = System.currentTimeMillis() + "";
        switch (index) {
            case "92":
                result = "风压-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-风压值-" + windpress + "-" + time;
                break;
            case "48":
                result = "风压报警-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-风压值-" + windpress + "-" + time;
                break;
            case "B6":
                result = "列尾确认完毕-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "122":
                result = "查询日期-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "5B":
                result = "列尾等待确认-" + "列尾号-" + input[2] + "-" + time;
                break;
            case "183":
                result = "列尾已连接-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "84":
                result = "销号完毕-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "133":
                result = "已销号-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "176":
                result = "电池报警-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            case "30":
                result = "风压-" + "机车号-" + input[1] + "-列尾号-" + input[2] + "-" + time;
                break;
            default:
                result = "无指令返回-";
                break;
        }
        Log.d("eee", result);
        return result;
    }
    /*//判断按钮点击时间，500毫秒内在再次点击不会调用音量调节的方法
    private final long MIN_DELAY_TIME = 2000;
    private long LASTTIME,FIRSTTIME;
    boolean flag = true;
    public boolean isDelay() {
        flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - LASTTIME) >= MIN_DELAY_TIME) {
            flag = true;
        }
        LASTTIME = curClickTime;
        return flag;
    }*/

    public void Jiche(String str) {
        String result = "";
        try {
            str = str.replace("1010", "10");
            Log.d("jiche", str);
            String trainId = str.substring(36, 40);
            String windpress = str.substring(44, 48);
            String resource = str.substring(40, 42);
            String commend = str.substring(42, 44);
            result = commend + "," + trainId + "," + resource + "," + windpress;
            Log.d("bbb", result);
        } catch (Exception e) {
        }
        if (result.length() > 8) {
            combineList.add(result);
            Log.d("ccc", combineList.get(0));
        }
    }

    public String LowcommendJiche(String str) {
        Log.d("ddd", "1");
        String result = "";
        String[] input = str.split(",");
        Log.d("ddd", "2");
        String index = input[0];
        Log.d("ddd", "3");
        String windpress = "" + Integer.parseInt(input[3]);
        Log.d("ddd", "4");
        Log.d("ddd", str);
        String time = System.currentTimeMillis() + "";
        if (input[2].matches("55")) {
            switch (index) {
                case "92":
                    result = "风压-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-风压值-" + windpress + "-" + time;
                    break;
                case "48":
                    result = "风压报警-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-风压值-" + windpress + "-" + time;
                    break;
                case "B6":
                    result = "列尾确认完毕-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "122":
                    result = "查询日期-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "5B":
                    result = "列尾等待确认-" + "主机指令-" + input[2] + "-" + time;
                    break;
                case "183":
                    result = "列尾已连接-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "84":
                    result = "销号完毕-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "133":
                    result = "已销号-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "B0":
                    result = "电池报警-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                case "30":
                    result = "风压-" + "机车号-" + input[1] + "-主机指令-" + input[2] + "-" + time;
                    break;
                default:
                    result = "无指令返回-";
                    break;
            }
        }
        Log.d("eee", result);
        return result;
    }

    private String hexString = "0123456789ABCDEF";

    /**
     * 将16进制数字解码成字符串,适用于所有字符（包括中文）
     */
    public String decode16togbk(String bytes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
        //将每2位16进制整数组装成一个字节
        for (int i = 0; i < bytes.length(); i += 2)
            baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
        String bb = "";
        try {
            bb = new String(baos.toByteArray(), "GB2312");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bb;
    }

    //检测crc
    public boolean CRC_Test(String str) {
        if (GetCRC_XMODEM_Str(str.substring(0, str.length() - 4)).toUpperCase().matches(str.substring(str.length() - 4))) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList Decode_diaodan(String str) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder strB = new StringBuilder();
        String test = str.replace(" ", "");
        strB.append(test.substring(4, test.length() - 4));
        Log.d("diaodan", strB.toString());
        String command = "", diaodan_time = "", total_gou = "", type_jiche = "", diaohao = "", danhao = "", jihuashijian_start = "", jihuashijian_end = "", bianzhiren = "", diaochezhang = "", content = "", checi = "", zhuyi_content = "";
        int diaodan_length = 0, total_length = 0, content_length = 0, checi_length = 0, zhuyi_length = 0;

        diaodan_length = Integer.parseInt(strB.substring(0, 4), 16) * 2;
        strB.delete(0, 4);
        command = Integer.parseInt(strB.substring(0, 2), 16) + "";
        strB.delete(0, 6);
        list.add(command);               //0
        diaodan_time = strB.substring(0, 12);
        strB.delete(0, 12);
        list.add(diaodan_time);                                  //1
        total_gou = Integer.parseInt(strB.substring(0, 2), 16) + "";
        strB.delete(0, 2);
        list.add(total_gou);           //2
        type_jiche = decode16togbk(strB.substring(0, 12));
        strB.delete(0, 12);
        list.add(type_jiche);                      //3
        diaohao = Integer.parseInt(strB.substring(0, 2), 16) + "";
        strB.delete(0, 2);
        list.add(diaohao);              //4
        danhao = Integer.parseInt(strB.substring(2, 4), 16) + "";
        strB.delete(0, 4);
        list.add(danhao);                //5
        jihuashijian_start = strB.substring(0, 4);
        strB.delete(0, 4);
        list.add(jihuashijian_start);                       //6
        jihuashijian_end = strB.substring(0, 4);
        strB.delete(0, 4);
        list.add(jihuashijian_end);                           //7
        bianzhiren = decode16togbk(strB.substring(0, 16));
        strB.delete(0, 16);
        list.add(bianzhiren);                      //8
        diaochezhang = decode16togbk(strB.substring(0, 16));
        strB.delete(0, 16);
        list.add(diaochezhang);                  //9
        total_length = Integer.parseInt(strB.substring(0, 4), 16) * 2;
        strB.delete(0, 4);
        content_length = Integer.parseInt(strB.substring(0, 2), 16) * 2;
        strB.delete(0, 2);
        content = decode16togbk(strB.substring(0, content_length - 2));
        strB.delete(0, content_length - 2);
        list.add(content);        //10
        checi_length = Integer.parseInt(strB.substring(0, 2), 16) * 2;
        strB.delete(0, 2);
        checi = decode16togbk(strB.substring(0, checi_length - 2));
        strB.delete(0, checi_length);
        list.add(checi);        //11
        zhuyi_length = Integer.parseInt(strB.substring(0, 4), 16) * 2;
        strB.delete(0, 4);
        if (zhuyi_length != 4) {
            zhuyi_content = decode16togbk(strB.substring(0, zhuyi_length - 4));
            strB.delete(0, zhuyi_length - 4);
            list.add(zhuyi_content);        //12
        } else {
            list.add("");        //12
        }
        Log.d("diaodan2", strB.toString());

        while (strB.length() > 1) {
            int gou_length = 0, gudao_length = 0;
            String gudao = "", guazhai = "", jishi = "";
            int chaZhi = Integer.parseInt(HexUtil.hexString2binaryString2("40"), 2);
            int totalNum = Integer.parseInt(HexUtil.hexString2binaryString2(strB.substring(0, 2)), 2);
            gou_length = (totalNum - chaZhi) * 2;
            strB.delete(0, 2);
            gudao_length = Integer.parseInt(strB.substring(0, 2), 16) * 2;
            strB.delete(0, 2);
            Log.d("gudao_length", gudao_length + "");
            gudao = decode16togbk(strB.substring(0, gudao_length - 2));
            strB.delete(0, gudao_length - 2);
            list.add(gudao);        //13
            Log.d("gudao", gudao + "");
            if (Integer.parseInt(HexUtil.hexString2binaryString2(strB.substring(0, 2)).substring(0, 1), 2) == 1) {
                guazhai = "+" + Integer.parseInt(HexUtil.hexString2binaryString2(strB.substring(0, 2)).substring(1, 8), 2);
            } else {
                guazhai = "-" + Integer.parseInt(HexUtil.hexString2binaryString2(strB.substring(0, 2)).substring(1, 8), 2);
            }
            strB.delete(0, 2);
            list.add(guazhai);                                                                          //14
            Log.d("guazhai", guazhai + "");
            if (gou_length - gudao_length != 4) {
                Log.d("jishi", strB.substring(0, gou_length - gudao_length - 4));
                jishi = decode16togbk(strB.substring(0, gou_length - gudao_length - 4));
                strB.delete(0, gou_length - gudao_length - 4);
                list.add(jishi);  //15
            } else {
                list.add("");  //15
            }
            Log.d("jishi", jishi + "");
        }
        return list;
    }


}
