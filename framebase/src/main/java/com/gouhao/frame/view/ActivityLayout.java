package com.gouhao.frame.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gouhao.frame.view.ITitleBar;
import com.gouhao.frame.view.TitleBarView;

/**
 * Created by gouhao on 2017/2/3 0003.
 * Activity的布局类，里面集成了标题栏
 */
public class ActivityLayout extends LinearLayout{
    private ITitleBar titleBar;
    private int titleBarHeight;

    public ActivityLayout(Context context, int titleBarHeight) {
        this(context, titleBarHeight, null);
    }

    public ActivityLayout(Context context, int titleBarHeight, ITitleBar titleBar) {
        super(context);
        setOrientation(VERTICAL);
        this.titleBarHeight = titleBarHeight;
        if(titleBar == null) {
            titleBar = new TitleBarView(getContext());
        }
        this.titleBar = titleBar;
        initView();
    }

    private void initView() {
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                titleBarHeight);
        addView((View) titleBar, params);
    }

    public void addContentView(View view) {
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view, params);
    }

    public ITitleBar getTitleBar() {
        return titleBar;
    }


}
