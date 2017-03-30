package com.xdja.jwt.jgts.activity.policemanage;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;

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
}
