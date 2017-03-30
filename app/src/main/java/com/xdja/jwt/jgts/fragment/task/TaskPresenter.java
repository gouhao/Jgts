package com.xdja.jwt.jgts.fragment.task;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.activity.policemanage.PoliceManageActivity;

/**
 * Created by gouhao on 3/30/2017.
 */

public class TaskPresenter extends BasePresenter<TaskViewData> implements ITaskPresenter{

    public TaskPresenter(Context context, TaskViewData data) {
        super(context, data);
    }

    @Override
    public void executeFinish(Object object) {

    }

    @Override
    public void openPoliceEventManageActivity() {
        PoliceManageActivity.openActivity(context);
    }
}
