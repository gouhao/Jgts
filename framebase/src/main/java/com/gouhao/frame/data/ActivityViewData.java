package com.gouhao.frame.data;

import android.databinding.ObservableInt;

/**
 * Created by gouhao on 3/30/2017.
 */

public abstract class ActivityViewData extends ViewData {
    public ObservableInt titleRes = new ObservableInt();

    public ActivityViewData(int titleRes) {
        this.titleRes.set(titleRes);
    }
}
