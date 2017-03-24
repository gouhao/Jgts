package com.xdja.jwt.jgts.pn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gouhao.frame.utils.LogUtil;

/**
 * Created by xdjaxa on 2016/11/22.
 */

public class ClickMsgHandlerReceiver extends BroadcastReceiver {
    private static String TAG = ClickMsgHandlerReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i(TAG, intent.getAction());
    }
}
