package com.xdja.jwt.jgts.activity.policequery;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.databinding.ActivityPoliceEventQueryBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryActivity extends BackNavActivity<ActivityPoliceEventQueryBinding, PoliceEventQueryViewData, PoliceEventQueryPresenter> {
    public static void openActivity(Context context) {
        context.startActivity(new Intent(context, PoliceEventQueryActivity.class));
    }
    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_police_event_query, null, false);
    }

    @Override
    protected void initActivityData() {
        activityViewData = new PoliceEventQueryViewData(R.string.police_event_query);
        dataBinding.setData(activityViewData);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new PoliceEventQueryPresenter(this, dataBinding);
        dataBinding.setPresenter(presenter);
    }
}
