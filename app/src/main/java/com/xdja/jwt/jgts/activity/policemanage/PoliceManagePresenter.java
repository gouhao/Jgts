package com.xdja.jwt.jgts.activity.policemanage;

import android.content.Context;

import com.gouhao.frame.mvp.BasePresenter;
import com.xdja.jwt.jgts.activity.policedeal.PoliceEventDealActivity;
import com.xdja.jwt.jgts.activity.policequery.PoliceEventQueryActivity;
import com.xdja.jwt.jgts.activity.policereport.PoliceEventReportActivity;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceManagePresenter extends BasePresenter<IPoliceManageView> implements IPoliceManagePresenter {

    public PoliceManagePresenter(Context context, IPoliceManageView view) {
        super(context, view);
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
