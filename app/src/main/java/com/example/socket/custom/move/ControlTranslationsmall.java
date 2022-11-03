package com.example.socket.custom.move;

import android.util.Log;
import android.view.View;

import com.example.socket.Unit.SpUtil;

/**
 * @date 2021/6/21 8:48
 */
public class ControlTranslationsmall {
    public static void proplrMove1(SpUtil s1, View v, String ratioOfGpsTrack, double mGpsPistanceCar, int transverse, int disparity,float beishu) {
        switch (ratioOfGpsTrack) {
            case "1":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (162/beishu - transverse + mGpsPistanceCar / 1.7 * 17.71f));
                    v.setY((float) (440/beishu + disparity + mGpsPistanceCar / 1.7 * 17.14f));
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (286/beishu - transverse + (mGpsPistanceCar - 7) / 1.7 * 3.81f));
                    v.setY(560/beishu + disparity);
                    Log.e("1111",(float) (286/beishu - transverse + (mGpsPistanceCar - 7) / 1.7 * 3.86f) +"   " );
                } else {//you
                    v.setX((float) (626/beishu - transverse + (mGpsPistanceCar - 96) / 1.7 * 18f));
                    v.setY((float) (560/beishu + disparity - (mGpsPistanceCar - 96)  / 1.7 * 14.5f));
                    Log.e("111",(float) (626/beishu - transverse + (mGpsPistanceCar - 96) / 1.7 * 18f) +"   " );
                }
                v.invalidate();
                break;
            case "2":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (80/beishu - transverse + mGpsPistanceCar * 35.7 / 1.7f));
                    v.setY((float) (400/beishu + disparity + mGpsPistanceCar * 17.14 / 1.7f));
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 92) {   //zhi
                    v.setX((float) (330/beishu - transverse + (mGpsPistanceCar - 7) * 3.52 / 1.7f));
                    v.setY(520/beishu + disparity);
                } else {//you
                    v.setX((float) (626/beishu - transverse + (mGpsPistanceCar - 92) * 42.25 / 1.7f));
                    v.setY((float) (520/beishu + disparity - (mGpsPistanceCar - 92) * 10.63 / 1.7f));
                    Log.e("1111111",(float) (626/beishu - transverse + (mGpsPistanceCar - 92) * 42.25 / 1.7f) +"  ");
                }
                v.invalidate();
                break;
            case "3":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 93) {//zuo
                    v.setX((float) (246/beishu - transverse+ mGpsPistanceCar * 3.87 / 1.7f));
                    v.setY((float) (480/beishu + disparity ));
                } else {//you
                    v.setX((float) (606/beishu - transverse + (mGpsPistanceCar - 93) * 52 / 1.7f));
                    v.setY((float) (480/beishu + disparity - (mGpsPistanceCar - 93) * 12.86 / 1.7f));
                }
                v.invalidate();
                break;
            case "4":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 35.14 / 1.7f - transverse));
                    v.setY((float) (320/beishu + disparity + mGpsPistanceCar * 17.14 / 1.7f));
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (246/beishu - transverse + (mGpsPistanceCar - 7) * 4.09 / 1.7f));
                    v.setY(440/beishu + disparity);
                }else {//you
                    v.setX((float) (606/beishu - transverse + (mGpsPistanceCar - 96) * 74.75 / 1.7f));
                    v.setY((float) (440/beishu + disparity - (mGpsPistanceCar - 96) * 16.25 / 1.7f));
                    Log.e ("4",(float) (606/beishu - transverse + (mGpsPistanceCar - 98) * 149.5/ 1.7f) +"   "+(float) (440/beishu + disparity + (mGpsPistanceCar - 98) * 32.5/ 1.7f)  +  "  ");
                }
                v.invalidate();
                break;
            case "5":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 92) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.35 / 1.7f - transverse));
                    v.setY((float) (400/beishu + disparity));
                } else {//you
                    v.setX((float) (676/beishu - transverse + (mGpsPistanceCar - 92) * 43.5 / 1.7f));
                    v.setY((float) (400/beishu + disparity + (mGpsPistanceCar - 92) * 11.875 / 1.7f));
                }
                v.invalidate();
                break;
            case "6":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 91) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 7.54 / 1.7f- transverse));
                    v.setY((float) (360/beishu + disparity));
