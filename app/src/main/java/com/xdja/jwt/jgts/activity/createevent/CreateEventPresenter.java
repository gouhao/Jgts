package com.xdja.jwt.jgts.activity.createevent;

import android.content.Context;

import com.gouhao.frame.mvp.BasePresenter;


/**
 * Created by gouhao on 3/31/2017.
 */

public class CreateEventPresenter extends BasePresenter<ICreateEventView>
        implements ICreateEventPresenter {
    public CreateEventPresenter(Context context, ICreateEventView view) {
        super(context, view);
    }
}
