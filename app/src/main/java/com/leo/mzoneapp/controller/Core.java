package com.leo.mzoneapp.controller;

import android.app.Application;


/**
 * author： LeoCheung4ever on 2016/5/9 13:00
 * email： leocheung4ever@gmail.com
 * description: 应用核心
 * what & why is modified:
 */
public class Core extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
    }
}
