package com.xdja.jwt.jgts.activity.policedeal;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventDealPresenter extends BasePresenter<PoliceEventDealViewData> implements IPoliceEventDealPresenter {
    public PoliceEventDealPresenter(Context context, PoliceEventDealViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }
}
