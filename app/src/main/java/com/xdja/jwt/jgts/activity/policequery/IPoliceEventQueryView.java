package com.xdja.jwt.jgts.activity.policequery;

import com.gouhao.frame.mvp.IView;

/**
 * Created by gouhao on 3/31/2017.
 */

public interface IPoliceEventQueryView extends IView {
    String getReporterName();

    String getReporterPhone();

    void setReportDate(String date);
}
