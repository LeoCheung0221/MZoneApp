package com.leo.mzoneapp.api.request;


import com.leo.mzoneapp.controller.ControllerMzoneInfo;

/**
 * author：leo on 2016/5/16 00:10
 * email： leocheung4ever@gmail.com
 * description: TODO
 * what & why is modified:
 */
public class RequestMzone {
    public int boozer_id;

    public RequestMzone(int mzone_id) {
        this.boozer_id = mzone_id;
    }

    public RequestMzone enqueue(ControllerMzoneInfo controllerMzoneInfo) {
        return null;
    }
}
