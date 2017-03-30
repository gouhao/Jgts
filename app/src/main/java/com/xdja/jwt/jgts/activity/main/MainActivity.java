package com.xdja.jwt.jgts.activity.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.gouhao.frame.activity.BaseDataBindingActivity;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.databinding.ActivityMainBinding;
import com.xdja.jwt.jgts.fragment.task.TaskFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouhao on 3/30/2017.
 */

public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding, MainViewData, MainActivityPresenter> {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    private MainViewPagerAdapter adapter;

    private List<Fragment> fragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragments = new ArrayList<>();
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        dataBinding.mainTabLayout.setupWithViewPager(dataBinding.mainViewPage, false);
        dataBinding.mainTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initViewPager() {
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new TaskFragment());
        fragments.add(new Fragment());
        adapter = new MainViewPagerAdapter(this, fragments, getSupportFragmentManager());
        dataBinding.mainViewPage.setAdapter(adapter);
    }

    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_main, null, false);
    }

    @Override
    protected void initActivityData() {
        activityViewData = new MainViewData();
    }

    @Override
    protected void initActivityPresenter() {

    }

    @Override
    protected void initTitle() {
        getTitleBar().setTitleBarTitle(activityViewData.titleRes.get());
    }
}
