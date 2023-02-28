package com.example.socket.Bean;

import java.io.Serializable;

public class Pocket implements Serializable {

    //数据类型ReportDetailAdapter
    String type = "";
    //时间戳
    long time = 10000000;
    //ip地址
    String ipAdress = "192.168.0.0";
    //音频数据
    byte data[];
    //message
    String dataMessage = "";
    //尾帧标记位
    boolean end = false;
    //序列号
    int num;
    //人员号
    String peopleId;
    //IMEI号
    String imei;
    //组号
    String group;
    //用户编号
    String userCode;
    //gjhId
    String gjhId;
    int signalling;

    public Pocket(String type, long time, String ipAdress, byte[] data, String dataMessage, boolean end, int num, String peopleId, String imei, String group, String userCode, String gjhId, int signalling) {
        this.type = type;
        this.time = time;
        this.ipAdress = ipAdress;
        this.data = data;
        this.dataMessage = dataMessage;
        this.end = end;
        this.num = num;
        this.peopleId = peopleId;
        this.imei = imei;
        this.group = group;
        this.userCode = userCode;
        this.gjhId = gjhId;
        this.signalling = signalling;
    }

    public int getSignalling() {
        return signalling;
    }

    public void setSignalling(int signalling) {
        this.signalling = signalling;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Pocket() {
        super();
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDataMessage() {
        return dataMessage;
    }

    public void setDataMessage(String dataMessage) {
        this.dataMessage = dataMessage;
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

    public String getGjhId() {
        return gjhId;
    }

    public void setGjhId(String gjhId) {
        this.gjhId = gjhId;
    }
}
