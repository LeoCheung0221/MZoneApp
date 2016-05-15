package com.leo.mzoneapp.controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.leo.mzoneapp.util.CloseUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * author：leo on 2016/5/15 19:34
 * email： leocheung4ever@gmail.com
 * description: 存储控制器
 * what & why is modified:
 */
public class ControllerStorage {

    public static final String ITEMS_INFO = "cache_items";
    public static final String TOKEN = "token_cache";
    public static final String CART_CACHE = "cart_cache";
    public static final String FAVORITES_CACHE = "favorites_cache";
    public static final String NEWS_CACHE = "cache_news";
    public static final String MARKETS_CACHE = "cache_markets";
    public static final String USERINFO_CACHE = "cache_userinfo";
    public static final String ALBUMS_CACHE = "cache_albums";
    public static final String ORDERS_HISTORY_CACHE = "orders_cache";
    private static final String TAG = "ControllerStorage";

    public synchronized static void writeObjectToFile(Context context, Object object, String fileName) {
        ObjectOutputStream objectOut = null;
        if (object == null)
            context.deleteFile(fileName);
        else {
            try {
                FileOutputStream fileOut = context.openFileOutput(fileName, Activity.MODE_PRIVATE);
                objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(object);
                fileOut.getFD().sync();
            } catch (IOException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            } finally {
                CloseUtil.closeQuietly(TAG, objectOut);
            }
        }
    }

//    public synchronized static Object readObjectFromFile(Context context, String filename) {
//
//    }
}
