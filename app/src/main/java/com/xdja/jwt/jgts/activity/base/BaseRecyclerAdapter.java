package com.xdja.jwt.jgts.activity.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

/**
 * Created by gouhao on 3/31/2017.
 */

public abstract class BaseRecyclerAdapter<VH extends RecyclerView.ViewHolder, D extends Object>
        extends RecyclerView.Adapter<VH> {
    protected Context context;
    protected List<D> dataList;
    protected LayoutInflater inflater;

    public BaseRecyclerAdapter(Context context, List<D> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }


}
