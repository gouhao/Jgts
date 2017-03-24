package com.gouhao.frame.base;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<D extends ActivityData> implements ActivityModel.Callback{
    protected String TAG = this.getClass().getSimpleName();
    protected D activityData;

    public BasePresenter(D data){
        this.activityData = data;
    }
}
