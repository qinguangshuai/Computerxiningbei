package com.example.socket.Bean;

/**
 * @date 2021/2/3 8:59
 */
public class DataUser {
    private int id;
    private String gd;
    private String lat;
    private String lon;
    private String ratioOfGpsPointCar;
    private String num;

    public DataUser() {
        super();
    }

    public DataUser(int id, String gd, String lat, String lon, String ratioOfGpsPointCar, String num) {
        this.id = id;
        this.gd = gd;
        this.lat = lat;
        this.lon = lon;
        this.ratioOfGpsPointCar = ratioOfGpsPointCar;
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
