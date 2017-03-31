package com.xdja.jwt.jgts.fragment.task;

import android.content.Context;

import com.gouhao.frame.mvp.BasePresenter;
import com.xdja.jwt.jgts.activity.policemanage.PoliceManageActivity;

/**
 * Created by gouhao on 3/30/2017.
 */

public class TaskPresenter extends BasePresenter<ITaskView> implements ITaskPresenter{

    public TaskPresenter(Context context, ITaskView view) {
        super(context, view);
    }

    @Override
    public void openPoliceEventManageActivity() {
        PoliceManageActivity.openActivity(context);
    }
}
