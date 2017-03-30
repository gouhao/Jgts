package com.xdja.jwt.jgts.activity.policequery;

import android.databinding.ObservableField;

import com.gouhao.frame.data.ActivityViewData;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryViewData extends ActivityViewData {
    public ObservableField<String> date = new ObservableField<>();
    public PoliceEventQueryViewData(int titleRes) {
        super(titleRes);
    }
}
