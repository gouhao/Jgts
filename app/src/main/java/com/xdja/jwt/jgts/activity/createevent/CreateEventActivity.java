package com.xdja.jwt.jgts.activity.createevent;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.databinding.ActivitySubmitReportBinding;

/**
 * Created by gouhao on 3/31/2017.
 */

public class CreateEventActivity extends BackNavActivity<ActivitySubmitReportBinding, CreateEventPresenter> implements ICreateEventView{
    public static void start(Context context) {
        context.startActivity(new Intent(context, CreateEventActivity.class));
    }
    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_submit_report, null, false);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new CreateEventPresenter(this, this);
        dataBinding.setPresenter(presenter);
    }

    @Override
    protected void initTitle() {
        super.initTitle();
        getTitleBar().setTitleBarTitle(R.string.create_event);
    }
}
