package com.example.socket.Bean;

/**
 * @date 2021/12/30 8:50
 */
public class ZhanchangWrap {

    public String ratioOfGpsTrackCar;
    public double ratioOfGpsPointCar;
    public ZhanchangWrap(String ratioOfGpsTrackCar, double ratioOfGpsPointCar) {
        this.ratioOfGpsTrackCar = ratioOfGpsTrackCar;
        this.ratioOfGpsPointCar = ratioOfGpsPointCar;
    }

    public String getRatioOfGpsTrackCar() {
        return ratioOfGpsTrackCar;
    }

    public void setRatioOfGpsTrackCar(String ratioOfGpsTrackCar) {
        this.ratioOfGpsTrackCar = ratioOfGpsTrackCar;
    }

    public double getRatioOfGpsPointCar() {
        return ratioOfGpsPointCar;
    }

    public void setRatioOfGpsPointCar(double ratioOfGpsPointCar) {
        this.ratioOfGpsPointCar = ratioOfGpsPointCar;
    }
}
