package com.xdja.jwt.jgts.activity.policemanage;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.activity.policedeal.PoliceEventDealActivity;
import com.xdja.jwt.jgts.activity.policequery.PoliceEventQueryActivity;
import com.xdja.jwt.jgts.activity.policereport.PoliceEventReportActivity;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceManagePresenter extends BasePresenter<PoliceManageViewData> implements IPoliceManagePresenter {
    public PoliceManagePresenter(Context context, PoliceManageViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }

    @Override
    public void openPoliceEventQueryActivity() {
        PoliceEventQueryActivity.openActivity(context);
    }

    @Override
    public void openPoliceEventReportActivity() {
        PoliceEventReportActivity.openActivity(context);
    }

    @Override
    public void openPoliceEventDealActivity() {
        PoliceEventDealActivity.openActivity(context);
    }
}
