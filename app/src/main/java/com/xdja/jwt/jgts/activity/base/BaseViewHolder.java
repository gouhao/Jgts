package com.xdja.jwt.jgts.activity.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by gouhao on 3/31/2017.
 */

public class BaseViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected V dataBinding;

    public BaseViewHolder(View itemView, V dataBinding) {
        super(itemView);
        this.dataBinding = dataBinding;
    }

    public V getDataBinding() {
        return dataBinding;
    }
}
