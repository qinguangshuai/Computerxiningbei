package com.example.socket.custom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/2/3 9:01
 * 停留车数据保存
 */
public class ParkDataDao {

    private ParkOpenHelper helper;

    public ParkDataDao(Context context) {
        helper = new ParkOpenHelper(context);
    }

    /**
     * 数据库的增加方法
     */
    public boolean add(String info, String gd, String lat, String lon, double ratioOfGpsPointCar) {
        SQLiteDatabase db = helper.getWritableDatabase();
//		db.execSQL("insert into info(name,phone) values(?,?)", new Object[]{NULL,phone});

        /**
         * table 表明
         * nullColumnHack  null
         */
        ContentValues values = new ContentValues();  //实际就是一个map    key:对应我们表的列名   value :值
        values.put("gd", gd);
        values.put("lat", lat);
        values.put("lon", lon);
        values.put("ratioOfGpsPointCar", ratioOfGpsPointCar);
        //实际底层原理 就是在组拼sql语句
        long result = db.insert(info, null, values);
        db.close();
        if (result == -1) {
            //说明插入失败
            return false;

        } else {
            return true;
        }
    }

    /**
     * 数据库的删除方法
     */
    public int del(String info) {
        SQLiteDatabase db = helper.getReadableDatabase();
        /**
         * table 表名
         * whereClause  删除条件
         */
        //代表 影响了多少行
        int delete = db.delete(info, null, null);
        db.close();
        return delete;
    }

    public List<ParkDataUser> findMax(String info, String ddd) {
        List<ParkDataUser> personLists = new ArrayList<ParkDataUser>();
        SQLiteDatabase db = helper.getWritableDatabase();
        //String sql = "DELETE FROM " + info + " WHERE time < " + "'" + str + "'";
        /*Cursor cursor = db.query(info, new String[]{"MAX(" + ddd + ") AS MAX"}, null, null, null, null, null);
        cursor.moveToFirst(); // to move the cursor to first record
        int index  = cursor.getColumnIndex("MAX");
        String gd = cursor.getString(index);

        Log.e("ratioOfGpsPointCar", "max--" + index+"   "+gd);

        ParkDataUser dataUser = new ParkDataUser();
        personLists.add(dataUser);
        cursor.close();
        db.close();*/

        String sql = "select max(ratioOfGpsPointCar) from " + info;
        Log.e("SQL", sql);
        Cursor c = db.rawQuery(sql, null);
        double p = 0;
        if (c.moveToFirst())
            p = c.getDouble(0);
        Log.e("ratioOfGpsPointCar", "max--" + p);
        return personLists;
    }

    /**
     * 数据库的查询方法
     */
    public List<ParkDataUser> find(String info) {
        List<ParkDataUser> personLists = new ArrayList<ParkDataUser>();
        SQLiteDatabase db = helper.getWritableDatabase();
//		Cursor cursor = db.rawQuery("select * from info", null);

        /**
         * table 表名
         * columns  查询的列  具体查询的是哪一列
         * selection 根据什么条件去
         * selectionArgs
         */
//		Cursor cursor = db.query("info", new String[]{"phone"}, "name=?", new String[]{name}, null, null, null);

        Cursor cursor = db.query(info, null, null, null, null, null, null);
        //对cursor 判断一下cursor
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                // 开始取 字段数据   sqliet 不区分数据类型  想要什么你就自己拿什么
                int anInt = cursor.getInt(0);
                String gd = cursor.getString(1);   //获取我们的phone
                String lat = cursor.getString(2);   //获取我们的phone
                String lon = cursor.getString(3);    //获取我们的name值
                String ratioOfGpsPointCar = cursor.getString(4);    //获取我们的name值
                ParkDataUser dataUser = new ParkDataUser();

                System.out.println("gd--" + gd + "lat--" + lat + "lon--" + lon + "ratioOfGpsPointCar--" + ratioOfGpsPointCar);
                dataUser.setId(anInt);
                dataUser.setGd(gd);
                dataUser.setLat(lat);
                dataUser.setLon(lon);
                dataUser.setRatioOfGpsPointCar(ratioOfGpsPointCar);
                // 把Person对象 加入到 personLists集合中.
                personLists.add(dataUser);
            }
            cursor.close();
            db.close();
        }
        return personLists;
    }
}
