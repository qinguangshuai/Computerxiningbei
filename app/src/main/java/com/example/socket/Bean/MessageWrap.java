package com.example.socket.Bean;

/**
 * @date 2021/12/30 8:50
 */
public class MessageWrap {

    public String lat;
    public String lon;

    public MessageWrap(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
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
}
