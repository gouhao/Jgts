package com.xdja.jwt.jgts.activity.policedeal;

import android.content.Context;

import com.gouhao.frame.mvp.BasePresenter;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventDealPresenter extends BasePresenter<IPoliceEventDealView> implements IPoliceEventDealPresenter {
    public PoliceEventDealPresenter(Context context, IPoliceEventDealView view) {
        super(context, view);
    }
}
