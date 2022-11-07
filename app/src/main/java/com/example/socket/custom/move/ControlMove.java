package com.example.socket.custom.move;

import android.animation.ObjectAnimator;
import android.view.View;

import com.example.socket.Unit.SpUtil;


/**
 * @date 2021/6/4 9:19
 */
public class ControlMove {

    static boolean oneTrack = false;
    static boolean twoTrack = false;
    static boolean threeTrack = false;
    static boolean fourTrack = false;
    static boolean fiveTrack = false;
    static boolean sixTrack = false;
    static boolean sevenTrack = false;
    static boolean eightTrack = false;
    static boolean nine = false;
    static boolean ten = false;
    static boolean eleven = false;
    static boolean twelve = false;
    static boolean thirteen = false;
    static boolean fourteen = false;
    static boolean fifteen = false;
    static boolean sixteen = false;
    static boolean seventeen = false;
    static boolean eighteen = false;
    static boolean nineteen = false;

    public static void proplrMove0(SpUtil s1, SpUtil s2, SpUtil s3, View v, String ratioOfGpsTrack, double mGpsPistanceCar, int transverse, int disparity, int mTime) {
        switch (ratioOfGpsTrack) {
            case "1":
                twoTrack = false;
                threeTrack = false;
                fourTrack = false;
                fiveTrack = false;
                sixTrack = false;
                sevenTrack = false;
                eightTrack = false;
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                if (oneTrack == false) {
                    v.setX(320 - transverse);
                    v.setY(450 - disparity);
                    oneTrack = true;
                    if (mGpsPistanceCar <= 5) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + mGpsPistanceCar * 12.8f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (450 - disparity + mGpsPistanceCar * 10f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 94) {
                        v.setY(500 - disparity);
                        //setStraightLine(340, mGpsPistanceCar - 5, 2.88f);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (384 - transverse + (mGpsPistanceCar - 5) * 2.88f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (500 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 5) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + mGpsPistanceCar * 12.8f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (450 - disparity + mGpsPistanceCar * 10f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 5 && mGpsPistanceCar <= 94) {
                        v.setY(500 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (384 - transverse + (mGpsPistanceCar - 5) * 2.88f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (500 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "2":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                threeTrack = false;
                fourTrack = false;
                fiveTrack = false;
                sixTrack = false;
                sevenTrack = false;
                eightTrack = false;
                if (twoTrack == false) {
                    v.setX(50 - transverse);
                    v.setY(450 - disparity);
                    twoTrack = true;
                    if (mGpsPistanceCar <= 87) {
                        v.setY(450 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 8.25f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 87) * 4.92f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (450 - disparity + (mGpsPistanceCar - 87) * 3.84f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 87) {
                        v.setY(450 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 8.25f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 87) * 4.92f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (450 - disparity + (mGpsPistanceCar - 87) * 3.84f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "3":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                fourTrack = false;
                fiveTrack = false;
                sixTrack = false;
                sevenTrack = false;
                eightTrack = false;
                if (threeTrack == false) {
                    v.setX(128 - transverse);
                    v.setY(400 - disparity);
                    threeTrack = true;
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (128 - transverse + mGpsPistanceCar * 8.46f));
                    animator.setDuration(mTime);
                    animator.start();
                } else {
                    v.setY(400 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (128 - transverse + mGpsPistanceCar * 8.46f));
                    animator.setDuration(mTime);
                    animator.start();
                }
                break;
            case "4":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                threeTrack = false;
                fiveTrack = false;
                sixTrack = false;
                sevenTrack = false;
                eightTrack = false;
                if (fourTrack == false) {
                    v.setX(256 - transverse);
                    v.setY(400 - disparity);
                    fourTrack = true;
                    if (mGpsPistanceCar <= 6) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (256 - transverse + mGpsPistanceCar * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity - mGpsPistanceCar * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 94) {
                        v.setY(350 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + (mGpsPistanceCar - 6) * 4.36f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (704 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 6) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (256 - transverse + mGpsPistanceCar * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity - mGpsPistanceCar * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 94) {
                        v.setY(350 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + (mGpsPistanceCar - 6) * 4.36f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (704 - transverse + (mGpsPistanceCar - 94) * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity + (mGpsPistanceCar - 94) * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "5":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                threeTrack = false;
                fourTrack = false;
                sixTrack = false;
                sevenTrack = false;
                eightTrack = false;
                if (fiveTrack == false) {
                    v.setX(320 - transverse);
                    v.setY(350 - disparity);
                    fiveTrack = true;
                    if (mGpsPistanceCar <= 6) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + mGpsPistanceCar * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity - mGpsPistanceCar * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 93) {
                        v.setY(300 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (384 - transverse + (mGpsPistanceCar - 6) * 2.94f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 93) * 9.14f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity + (mGpsPistanceCar - 93) * 7.14f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 6) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (320 - transverse + mGpsPistanceCar * 10.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity - mGpsPistanceCar * 8.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 6 && mGpsPistanceCar <= 93) {
                        v.setY(300 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (384 - transverse + (mGpsPistanceCar - 6) * 2.94f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 93) * 9.14f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity + (mGpsPistanceCar - 93) * 7.14f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "6":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                threeTrack = false;
                fourTrack = false;
                fiveTrack = false;
                sevenTrack = false;
                eightTrack = false;
                if (sixTrack == false) {
                    v.setX(50 - transverse);
                    v.setY(250 - disparity);
                    sixTrack = true;
                    if (mGpsPistanceCar <= 83) {
                        v.setY(250 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 8.65f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 83) * 7.53f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity + (mGpsPistanceCar - 83) * 8.82f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 83) {
                        v.setY(250 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 8.65f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 83) * 7.53f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity + (mGpsPistanceCar - 83) * 8.82f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "7":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                threeTrack = false;
                fourTrack = false;
                fiveTrack = false;
                sixTrack = false;
                eightTrack = false;
                if (sevenTrack == false) {
                    v.setX(128 - transverse);
                    v.setY(250 - disparity);
                    sevenTrack = true;
                    if (mGpsPistanceCar <= 20) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (128 - transverse + mGpsPistanceCar * 3.84f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity - mGpsPistanceCar * 5f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 20 && mGpsPistanceCar <= 78) {
                        v.setY(150 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (205 - transverse + (mGpsPistanceCar - 20) * 9.71f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 78) * 2.91f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity + (mGpsPistanceCar - 78) * 7.95f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 20) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (128 - transverse + mGpsPistanceCar * 3.84f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity - mGpsPistanceCar * 5f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 20 && mGpsPistanceCar <= 78) {
                        v.setY(150 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (205 - transverse + (mGpsPistanceCar - 20) * 9.71f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (768 - transverse + (mGpsPistanceCar - 78) * 2.91f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity + (mGpsPistanceCar - 78) * 7.95f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "8":
                s1.setName("visible");
                s2.setName("gone");
                s3.setName("gone");
                oneTrack = false;
                twoTrack = false;
                threeTrack = false;
                fourTrack = false;
                sixTrack = false;
                fiveTrack = false;
                sevenTrack = false;
                if (eightTrack == false) {
                    v.setX(230 - transverse);
                    v.setY(150 - disparity);
                    eightTrack = true;
                    if (mGpsPistanceCar <= 21) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (230 - transverse + mGpsPistanceCar * 3.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity - mGpsPistanceCar * 4.76f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 21 && mGpsPistanceCar <= 76) {
                        v.setY(50 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (307 - transverse + (mGpsPistanceCar - 21) * 6.05f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 76) * 5.33f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (50 - disparity + (mGpsPistanceCar - 76) * 4.17f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 21) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (230 - transverse + mGpsPistanceCar * 3.67f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity - mGpsPistanceCar * 4.76f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 21 && mGpsPistanceCar <= 76) {
                        v.setY(50 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (307 - transverse + (mGpsPistanceCar - 21) * 6.05f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (640 - transverse + (mGpsPistanceCar - 76) * 5.33f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (50 - disparity + (mGpsPistanceCar - 76) * 4.17f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "9":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                ten = false;
                eleven = false;
                twelve = false;
                thirteen = false;
                fourteen = false;
                if (nine == false) {
                    nine = true;
                    v.setX(1000 - transverse);
                    v.setY(400 - disparity);
                    if (mGpsPistanceCar >= 81) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (1000 - transverse - (100 - mGpsPistanceCar) * 10.53f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else if (mGpsPistanceCar >= 43 && mGpsPistanceCar < 81) {
                        v.setX(800 - transverse);
                        v.setY(400 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse - (81 - mGpsPistanceCar) * 2.7f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity + (81 - mGpsPistanceCar) * 2.7f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar >= 0 && mGpsPistanceCar < 43) {
                        v.setY(500 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (700 - transverse - (43 - mGpsPistanceCar) * 4.76f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                } else {
                    if (mGpsPistanceCar >= 81) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (1000 - transverse - (100 - mGpsPistanceCar) * 10.53f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else if (mGpsPistanceCar >= 43 && mGpsPistanceCar < 81) {
                        v.setX(800 - transverse);
                        v.setY(400 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse - (81 - mGpsPistanceCar) * 2.7f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity + (81 - mGpsPistanceCar) * 2.7f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar >= 0 && mGpsPistanceCar < 43) {
                        v.setY(500 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (700 - transverse - (43 - mGpsPistanceCar) * 4.76f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                }
                break;
            case "10":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                nine = false;
                eleven = false;
                twelve = false;
                thirteen = false;
                fourteen = false;
                if (ten == false) {
                    ten = true;
                    v.setX(700 - transverse);
                    v.setY(500 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (700 - transverse + mGpsPistanceCar * 3f));
                    animator.setDuration(mTime);
                    animator.start();
                } else {
                    v.setY(500 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (700 - transverse + mGpsPistanceCar * 3f));
                    animator.setDuration(mTime);
                    animator.start();
                }
                break;
            case "11":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                nine = false;
                ten = false;
                twelve = false;
                thirteen = false;
                fourteen = false;
                if (eleven == false) {
                    eleven = true;
                    v.setX(600 - transverse);
                    v.setY(400 - disparity);
                    if (mGpsPistanceCar >= 77) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (600 - transverse - (100 - mGpsPistanceCar) * 2.17f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity - (100 - mGpsPistanceCar) * 4.35f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(300 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse - (76 - mGpsPistanceCar) * 6.58f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                } else {
                    if (mGpsPistanceCar >= 77) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (600 - transverse - (100 - mGpsPistanceCar) * 2.17f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity - (100 - mGpsPistanceCar) * 4.35f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(300 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse - (76 - mGpsPistanceCar) * 6.58f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                }
                break;
            case "12":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                nine = false;
                ten = false;
                eleven = false;
                thirteen = false;
                fourteen = false;
                if (twelve == false) {
                    twelve = true;
                    v.setX(500 - transverse);
                    v.setY(300 - disparity);
                    if (mGpsPistanceCar >= 76) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse - (100 - mGpsPistanceCar) * 2.08f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity - (100 - mGpsPistanceCar) * 4.17f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar >= 26 && mGpsPistanceCar < 76) {
                        v.setY(200 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse - (75 - mGpsPistanceCar) * 6.12f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (150 - transverse + (25 - mGpsPistanceCar) * 2f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (200 - disparity - (25 - mGpsPistanceCar) * 4f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar >= 76) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse - (100 - mGpsPistanceCar) * 2.08f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity - (100 - mGpsPistanceCar) * 4.17f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar >= 26 && mGpsPistanceCar < 76) {
                        v.setY(200 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse - (75 - mGpsPistanceCar) * 6.12f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (150 - transverse + (25 - mGpsPistanceCar) * 2f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (200 - disparity - (25 - mGpsPistanceCar) * 4f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "13":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                nine = false;
                ten = false;
                eleven = false;
                twelve = false;
                fourteen = false;
                if (thirteen == false) {
                    thirteen = true;
                    v.setX(800 - transverse);
                    v.setY(400 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse - (100 - mGpsPistanceCar) * 7.5f));
                    animator.setDuration(mTime);
                    animator.start();
                } else {
                    v.setY(400 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse - (100 - mGpsPistanceCar) * 7.5f));
                    animator.setDuration(mTime);
                    animator.start();
                }
                break;
            case "14":
                s2.setName("visible");
                s1.setName("gone");
                s3.setName("gone");
                nine = false;
                ten = false;
                eleven = false;
                twelve = false;
                thirteen = false;
                if (fourteen == false) {
                    fourteen = true;
                    v.setX(450 - transverse);
                    v.setY(400 - disparity);
                    if (mGpsPistanceCar >= 47) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse - (100 - mGpsPistanceCar) * 1.89f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity + (100 - mGpsPistanceCar) * 1.89f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(500 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (350 - transverse - (46 - mGpsPistanceCar) * 6.52f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                } else {
                    if (mGpsPistanceCar >= 47) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse - (100 - mGpsPistanceCar) * 1.89f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (400 - disparity + (100 - mGpsPistanceCar) * 1.89f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(500 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (350 - transverse - (46 - mGpsPistanceCar) * 6.52f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                }
                break;
            case "15":
                s3.setName("visible");
                s1.setName("gone");
                s2.setName("gone");
                sixteen = false;
                seventeen = false;
                eighteen = false;
                nineteen = false;
                if (fifteen == false) {
                    fifteen = true;
                    v.setX(50 - transverse);
                    v.setY(300 - disparity);
                    if (mGpsPistanceCar <= 42) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 10.71f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity + mGpsPistanceCar * 5.95f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setX(500 - transverse);
                        v.setY(550 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse + (mGpsPistanceCar - 43) * 5.26f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 42) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (50 - transverse + mGpsPistanceCar * 10.71f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (300 - disparity + mGpsPistanceCar * 5.95f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(550 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse + (mGpsPistanceCar - 43) * 5.26f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                }
                break;
            case "16":
                s3.setName("visible");
                s1.setName("gone");
                s2.setName("gone");
                fifteen = false;
                seventeen = false;
                eighteen = false;
                nineteen = false;
                if (sixteen == false) {
                    sixteen = true;
                    v.setX(450 - transverse);
                    v.setY(350 - disparity);
                    if (mGpsPistanceCar <= 30) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse + mGpsPistanceCar * 3.33f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity + mGpsPistanceCar * 3.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(450 - disparity);
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse + (mGpsPistanceCar - 31) * 4.93f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 30) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (450 - transverse + mGpsPistanceCar * 3.33f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity + mGpsPistanceCar * 3.33f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(450 - disparity);
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse + (mGpsPistanceCar - 31) * 4.93f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "17":
                s3.setName("visible");
                s1.setName("gone");
                s2.setName("gone");
                fifteen = false;
                sixteen = false;
                eighteen = false;
                nineteen = false;
                if (seventeen == false) {
                    seventeen = true;
                    v.setX(150 - transverse);
                    v.setY(150 - disparity);
                    if (mGpsPistanceCar <= 52) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (150 - transverse + mGpsPistanceCar * 4.81f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity + mGpsPistanceCar * 3.85f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setX(400 - transverse);
                        v.setY(350 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (400 - transverse + (mGpsPistanceCar - 53) * 8.51f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 52) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (150 - transverse + mGpsPistanceCar * 4.81f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (150 - disparity + mGpsPistanceCar * 3.85f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else {
                        v.setY(350 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (400 - transverse + (mGpsPistanceCar - 53) * 8.51f));
                        animator.setDuration(mTime);
                        animator.start();
                    }
                }
                break;
            case "18":
                s3.setName("visible");
                s1.setName("gone");
                s2.setName("gone");
                fifteen = false;
                sixteen = false;
                seventeen = false;
                eighteen = false;
                nineteen = false;
                if (eighteen == false) {
                    eighteen = true;
                    v.setX(500 - transverse);
                    v.setY(350 - disparity);
                    if (mGpsPistanceCar <= 8) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse + mGpsPistanceCar * 6.25f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity - mGpsPistanceCar * 12.5f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 8 && mGpsPistanceCar <= 79) {
                        v.setY(250 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse + (mGpsPistanceCar - 8) * 2.82f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (750 - transverse + (mGpsPistanceCar - 79) * 2.38f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity + (mGpsPistanceCar - 79) * 4.76f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                } else {
                    if (mGpsPistanceCar <= 8) {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (500 - transverse + mGpsPistanceCar * 6.25f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (350 - disparity - mGpsPistanceCar * 12.5f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    } else if (mGpsPistanceCar > 8 && mGpsPistanceCar <= 79) {
                        v.setY(250 - disparity);
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (550 - transverse + (mGpsPistanceCar - 8) * 2.82f));
                        animator.setDuration(mTime);
                        animator.start();
                    } else {
                        ObjectAnimator animator
                                = ObjectAnimator.ofFloat(v, "translationX", (float) (750 - transverse + (mGpsPistanceCar - 79) * 2.38f));
                        animator.setDuration(mTime);
                        animator.start();
                        ObjectAnimator animator1
                                = ObjectAnimator.ofFloat(v, "translationY", (float) (250 - disparity + (mGpsPistanceCar - 79) * 4.76f));
                        animator1.setDuration(mTime);
                        animator1.start();
                    }
                }
                break;
            case "19":
                s3.setName("visible");
                s1.setName("gone");
                s2.setName("gone");
                fifteen = false;
                sixteen = false;
                seventeen = false;
                eighteen = false;
                if (nineteen == false) {
                    nineteen = true;
                    v.setX(800 - transverse);
                    v.setY(350 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse + mGpsPistanceCar * 2f));
                    animator.setDuration(mTime);
                    animator.start();
                } else {
                    v.setY(350 - disparity);
                    ObjectAnimator animator
                            = ObjectAnimator.ofFloat(v, "translationX", (float) (800 - transverse + mGpsPistanceCar * 2f));
                    animator.setDuration(mTime);
                    animator.start();
                }
                break;
        }
    }
}
