package com.leo.mzoneapp.util;

import android.util.Log;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author：leo on 2016/5/15 19:44
 * email： leocheung4ever@gmail.com
 * description: ISP实现 close closable object
 * what & why is modified:
 */
public class CloseUtil {

    private CloseUtil() {
    }

    /**
     * close the closeable object
     *
     * @param tag
     * @param closeable
     */
    public static void closeQuietly(String tag, Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(tag, Log.getStackTraceString(e));
            }
        }
    }
}
