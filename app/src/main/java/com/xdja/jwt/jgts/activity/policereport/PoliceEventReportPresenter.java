package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.databinding.ActivityPoliceEventReportBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventReportPresenter extends BasePresenter<ActivityPoliceEventReportBinding> implements IPoliceEventReportPresenter {
    public PoliceEventReportPresenter(Context context, ActivityPoliceEventReportBinding binding) {
        super(context, binding);
    }
}
