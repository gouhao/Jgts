package com.xdja.jwt.jgts.fragment.task;

import android.content.Context;

import com.gouhao.frame.presenter.BasePresenter;
import com.xdja.jwt.jgts.activity.policemanage.PoliceManageActivity;
import com.xdja.jwt.jgts.databinding.ActivityTaskBinding;
import com.xdja.jwt.jgts.databinding.FragmentTaskBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class TaskPresenter extends BasePresenter<FragmentTaskBinding> implements ITaskPresenter{

    public TaskPresenter(Context context, FragmentTaskBinding binding) {
        super(context, binding);
    }

    @Override
    public void openPoliceEventManageActivity() {
        PoliceManageActivity.openActivity(context);
    }
}
