package com.xdja.jwt.jgts.pn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gouhao.frame.utils.LogUtil;

/**
 * Created by gucun on 2016/5/5.
 */
public class PushMsgReceiver extends BroadcastReceiver {
    private static String TAG = PushMsgReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i(TAG, intent.getAction());
    }
}