//                    Log.e ("6",(float) (0 + mGpsPistanceCar * 4.44f- transverse) +"   "+(float) (360 - disparity)  +  "  ");
                } else {//you
                    v.setX((float) (686/beishu - transverse + (mGpsPistanceCar - 91) * 37.56 / 1.7f));
                    v.setY((float) (360/beishu + disparity + (mGpsPistanceCar - 91) * 10 / 1.7));
//                    Log.e ("6you",(float) (686 - transverse + (mGpsPistanceCar - 9) * 20.10f) +"   "+(360 - disparity + (mGpsPistanceCar - 9) * 5.88f)  +  "  ");
                }
                v.invalidate();
                break;
            case "7":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 91) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.69 / 1.7f - transverse));
                    v.setY((float) (320/beishu + disparity));
                } else {//you
                    v.setX((float) (700/beishu - transverse + (mGpsPistanceCar - 91) * 36 / 1.7f));
                    v.setY((float) (320/beishu + disparity + (mGpsPistanceCar - 91) * 9.44 / 1.7f));
                    Log.e ("7",(float) (700/beishu - transverse + (mGpsPistanceCar - 91) * 36f) +"   "+(float) (320/beishu + disparity + (mGpsPistanceCar - 91) * 9.44f)  +  "  ");
                }
                v.invalidate();
                break;
            case "8":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 84) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 8.05/ 1.7f - transverse ));
                    v.setY((float) (280/beishu + disparity ));
                } else {//you
                    v.setX((float) (676/beishu - transverse + (mGpsPistanceCar - 84) * 21.75 / 1.7f));
                    v.setY((float) (280/beishu + disparity + (mGpsPistanceCar - 84) * 5 / 1.7f));
                }
                v.invalidate();
                break;
            case "9":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 88) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 7.80 / 1.7f - transverse));
                    v.setY((float) (240/beishu + disparity));
                    Log.e ("9",(float) (0 + mGpsPistanceCar * 4.59f - transverse) +"   "+(float) (240 - disparity)+ "    ");

                } else {//you
                    v.setX((float) (686/beishu - transverse + (mGpsPistanceCar - 88) * 28.17 / 1.7f));
                    v.setY((float) (240/beishu + disparity + (mGpsPistanceCar - 88) * 6.25 / 1.7f));
                    Log.e ("9you",(float) (686/beishu - transverse + (mGpsPistanceCar - 88) * 16.57f) +"   "+(240/beishu + disparity + (mGpsPistanceCar - 88) * 3.68f)+ "    ");
                }
                v.invalidate();
                break;
            case "10":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 94) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.3 / 1.7f - transverse));
                    v.setY((float) (200/beishu + disparity));
                } else {//you
                    v.setX((float) (686/beishu - transverse + (mGpsPistanceCar - 94) * 56.33 / 1.7f));
                    v.setY((float) (200/beishu + disparity + (mGpsPistanceCar - 94) * 11.67 / 1.7f));
                    Log.e ("10",(float) (686/beishu - transverse + (mGpsPistanceCar - 94) * 33.14f) +"   "+(float) (200/beishu + disparity + (mGpsPistanceCar - 94) * 6.86f)+ "    ");
                }
                v.invalidate();
                break;
            case "11":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 5) {//zuo
                    v.setX((float) (10/beishu - transverse+ mGpsPistanceCar * 49.2/ 1.7f));
                    v.setY((float) (280/beishu + disparity - mGpsPistanceCar * 24/ 1.7f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 90) {   //zhi
                    v.setX((float) (256/beishu - transverse + (mGpsPistanceCar - 5) * 4.88/ 1.7f));
                    v.setY(160/beishu + disparity);
                } else {//you
                    v.setX((float) (666/beishu - transverse + (mGpsPistanceCar - 90) * 23.4/ 1.7f));
                    v.setY((float) (160/beishu + disparity + (mGpsPistanceCar - 90) * 3 / 1.7f));
                }
                v.invalidate();
                break;
            case "12":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 5) {//zuo
                    v.setX((float) (80/beishu - transverse+ mGpsPistanceCar * 35.2/ 1.7f));
                    v.setY((float) (200/beishu + disparity - mGpsPistanceCar * 16 / 1.7f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (256/beishu - transverse + (mGpsPistanceCar - 5) * 5.6/ 1.7f));
                    v.setY(122/beishu + disparity);
                } else {//you
                    v.setX((float) (764/beishu - transverse + (mGpsPistanceCar - 96) * 65 / 1.7f));
                    v.setY((float) (123/beishu + disparity + (mGpsPistanceCar - 96) * 59.25 / 1.7f));
                    Log.e ("12you",(float) (764/beishu - transverse + (mGpsPistanceCar - 96) * 38.23f) +"   "+ (float) (123/beishu +disparity + (mGpsPistanceCar - 96) * 34.85f) + "    ");
                }
                v.invalidate();
                break;
            case "13":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 3) {//zuo
                    v.setX((float) (134/beishu- transverse+ mGpsPistanceCar * 40.67 / 1.7f));
                    v.setY((float) (175/beishu + disparity - mGpsPistanceCar * 31.67 / 1.7f));
                } else if (mGpsPistanceCar > 3 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (256/beishu - transverse + (mGpsPistanceCar - 3) * 5.70 / 1.7f));
                    v.setY(80/beishu + disparity);
                } else {//you
                    v.setX((float) (786/beishu - transverse + (mGpsPistanceCar - 96) * 59.5 / 1.7f));
                    v.setY((float) (80/beishu + disparity + (mGpsPistanceCar - 96) * 56.25 / 1.7f));
                    Log.e ("13",(float) (786/beishu - transverse + (mGpsPistanceCar - 96) * 35f) +"   "+ (float) (80/beishu + disparity - (mGpsPistanceCar - 96) * 33.09f)+ "    ");
                }
                v.invalidate();
                break;
            case "14":
                s1.setName("fu");
                if (mGpsPistanceCar <= 20) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar / 1.7 * 3f - transverse));
                    v.setY((float) (585/beishu + disparity));
                } else {//you
                    v.setX((float) (60/beishu - transverse + (mGpsPistanceCar - 20) / 1.7 * 5.5f));
                    v.setY((float) (585/beishu + disparity - (mGpsPistanceCar - 20) / 1.7 * 1.5625f));
                }
                v.invalidate();
                break;
            case "15":
                s1.setName("fu");
                if (mGpsPistanceCar <= 50 ) {
                    v.setX((float) (60/beishu - transverse + mGpsPistanceCar / 1.7  * 6.8f));
                    v.setY((float) (550/beishu + disparity - mGpsPistanceCar / 1.7  * 1.8f));
                } else {
                    v.setX((float) (400/beishu  + (mGpsPistanceCar - 50) / 1.7 * 12.48f - transverse));
                    v.setY((float) (460/beishu + disparity));
                }
                v.invalidate();
                break;
            case "16":
                s1.setName("fu");
                if (mGpsPistanceCar <= 79) {
                    v.setX((float) (50/beishu - transverse + mGpsPistanceCar / 1.7  * 5.06f));
                    v.setY((float) (235/beishu + disparity + mGpsPistanceCar / 1.7 * 1.08f));
                } else {
                    v.setX((float) (450/beishu  + (mGpsPistanceCar - 79) / 1.7 * 4.76f - transverse));
                    v.setY((float) (320 /beishu + disparity));
                }
                v.invalidate();
                break;
            case "17":
                s1.setName("fu");
                if (mGpsPistanceCar <= 23) {
                    v.setX((float) (550/beishu - transverse + mGpsPistanceCar / 1.7  * 2.17f));
                    v.setY((float) (320/beishu + disparity + mGpsPistanceCar / 1.7  * 0.87f));
                } else {
                    v.setX((float) (600/beishu  + (mGpsPistanceCar - 23) / 1.7 * 5.5f - transverse));
                    v.setY((float) (340/beishu + disparity));
                }
                v.invalidate();
                break;
            case "18":
                s1.setName("fu");
                if (mGpsPistanceCar <= 17) {
                    v.setX((float) (550/beishu - transverse + mGpsPistanceCar / 1.7  * 2.94f));
                    v.setY((float) (320/beishu + disparity - mGpsPistanceCar / 1.7  * 1.18f));
                } else {
                    v.setX((float) (600/beishu  + (mGpsPistanceCar - 17) / 1.7 * 5.11f - transverse));
                    v.setY((float) (300/beishu + disparity));
                }
                v.invalidate();
                break;
            case "19":
                s1.setName("fu");
                if (mGpsPistanceCar <= 11) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar / 1.7 * 4.55f - transverse));
                    v.setY((float) (180/beishu + disparity + mGpsPistanceCar / 1.7 * 0.45f));
                } else if (mGpsPistanceCar > 11 && mGpsPistanceCar <= 62) {   //zhi
                    v.setX((float) (50/beishu - transverse + (mGpsPistanceCar - 11) / 1.7 * 7.84f));
                    v.setY((float) (185/beishu + disparity + (mGpsPistanceCar - 11) / 1.7 * 1.47f));
                } else {//you
                    v.setX((float) (450/beishu - transverse + (mGpsPistanceCar - 62) / 1.7 * 15.11f));
                    v.setY(260/beishu + disparity);
                }
                v.invalidate();
                break;
            case "20":
                s1.setName("fu");
                if (mGpsPistanceCar <= 17) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar / 1.7 * 5.59f - transverse));
                    v.setY((float) (80/beishu + disparity + mGpsPistanceCar / 1.7 * 0.59f));
                } else if (mGpsPistanceCar > 17 && mGpsPistanceCar <= 83) {
                    v.setX((float) (95/beishu - transverse + (mGpsPistanceCar - 17) / 1.7 * 5.76f));
                    v.setY((float) (90/beishu + disparity + (mGpsPistanceCar - 17) / 1.7 * 2.27f));
                } else {//you
                    v.setX((float) (475/beishu - transverse + (mGpsPistanceCar - 83) / 1.7 * 10.29f));
                    v.setY((float) (240/beishu + disparity + (mGpsPistanceCar - 83) / 1.7 * 1.18f));
                }
                break;
            case "21":
                s1.setName("fu");
                if (mGpsPistanceCar <= 62) {//zuo
                    v.setX((float) (210/beishu - transverse + mGpsPistanceCar / 1.7  * 4.35f));
                    v.setY((float) (90/beishu + disparity + mGpsPistanceCar / 1.7  * 1.935f));
                } else {//you
                    v.setX((float) (480/beishu - transverse + (mGpsPistanceCar - 62) / 1.7 * 8.42f));
                    v.setY((float) (210/beishu + disparity + (mGpsPistanceCar - 62) / 1.7 * 1.315f));
                }
                v.invalidate();
                break;

        }
    }
}
