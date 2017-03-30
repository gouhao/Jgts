package com.xdja.jwt.jgts.fragment.task;

import android.databinding.DataBindingUtil;

import com.gouhao.frame.fragment.BaseDataBindingFragment;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.databinding.FragmentTaskBinding;

/**
 * Created by gouhao on 3/30/2017.
 */

public class TaskFragment extends BaseDataBindingFragment<FragmentTaskBinding, TaskViewData, TaskPresenter> {
    @Override
    protected void initDataBinding() {
        dataBinding = DataBindingUtil.inflate(getActivity().getLayoutInflater(),
                R.layout.fragment_task, null, false);
    }

    @Override
    protected void initViewData() {
        viewData = new TaskViewData();
        dataBinding.setData(viewData);
    }

    @Override
    protected void initPresenter() {
        presenter = new TaskPresenter(viewData);
        dataBinding.setPresenter(presenter);
    }
}
