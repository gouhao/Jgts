package com.xdja.jwt.jgts.activity.policequery;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import com.gouhao.frame.presenter.BasePresenter;

import java.util.Calendar;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryPresenter extends BasePresenter<PoliceEventQueryViewData> implements IPoliceEventQueryPresenter {
    private DatePickerDialog datePickerDialog;

    public PoliceEventQueryPresenter(Context context, PoliceEventQueryViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }

    @Override
    public void pickDate() {
        Calendar calendar = Calendar.getInstance();
        if(datePickerDialog == null) {
            datePickerDialog = new DatePickerDialog(context, dateSetListener, calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
        datePickerDialog.show();
    }

    @Override
    public void query() {

    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            activityData.date.set(year + "-" + month + "-" + dayOfMonth);
        }
    };
}

