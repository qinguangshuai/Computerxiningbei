package com.example.socket.custom.data;

/**
 * @date 2021/2/25 13:34
 */
public class Point3d {
    public double trackxn;
    public double X;
    public double Y;

    public Point3d() {
        super();
    }

    public double getTrackxn() {
        return trackxn;
    }

    public void setTrackxn(double trackxn) {
        this.trackxn = trackxn;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public Point3d(double trackxn, double x, double y) {
        this.trackxn = trackxn;
        X = x;
        Y = y;
    }
}
