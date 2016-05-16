package com.leo.mzoneapp.controller;

/**
 * author：leo on 2016/5/15 16:35
 * email： leocheung4ever@gmail.com
 * description: songs queue controller
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

    public boolean isPlayingNow() {
        return ControllerMzoneInfo.getInstance().getData() != null
                && ControllerMzoneInfo.getInstance().getData().currentSong != null;
    }

    public boolean isQueueEmpty() {
        return getQueueSize() == 0;
    }


    public int getQueueSize() {
        if (ControllerMzoneInfo.getInstance().getData() == null
                || ControllerMzoneInfo.getInstance().getData().songsQueue == null
                || ControllerMzoneInfo.getInstance().getData().songsQueue.size() == 0)
            return 0;
        return ControllerMzoneInfo.getInstance().getData().songsQueue.size();
    }
}
