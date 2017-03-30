package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventReportPresenter extends BasePresenter<PoliceEventReportViewData> implements IPoliceEventReportPresenter {
    public PoliceEventReportPresenter(Context context, PoliceEventReportViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }
}
