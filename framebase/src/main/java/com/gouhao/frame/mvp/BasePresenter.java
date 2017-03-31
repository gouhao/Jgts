package com.gouhao.frame.mvp;

import android.content.Context;
import android.databinding.ViewDataBinding;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<V extends IView> implements IPresenter {
    protected String TAG = this.getClass().getSimpleName();
    protected V view;
    protected Context context;

    public BasePresenter(Context context, V view){
        this.context = context;
        this.view = view;
    }
}
