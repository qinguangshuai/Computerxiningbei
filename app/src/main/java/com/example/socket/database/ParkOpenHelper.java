package com.example.socket.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * dmr  232数据保存
 */
public class ParkOpenHelper extends SQLiteOpenHelper {

    public ParkOpenHelper(Context context) {
        /**
         * name 数据库的名字
         * factory 游标工厂  目的创建 cursor(结果集)
         * version 版本    版本从1开始  版本必须>=1
         */
        super(context, "parkcar_gps.db", null, 1);
    }

    /**
     * Called when the database is created for the first time
     * 当 数据第一次创建的时候调用
     * 该方法适合做 表结构的初始化
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        System.out.println("oncreate");
        //创建一个教info的表里面的字段有 id(android官方建议前面加下划线_) integer类型 主键  自动增长
        //db.execSQL("create table oneparkcar(oneId integer primary key autoincrement,oneGd varchar(60),oneLat varchar(60),oneLon varchar(60),oneRatioOfGpsPointCar varchar(60),oneNum varchar(60))");
        db.execSQL("create table oneParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table twoParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table threeParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table fourParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table fiveParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table sixParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table sevenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table eightParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table nineParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table tenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table elevenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table twelveParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table thirteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table fourteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table fifteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table sixteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table seventeenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table eighteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
        db.execSQL("create table nineteenParkcar(id integer primary key autoincrement,gd varchar(60),lat varchar(60),lon varchar(60),ratioOfGpsPointCar varchar(60))");
    }

    /**
     * 当数据库需要升级的时候调用
     * 该方法适合做 表结构修改
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        System.out.println("onUpgrade");
        // 比如 我给 info 表添加一列   phone
//		db.execSQL("alter table info add phone varchar(20)");

    }


}
