package com.xdja.jwt.jgts.activity.policemanage;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.activity.policedeal.PoliceEventDealActivity;
import com.xdja.jwt.jgts.activity.policequery.PoliceEventQueryActivity;
import com.xdja.jwt.jgts.activity.policereport.PoliceEventReportActivity;
import com.xdja.jwt.jgts.databinding.ActivityPoliceManageBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceManagePresenter extends BasePresenter<ActivityPoliceManageBinding> implements IPoliceManagePresenter {
    public PoliceManagePresenter(Context context, ActivityPoliceManageBinding binding) {
        super(context, binding);
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
