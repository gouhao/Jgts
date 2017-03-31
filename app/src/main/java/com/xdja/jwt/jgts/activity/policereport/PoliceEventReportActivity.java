package com.xdja.jwt.jgts.activity.policereport;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import com.xdja.jwt.jgts.R;
import com.xdja.jwt.jgts.activity.base.BackNavActivity;
import com.xdja.jwt.jgts.bean.Event;
import com.xdja.jwt.jgts.databinding.ActivityPoliceEventReportBinding;
import com.xdja.jwt.jgts.widget.recyclerview.SimpleRecyclerView;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by gouhao on 3/30/2017.
 */

public class PoliceEventReportActivity extends BackNavActivity<ActivityPoliceEventReportBinding,
        PoliceEventReportViewData, PoliceEventReportPresenter> implements SwipeRefreshLayout.OnRefreshListener, SimpleRecyclerView.OnLoadMoreListener {
    public static void openActivity(Context context) {
        context.startActivity(new Intent(context, PoliceEventReportActivity.class));
    }

    private static final int WHAT_UPDATE_LIST = 1;
    private static final int WHAT_LOAD_MORE = 2;
    private ReportAdapter adapter;
    private List<Event> dataList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataList = new ArrayList<>();
        adapter =  new ReportAdapter(this, dataList);
        dataBinding.recyclerView.setAdapter(adapter);
        dataBinding.recyclerView.setRefreshListener(this);
        dataBinding.recyclerView.setLoadMoreListener(this);
        dataBinding.recyclerView.setFooter(getLayoutInflater().inflate(R.layout.footer_recycler, null));
        createTestData();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_UPDATE_LIST:
                    adapter.notifyDataSetChanged();
                    break;
                case WHAT_LOAD_MORE:
                    dataBinding.recyclerView.stopLoadMore();
                    break;
            }
        }
    };
    private void createTestData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    for(int i = 0; i < 15; i++) {
                        Event event = new Event();
                        event.setCallTime("2012-12-12 12-12");
                        event.setAddress("锦业路" + (i + 1));
                        dataList.add(event);
                    }
                    handler.sendEmptyMessage(WHAT_UPDATE_LIST);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    protected void initActivityDataBinding() {
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_police_event_report, null, false);
    }

    @Override
    protected void initActivityData() {
        activityViewData = new PoliceEventReportViewData(R.string.police_event_report);
        dataBinding.setData(activityViewData);
    }

    @Override
    protected void initActivityPresenter() {
        presenter = new PoliceEventReportPresenter(this, dataBinding);
        dataBinding.setPresenter(presenter);
    }

    @Override
    public void onRefresh() {
        dataBinding.recyclerView.stopRefresh();
    }

    @Override
    public void onLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(WHAT_LOAD_MORE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
