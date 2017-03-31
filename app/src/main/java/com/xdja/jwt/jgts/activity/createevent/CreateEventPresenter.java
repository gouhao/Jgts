package com.xdja.jwt.jgts.activity.createevent;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.databinding.ActivitySubmitReportBinding;


/**
 * Created by gouhao on 3/31/2017.
 */

public class CreateEventPresenter extends BasePresenter<ActivitySubmitReportBinding> implements ICreateEventPresenter {
    public CreateEventPresenter(Context context, ActivitySubmitReportBinding binding) {
        super(context, binding);
    }
}
