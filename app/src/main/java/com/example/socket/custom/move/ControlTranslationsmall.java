package com.example.socket.custom.move;

import android.view.View;

import com.example.socket.Unit.SpUtil;

/**
 * @date 2021/6/21 8:48
 */
public class ControlTranslationsmall {
    public static void proplrMove1(SpUtil s1, View v, String ratioOfGpsTrack, double mGpsPistanceCar, int transverse, int disparity) {
        switch (ratioOfGpsTrack) {
            case "1":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 5) {
                    v.setX((float) (320/1.2 - transverse + mGpsPistanceCar/ 1.2 * 12.8f));
                    v.setY((float) (450/1.2 - disparity + mGpsPistanceCar/ 1.2 * 10f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 94) {
                    v.setX((float) (384/1.2 - transverse + (mGpsPistanceCar - 5)/1.2 * 2.88f));
                    v.setY((float) (500/1.2 - disparity));
                } else {
                    v.setX((float) (640/1.2 - transverse + (mGpsPistanceCar - 94)/1.2 * 10.67f));
                    v.setY((float) (500/1.2 - disparity + (mGpsPistanceCar - 94)/1.2 * 8.33f));
                }
                v.invalidate();
                break;
            case "2":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 87) {
                    v.setX((float) (50 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 8.25f));
                    v.setY((float) (450 / 1.2- disparity));
                } else {
                    v.setX((float) (768 / 1.2 - transverse + (mGpsPistanceCar - 87) / 1.2 * 4.92f));
                    v.setY((float) (450 / 1.2 - disparity + (mGpsPistanceCar - 87) / 1.2 * 3.84f));
                }
                v.invalidate();
                break;
            case "3":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                v.setX((float) (128 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 8.46f));
                v.setY((float) (400 / 1.2 - disparity));
                v.invalidate();
                break;
            case "4":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 6) {
                    v.setX((float) (256 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 10.67f));
                    v.setY((float) (400 / 1.2 - disparity - mGpsPistanceCar / 1.2 * 8.33f));
                } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 94) {
                    v.setX((float) (320 / 1.2- transverse + (mGpsPistanceCar - 6) / 1.2 * 4.36f));
                    v.setY((float) (350 / 1.2 - disparity));
                } else {
                    v.setX((float) (704 / 1.2 - transverse + (mGpsPistanceCar - 94) / 1.2 * 10.67f));
                    v.setY((float) (350 / 1.2- disparity + (mGpsPistanceCar - 94) / 1.2 * 8.33f));
                }
                v.invalidate();
                break;
            case "5":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 6) {
                    v.setX((float) (320 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 10.67f));
                    v.setY((float) (350 / 1.2 - disparity - mGpsPistanceCar / 1.2 * 8.33f));
                } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 93) {
                    v.setX((float) (384 / 1.2 - transverse + (mGpsPistanceCar - 6) / 1.2 * 2.94f));
                    v.setY((float) (300 / 1.2 - disparity));
                } else {
                    v.setX((float) (640 / 1.2 - transverse + (mGpsPistanceCar - 93) / 1.2 * 9.14f));
                    v.setY((float) (300 / 1.2 - disparity + (mGpsPistanceCar - 93) / 1.2 * 7.14f));
                }
                v.invalidate();
                break;
            case "6":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 83) {
                    v.setX((float) (50 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 8.65f));
                    v.setY((float) (250 / 1.2 - disparity));
                } else {
                    v.setX((float) (768 / 1.2- transverse + (mGpsPistanceCar - 83) / 1.2 * 7.53f));
                    v.setY((float) (250 / 1.2 - disparity + (mGpsPistanceCar - 83) / 1.2 * 8.82f));
                }
                v.invalidate();
                break;
            case "7":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 20) {
                    v.setX((float) (128 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 3.84f));
                    v.setY((float) (250 / 1.2 - disparity - mGpsPistanceCar / 1.2 * 5f));
                } else if (mGpsPistanceCar > 20 && mGpsPistanceCar <= 78) {
                    v.setX((float) (205 / 1.2 - transverse + (mGpsPistanceCar - 20) / 1.2 * 9.71f));
                    v.setY((float) (150 / 1.2 - disparity));
                } else {
                    v.setX((float) (768 / 1.2 - transverse + (mGpsPistanceCar - 78) / 1.2 * 2.91f));
                    v.setY((float) (150 / 1.2 - disparity + (mGpsPistanceCar - 78) / 1.2 * 7.95f));
                }
                v.invalidate();
                break;
            case "8":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 21) {
                    v.setX((float) (230 / 1.2 - transverse + mGpsPistanceCar / 1.2 * 3.67f));
                    v.setY((float) (150 / 1.2 - disparity - mGpsPistanceCar / 1.2 * 4.76f));
                } else if (mGpsPistanceCar > 21 && mGpsPistanceCar <= 76) {
                    v.setX((float) (307 / 1.2 - transverse + (mGpsPistanceCar - 21) / 1.2 * 6.05f));
                    v.setY((float) (50 / 1.2 - disparity));
                } else {
                    v.setX((float) (640 / 1.2 - transverse + (mGpsPistanceCar - 76) / 1.2 * 5.33f));
                    v.setY((float) (50 / 1.2 - disparity + (mGpsPistanceCar - 76) / 1.2 * 4.17f));
                }
                v.invalidate();
                break;
            case "9":
                /*s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");*/
                s1.setName("cf");
                if (mGpsPistanceCar >= 81) {
                    v.setX((float) (1000 / 1.7 - transverse - (100 - mGpsPistanceCar) / 1.7 * 10.53f));
                    v.setY((float) (400 / 1.7 - disparity));
                } else if (mGpsPistanceCar >= 43 && mGpsPistanceCar < 81) {
                    v.setX((float) (800 / 1.7 - transverse - (81 - mGpsPistanceCar) / 1.7 * 2.7f));
                    v.setY((float) (400 / 1.7 - disparity + (81 - mGpsPistanceCar) / 1.7 * 2.7f));
                } else if (mGpsPistanceCar >= 0 && mGpsPistanceCar < 43) {
                    v.setX((float) (700 / 1.7 - transverse - (43 - mGpsPistanceCar) / 1.7 * 4.76f));
                    v.setY((float) (500 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "10":
                /*s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");*/
                s1.setName("cf");
                v.setX((float) (700 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 3f));
                v.setY((float) (500 / 1.7 - disparity));
                v.invalidate();
                break;
            case "11":
                s1.setName("cf");
                if (mGpsPistanceCar >= 77) {
                    v.setX((float) (600 / 1.7 - transverse - (100 - mGpsPistanceCar) / 1.7 * 2.17f));
                    v.setY((float) (400 / 1.7 - disparity - (100 - mGpsPistanceCar) / 1.7 * 4.35f));
                } else {
                    v.setX((float) (550 / 1.7 - transverse - (76 - mGpsPistanceCar) / 1.7* 6.58f));
                    v.setY((float) (300 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "12":
                s1.setName("cf");
                if (mGpsPistanceCar >= 76) {
                    v.setX((float) (500 / 1.7 - transverse - (100 - mGpsPistanceCar) / 1.7 * 2.08f));
                    v.setY((float) (300 / 1.7 - disparity - (100 - mGpsPistanceCar) / 1.7 * 4.17f));
                } else if (mGpsPistanceCar >= 26 && mGpsPistanceCar < 76) {
                    v.setX((float) (450 / 1.7 - transverse - (75 - mGpsPistanceCar) / 1.7 * 6.12f));
                    v.setY((float) (200 / 1.7 - disparity));
                } else {
                    v.setX((float) (150 / 1.7 - transverse + (25 - mGpsPistanceCar) / 1.7 * 2f));
                    v.setY((float) (200 / 1.7 - disparity - (25 - mGpsPistanceCar) / 1.7 * 4f));
                }
                v.invalidate();
                break;
            case "13":
                s1.setName("cf");
                v.setX((float) (800 / 1.7 - transverse - (100 - mGpsPistanceCar) / 1.7 * 7.5f));
                v.setY((float) (400 / 1.7 - disparity));
                v.invalidate();
                break;
            case "14":
                s1.setName("cf");
                if (mGpsPistanceCar >= 47) {
                    v.setX((float) (450 / 1.7 - transverse - (100 - mGpsPistanceCar) / 1.7 * 1.89f));
                    v.setY((float) (400 / 1.7 - disparity + (100 - mGpsPistanceCar) / 1.7 * 1.89f));
                } else {
                    v.setX((float) (350 / 1.7 - transverse - (46 - mGpsPistanceCar) / 1.7 * 6.52f));
                    v.setY((float) (500 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "15":
                s1.setName("bl");
                if (mGpsPistanceCar <= 42) {
                    v.setX((float) (50 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 10.71f));
                    v.setY((float) (300 / 1.7 - disparity + mGpsPistanceCar / 1.7 * 5.95f));
                } else {
                    v.setX((float) (500 / 1.7 - transverse + (mGpsPistanceCar - 43) / 1.7 * 5.26f));
                    v.setY((float) (550 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "16":
                s1.setName("bl");
                if (mGpsPistanceCar <= 30) {
                    v.setX((float) (450 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 3.33f));
                    v.setY((float) (350 / 1.7 - disparity + mGpsPistanceCar / 1.7 * 3.33f));
                } else {
                    v.setX((float) (550 / 1.7 - transverse + (mGpsPistanceCar - 31) / 1.7 * 4.93f));
                    v.setY((float) (450 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "17":
                s1.setName("bl");
                if (mGpsPistanceCar <= 52) {
                    v.setX((float) (150 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 4.81f));
                    v.setY((float) (150 / 1.7 - disparity + mGpsPistanceCar / 1.7 * 3.85f));
                } else {
                    v.setX((float) (400 / 1.7 - transverse + (mGpsPistanceCar - 53) / 1.7 * 8.51f));
                    v.setY((float) (350 / 1.7 - disparity));
                }
                v.invalidate();
                break;
            case "18":
                s1.setName("bl");
                if (mGpsPistanceCar <= 8) {
                    v.setX((float) (500 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 6.25f));
                    v.setY((float) (350 / 1.7 - disparity - mGpsPistanceCar / 1.7 * 12.5f));
                } else if (mGpsPistanceCar > 8 && mGpsPistanceCar <= 79) {
                    v.setX((float) (550 / 1.7 - transverse + (mGpsPistanceCar - 8) / 1.7 * 2.82f));
                    v.setY((float) (250 / 1.7 - disparity));
                } else {
                    v.setX((float) (750 / 1.7 - transverse + (mGpsPistanceCar - 79) / 1.7 * 2.38f));
                    v.setY((float) (250 / 1.7 - disparity + (mGpsPistanceCar - 79) / 1.7 * 4.76f));
                }
                v.invalidate();
                break;
            case "19":
                s1.setName("bl");
                v.setX((float) (800 / 1.7 - transverse + mGpsPistanceCar / 1.7 * 2f));
                v.setY((float) (350 / 1.7 - disparity));
                v.invalidate();
                break;
        }
    }
}
