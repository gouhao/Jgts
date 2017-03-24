package com.xdja.jwt.jgts.module.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.gouhao.frame.activity.BaseActivity;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.databinding.ActivityMainBinding;

/**
 * Created by gouhao on 3/21/2017.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityData, MainActivityPresenter> {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void initActivityPresenter() {
         activityPresenter = new MainActivityPresenter(activityData);
        activityDataBinding.setPresenter(activityPresenter);
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
