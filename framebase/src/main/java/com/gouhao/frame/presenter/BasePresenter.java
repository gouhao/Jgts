package com.gouhao.frame.presenter;

import android.content.Context;

import com.gouhao.frame.data.ViewData;
import com.gouhao.frame.model.ActivityModel;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<D extends ViewData> implements ActivityModel.Callback, IPresenter {
    protected String TAG = this.getClass().getSimpleName();
    protected D activityData;
    protected Context context;

    public BasePresenter(Context context, D data){
        this.context = context;
        this.activityData = data;
    }
}
