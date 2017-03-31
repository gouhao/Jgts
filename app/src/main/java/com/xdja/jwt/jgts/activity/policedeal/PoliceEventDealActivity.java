package com.xdja.jwt.jgts.activity.policedeal;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.databinding.ActivityPoliceEventDealBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventDealActivity extends BackNavActivity<ActivityPoliceEventDealBinding, PoliceEventDealViewData, PoliceEventDealPresenter> {
    public static void openActivity(Context context) {
        context.startActivity(new Intent(context, PoliceEventDealActivity.class));
    }

    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_police_event_deal, null, false);
    }

    @Override
    protected void initActivityData() {
        activityViewData = new PoliceEventDealViewData(R.string.police_event_deal);
        dataBinding.setData(activityViewData);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new PoliceEventDealPresenter(this, dataBinding);
        dataBinding.setPresenter(presenter);
    }
}
