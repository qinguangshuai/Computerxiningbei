package com.example.socket.Unit;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * BJXT-QGS
 *
 * @date 2020/8/14 16:01
 */
public class SpUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public final String SP_NAME = "config";

    public SpUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, context.MODE_PRIVATE);
        editor = sp.edit();
        editor.commit();
    }

    /**
     * 保存字符串
     *
     * @param context
     * @param key
     * @param value
     */
    public void saveString(Context context, String key, String value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }
        sp.edit().putString(key, value).commit();
    }

    /**
     * 返回字符串
     *
     * @param context
     * @param key
     * @param defValue 默认值
     * @return
     */
    public String getString(Context context, String key, String defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }
        return sp.getString(key, defValue);
    }

    /**
     * 保存布尔
     *
     * @param context
     * @param key
     * @param value
     */
    public void saveBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 返回布尔
     *
     * @param context
     * @param key
     * @param defValue 默认值
     * @return
     */
    public boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }

        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存int
     *
     * @param context
     * @param key
     * @param value
     */
    public void saveInt(Context context, String key, int value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }

        sp.edit().putInt(key, value).commit();
    }

    /**
     * 返回int
     *
     * @param context
     * @param key
     * @param defValue 默认值
     * @return
     */
    public int getInt(Context context, String key, int defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }

        return sp.getInt(key, defValue);
    }

    /**
     * 保存float
     *
     * @param context
     * @param key
     * @param value
     */
    public void saveFloat(Context context, String key, float value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }

        sp.edit().putFloat(key, value).commit();
    }

    /**
     * 返回float
     *
     * @param context
     * @param key
     * @param defValue 默认值
     * @return
     */
    public float getFloat(Context context, String key, float defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }

        return sp.getFloat(key, defValue);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public boolean contains(Context context, String key) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, 0);
        }
        return sp.contains(key);
    }

    // 用户的密码
    public void setPasswd(String passwd) {
        editor.putString("passwd", passwd);
        editor.commit();
    }

    public String getPasswd() {
        return sp.getString("passwd", "");
    }

    // 用户的id
    public void setId(String id) {
        editor.putString("id", id);
        editor.commit();
    }

    public String getId() {
        return sp.getString("id", "");
    }

    public String getIMEI() {
        return sp.getString("imei", "");
    }

    public void setIMEI(String imei) {
        editor.putString("imei", imei);
        editor.commit();
    }

    //调号
    public void setSignatureId(String signatureId) {
        editor.putString("signatureId", signatureId);
        editor.commit();
    }

    public String getSignatureId() {
        return sp.getString("signatureId", "");
    }

    //用户的id（人员号）
    public void setPeopleId(String peopleId) {
        editor.putString("peopleId", peopleId);
        editor.commit();
    }

    public String getPeopleId() {
        return sp.getString("peopleId", "");
    }

    // 用户的昵称
    public String getName() {
        return sp.getString("name", "");
    }

    public void setName(String name) {
        editor.putString("name", name);
        editor.commit();
    }

    //本机号
    public String getBenJi() {
        return sp.getString("benji", "");
    }

    public void setBenJi(String benji) {
        editor.putString("benji", benji);
        editor.commit();
    }

    // 用户的昵称
    public String getStandard() {
        return sp.getString("standard", "");
    }

    public void setStandard(String standard) {
        editor.putString("standard", standard);
        editor.commit();
    }

    public String getTrack() {
        return sp.getString("track", "");
    }

    public void setTrack(String track) {
        editor.putString("track", track);
        editor.commit();
    }

    public String getPosition() {
        return sp.getString("position", "");
    }

    public void setPosition(String position) {
        editor.putString("position", position);
        editor.commit();
    }

    // 用户编号
    public void setHao(String hao) {
        editor.putString("hao", hao);
        editor.commit();
    }

    public String getHao() {
        return sp.getString("hao", "");
    }

    // 群组
    public void setGroup(String group) {
        editor.putString("group", group);
        editor.commit();
    }

    public String getGroup() {
        return sp.getString("group", "");
    }

    public String getLon() {
        return sp.getString("lon", "");
    }

    public void setLon(String lon) {
        editor.putString("lon", lon);
        editor.commit();
    }

    public String getLon1() {
        return sp.getString("lon1", "");
    }

    public void setLon1(String lon1) {
        editor.putString("lon1", lon1);
        editor.commit();
    }

    public String getLat() {
        return sp.getString("lat", "");
    }

    public void setLat(String lat) {
        editor.putString("lat", lat);
        editor.commit();
    }

    public String getLat1() {
        return sp.getString("lat1", "");
    }

    public void setLat1(String lat1) {
        editor.putString("lat1", lat1);
        editor.commit();
    }

    // 用户的邮箱
    public String getEmail() {
        return sp.getString("email", "");
    }

    public void setEmail(String email) {
        editor.putString("email", email);
        editor.commit();
    }

    // 用户自己的头像
    public Integer getImg() {
        return sp.getInt("img", 0);
    }

    public void setImg(int i) {
        editor.putInt("img", i);
        editor.commit();
    }

    // ip
    public void setIp(String ip) {
        editor.putString("ip", ip);
        editor.commit();
    }

    // 端口
    public void setPort(int port) {
        editor.putInt("port", port);
        editor.commit();
    }

    //index
    public void setIndex(int index) {
        editor.putInt("index", index);
        editor.commit();
    }

    public int getIndex(int index) {
        return sp.getInt("index", index);
    }

    // 是否在后台运行标记
    public void setIsStart(boolean isStart) {
        editor.putBoolean("isStart", isStart);
        editor.commit();
    }

    public boolean getIsStart() {
        return sp.getBoolean("isStart", false);
    }

    // 是否第一次运行本应用
    public void setIsFirst(boolean isFirst) {
        editor.putBoolean("isFirst", isFirst);
        editor.commit();
    }

    public boolean getisFirst() {
        return sp.getBoolean("isFirst", true);
    }

    // 指令通知协议
    public String getNotice() {
        return sp.getString("notice", "");
    }

    public void setNotice(String notice) {
        editor.putString("notice", notice);
        editor.commit();
    }
}
