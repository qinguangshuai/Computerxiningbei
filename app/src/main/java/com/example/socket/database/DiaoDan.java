package com.example.socket.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @date 2021/9/24 14:53
 */
@Entity
public class DiaoDan {
    @PrimaryKey(autoGenerate = true)
    public Integer reportid;
    @ColumnInfo(name = "str")
    public String str;//调单原始数据
    @ColumnInfo(name = "currentTime")
    public String current_time;//接收时间
    @ColumnInfo(name = "danhao")
    public String danhao;
    @ColumnInfo(name = "gou_number")
    public String gou_number;
    @ColumnInfo(name = "state")
    public String state;
    @ColumnInfo(name = "curTime")
    public String cur_time;
    @ColumnInfo(name = "gjhId")
    public String gjhId;

    public DiaoDan(String str, String current_time, String danhao, String gou_number, String state, String cur_time,String  gjhId) {
        this.str = str;
        this.current_time = current_time;
        this.danhao = danhao;
        this.gou_number = gou_number;
        this.state = state;
        this.cur_time = cur_time;
        this.gjhId = gjhId;
    }

    public String getCur_time() {
        return cur_time;
    }

    public void setCur_time(String cur_time) {
        this.cur_time = cur_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getDanhao() {
        return danhao;
    }

    public void setDanhao(String danhao) {
        this.danhao = danhao;
    }

    public String getGou_number() {
        return gou_number;
    }

    public void setGou_number(String gou_number) {
        this.gou_number = gou_number;
    }

    public String getGjhId() {
        return gjhId;
    }

    public void setGjhId(String gjhId) {
        this.gjhId = gjhId;
    }
}
