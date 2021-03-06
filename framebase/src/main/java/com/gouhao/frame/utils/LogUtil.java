package com.gouhao.frame.utils;

import android.util.Log;

/**
 * Created by gouhao on 2017/2/7 0007.
 */
public class LogUtil {
    public static boolean DEBUG = true;

    public static void d(String tag, String msg) {
        if(DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if(DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if(DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if(DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if(DEBUG) {
            Log.w(tag, msg);
        }
    }
}
