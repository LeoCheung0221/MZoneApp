package com.leo.mzoneapp.controller;

import com.leo.mzoneapp.ui.adapters.AdapterSongsQueue;

/**
 * author：leo on 2016/5/15 16:35
 * email： leocheung4ever@gmail.com
 * description: TODO
 * what & why is modified:
 */
public class ControllerSongsQueue {

    private ControllerSongsQueue() {
    }

    private static ControllerSongsQueue instance;

    public static ControllerSongsQueue getInstance() {
        if (instance == null)
            instance = new ControllerSongsQueue();
        return instance;
    }

    //todo implement
    public boolean isPlayingNow() {
        return true;
    }

    //todo implement
    public boolean isQueueEmpty() {
        return getSongsQueueSize() == 0;
    }

    public int getSongsQueueSize() {
        //todo implement
        return 3;
    }
}
