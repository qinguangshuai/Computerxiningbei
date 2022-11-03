package com.example.socket.custom.dao;

/**
 * @date 2021/2/3 8:59
 */
public class ParkDataUser {
    private int id;
    private String gd;
    private String lat;
    private String lon;
    private String ratioOfGpsPointCar;

    public ParkDataUser() {
        super();
    }

    public ParkDataUser(int id, String gd, String lat, String lon, String ratioOfGpsPointCar) {
        this.id = id;
        this.gd = gd;
        this.lat = lat;
        this.lon = lon;
        this.ratioOfGpsPointCar = ratioOfGpsPointCar;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getRatioOfGpsPointCar() {
        return ratioOfGpsPointCar;
    }

    public void setRatioOfGpsPointCar(String ratioOfGpsPointCar) {
        this.ratioOfGpsPointCar = ratioOfGpsPointCar;
    }
}
