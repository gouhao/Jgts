package com.gouhao.frame.activity;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<D extends ActivityData> implements ActivityModel.Callback, IPresenter {
    protected String TAG = this.getClass().getSimpleName();
    protected D activityData;

    public BasePresenter(D data){
        this.activityData = data;
    }
}
