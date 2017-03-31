package com.gouhao.frame.presenter;

import android.content.Context;
import android.databinding.ViewDataBinding;

/**
 * Created by gouhao on 3/24/2017.
 */

public abstract class BasePresenter<V extends ViewDataBinding> implements IPresenter {
    protected String TAG = this.getClass().getSimpleName();
    protected V dataBinding;
    protected Context context;

    public BasePresenter(Context context, V binding){
        this.context = context;
        this.dataBinding = binding;
    }
}
