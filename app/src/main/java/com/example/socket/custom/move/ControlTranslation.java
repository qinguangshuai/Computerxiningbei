package com.example.socket.custom.move;

import android.view.View;

import com.example.socket.Unit.SpUtil;


/**
 * @date 2021/6/21 8:48
 */
public class ControlTranslation {
    public static void proplrMove1(SpUtil s1, View v, String ratioOfGpsTrack, double mGpsPistanceCar, int transverse, int disparity) {
        switch (ratioOfGpsTrack) {
            case "1":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 5) {
                    v.setX((float) (320 - transverse + mGpsPistanceCar * 12.8f));
                    v.setY((float) (450 - disparity + mGpsPistanceCar * 10f));
                } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 94) {
                    v.setX((float) (384 - transverse + (mGpsPistanceCar - 5) * 2.88f));
                    v.setY(500 - disparity);
                } else {
                    v.setX((float) (640 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                    v.setY((float) (500 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                }
                v.invalidate();
                break;
            case "2":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 87) {
                    v.setX((float) (50 - transverse + mGpsPistanceCar * 8.25f));
                    v.setY(450 - disparity);
                } else {
                    v.setX((float) (768 - transverse + (mGpsPistanceCar - 87) * 4.92f));
                    v.setY((float) (450 - disparity + (mGpsPistanceCar - 87) * 3.84f));
                }
                v.invalidate();
                break;
            case "3":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                v.setX((float) (128 - transverse + mGpsPistanceCar * 8.46f));
                v.setY(400 - disparity);
                v.invalidate();
                break;
            case "4":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 6) {
                    v.setX((float) (256 - transverse + mGpsPistanceCar * 10.67f));
                    v.setY((float) (400 - disparity - mGpsPistanceCar * 8.33f));
                } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 94) {
                    v.setX((float) (320 - transverse + (mGpsPistanceCar - 6) * 4.36f));
                    v.setY(350 - disparity);
                } else {
                    v.setX((float) (704 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                    v.setY((float) (350 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                }
                v.invalidate();
                break;
            case "5":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 6) {
                    v.setX((float) (320 - transverse + mGpsPistanceCar * 10.67f));
                    v.setY((float) (350 - disparity - mGpsPistanceCar * 8.33f));
                } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 93) {
                    v.setX((float) (384 - transverse + (mGpsPistanceCar - 6) * 2.94f));
                    v.setY(300 - disparity);
                } else {
                    v.setX((float) (640 - transverse + (mGpsPistanceCar - 93) * 9.14f));
                    v.setY((float) (300 - disparity + (mGpsPistanceCar - 93) * 7.14f));
                }
                v.invalidate();
                break;
            case "6":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 83) {
                    v.setX((float) (50 - transverse + mGpsPistanceCar * 8.65f));
                    v.setY(250 - disparity);
                } else {
                    v.setX((float) (768 - transverse + (mGpsPistanceCar - 83) * 7.53f));
                    v.setY((float) (250 - disparity + (mGpsPistanceCar - 83) * 8.82f));
                }
                v.invalidate();
                break;
            case "7":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 20) {
                    v.setX((float) (128 - transverse + mGpsPistanceCar * 3.84f));
                    v.setY((float) (250 - disparity - mGpsPistanceCar * 5f));
                } else if (mGpsPistanceCar > 20 && mGpsPistanceCar <= 78) {
                    v.setX((float) (205 - transverse + (mGpsPistanceCar - 20) * 9.71f));
                    v.setY(150 - disparity);
                } else {
                    v.setX((float) (768 - transverse + (mGpsPistanceCar - 78) * 2.91f));
                    v.setY((float) (150 - disparity + (mGpsPistanceCar - 78) * 7.95f));
                }
                v.invalidate();
                break;
            case "8":
                /*s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");*/
                s1.setName("zheng");
                if (mGpsPistanceCar <= 21) {
                    v.setX((float) (230 - transverse + mGpsPistanceCar * 3.67f));
                    v.setY((float) (150 - disparity - mGpsPistanceCar * 4.76f));
                } else if (mGpsPistanceCar > 21 && mGpsPistanceCar <= 76) {
                    v.setX((float) (307 - transverse + (mGpsPistanceCar - 21) * 6.05f));
                    v.setY(50 - disparity);
                } else {
                    v.setX((float) (640 - transverse + (mGpsPistanceCar - 76) * 5.33f));
                    v.setY((float) (50 - disparity + (mGpsPistanceCar - 76) * 4.17f));
                }
                v.invalidate();
                break;
            case "9":
                /*s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");*/
                s1.setName("cf");
                if (mGpsPistanceCar >= 81) {
                    v.setX((float) (1000 - transverse - (100 - mGpsPistanceCar) * 10.53f));
                    v.setY(400 - disparity);
                } else if (mGpsPistanceCar >= 43 && mGpsPistanceCar < 81) {
                    v.setX((float) (800 - transverse - (81 - mGpsPistanceCar) * 2.7f));
                    v.setY((float) (400 - disparity + (81 - mGpsPistanceCar) * 2.7f));
                } else if (mGpsPistanceCar >= 0 && mGpsPistanceCar < 43) {
                    v.setX((float) (700 - transverse - (43 - mGpsPistanceCar) * 4.76f));
                    v.setY(500 - disparity);
                }
                v.invalidate();
                break;
            case "10":
                /*s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");*/
                s1.setName("cf");
                v.setX((float) (700 - transverse + mGpsPistanceCar * 3f));
                v.setY(500 - disparity);
                v.invalidate();
                break;
            case "11":
                s1.setName("cf");
                if (mGpsPistanceCar >= 77) {
                    v.setX((float) (600 - transverse - (100 - mGpsPistanceCar) * 2.17f));
                    v.setY((float) (400 - disparity - (100 - mGpsPistanceCar) * 4.35f));
                } else {
                    v.setX((float) (550 - transverse - (76 - mGpsPistanceCar) * 6.58f));
                    v.setY(300 - disparity);
                }
                v.invalidate();
                break;
            case "12":
                s1.setName("cf");
                if (mGpsPistanceCar >= 76) {
                    v.setX((float) (500 - transverse - (100 - mGpsPistanceCar) * 2.08f));
                    v.setY((float) (300 - disparity - (100 - mGpsPistanceCar) * 4.17f));
                } else if (mGpsPistanceCar >= 26 && mGpsPistanceCar < 76) {
                    v.setX((float) (450 - transverse - (75 - mGpsPistanceCar) * 6.12f));
                    v.setY(200 - disparity);
                } else {
                    v.setX((float) (150 - transverse - (25 - mGpsPistanceCar) * 2f));
                    v.setY((float) (200 - disparity + (25 - mGpsPistanceCar) * 4f));
                }
                v.invalidate();
                break;
            case "13":
                s1.setName("cf");
                v.setX((float) (800 - transverse - (100 - mGpsPistanceCar) * 7.5f));
                v.setY(400 - disparity);
                v.invalidate();
                break;
            case "14":
                s1.setName("cf");
                if (mGpsPistanceCar >= 47) {
                    v.setX((float) (450 - transverse - (100 - mGpsPistanceCar) * 1.89f));
                    v.setY((float) (400 - disparity + (100 - mGpsPistanceCar) * 1.89f));
                } else {
                    v.setX((float) (350 - transverse - (46 - mGpsPistanceCar) * 6.52f));
                    v.setY(500 - disparity);
                }
                v.invalidate();
                break;
            case "15":
                s1.setName("bl");
                if (mGpsPistanceCar <= 42) {
                    v.setX((float) (50 - transverse + mGpsPistanceCar * 10.71f));
                    v.setY((float) (300 - disparity + mGpsPistanceCar * 5.95f));
                } else {
                    v.setX((float) (500 - transverse + (mGpsPistanceCar - 43) * 5.26f));
                    v.setY(550 - disparity);
                }
                v.invalidate();
                break;
            case "16":
                s1.setName("bl");
                if (mGpsPistanceCar <= 30) {
                    v.setX((float) (450 - transverse + mGpsPistanceCar * 3.33f));
                    v.setY((float) (350 - disparity + mGpsPistanceCar * 3.33f));
                } else {
                    v.setX((float) (550 - transverse + (mGpsPistanceCar - 31) * 4.93f));
                    v.setY(450 - disparity);
                }
                v.invalidate();
                break;
            case "17":
                s1.setName("bl");
                if (mGpsPistanceCar <= 52) {
                    v.setX((float) (150 - transverse + mGpsPistanceCar * 4.81f));
                    v.setY((float) (150 - disparity + mGpsPistanceCar * 3.85f));
                } else {
                    v.setX((float) (400 - transverse + (mGpsPistanceCar - 53) * 8.51f));
                    v.setY(350 - disparity);
                }
                v.invalidate();
                break;
            case "18":
                s1.setName("bl");
                if (mGpsPistanceCar <= 8) {
                    v.setX((float) (500 - transverse + mGpsPistanceCar * 6.25f));
                    v.setY((float) (350 - disparity - mGpsPistanceCar * 12.5f));
                } else if (mGpsPistanceCar > 8 && mGpsPistanceCar <= 79) {
                    v.setX((float) (550 - transverse + (mGpsPistanceCar - 8) * 2.82f));
                    v.setY(250 - disparity);
                } else {
                    v.setX((float) (750 - transverse + (mGpsPistanceCar - 79) * 2.38f));
                    v.setY((float) (250 - disparity + (mGpsPistanceCar - 79) * 4.76f));
                }
                v.invalidate();
                break;
            case "19":
                s1.setName("bl");
                v.setX((float) (800 - transverse + mGpsPistanceCar * 2f));
                v.setY(350 - disparity);
                v.invalidate();
                break;
        }
    }
}
