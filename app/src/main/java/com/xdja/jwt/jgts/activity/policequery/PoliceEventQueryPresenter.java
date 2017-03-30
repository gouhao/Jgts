package com.xdja.jwt.jgts.activity.policequery;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.widget.DateTimePickDialog;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryPresenter extends BasePresenter<PoliceEventQueryViewData> implements IPoliceEventQueryPresenter {
        private DateTimePickDialog dialog;
    public PoliceEventQueryPresenter(Context context, PoliceEventQueryViewData data) {
        super(context, data);
        dialog = new DateTimePickDialog(context, 1992, dateSetListener);
    }

    @Override
    public void executeFinish(Object object) {

    }

    @Override
    public void pickDate() {
        dialog.show();
    }

    @Override
    public void query() {

    }

    private DateTimePickDialog.OnSetDataListener dateSetListener = new DateTimePickDialog.OnSetDataListener() {
        @Override
        public void onSetData(int year, int month, int day, int hour, int minute) {
            StringBuilder sb = new StringBuilder();
            sb.append(year);
            sb.append("-");
            sb.append(month);
            sb.append("-");
            sb.append(day);
            sb.append(" ");
            sb.append(hour);
            sb.append(":");
            sb.append(minute);
            activityData.date.set(sb.toString());
        }
    };
}

