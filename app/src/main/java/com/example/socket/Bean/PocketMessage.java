package com.example.socket.Bean;

import java.io.Serializable;

public class PocketMessage implements Serializable {

    //数据类型
    String type = "";
    //时间戳
    long time = 10000000;
    //ip地址
    String ipAdress = "192.168.0.0";
    //message
    String data = "";
    //尾帧标记位
    boolean end = false;
    //序列号
    int num;
    //人员号
    String peopleId;

    public PocketMessage() {
        super();
    }

    public PocketMessage(String type, long time, String ipAdress, String data, boolean end, int num, String peopleId) {
        this.type = type;
        this.time = time;
        this.ipAdress = ipAdress;
        this.data = data;
        this.end = end;
        this.num = num;
        this.peopleId = peopleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }
}
