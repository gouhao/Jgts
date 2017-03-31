package com.xdja.jwt.jgts.activity.policemanage;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.databinding.ActivityPoliceManageBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceManageActivity extends BackNavActivity<ActivityPoliceManageBinding,PoliceManagePresenter> implements IPoliceManageView{

    public static void openActivity(Context context) {
        context.startActivity(new Intent(context, PoliceManageActivity.class));
    }
    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_police_manage, null, false);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new PoliceManagePresenter(this, this);
        dataBinding.setPresenter(presenter);
    }

    @Override
    protected void initTitle() {
        super.initTitle();
        getTitleBar().setTitleBarTitle(R.string.police_manage);
    }
}
