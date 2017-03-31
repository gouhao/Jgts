package com.xdja.jwt.jgts.activity.policequery;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.gouhao.frame.mvp.BasePresenter;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.widget.DateTimePickDialog;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventQueryPresenter extends BasePresenter<IPoliceEventQueryView> implements IPoliceEventQueryPresenter {
        private DateTimePickDialog dialog;
    public PoliceEventQueryPresenter(Context context, IPoliceEventQueryView view) {
        super(context, view);
        dialog = new DateTimePickDialog(context, 1992, dateSetListener);
    }

    @Override
    public void pickDate() {
        dialog.show();
    }

    @Override
    public void query() {
        String reportName = view.getReporterName();
        String reportPhone = view.getReporterPhone();
        if(TextUtils.isEmpty(reportName) || TextUtils.isEmpty(reportPhone)) {
            Toast.makeText(context, context.getString(R.string.report_or_phone_not_empty),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(context, "query", Toast.LENGTH_SHORT).show();
    }

    private DateTimePickDialog.OnSetDataListener dateSetListener = new DateTimePickDialog.OnSetDataListener() {
        @Override
        public void onSetData(int year, int month, int day, int hour, int minute) {
            StringBuilder sb = new StringBuilder();
            sb.append(year)
            .append("-")
            .append(month)
            .append("-")
            .append(day)
            .append(" ")
            .append(hour)
            .append(":")
            .append(minute);
            view.setReportDate(sb.toString());
        }
    };
}

