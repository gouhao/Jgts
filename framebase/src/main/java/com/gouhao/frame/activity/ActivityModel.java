package com.gouhao.frame.activity;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class ActivityModel implements IModel {
    protected String TAG = getClass().getSimpleName();

    protected Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    interface Callback{
        void executeFinish(Object object);
    }
}
