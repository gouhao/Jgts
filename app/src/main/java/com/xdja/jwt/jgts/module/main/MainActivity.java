package com.xdja.jwt.jgts.module.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gouhao.frame.base.BaseActivity;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.databinding.ActivityMainBinding;

/**
 * Created by gouhao on 3/21/2017.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityModel, MainActivityData> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initActivityModel() {
        activityModel = new MainActivityModel(activityDataBinding);
        activityDataBinding.setModel(activityModel);
    }

    @Override
    protected void initActivityData() {
        activityData = new MainActivityData();
        activityDataBinding.setData(activityData);
    }

    @Override
    protected void initTitle() {
        getTitleBar().setTitleBarTitle(R.string.app_name);
    }

    @Override
    protected void initActivityDataBinding() {
        activityDataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_main, null, false);
    }
}
