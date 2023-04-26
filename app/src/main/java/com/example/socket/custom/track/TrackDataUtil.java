package com.example.socket.custom.track;

import com.example.socket.custom.data.Point3d;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2021/2/25 13:33
 * 西宁北股道数据
 */
public class TrackDataUtil {
    static HashMap<Integer, ArrayList<Point3d>> GPS = new HashMap<>();

    public static HashMap<Integer, ArrayList<Point3d>> getGps() {
        /**
         *[1]
         * count=18
         * 0=101.765904  36.667434 十进制度
         * 1=101.765935  36.667339 十进制度
         * 2=101.765958  36.667243 十进制度
         * 3=101.765988  36.667101 十进制度
         * 4=101.766023  36.666956 十进制度
         * 5=101.766062  36.666830 十进制度
         * 6=101.766121  36.666660 十进制度
         * 7=101.766206  36.666420 十进制度
         * 8=101.767750  36.662057 十进制度
         * 9=101.768745  36.659256 十进制度
         * 10=101.768771  36.659182 十进制度
         * 11=101.768799  36.659115 十进制度
         * 12=101.768838  36.659031 十进制度
         * 13=101.768871  36.658968 十进制度
         * 14=101.768899  36.658910 十进制度
         * 15=101.768932  36.658849 十进制度
         * 16=101.768969  36.658770 十进制度
         * 17=101.769017  36.658649 十进制度
         * */
        ArrayList<Point3d> array1 = new ArrayList<>();
        Point3d oneTrack0 = new Point3d(1, 101.765904, 36.667434);
        Point3d oneTrack1 = new Point3d(1, 101.765935, 36.667339);
        Point3d oneTrack2 = new Point3d(1, 101.765958, 36.667243);
        Point3d oneTrack3 = new Point3d(1, 101.765988, 36.667101);
        Point3d oneTrack4 = new Point3d(1, 101.766023, 36.666956);
        Point3d oneTrack5 = new Point3d(1, 101.766062, 36.666830);
        Point3d oneTrack6 = new Point3d(1, 101.766121, 36.666660);
        Point3d oneTrack7 = new Point3d(1, 101.766206, 36.666420);
        Point3d oneTrack8 = new Point3d(1, 101.767750, 36.662057);
        Point3d oneTrack9 = new Point3d(1, 101.768745, 36.659256);
        Point3d oneTrack10 = new Point3d(1, 101.768771, 36.659182);
        Point3d oneTrack11 = new Point3d(1, 101.768799, 36.659115);
        Point3d oneTrack12 = new Point3d(1, 101.768838, 36.659031);
        Point3d oneTrack13 = new Point3d(1, 101.768871, 36.658968);
        Point3d oneTrack14 = new Point3d(1, 101.768899, 36.658910);
        Point3d oneTrack15 = new Point3d(1, 101.768932, 36.658849);
        Point3d oneTrack16 = new Point3d(1, 101.768969, 36.658770);
        Point3d oneTrack17 = new Point3d(1, 101.769017, 36.658649);
        array1.add(oneTrack17);
        array1.add(oneTrack16);
        array1.add(oneTrack15);
        array1.add(oneTrack14);
        array1.add(oneTrack13);
        array1.add(oneTrack12);
        array1.add(oneTrack11);
        array1.add(oneTrack10);
        array1.add(oneTrack9);
        array1.add(oneTrack8);
        array1.add(oneTrack7);
        array1.add(oneTrack6);
        array1.add(oneTrack5);
        array1.add(oneTrack4);
        array1.add(oneTrack3);
        array1.add(oneTrack2);
        array1.add(oneTrack1);
        array1.add(oneTrack0);
        GPS.put(1, array1);

        /**
         *[2]
         * count=13
         * 0=101.765564  36.668399 十进制度
         * 1=101.765599  36.668297 十进制度
         * 2=101.765667  36.668105 十进制度
         * 3=101.765745  36.667888 十进制度
         * 4=101.765832  36.667644 十进制度
         * 5=101.765905  36.667435 十进制度
         * 6=101.766071  36.666966 十进制度
         * 7=101.766260  36.666430 十进制度
         * 8=101.767806  36.662066 十进制度
         * 9=101.768811  36.659232 十进制度
         * 10=101.768891  36.659009 十进制度
         * 11=101.769018  36.658649 十进制度
         * 12=101.769260  36.657968 十进制度
         * */
        ArrayList<Point3d> array2 = new ArrayList<>();
        Point3d twoTrack0 = new Point3d(2, 101.765564, 36.668399);
        Point3d twoTrack1 = new Point3d(2, 101.765599, 36.668297);
        Point3d twoTrack2 = new Point3d(2, 101.765667, 36.668105);
        Point3d twoTrack3 = new Point3d(2, 101.765745, 36.667888);
        Point3d twoTrack4 = new Point3d(2, 101.765832, 36.667644);
        Point3d twoTrack5 = new Point3d(2, 101.765905, 36.667435);
        Point3d twoTrack6 = new Point3d(2, 101.766071, 36.666966);
        Point3d twoTrack7 = new Point3d(2, 101.766260, 36.666430);
        Point3d twoTrack8 = new Point3d(2, 101.767806, 36.662066);
        Point3d twoTrack9 = new Point3d(2, 101.768811, 36.659232);
        Point3d twoTrack10 = new Point3d(2, 101.768891, 36.659009);
        Point3d twoTrack11 = new Point3d(2, 101.769018, 36.658649);
        Point3d twoTrack12 = new Point3d(2, 101.769260, 36.657968);
        array2.add(twoTrack12);
        array2.add(twoTrack11);
        array2.add(twoTrack10);
        array2.add(twoTrack9);
        array2.add(twoTrack8);
        array2.add(twoTrack7);
        array2.add(twoTrack6);
        array2.add(twoTrack5);
        array2.add(twoTrack4);
        array2.add(twoTrack3);
        array2.add(twoTrack2);
        array2.add(twoTrack1);
        array2.add(twoTrack0);
        GPS.put(2, array2);

        /**
         *[3]
         * count=10
         * 0=101.765617  36.668411 十进制度
         * 1=101.765637  36.668354 十进制度
         * 2=101.765794  36.667915 十进制度
         * 3=101.765948  36.667481 十进制度
         * 4=101.766126  36.666978 十进制度
         * 5=101.766317  36.666439 十进制度
         * 6=101.767861  36.662076 十进制度
         * 7=101.768852  36.659279 十进制度
         * 8=101.769248  36.658165 十进制度
         * 9=101.769313  36.657980 十进制度
         * */
        ArrayList<Point3d> array3 = new ArrayList<>();
        Point3d threeTrack0 = new Point3d(3, 101.765617, 36.668411);
        Point3d threeTrack1 = new Point3d(3, 101.765637, 36.668354);
        Point3d threeTrack2 = new Point3d(3, 101.765794, 36.667915);
        Point3d threeTrack3 = new Point3d(3, 101.765948, 36.667481);
        Point3d threeTrack4 = new Point3d(3, 101.766126, 36.666978);
        Point3d threeTrack5 = new Point3d(3, 101.766317, 36.666439);
        Point3d threeTrack6 = new Point3d(3, 101.767861, 36.662076);
        Point3d threeTrack7 = new Point3d(3, 101.768852, 36.659279);
        Point3d threeTrack8 = new Point3d(3, 101.769248, 36.658165);
        Point3d threeTrack9 = new Point3d(3, 101.769313, 36.657980);
        array3.add(threeTrack9);
        array3.add(threeTrack8);
        array3.add(threeTrack7);
        array3.add(threeTrack6);
        array3.add(threeTrack5);
        array3.add(threeTrack4);
        array3.add(threeTrack3);
        array3.add(threeTrack2);
        array3.add(threeTrack1);
        array3.add(threeTrack0);
        GPS.put(3, array3);

        /**
         * [4]
         * count=14
         * 0=101.765794  36.667914 十进制度
         * 1=101.765850  36.667775 十进制度
         * 2=101.765909  36.667644 十进制度
         * 3=101.765995  36.667462 十进制度
         * 4=101.766070  36.667293 十进制度
         * 5=101.766145  36.667091 十进制度
         * 6=101.766225  36.666862 十进制度
         * 7=101.766371  36.666451 十进制度
         * 8=101.767915  36.662090 十进制度
         * 9=101.768910  36.659280 十进制度
         * 10=101.769029  36.658947 十进制度
         * 11=101.769108  36.658683 十进制度
         * 12=101.769164  36.658455 十进制度
         * 13=101.769246  36.658170 十进制度
         * */
        ArrayList<Point3d> array4 = new ArrayList<>();
        Point3d fourTrack0 = new Point3d(4, 101.765794, 36.667914);
        Point3d fourTrack1 = new Point3d(4, 101.765850, 36.667775);
        Point3d fourTrack2 = new Point3d(4, 101.765909, 36.667644);
        Point3d fourTrack3 = new Point3d(4, 101.765995, 36.667462);
        Point3d fourTrack4 = new Point3d(4, 101.766070, 36.667293);
        Point3d fourTrack5 = new Point3d(4, 101.766145, 36.667091);
        Point3d fourTrack6 = new Point3d(4, 101.766225, 36.666862);
        Point3d fourTrack7 = new Point3d(4, 101.766371, 36.666451);
        Point3d fourTrack8 = new Point3d(4, 101.767915, 36.662090);
        Point3d fourTrack9 = new Point3d(4, 101.768910, 36.659280);
        Point3d fourTrack10 = new Point3d(4, 101.769029, 36.658947);
        Point3d fourTrack11 = new Point3d(4, 101.769108, 36.658683);
        Point3d fourTrack12 = new Point3d(4, 101.769164, 36.658455);
        Point3d fourTrack13 = new Point3d(4, 101.769246, 36.658170);
        array4.add(fourTrack13);
        array4.add(fourTrack12);
        array4.add(fourTrack11);
        array4.add(fourTrack10);
        array4.add(fourTrack9);
        array4.add(fourTrack8);
        array4.add(fourTrack7);
        array4.add(fourTrack6);
        array4.add(fourTrack5);
        array4.add(fourTrack4);
        array4.add(fourTrack3);
        array4.add(fourTrack2);
        array4.add(fourTrack1);
        array4.add(fourTrack0);
        GPS.put(4, array4);

        /**
         *[5]
         * count=12
         * 0=101.766016  36.667417 十进制度
         * 1=101.766078  36.667285 十进制度
         * 2=101.766152  36.667127 十进制度
         * 3=101.766268  36.666879 十进制度
         * 4=101.766359  36.666666 十进制度
         * 5=101.766433  36.666460 十进制度
         * 6=101.768002  36.662022 十进制度
         * 7=101.768853  36.659626 十进制度
         * 8=101.768913  36.659450 十进制度
         * 9=101.768956  36.659304 十进制度
         * 10=101.769035  36.658987 十进制度
         * 11=101.769108  36.658684 十进制度
         * */
        ArrayList<Point3d> array5 = new ArrayList<>();
        Point3d fiveTrack0 = new Point3d(5, 101.766016, 36.667417);
        Point3d fiveTrack1 = new Point3d(5, 101.766078, 36.667285);
        Point3d fiveTrack2 = new Point3d(5, 101.766152, 36.667127);
        Point3d fiveTrack3 = new Point3d(5, 101.766268, 36.666879);
        Point3d fiveTrack4 = new Point3d(5, 101.766359, 36.666666);
        Point3d fiveTrack5 = new Point3d(5, 101.766433, 36.666460);
        Point3d fiveTrack6 = new Point3d(5, 101.768002, 36.662022);
        Point3d fiveTrack7 = new Point3d(5, 101.768853, 36.659626);
        Point3d fiveTrack8 = new Point3d(5, 101.768913, 36.659450);
        Point3d fiveTrack9 = new Point3d(5, 101.768956, 36.659304);
        Point3d fiveTrack10 = new Point3d(5, 101.769035, 36.658987);
        Point3d fiveTrack11 = new Point3d(5, 101.769108, 36.658684);
        array5.add(fiveTrack11);
        array5.add(fiveTrack10);
        array5.add(fiveTrack9);
        array5.add(fiveTrack8);
        array5.add(fiveTrack7);
        array5.add(fiveTrack6);
        array5.add(fiveTrack5);
        array5.add(fiveTrack4);
        array5.add(fiveTrack3);
        array5.add(fiveTrack2);
        array5.add(fiveTrack1);
        array5.add(fiveTrack0);
        GPS.put(5, array5);

        /**
         *[6]
         * count=15
         * 0=101.765343  36.670503 十进制度
         * 1=101.765386  36.670375 十进制度
         * 2=101.765454  36.670182 十进制度
         * 3=101.765691  36.669512 十进制度
         * 4=101.766308  36.667773 十进制度
         * 5=101.769011  36.660138 十进制度
         * 6=101.769134  36.659784 十进制度
         * 7=101.769184  36.659589 十进制度
         * 8=101.769214  36.659422 十进制度
         * 9=101.769236  36.659226 十进制度
         * 10=101.769303  36.658579 十进制度
         * 11=101.769339  36.658343 十进制度
         * 12=101.769449  36.657889 十进制度
         * 13=101.769541  36.657516 十进制度
         * 14=101.769599  36.657283 十进制度
         * */
        ArrayList<Point3d> array6 = new ArrayList<>();
        Point3d sixTrack0 = new Point3d(6, 101.765343, 36.670503);
        Point3d sixTrack1 = new Point3d(6, 101.765386, 36.670375);
        Point3d sixTrack2 = new Point3d(6, 101.765454, 36.670182);
        Point3d sixTrack3 = new Point3d(6, 101.765691, 36.669512);
        Point3d sixTrack4 = new Point3d(6, 101.766308, 36.667773);
        Point3d sixTrack5 = new Point3d(6, 101.769011, 36.660138);
        Point3d sixTrack6 = new Point3d(6, 101.769134, 36.659784);
        Point3d sixTrack7 = new Point3d(6, 101.769184, 36.659589);
        Point3d sixTrack8 = new Point3d(6, 101.769214, 36.659422);
        Point3d sixTrack9 = new Point3d(6, 101.769236, 36.659226);
        Point3d sixTrack10 = new Point3d(6, 101.769303, 36.658579);
        Point3d sixTrack11 = new Point3d(6, 101.769339, 36.658343);
        Point3d sixTrack12 = new Point3d(6, 101.769449, 36.657889);
        Point3d sixTrack13 = new Point3d(6, 101.769541, 36.657516);
        Point3d sixTrack14 = new Point3d(6, 101.769599, 36.657283);
        array6.add(sixTrack14);
        array6.add(sixTrack13);
        array6.add(sixTrack12);
        array6.add(sixTrack11);
        array6.add(sixTrack10);
        array6.add(sixTrack9);
        array6.add(sixTrack8);
        array6.add(sixTrack7);
        array6.add(sixTrack6);
        array6.add(sixTrack5);
        array6.add(sixTrack4);
        array6.add(sixTrack3);
        array6.add(sixTrack2);
        array6.add(sixTrack1);
        array6.add(sixTrack0);
        GPS.put(6, array6);

        /**
         *[7]
         * count=32
         * 0=101.765387  36.670374 十进制度
         * 1=101.765450  36.670220 十进制度
         * 2=101.765499  36.670125 十进制度
         * 3=101.765614  36.669897 十进制度
         * 4=101.765751  36.669640 十进制度
         * 5=101.765845  36.669489 十进制度
         * 6=101.765982  36.669308 十进制度
         * 7=101.766173  36.669098 十进制度
         * 8=101.766523  36.668792 十进制度
         * 9=101.766799  36.668538 十进制度
         * 10=101.766957  36.668357 十进制度
         * 11=101.767116  36.668138 十进制度
         * 12=101.767216  36.667977 十进制度
         * 13=101.767295  36.667824 十进制度
         * 14=101.767408  36.667516 十进制度
         * 15=101.768742  36.663744 十进制度
         * 16=101.769845  36.660631 十进制度
         * 17=101.769891  36.660478 十进制度
         * 18=101.769936  36.660224 十进制度
         * 19=101.769947  36.660011 十进制度
         * 20=101.769940  36.659800 十进制度
         * 21=101.769916  36.659601 十进制度
         * 22=101.769858  36.659350 十进制度
         * 23=101.769800  36.659175 十进制度
         * 24=101.769671  36.658860 十进制度
         * 25=101.769602  36.658648 十进制度
         * 26=101.769558  36.658458 十进制度
         * 27=101.769531  36.658234 十进制度
         * 28=101.769526  36.657990 十进制度
         * 29=101.769541  36.657794 十进制度
         * 30=101.769572  36.657516 十进制度
         * 31=101.769600  36.657283 十进制度
         * */
        ArrayList<Point3d> array7 = new ArrayList<>();
        Point3d sevenTrack0 = new Point3d(7, 101.765387, 36.670374);
        Point3d sevenTrack1 = new Point3d(7, 101.765450, 36.670220);
        Point3d sevenTrack2 = new Point3d(7, 101.765499, 36.670125);
        Point3d sevenTrack3 = new Point3d(7, 101.765614, 36.669897);
        Point3d sevenTrack4 = new Point3d(7, 101.765751, 36.669640);
        Point3d sevenTrack5 = new Point3d(7, 101.765845, 36.669489);
        Point3d sevenTrack6 = new Point3d(7, 101.765982, 36.669308);
        Point3d sevenTrack7 = new Point3d(7, 101.766173, 36.669098);
        Point3d sevenTrack8 = new Point3d(7, 101.766523, 36.668792);
        Point3d sevenTrack9 = new Point3d(7, 101.766799, 36.668538);
        Point3d sevenTrack10 = new Point3d(7, 101.766957, 36.668357);
        Point3d sevenTrack11 = new Point3d(7, 101.767116, 36.668138);
        Point3d sevenTrack12 = new Point3d(7, 101.767216, 36.667977);
        Point3d sevenTrack13 = new Point3d(7, 101.767295, 36.667824);
        Point3d sevenTrack14 = new Point3d(7, 101.767408, 36.667516);
        Point3d sevenTrack15 = new Point3d(7, 101.768742, 36.663744);
        Point3d sevenTrack16 = new Point3d(7, 101.769845, 36.660631);
        Point3d sevenTrack17 = new Point3d(7, 101.769891, 36.660478);
        Point3d sevenTrack18 = new Point3d(7, 101.769936, 36.660224);
        Point3d sevenTrack19 = new Point3d(7, 101.769947, 36.660011);
        Point3d sevenTrack20 = new Point3d(7, 101.769940, 36.659800);
        Point3d sevenTrack21 = new Point3d(7, 101.769916, 36.659601);
        Point3d sevenTrack22 = new Point3d(7, 101.769858, 36.659350);
        Point3d sevenTrack23 = new Point3d(7, 101.769800, 36.659175);
        Point3d sevenTrack24 = new Point3d(7, 101.769671, 36.658860);
        Point3d sevenTrack25 = new Point3d(7, 101.769602, 36.658648);
        Point3d sevenTrack26 = new Point3d(7, 101.769558, 36.658458);
        Point3d sevenTrack27 = new Point3d(7, 101.769531, 36.658234);
        Point3d sevenTrack28 = new Point3d(7, 101.769526, 36.657990);
        Point3d sevenTrack29 = new Point3d(7, 101.769541, 36.657794);
        Point3d sevenTrack30 = new Point3d(7, 101.769572, 36.657516);
        Point3d sevenTrack31 = new Point3d(7, 101.769600, 36.657283);
        array7.add(sevenTrack31);
        array7.add(sevenTrack30);
        array7.add(sevenTrack29);
        array7.add(sevenTrack28);
        array7.add(sevenTrack27);
        array7.add(sevenTrack26);
        array7.add(sevenTrack25);
        array7.add(sevenTrack24);
        array7.add(sevenTrack23);
        array7.add(sevenTrack22);
        array7.add(sevenTrack21);
        array7.add(sevenTrack20);
        array7.add(sevenTrack19);
        array7.add(sevenTrack18);
        array7.add(sevenTrack17);
        array7.add(sevenTrack16);
        array7.add(sevenTrack15);
        array7.add(sevenTrack14);
        array7.add(sevenTrack13);
        array7.add(sevenTrack12);
        array7.add(sevenTrack11);
        array7.add(sevenTrack10);
        array7.add(sevenTrack9);
        array7.add(sevenTrack8);
        array7.add(sevenTrack7);
        array7.add(sevenTrack6);
        array7.add(sevenTrack5);
        array7.add(sevenTrack4);
        array7.add(sevenTrack3);
        array7.add(sevenTrack2);
        array7.add(sevenTrack1);
        array7.add(sevenTrack0);
        GPS.put(7, array7);

        /**
         * [8]
         * count=32
         * 0=101.765523  36.670078 十进制度
         * 1=101.765604  36.669935 十进制度
         * 2=101.765740  36.669737 十进制度
         * 3=101.765913  36.669523 十进制度
         * 4=101.766089  36.669349 十进制度
         * 5=101.766291  36.669189 十进制度
         * 6=101.766501  36.669051 十进制度
         * 7=101.767000  36.668785 十进制度
         * 8=101.767292  36.668590 十进制度
         * 9=101.767445  36.668463 十进制度
         * 10=101.767556  36.668356 十进制度
         * 11=101.767773  36.668109 十进制度
         * 12=101.767935  36.667863 十进制度
         * 13=101.768032  36.667638 十进制度
         * 14=101.769398  36.663776 十进制度
         * 15=101.770389  36.660984 十进制度
         * 16=101.770431  36.660836 十进制度
         * 17=101.770464  36.660685 十进制度
         * 18=101.770490  36.660541 十进制度
         * 19=101.770508  36.660302 十进制度
         * 20=101.770498  36.660100 十进制度
         * 21=101.770445  36.659806 十进制度
         * 22=101.770346  36.659535 十进制度
         * 23=101.770144  36.659178 十进制度
         * 24=101.769881  36.658820 十进制度
         * 25=101.769778  36.658643 十进制度
         * 26=101.769714  36.658503 十进制度
         * 27=101.769662  36.658367 十进制度
         * 28=101.769606  36.658153 十进制度
         * 29=101.769579  36.657990 十进制度
         * 30=101.769564  36.657748 十进制度
         * 31=101.769572  36.657517 十进制度
         * */
        ArrayList<Point3d> array8 = new ArrayList<>();
        Point3d eightTrack0 = new Point3d(8, 101.765523, 36.670078);
        Point3d eightTrack1 = new Point3d(8, 101.765604, 36.669935);
        Point3d eightTrack2 = new Point3d(8, 101.765740, 36.669737);
        Point3d eightTrack3 = new Point3d(8, 101.765913, 36.669523);
        Point3d eightTrack4 = new Point3d(8, 101.766089, 36.669349);
        Point3d eightTrack5 = new Point3d(8, 101.766291, 36.669189);
        Point3d eightTrack6 = new Point3d(8, 101.766501, 36.669051);
        Point3d eightTrack7 = new Point3d(8, 101.767000, 36.668785);
        Point3d eightTrack8 = new Point3d(8, 101.767292, 36.668590);
        Point3d eightTrack9 = new Point3d(8, 101.767445, 36.668463);
        Point3d eightTrack10 = new Point3d(8, 101.767556, 36.668356);
        Point3d eightTrack11 = new Point3d(8, 101.767773, 36.668109);
        Point3d eightTrack12 = new Point3d(8, 101.767935, 36.667863);
        Point3d eightTrack13 = new Point3d(8, 101.768032, 36.667638);
        Point3d eightTrack14 = new Point3d(8, 101.769398, 36.663776);
        Point3d eightTrack15 = new Point3d(8, 101.770390, 36.660980);
        Point3d eightTrack16 = new Point3d(8, 101.770466, 36.660766);
        Point3d eightTrack17 = new Point3d(8, 101.770547, 36.660539);
        Point3d eightTrack18 = new Point3d(8, 101.770662, 36.660213);
        Point3d eightTrack19 = new Point3d(8, 101.770752, 36.659954);
        array8.add(eightTrack19);
        array8.add(eightTrack18);
        array8.add(eightTrack17);
        array8.add(eightTrack16);
        array8.add(eightTrack15);
        array8.add(eightTrack14);
        array8.add(eightTrack13);
        array8.add(eightTrack12);
        array8.add(eightTrack11);
        array8.add(eightTrack10);
        array8.add(eightTrack9);
        array8.add(eightTrack8);
        array8.add(eightTrack7);
        array8.add(eightTrack6);
        array8.add(eightTrack5);
        array8.add(eightTrack4);
        array8.add(eightTrack3);
        array8.add(eightTrack2);
        array8.add(eightTrack1);
        array8.add(eightTrack0);
        GPS.put(8, array8);

        //长丰
        ArrayList<Point3d> array9 = new ArrayList<>();
        Point3d nineTrack1 = new Point3d(9, 101.765878, 36.667509);//头右边
        Point3d nineTrack2 = new Point3d(9, 101.765744, 36.667891);
        Point3d nineTrack3 = new Point3d(9, 101.765744, 36.667891);
        Point3d nineTrack4 = new Point3d(9, 101.765622, 36.668227);
        Point3d nineTrack5 = new Point3d(9, 101.765563, 36.668397);
        Point3d nineTrack6 = new Point3d(9, 101.765500, 36.668552);
        Point3d nineTrack7 = new Point3d(9, 101.765466, 36.668618);
        Point3d nineTrack8 = new Point3d(9, 101.765392, 36.668760);
        Point3d nineTrack9 = new Point3d(9, 101.765323, 36.668894);
        Point3d nineTrack10 = new Point3d(9, 101.765223, 36.669092);
        Point3d nineTrack11 = new Point3d(9, 101.765137, 36.669272);
        Point3d nineTrack12 = new Point3d(9, 101.765039, 36.669505);
        Point3d nineTrack13 = new Point3d(9, 101.765083, 36.669398);
        Point3d nineTrack14 = new Point3d(9, 101.764864, 36.670000);
        Point3d nineTrack15 = new Point3d(9, 101.764794, 36.670205);
        Point3d nineTrack16 = new Point3d(9, 101.764727, 36.670399);
        Point3d nineTrack17 = new Point3d(9, 101.764687, 36.670513);
        Point3d nineTrack18 = new Point3d(9, 101.764652, 36.670616);//弯点
        Point3d nineTrack19 = new Point3d(9, 101.764586, 36.670809);
        Point3d nineTrack20 = new Point3d(9, 101.764427, 36.671260);
        Point3d nineTrack21 = new Point3d(9, 101.764238, 36.671810);
        Point3d nineTrack22 = new Point3d(9, 101.764185, 36.671960);
        Point3d nineTrack23 = new Point3d(9, 101.764139, 36.672084);
        Point3d nineTrack24 = new Point3d(9, 101.764063, 36.672251);
        Point3d nineTrack25 = new Point3d(9, 101.763988, 36.672390);
        Point3d nineTrack26 = new Point3d(9, 101.763917, 36.672503);
        Point3d nineTrack27 = new Point3d(9, 101.763849, 36.672602);
        Point3d nineTrack28 = new Point3d(9, 101.763587, 36.672909);
        array9.add(nineTrack1);
        array9.add(nineTrack2);
        array9.add(nineTrack3);
        array9.add(nineTrack4);
        array9.add(nineTrack5);
        array9.add(nineTrack6);
        array9.add(nineTrack7);
        array9.add(nineTrack8);
        array9.add(nineTrack9);
        array9.add(nineTrack10);
        array9.add(nineTrack11);
        array9.add(nineTrack12);
        array9.add(nineTrack13);
        array9.add(nineTrack14);
        array9.add(nineTrack15);
        array9.add(nineTrack16);
        array9.add(nineTrack17);
        array9.add(nineTrack18);
        array9.add(nineTrack19);
        array9.add(nineTrack20);
        array9.add(nineTrack21);
        array9.add(nineTrack22);
        array9.add(nineTrack23);
        array9.add(nineTrack24);
        array9.add(nineTrack25);
        array9.add(nineTrack26);
        array9.add(nineTrack27);
        array9.add(nineTrack28);
        GPS.put(9, array9);

        //长丰
        ArrayList<Point3d> array10 = new ArrayList<>();
        Point3d tenTrack0 = new Point3d(10, 101.764644, 36.670582);//弯道
        Point3d tenTrack1 = new Point3d(10, 101.764711, 36.670247);
        Point3d tenTrack2 = new Point3d(10, 101.764779, 36.669919);
        Point3d tenTrack3 = new Point3d(10, 101.764824, 36.669748);
        Point3d tenTrack4 = new Point3d(10, 101.764871, 36.669607);
        Point3d tenTrack5 = new Point3d(10, 101.764971, 36.669374);
        Point3d tenTrack6 = new Point3d(10, 101.765144, 36.669012);
        Point3d tenTrack7 = new Point3d(10, 101.765320, 36.668651);
        Point3d tenTrack8 = new Point3d(10, 101.765410, 36.668448);
        Point3d tenTrack9 = new Point3d(10, 101.765739, 36.667518);
        Point3d tenTrack10 = new Point3d(10, 101.765784, 36.667362);
        Point3d tenTrack11 = new Point3d(10, 101.765833, 36.667099);
        Point3d tenTrack12 = new Point3d(10, 101.765890, 36.666538);
        Point3d tenTrack13 = new Point3d(10, 101.766000, 36.665431);
        Point3d tenTrack14 = new Point3d(10, 101.766080, 36.664621);
        Point3d tenTrack15 = new Point3d(10, 101.766137, 36.664042);
        array10.add(tenTrack15);
        array10.add(tenTrack14);
        array10.add(tenTrack13);
        array10.add(tenTrack12);
        array10.add(tenTrack11);
        array10.add(tenTrack10);
        array10.add(tenTrack9);
        array10.add(tenTrack8);
        array10.add(tenTrack7);
        array10.add(tenTrack6);
        array10.add(tenTrack5);
        array10.add(tenTrack4);
        array10.add(tenTrack3);
        array10.add(tenTrack2);
        array10.add(tenTrack1);
        array10.add(tenTrack0);
        GPS.put(10, array10);

        //园1
        ArrayList<Point3d> array11 = new ArrayList<>();
        Point3d elevenTrack0 = new Point3d(11, 101.765483, 36.668621);
        Point3d elevenTrack1 = new Point3d(11, 101.765395, 36.668871);
        Point3d elevenTrack2 = new Point3d(11, 101.765243, 36.669477);
        Point3d elevenTrack3 = new Point3d(11, 101.765340, 36.669038);
        Point3d elevenTrack4 = new Point3d(11, 101.765192, 36.669709);
        Point3d elevenTrack5 = new Point3d(11, 101.765144, 36.669958);//弯点
        Point3d elevenTrack6 = new Point3d(11, 101.765099, 36.670334);
        Point3d elevenTrack7 = new Point3d(11, 101.765100, 36.671014);
        Point3d elevenTrack8 = new Point3d(11, 101.765107, 36.671125);
        Point3d elevenTrack9 = new Point3d(11, 101.765103, 36.671353);
        Point3d elevenTrack10 = new Point3d(11, 101.765052, 36.672033);
        Point3d elevenTrack11 = new Point3d(11, 101.765077, 36.671701);
        Point3d elevenTrack12 = new Point3d(11, 101.765022, 36.672434);
        Point3d elevenTrack13 = new Point3d(11, 101.764996, 36.672777);
        Point3d elevenTrack14 = new Point3d(11, 101.764976, 36.672978);
        Point3d elevenTrack15 = new Point3d(11, 101.764948, 36.673173);
        Point3d elevenTrack16 = new Point3d(11, 101.764883, 36.673541);
        Point3d elevenTrack17 = new Point3d(11, 101.764851, 36.673701);
        Point3d elevenTrack18 = new Point3d(11, 101.764723, 36.674105);
        Point3d elevenTrack19 = new Point3d(11, 101.764569, 36.674584);
        array11.add(elevenTrack0);
        array11.add(elevenTrack1);
        array11.add(elevenTrack2);
        array11.add(elevenTrack3);
        array11.add(elevenTrack4);
        array11.add(elevenTrack5);
        array11.add(elevenTrack6);
        array11.add(elevenTrack7);
        array11.add(elevenTrack8);
        array11.add(elevenTrack9);
        array11.add(elevenTrack10);
        array11.add(elevenTrack11);
        array11.add(elevenTrack12);
        array11.add(elevenTrack13);
        array11.add(elevenTrack14);
        array11.add(elevenTrack15);
        array11.add(elevenTrack16);
        array11.add(elevenTrack17);
        array11.add(elevenTrack18);
        array11.add(elevenTrack19);
        GPS.put(11, array11);

        //园2
        ArrayList<Point3d> array12 = new ArrayList<>();
        Point3d twelveTrack0 = new Point3d(12, 101.765122, 36.671352);
        Point3d twelveTrack1 = new Point3d(12, 101.765144, 36.671701);
        Point3d twelveTrack2 = new Point3d(12, 101.765154, 36.671887);//弯点
        Point3d twelveTrack3 = new Point3d(12, 101.765157, 36.672073);
        Point3d twelveTrack4 = new Point3d(12, 101.765153, 36.672264);
        Point3d twelveTrack5 = new Point3d(12, 101.765139, 36.672473);
        Point3d twelveTrack6 = new Point3d(12, 101.765120, 36.672642);
        Point3d twelveTrack7 = new Point3d(12, 101.765098, 36.672787);//正常
        Point3d twelveTrack8 = new Point3d(12, 101.765061, 36.672982);//弯点
        Point3d twelveTrack9 = new Point3d(12, 101.765013, 36.673181);
        Point3d twelveTrack10 = new Point3d(12, 101.764986, 36.673283);
        Point3d twelveTrack11 = new Point3d(12, 101.764953, 36.673389);
        Point3d twelveTrack12 = new Point3d(12, 101.764905, 36.673545);
        array12.add(twelveTrack0);
        array12.add(twelveTrack1);
        array12.add(twelveTrack2);
        array12.add(twelveTrack3);
        array12.add(twelveTrack4);
        array12.add(twelveTrack5);
        array12.add(twelveTrack6);
        array12.add(twelveTrack7);
        array12.add(twelveTrack8);
        array12.add(twelveTrack9);
        array12.add(twelveTrack10);
        array12.add(twelveTrack11);
        array12.add(twelveTrack12);
        GPS.put(12, array12);

        //煤2
        ArrayList<Point3d> array13 = new ArrayList<>();
        Point3d thirteenTrack0 = new Point3d(13, 101.765293, 36.669162);
        Point3d thirteenTrack1 = new Point3d(13, 101.765158, 36.669550);
        Point3d thirteenTrack2 = new Point3d(13, 101.765033, 36.669939);
        Point3d thirteenTrack3 = new Point3d(13, 101.764899, 36.670338);
        Point3d thirteenTrack4 = new Point3d(13, 101.764759, 36.670737);
        Point3d thirteenTrack5 = new Point3d(13, 101.764628, 36.671113);
        Point3d thirteenTrack6 = new Point3d(13, 101.764499, 36.671484);
        Point3d thirteenTrack7 = new Point3d(13, 101.764370, 36.671855);
        Point3d thirteenTrack8 = new Point3d(13, 101.764238, 36.672232);
        Point3d thirteenTrack9 = new Point3d(13, 101.764189, 36.672362);
        Point3d thirteenTrack10 = new Point3d(13, 101.764114, 36.672511);
        Point3d thirteenTrack11 = new Point3d(13, 101.764033, 36.672639);
        Point3d thirteenTrack12 = new Point3d(13, 101.763933, 36.672769);
        Point3d thirteenTrack13 = new Point3d(13, 101.763758, 36.672968);
        Point3d thirteenTrack14 = new Point3d(13, 101.763634, 36.673125);
        Point3d thirteenTrack15 = new Point3d(13, 101.763503, 36.673319);
        Point3d thirteenTrack16 = new Point3d(13, 101.763417, 36.673482);
        Point3d thirteenTrack17 = new Point3d(13, 101.763357, 36.673635);
        Point3d thirteenTrack18 = new Point3d(13, 101.763314, 36.673790);
        Point3d thirteenTrack19 = new Point3d(13, 101.763286, 36.673963);
        Point3d thirteenTrack20 = new Point3d(13, 101.763280, 36.674137);
        Point3d thirteenTrack21 = new Point3d(13, 101.763293, 36.674313);
        Point3d thirteenTrack22 = new Point3d(13, 101.763322, 36.674683);
        Point3d thirteenTrack23 = new Point3d(13, 101.763354, 36.675076);
        Point3d thirteenTrack24 = new Point3d(13, 101.763381, 36.675421);
        Point3d thirteenTrack25 = new Point3d(13, 101.763411, 36.675791);
        array13.add(thirteenTrack0);
        array13.add(thirteenTrack1);
        array13.add(thirteenTrack2);
        array13.add(thirteenTrack3);
        array13.add(thirteenTrack4);
        array13.add(thirteenTrack5);
        array13.add(thirteenTrack6);
        array13.add(thirteenTrack7);
        array13.add(thirteenTrack8);
        array13.add(thirteenTrack9);
        array13.add(thirteenTrack10);
        array13.add(thirteenTrack11);
        array13.add(thirteenTrack12);
        array13.add(thirteenTrack13);
        array13.add(thirteenTrack14);
        array13.add(thirteenTrack15);
        array13.add(thirteenTrack16);
        array13.add(thirteenTrack17);
        array13.add(thirteenTrack18);
        array13.add(thirteenTrack19);
        array13.add(thirteenTrack20);
        array13.add(thirteenTrack21);
        array13.add(thirteenTrack22);
        array13.add(thirteenTrack23);
        array13.add(thirteenTrack24);
        array13.add(thirteenTrack25);
        GPS.put(13, array13);

        //煤1
        ArrayList<Point3d> array14 = new ArrayList<>();
        Point3d fourteenTrack0 = new Point3d(14, 101.763620, 36.673123);
        Point3d fourteenTrack1 = new Point3d(14, 101.763267, 36.673519);
        Point3d fourteenTrack2 = new Point3d(14, 101.763089, 36.673718);
        Point3d fourteenTrack3 = new Point3d(14, 101.762951, 36.673883);
        Point3d fourteenTrack4 = new Point3d(14, 101.762843, 36.674031);
        Point3d fourteenTrack5 = new Point3d(14, 101.762742, 36.674182);
        Point3d fourteenTrack6 = new Point3d(14, 101.762642, 36.674351);
        Point3d fourteenTrack7 = new Point3d(14, 101.762475, 36.674707);//弯点
        Point3d fourteenTrack8 = new Point3d(14, 101.762366, 36.675028);
        Point3d fourteenTrack9 = new Point3d(14, 101.762293, 36.675367);
        Point3d fourteenTrack10 = new Point3d(14, 101.762254, 36.675733);
        Point3d fourteenTrack11 = new Point3d(14, 101.762221, 36.676100);
        Point3d fourteenTrack12 = new Point3d(14, 101.762190, 36.676453);
        array14.add(fourteenTrack0);
        array14.add(fourteenTrack1);
        array14.add(fourteenTrack2);
        array14.add(fourteenTrack3);
        array14.add(fourteenTrack4);
        array14.add(fourteenTrack5);
        array14.add(fourteenTrack6);
        array14.add(fourteenTrack7);
        array14.add(fourteenTrack8);
        array14.add(fourteenTrack9);
        array14.add(fourteenTrack10);
        array14.add(fourteenTrack11);
        array14.add(fourteenTrack12);
        GPS.put(14, array14);

        //百立
        ArrayList<Point3d> array15 = new ArrayList<>();
        Point3d fifteenTrack0 = new Point3d(15, 101.768952, 36.658625);//尾左边
        Point3d fifteenTrack1 = new Point3d(15, 101.768987, 36.658450);
        Point3d fifteenTrack2 = new Point3d(15, 101.769010, 36.658223);
        Point3d fifteenTrack3 = new Point3d(15, 101.769010, 36.658068);
        Point3d fifteenTrack4 = new Point3d(15, 101.768999, 36.657948);
        Point3d fifteenTrack5 = new Point3d(15, 101.768982, 36.657831);
        Point3d fifteenTrack6 = new Point3d(15, 101.768947, 36.657655);
        Point3d fifteenTrack7 = new Point3d(15, 101.768916, 36.657501);
        Point3d fifteenTrack8 = new Point3d(15, 101.768874, 36.657267);
        Point3d fifteenTrack9 = new Point3d(15, 101.768855, 36.656851);
        Point3d fifteenTrack10 = new Point3d(15, 101.768865, 36.656712);//弯点
        Point3d fifteenTrack11 = new Point3d(15, 101.768884, 36.656573);
        Point3d fifteenTrack12 = new Point3d(15, 101.769010, 36.656098);
        Point3d fifteenTrack13 = new Point3d(15, 101.769124, 36.655716);
        Point3d fifteenTrack14 = new Point3d(15, 101.769201, 36.655452);
        Point3d fifteenTrack15 = new Point3d(15, 101.769336, 36.654996);
        Point3d fifteenTrack16 = new Point3d(15, 101.769476, 36.654523);
        Point3d fifteenTrack17 = new Point3d(15, 101.769568, 36.654206);
        array15.add(fifteenTrack17);
        array15.add(fifteenTrack16);
        array15.add(fifteenTrack15);
        array15.add(fifteenTrack14);
        array15.add(fifteenTrack13);
        array15.add(fifteenTrack12);
        array15.add(fifteenTrack11);
        array15.add(fifteenTrack10);
        array15.add(fifteenTrack9);
        array15.add(fifteenTrack8);
        array15.add(fifteenTrack7);
        array15.add(fifteenTrack6);
        array15.add(fifteenTrack5);
        array15.add(fifteenTrack4);
        array15.add(fifteenTrack3);
        array15.add(fifteenTrack2);
        array15.add(fifteenTrack1);
        array15.add(fifteenTrack0);
        GPS.put(15, array15);

        //物1
        ArrayList<Point3d> array16 = new ArrayList<>();
        Point3d sixteenTrack0 = new Point3d(16, 101.770956, 36.650032);
        Point3d sixteenTrack1 = new Point3d(16, 101.770940, 36.649921);
        Point3d sixteenTrack2 = new Point3d(16, 101.770925, 36.649809);
        Point3d sixteenTrack3 = new Point3d(16, 101.770907, 36.649698);
        Point3d sixteenTrack4 = new Point3d(16, 101.770891, 36.649597);
        Point3d sixteenTrack5 = new Point3d(16, 101.770868, 36.649435);//弯点
        Point3d sixteenTrack6 = new Point3d(16, 101.770842, 36.649267);
        Point3d sixteenTrack7 = new Point3d(16, 101.770823, 36.649136);
        Point3d sixteenTrack8 = new Point3d(16, 101.770785, 36.648890);
        Point3d sixteenTrack9 = new Point3d(16, 101.770747, 36.648643);
        Point3d sixteenTrack10 = new Point3d(16, 101.770712, 36.648419);
        Point3d sixteenTrack11 = new Point3d(16, 101.770677, 36.648188);
        Point3d sixteenTrack12 = new Point3d(16, 101.770665, 36.648104);
        array16.add(sixteenTrack12);
        array16.add(sixteenTrack11);
        array16.add(sixteenTrack10);
        array16.add(sixteenTrack9);
        array16.add(sixteenTrack8);
        array16.add(sixteenTrack7);
        array16.add(sixteenTrack6);
        array16.add(sixteenTrack5);
        array16.add(sixteenTrack4);
        array16.add(sixteenTrack3);
        array16.add(sixteenTrack2);
        array16.add(sixteenTrack1);
        array16.add(sixteenTrack0);
        GPS.put(16, array16);

        //物2
        ArrayList<Point3d> array17 = new ArrayList<>();
        Point3d seventeenTrack0 = new Point3d(17, 101.769261, 36.657963);//弯点
        Point3d seventeenTrack1 = new Point3d(17, 101.769393, 36.657590);
        Point3d seventeenTrack2 = new Point3d(17, 101.769640, 36.656890);
        Point3d seventeenTrack3 = new Point3d(17, 101.769784, 36.656460);
        Point3d seventeenTrack4 = new Point3d(17, 101.769865, 36.656089);
        Point3d seventeenTrack5 = new Point3d(17, 101.770227, 36.654899);
        Point3d seventeenTrack6 = new Point3d(17, 101.770515, 36.654004);
        Point3d seventeenTrack7 = new Point3d(17, 101.770952, 36.652646);
        Point3d seventeenTrack8 = new Point3d(17, 101.771034, 36.652266);
        Point3d seventeenTrack9 = new Point3d(17, 101.771045, 36.652158);
        Point3d seventeenTrack10 = new Point3d(17, 101.771050, 36.652063);//弯点
        Point3d seventeenTrack11 = new Point3d(17, 101.771040, 36.651640);
        Point3d seventeenTrack12 = new Point3d(17, 101.771018, 36.651148);
        Point3d seventeenTrack13 = new Point3d(17, 101.770977, 36.650195);
        Point3d seventeenTrack14 = new Point3d(17, 101.770966, 36.649743);
        Point3d seventeenTrack15 = new Point3d(17, 101.771047, 36.649255);
        Point3d seventeenTrack16 = new Point3d(17, 101.771146, 36.648784);
        Point3d seventeenTrack17 = new Point3d(17, 101.771250, 36.648292);
        Point3d seventeenTrack18 = new Point3d(17, 101.771355, 36.647794);
        Point3d seventeenTrack19 = new Point3d(17, 101.771460, 36.647300);
        Point3d seventeenTrack20 = new Point3d(17, 101.771540, 36.646924);
        Point3d seventeenTrack21 = new Point3d(17, 101.771587, 36.646698);
        array17.add(seventeenTrack21);
        array17.add(seventeenTrack20);
        array17.add(seventeenTrack19);
        array17.add(seventeenTrack18);
        array17.add(seventeenTrack17);
        array17.add(seventeenTrack16);
        array17.add(seventeenTrack15);
        array17.add(seventeenTrack14);
        array17.add(seventeenTrack13);
        array17.add(seventeenTrack12);
        array17.add(seventeenTrack11);
        array17.add(seventeenTrack10);
        array17.add(seventeenTrack9);
        array17.add(seventeenTrack8);
        array17.add(seventeenTrack7);
        array17.add(seventeenTrack6);
        array17.add(seventeenTrack5);
        array17.add(seventeenTrack4);
        array17.add(seventeenTrack3);
        array17.add(seventeenTrack2);
        array17.add(seventeenTrack1);
        array17.add(seventeenTrack0);
        GPS.put(17, array17);

        //物3
        ArrayList<Point3d> array18 = new ArrayList<>();
        Point3d eighteenTrack0 = new Point3d(18, 101.771138, 36.648882);
        Point3d eighteenTrack1 = new Point3d(18, 101.771163, 36.648812);
        Point3d eighteenTrack2 = new Point3d(18, 101.771195, 36.648718);//弯点
        Point3d eighteenTrack3 = new Point3d(18, 101.771226, 36.648625);
        Point3d eighteenTrack4 = new Point3d(18, 101.771256, 36.648514);
        Point3d eighteenTrack5 = new Point3d(18, 101.771285, 36.648389);
        Point3d eighteenTrack6 = new Point3d(18, 101.771311, 36.648267);
        Point3d eighteenTrack7 = new Point3d(18, 101.771337, 36.648150);
        Point3d eighteenTrack8 = new Point3d(18, 101.771363, 36.648028);
        Point3d eighteenTrack9 = new Point3d(18, 101.771391, 36.647898);
        Point3d eighteenTrack10 = new Point3d(18, 101.771413, 36.647787);
        Point3d eighteenTrack11 = new Point3d(18, 101.771437, 36.647672);
        Point3d eighteenTrack12 = new Point3d(18, 101.771461, 36.647560);
        Point3d eighteenTrack13 = new Point3d(18, 101.771487, 36.647434);
        Point3d eighteenTrack14 = new Point3d(18, 101.771504, 36.647339);//弯点
        Point3d eighteenTrack15 = new Point3d(18, 101.771519, 36.647226);
        Point3d eighteenTrack16 = new Point3d(18, 101.771532, 36.647115);
        Point3d eighteenTrack17 = new Point3d(18, 101.771539, 36.647025);
        Point3d eighteenTrack18 = new Point3d(18, 101.771547, 36.646941);
        array18.add(eighteenTrack18);
        array18.add(eighteenTrack17);
        array18.add(eighteenTrack16);
        array18.add(eighteenTrack15);
        array18.add(eighteenTrack14);
        array18.add(eighteenTrack13);
        array18.add(eighteenTrack12);
        array18.add(eighteenTrack11);
        array18.add(eighteenTrack10);
        array18.add(eighteenTrack9);
        array18.add(eighteenTrack8);
        array18.add(eighteenTrack7);
        array18.add(eighteenTrack6);
        array18.add(eighteenTrack5);
        array18.add(eighteenTrack4);
        array18.add(eighteenTrack3);
        array18.add(eighteenTrack2);
        array18.add(eighteenTrack1);
        array18.add(eighteenTrack0);
        GPS.put(18, array18);

        //物4
        ArrayList<Point3d> array19 = new ArrayList<>();
        Point3d nineteenTrack0 = new Point3d(19, 101.771591, 36.646681);
        Point3d nineteenTrack1 = new Point3d(19, 101.771616, 36.646563);
        Point3d nineteenTrack2 = new Point3d(19, 101.771637, 36.646461);
        Point3d nineteenTrack3 = new Point3d(19, 101.771659, 36.646360);
        Point3d nineteenTrack4 = new Point3d(19, 101.771681, 36.646261);
        Point3d nineteenTrack5 = new Point3d(19, 101.771701, 36.646166);
        Point3d nineteenTrack6 = new Point3d(19, 101.771720, 36.646073);
        Point3d nineteenTrack7 = new Point3d(19, 101.771740, 36.645978);
        Point3d nineteenTrack8 = new Point3d(19, 101.771761, 36.645884);
        Point3d nineteenTrack9 = new Point3d(19, 101.771784, 36.645773);
        Point3d nineteenTrack10 = new Point3d(19, 101.771806, 36.645668);
        Point3d nineteenTrack11 = new Point3d(19, 101.771829, 36.645562);
        Point3d nineteenTrack12 = new Point3d(19, 101.771854, 36.645445);
        Point3d nineteenTrack13 = new Point3d(19, 101.771875, 36.645339);
        Point3d nineteenTrack14 = new Point3d(19, 101.771897, 36.645233);
        Point3d nineteenTrack15 = new Point3d(19, 101.771919, 36.645139);
        Point3d nineteenTrack16 = new Point3d(19, 101.771942, 36.645027);
        Point3d nineteenTrack17 = new Point3d(19, 101.771965, 36.644918);
        Point3d nineteenTrack18 = new Point3d(19, 101.771985, 36.644818);
        Point3d nineteenTrack19 = new Point3d(19, 101.772003, 36.644739);
        array19.add(nineteenTrack19);
        array19.add(nineteenTrack18);
        array19.add(nineteenTrack17);
        array19.add(nineteenTrack16);
        array19.add(nineteenTrack15);
        array19.add(nineteenTrack14);
        array19.add(nineteenTrack13);
        array19.add(nineteenTrack12);
        array19.add(nineteenTrack11);
        array19.add(nineteenTrack10);
        array19.add(nineteenTrack9);
        array19.add(nineteenTrack8);
        array19.add(nineteenTrack7);
        array19.add(nineteenTrack6);
        array19.add(nineteenTrack5);
        array19.add(nineteenTrack4);
        array19.add(nineteenTrack3);
        array19.add(nineteenTrack2);
        array19.add(nineteenTrack1);
        array19.add(nineteenTrack0);
        GPS.put(19, array19);

        ArrayList<Point3d> array20 = new ArrayList<>();
        Point3d twenty0 = new Point3d(20, 101.770431, 36.660836);
        Point3d twenty1 = new Point3d(20, 101.770464, 36.660685);
        Point3d twenty2 = new Point3d(20, 101.770490, 36.660541);
        Point3d twenty3 = new Point3d(20, 101.770508, 36.660302);
        Point3d twenty4 = new Point3d(20, 101.770498, 36.660100);
        Point3d twenty5 = new Point3d(20, 101.770445, 36.659806);
        Point3d twenty6 = new Point3d(20, 101.770346, 36.659535);
        Point3d twenty7 = new Point3d(20, 101.770144, 36.659178);
        Point3d twenty8 = new Point3d(20, 101.769881, 36.658820);
        Point3d twenty9 = new Point3d(20, 101.769778, 36.658643);
        Point3d twenty10 = new Point3d(20, 101.769714, 36.658503);
        Point3d twenty11 = new Point3d(20, 101.769662, 36.658367);
        Point3d twenty12 = new Point3d(20, 101.769606, 36.658153);
        Point3d twenty13 = new Point3d(20, 101.769579, 36.657990);
        Point3d twenty14 = new Point3d(20, 101.769564, 36.657748);
        Point3d twenty15 = new Point3d(20, 101.769572, 36.657517);
        array20.add(twenty15);
        array20.add(twenty14);
        array20.add(twenty13);
        array20.add(twenty12);
        array20.add(twenty11);
        array20.add(twenty10);
        array20.add(twenty9);
        array20.add(twenty8);
        array20.add(twenty7);
        array20.add(twenty6);
        array20.add(twenty5);
        array20.add(twenty4);
        array20.add(twenty3);
        array20.add(twenty2);
        array20.add(twenty1);
        array20.add(twenty0);
        GPS.put(20, array20);
        return GPS;
    }
}
