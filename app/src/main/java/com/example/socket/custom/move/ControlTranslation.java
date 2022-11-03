package com.example.socket.custom.move;

import android.util.Log;
import android.view.View;

import com.example.socket.Unit.SpUtil;

/**
 * @date 2021/6/21 8:48
 */
public class ControlTranslation {
    public static void proplrMove1(SpUtil s1, View v, String ratioOfGpsTrack, double mGpsPistanceCar, int transverse, int disparity) {
        switch (ratioOfGpsTrack) {
            case "1":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (162 - transverse+ mGpsPistanceCar * 17.71f));
                    v.setY((float) (440 - disparity + mGpsPistanceCar * 17.14f));
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (286 - transverse + (mGpsPistanceCar - 7) * 3.81f));
                    v.setY(560 - disparity);
                } else {//you
                    v.setX((float) (626 - transverse + (mGpsPistanceCar - 96) * 18f));
                    v.setY((float) (560 - disparity - (mGpsPistanceCar - 96) * 14.5f));
                    Log.e("111",(float) (626 + (mGpsPistanceCar - 92) * 9f)+"");
                }
                v.invalidate();
                break;
            case "2":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (80 - transverse + mGpsPistanceCar * 35.7f));
                    v.setY((float) (400 - disparity + mGpsPistanceCar * 17.14f));
                    Log.e("1111111",(float) (mGpsPistanceCar * 35.7f)+"  " + mGpsPistanceCar +"  ");
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 92) {   //zhi
                    v.setX((float) (330 - transverse + (mGpsPistanceCar - 7) * 3.52f));
                    v.setY(520 - disparity);
                } else {//you
                    v.setX((float) (626 - transverse + (mGpsPistanceCar - 92) * 42.25f));
                    v.setY((float) (520 - disparity - (mGpsPistanceCar - 92) * 10.63f));//(-7.25)
                }
                v.invalidate();
                break;
            case "3":
               s1.setName("zhu");
                if (mGpsPistanceCar <= 93) {//zuo
                    v.setX((float) (246 - transverse+ mGpsPistanceCar * 3.87f));
                    v.setY((float) (480 - disparity ));
                } else {//you
                    v.setX((float) (606 - transverse + (mGpsPistanceCar - 93) * 52f));
                    v.setY((float) (480 - disparity - (mGpsPistanceCar - 93) * 12.86f));
                }
                v.invalidate();
                break;
            case "4":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 7) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 35.14f- transverse));
                    v.setY((float) (320 - disparity + mGpsPistanceCar * 17.14f));
                } else if (mGpsPistanceCar > 7 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (246 - transverse + (mGpsPistanceCar - 7) * 4.09f));
                    v.setY(440 - disparity);
                }else {//you
                    v.setX((float) (606 - transverse + (mGpsPistanceCar - 96) * 74.75f));
                    v.setY((float) (440 - disparity - (mGpsPistanceCar - 96) * 16.25f));

                    Log.e ("6",(float) (606 - transverse + (mGpsPistanceCar - 98) * 149.5f) +"   "+(float) (440 - disparity + (mGpsPistanceCar - 98) * 32.5f)  +  "  ");
                }
                v.invalidate();
                break;
            case "5":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 92) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.35f- transverse));
                    v.setY((float) (400 - disparity));
                } else {//you
                    v.setX((float) (676 - transverse + (mGpsPistanceCar - 92) * 43.5f));
                    v.setY((float) (400 - disparity + (mGpsPistanceCar - 92) * 11.875f));
                }
                v.invalidate();
                break;
            case "6":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 91) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 7.54f- transverse));
                    v.setY((float) (360 - disparity));
                    Log.e ("6",(float) (0 + mGpsPistanceCar * 7.54f- transverse) +"   "+(float) (360 - disparity)  +  "  ");
                } else {//you
                    v.setX((float) (686 - transverse + (mGpsPistanceCar - 91) * 37.56f));
                    v.setY((float) (360 - disparity + (mGpsPistanceCar - 91) * 10f));
                    Log.e ("6you",(float) (686 - transverse + (mGpsPistanceCar - 9) * 37.56f) +"   "+(360 - disparity + (mGpsPistanceCar - 9) * 10f)  +  "  ");
                }
                v.invalidate();
                break;
            case "7":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 91) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.69f - transverse));
                    v.setY((float) (320 - disparity));
                } else {//you
                    v.setX((float) (700 - transverse + (mGpsPistanceCar - 91) * 36f));
                    v.setY((float) (320 - disparity + (mGpsPistanceCar - 91) * 9.44f));
                    Log.e ("7",(float) (700 - transverse + (mGpsPistanceCar - 91) * 36f) +"   "+(float) (320 - disparity + (mGpsPistanceCar - 91) * 9.44f)  +  "  ");
                }
                v.invalidate();
                break;
            case "8":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 84) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 8.05f - transverse ));
                    v.setY((float) (280 - disparity ));
                } else {//you
                    v.setX((float) (676 - transverse + (mGpsPistanceCar - 84) * 21.75f));
                    v.setY((float) (280 - disparity + (mGpsPistanceCar - 84) * 5f));
                }
                v.invalidate();
                break;
            case "9":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 88) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 7.80f - transverse));
                    v.setY((float) (240 - disparity));
                    Log.e ("9",(float) (0 + mGpsPistanceCar * 7.80f - transverse) +"   "+(float) (240 - disparity)+ "    ");

                } else {//you
                    v.setX((float) (686 - transverse + (mGpsPistanceCar - 88) * 28.17f));
                    v.setY((float) (240 - disparity + (mGpsPistanceCar - 88) * 6.25f));
                    Log.e ("9you",(float) (686 - transverse + (mGpsPistanceCar - 88) * 28.17f) +"   "+(240 - disparity + (mGpsPistanceCar - 88) * 6.25f)+ "    ");
                }
                v.invalidate();
                break;
            case "10":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 94) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 7.3f - transverse));
                    v.setY((float) (200 - disparity));
                } else {//you
                    v.setX((float) (686 - transverse + (mGpsPistanceCar - 94) * 56.33f));
                    v.setY((float) (200 - disparity + (mGpsPistanceCar - 94) * 11.67f));
                    Log.e ("10",(float) (686 - transverse + (mGpsPistanceCar - 94) * 56.33f) +"   "+(float) (200 - disparity + (mGpsPistanceCar - 94) * 11.67f)+ "    ");
                }
                v.invalidate();
                break;
            case "11":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 5) {//zuo
                    v.setX((float) (10 - transverse+ mGpsPistanceCar * 49.2f));
                    v.setY((float) (280 - disparity - mGpsPistanceCar * 24f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 90) {   //zhi
                    v.setX((float) (256 - transverse + (mGpsPistanceCar - 5) * 4.88f));
                    v.setY(160 - disparity);
                } else {//you
                    v.setX((float) (666 - transverse + (mGpsPistanceCar - 90) * 23.4f));
                    v.setY((float) (160 - disparity + (mGpsPistanceCar - 90) * 3f));
                }
                v.invalidate();
                break;
            case "12":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 5) {//zuo
                    v.setX((float) (80 - transverse+ mGpsPistanceCar * 35.2f));
                    v.setY((float) (200 - disparity - mGpsPistanceCar * 16f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (256 - transverse + (mGpsPistanceCar - 5) * 5.6f));
                    v.setY(122 - disparity);
                } else {//you
                    v.setX((float) (764 - transverse + (mGpsPistanceCar - 96) * 65f));
                    v.setY((float) (123 - disparity + (mGpsPistanceCar - 96) * 59.25f));
                    Log.e ("12you",(float) (764 - transverse + (mGpsPistanceCar - 96) * 65f) +"   "+ (float) (123 - disparity + (mGpsPistanceCar - 96) * 59.25f) + "    ");
                }
                v.invalidate();
                break;
            case "13":
                s1.setName("zhu");
                if (mGpsPistanceCar <= 3) {//zuo
                    v.setX((float) (134- transverse+ mGpsPistanceCar * 40.67f));
                    v.setY((float) (175 - disparity - mGpsPistanceCar * 31.67f));
                } else if (mGpsPistanceCar > 3 && mGpsPistanceCar <= 96) {   //zhi
                    v.setX((float) (256 - transverse + (mGpsPistanceCar - 3) * 5.70f));
                    v.setY(80 - disparity);
                } else {//you
                    v.setX((float) (786 - transverse + (mGpsPistanceCar - 96) * 59.5f));
                    v.setY((float) (80 - disparity + (mGpsPistanceCar - 96) * 56.25f));
                    Log.e ("13",(float) (786 - transverse + (mGpsPistanceCar - 96) * 59.5f) +"   "+ (float) (80 - disparity - (mGpsPistanceCar - 96) * 56.25f)+ "    ");
                }
                v.invalidate();
                break;
            case "14":
                s1.setName("fu");
                if (mGpsPistanceCar <= 20) {//zuo
                    v.setX((float) (0  + mGpsPistanceCar * 3f - transverse));
                    v.setY((float) (585 - disparity));
                } else {//you
                    v.setX((float) (60 - transverse + (mGpsPistanceCar - 20) * 5.5f));
                    v.setY((float) (585 - disparity - (mGpsPistanceCar - 20) * 1.5625f));
                }
                v.invalidate();
                break;
            case "15":
                s1.setName("fu");
                if (mGpsPistanceCar <= 50 ) {
                    v.setX((float) (60 - transverse + mGpsPistanceCar  * 6.8f));
                    v.setY((float) (550 - disparity - mGpsPistanceCar  * 1.8f));
                } else {
                    v.setX((float) (400  + (mGpsPistanceCar - 50) * 12.48f - transverse));
                    v.setY((float) (460 - disparity));
                }
                v.invalidate();
                break;
            case "16":
                s1.setName("fu");
                if (mGpsPistanceCar <= 79) {
                    v.setX((float) (50 - transverse + mGpsPistanceCar  * 5.06f));
                    v.setY((float) (235 - disparity + mGpsPistanceCar  * 1.08f));
                } else {
                    v.setX((float) (450  + (mGpsPistanceCar - 79) * 4.76f - transverse));
                    v.setY((float) (320  - disparity));
                }
                v.invalidate();
                break;
            case "17":
                s1.setName("fu");
                if (mGpsPistanceCar <= 23) {
                    v.setX((float) (550 - transverse + mGpsPistanceCar  * 2.17f));
                    v.setY((float) (320 - disparity + mGpsPistanceCar  * 0.87f));
                } else {
                    v.setX((float) (600  + (mGpsPistanceCar - 23) * 5.5f - transverse));
                    v.setY((float) (340 - disparity));
                }
                v.invalidate();
                break;
            case "18":
                s1.setName("fu");
                if (mGpsPistanceCar <= 17) {
                    v.setX((float) (550 - transverse + mGpsPistanceCar  * 2.94f));
                    v.setY((float) (320 - disparity - mGpsPistanceCar  * 1.18f));
                } else {
                    v.setX((float) (600  + (mGpsPistanceCar - 17) * 5.11f - transverse));
                    v.setY((float) (300 - disparity));
                }
                v.invalidate();
                break;
            case "19":
                s1.setName("fu");
                if (mGpsPistanceCar <= 11) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 4.55f - transverse));
                    v.setY((float) (180 - disparity + mGpsPistanceCar * 0.45f));
                } else if (mGpsPistanceCar > 11 && mGpsPistanceCar <= 62) {   //zhi
                    v.setX((float) (50 - transverse + (mGpsPistanceCar - 11) * 7.84f));
                    v.setY((float) (185 - disparity + (mGpsPistanceCar - 11) * 1.47f));
                } else {//you
                    v.setX((float) (450 - transverse + (mGpsPistanceCar - 62) * 15.11f));
                    v.setY((float)260 - disparity);
                }
                v.invalidate();
                break;
            case "20":
                s1.setName("fu");
                if (mGpsPistanceCar <= 17) {//zuo
                    v.setX((float) (0 + mGpsPistanceCar * 5.59f - transverse));
                    v.setY((float) (80 - disparity + mGpsPistanceCar * 0.59f));
                } else if (mGpsPistanceCar > 17 && mGpsPistanceCar <= 83) {
                    v.setX((float) (95 - transverse + (mGpsPistanceCar - 17) * 5.76f));
                    v.setY((float) (90 - disparity + (mGpsPistanceCar - 17) * 2.27f));
                } else {//you
                    v.setX((float) (475 - transverse + (mGpsPistanceCar - 83) * 10.29f));
                    v.setY((float) (240 - disparity + (mGpsPistanceCar - 83) * 1.18f));
                }
                break;
            case "21":
                s1.setName("fu");
                if (mGpsPistanceCar <= 62) {//zuo
                    v.setX((float) (210 - transverse + mGpsPistanceCar  * 4.35f));
                    v.setY((float) (90 - disparity + mGpsPistanceCar  * 1.935f));
                } else {//you
                    v.setX((float) (480 - transverse + (mGpsPistanceCar - 62) * 8.42f));
                    v.setY((float) (210 - disparity + (mGpsPistanceCar - 62) * 1.315f));
                    Log.e ("10",(float) (686 - transverse + (mGpsPistanceCar - 94) * 56.33f) +"   "+(float) (200 - disparity + (mGpsPistanceCar - 94) * 11.67f)+ "    ");
                }
                v.invalidate();
                break;

        }
    }
}
