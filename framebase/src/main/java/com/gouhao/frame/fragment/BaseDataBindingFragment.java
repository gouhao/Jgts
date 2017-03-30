package com.gouhao.frame.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gouhao.frame.data.ViewData;
import com.gouhao.frame.presenter.BasePresenter;

/**
 * Created by gouhao on 3/30/2017.
 */

public abstract class BaseDataBindingFragment<V extends ViewDataBinding, D extends ViewData, P extends BasePresenter<D>>
    extends BaseFragment{

    protected V dataBinding;
    protected P presenter;
    protected D viewData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDataBinding();
        if(dataBinding == null) {
            throw new NullPointerException("WHAT THE FUCK!ActivityDataBinding is null");
        }
        initViewData();
        initPresenter();
        return dataBinding.getRoot();
    }


    protected abstract void initDataBinding();

    protected abstract void initViewData();

    protected abstract void initPresenter();
}
