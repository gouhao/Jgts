package com.xdja.jwt.jgts.activity.policequery;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryPresenter extends BasePresenter<PoliceEventQueryViewData> implements IPoliceEventQueryPresenter {
    public PoliceEventQueryPresenter(Context context, PoliceEventQueryViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }
}
