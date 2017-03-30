package com.gouhao.frame.presenter;

import com.gouhao.frame.data.ViewData;
import com.gouhao.frame.model.ActivityModel;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<D extends ViewData> implements ActivityModel.Callback, IPresenter {
    protected String TAG = this.getClass().getSimpleName();
    protected D activityData;

    public BasePresenter(D data){
        this.activityData = data;
    }
}
