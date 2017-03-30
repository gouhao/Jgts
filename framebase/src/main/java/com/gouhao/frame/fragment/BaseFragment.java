package com.gouhao.frame.fragment;

import android.support.v4.app.Fragment;

import com.gouhao.frame.utils.LogUtil;

/**
 * Created by gouhao on 3/30/2017.
 */

public abstract class BaseFragment extends Fragment {
    protected String TAG = getClass().getSimpleName();


    @Override
    public void onStart() {
        LogUtil.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        LogUtil.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        LogUtil.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        LogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
