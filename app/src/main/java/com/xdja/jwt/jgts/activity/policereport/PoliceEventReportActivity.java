package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.databinding.ActivityPoliceEventReportBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventReportActivity extends BackNavActivity<ActivityPoliceEventReportBinding, PoliceEventReportViewData, PoliceEventReportPresenter> {
    public static void openActivity(Context context) {
        context.startActivity(new Intent(context, PoliceEventReportActivity.class));
    }
    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_police_event_report, null, false);
    }

    @Override
    protected void initActivityData() {
        activityViewData = new PoliceEventReportViewData(R.string.police_event_report);
        dataBinding.setData(activityViewData);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new PoliceEventReportPresenter(this, dataBinding);
        dataBinding.setPresenter(presenter);
    }
}
