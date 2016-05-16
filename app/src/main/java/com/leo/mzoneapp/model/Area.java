package com.leo.mzoneapp.model;

/**
 * author：leo on 2016/5/16 10:12
 * email： leocheung4ever@gmail.com
 * description: area model
 * what & why is modified:
 */
public class Area {

    public float lon;  //经度
    public float lat;  //纬度
    public int radius; //半径


    //todo need setter and getter
    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
