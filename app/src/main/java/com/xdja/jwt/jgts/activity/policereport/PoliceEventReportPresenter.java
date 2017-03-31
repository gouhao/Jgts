package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;

import com.gouhao.frame.model.BaseModel;
import com.gouhao.frame.mvp.BasePresenter;
import com.xdja.jwt.jgts.bean.Event;
import com.xdja.jwt.jgts.model.EventModel;

import java.util.List;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventReportPresenter extends BasePresenter<IPoliceEventReportView> implements IPoliceEventReportPresenter {
    private EventModel eventModel;
    public PoliceEventReportPresenter(Context context, IPoliceEventReportView view) {
        super(context, view);
        eventModel = new EventModel();
    }

    @Override
    public void refresh() {
        eventModel.getMyCreateEvent(new BaseModel.Callback<List<Event>>() {
            @Override
            public void executeFinish(List<Event> result) {

            }
        });
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void startCreateEvent() {

    }
}
