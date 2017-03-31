package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BaseRecyclerAdapter;
import com.xdja.jwt.jgts.bean.Event;
import com.xdja.jwt.jgts.databinding.ItemReportBinding;

import java.util.List;

/**
 * Created by gouhao on 3/31/2017.
 */

public class ReportAdapter extends BaseRecyclerAdapter<ReportViewHolder, Event> {

    public ReportAdapter(Context context, List<Event> dataList) {
        super(context, dataList);
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemReportBinding itemReportBinding = DataBindingUtil.inflate(inflater, R.layout.item_report, null, false);
        ReportViewHolder reportViewHolder = new ReportViewHolder(itemReportBinding.getRoot(), itemReportBinding);
        return reportViewHolder;
    }

    @Override
    public void onBindViewHolder(ReportViewHolder holder, int position) {
        ItemReportBinding binding = holder.getDataBinding();
        Event item = dataList.get(position);
        binding.setDate(item.getCallTime());
        binding.setPosition(item.getAddress());
        binding.setTheme(item.getAddress());
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
