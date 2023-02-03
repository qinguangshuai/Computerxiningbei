package com.example.socket.Bean;

public class InitializationParkGPSUser {
    private String sGpsLon;
    private String sGpsLat;
    private String eGpsLon;
    private String eGpsLat;
    private String track;
    private int carNum;
    private int pId;

    public InitializationParkGPSUser() {
        super();
    }

    public InitializationParkGPSUser(String sGpsLon, String sGpsLat, String eGpsLon, String eGpsLat, String track, int carNum, int pId) {
        this.sGpsLon = sGpsLon;
        this.sGpsLat = sGpsLat;
        this.eGpsLon = eGpsLon;
        this.eGpsLat = eGpsLat;
        this.track = track;
        this.carNum = carNum;
        this.pId = pId;
    }

    public String getsGpsLon() {
        return sGpsLon;
    }

    public void setsGpsLon(String sGpsLon) {
        this.sGpsLon = sGpsLon;
    }

    public String getsGpsLat() {
        return sGpsLat;
    }

    public void setsGpsLat(String sGpsLat) {
        this.sGpsLat = sGpsLat;
    }

    public String geteGpsLon() {
        return eGpsLon;
    }

    public void seteGpsLon(String eGpsLon) {
        this.eGpsLon = eGpsLon;
    }

    public String geteGpsLat() {
        return eGpsLat;
    }

    public void seteGpsLat(String eGpsLat) {
        this.eGpsLat = eGpsLat;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
