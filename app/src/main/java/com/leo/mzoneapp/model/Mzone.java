package com.leo.mzoneapp.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author：leo on 2016/5/16 09:02
 * email： leocheung4ever@gmail.com
 * description: Mzone Model
 * what & why is modified:
 */
public class Mzone {

    public int id;
    @NonNull
    public String name;
    @NonNull
    public String address;
    @NonNull
    public String phone;
    public float lon;
    public float lat;
    @Nullable
    public Integer operatingStart;
    @Nullable
    public Integer operatingEnd;
    @Nullable
    public Song currentSong;
    @Nullable
    public String currentSongStart;
    @Nullable
    public ArrayList<Song> songsQueue;

    /*public List<Song> getSongsQueue() {
        return songsQueue;
    }

    public void setSongsQueue(List<Song> songsQueue) {
        this.songsQueue = songsQueue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }*/

}
