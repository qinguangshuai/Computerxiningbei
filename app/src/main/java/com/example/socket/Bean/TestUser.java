package com.example.socket.Bean;

public class TestUser {
    private String sGpsLon;
    private String sGpsLat;
    private String eGpsLon;
    private String eGpsLat;
    private int track;
    private int carNum;

    public TestUser() {
        super();
    }

    public TestUser(String sGpsLon, String sGpsLat, String eGpsLon, String eGpsLat, int track, int carNum) {
        this.sGpsLon = sGpsLon;
        this.sGpsLat = sGpsLat;
        this.eGpsLon = eGpsLon;
        this.eGpsLat = eGpsLat;
        this.track = track;
        this.carNum = carNum;
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

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }
}
