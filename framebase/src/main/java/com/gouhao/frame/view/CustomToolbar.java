package com.gouhao.frame.view;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gouhao.frame.view.ITitleBar;

/**
 * Created by gouhao on 2017/2/4 0004.
 * Toolbar风格的标题栏
 */
public class CustomToolbar extends Toolbar implements ITitleBar {
    public CustomToolbar(Context context) {
        super(context);
    }

    @Override
    public void addTitleBarRightView(View view) {

    }

    @Override
    public void addTitleBarLeftView(View view) {

    }

    @Override
    public void setTitleBarVisibility(int visibility) {

    }

    @Override
    public void setTitleBarTitle(int resId) {

    }

    @Override
    public void setTitleBarTitle(String title) {

    }

    @Override
    public void setLayoutBackground(int resId) {

    }

    @Override
    public void setLayoutBackgroud(int color) {

    }

    @Override
    public void setTitleColor(int color) {

    }

    @Override
    public void setTitleTextSize(float size) {

    }

    @Override
    public void setTitlePadding(int l, int t, int r, int b) {

    }

    @Override
    public void setTintColor(int color) {

    }
}
