package com.gouhao.frame.view;

import android.view.View;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public interface ITitleBar {

    void addTitleBarRightView(View view);

    void addTitleBarLeftView(View view);

    void setTitleBarVisibility(int visibility);

    void setTitleBarTitle(int resId);

    void setTitleBarTitle(String title);

    void setLayoutBackground(int resId);

    void setLayoutBackgroud(int color);

    void setTitleColor(int color);

    void setTitleTextSize(float size);

    void setTitlePadding(int l, int t, int r, int b);

    void setTintColor(int color);
}
