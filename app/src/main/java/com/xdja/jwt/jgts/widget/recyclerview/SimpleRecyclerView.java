package com.xdja.jwt.jgts.widget.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gouhao.frame.utils.LogUtil;
import com.xdja.jwt.jgts.R;

/**
 * Created by gouhao on 3/31/2017.
 */

public class SimpleRecyclerView extends SwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = SimpleRecyclerView.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager lineLayoutManager;
    private SwipeRefreshLayout.OnRefreshListener refreshListener;
    private OnLoadMoreListener loadMoreListener;
    private View footerView, emptyView, errorView;
    private boolean isLoading, isRefreshing;
    private LinearLayout contentPanel;

    public SimpleRecyclerView(Context context) {
        this(context, null);
    }

    public SimpleRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_simple_recycler, this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);

        lineLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lineLayoutManager);
        recyclerView.addItemDecoration(new ColorDecoration(Color.RED, 2) );
        recyclerView.addOnScrollListener(new ScrollListener());
        setOnRefreshListener(this);
        contentPanel = (LinearLayout) findViewById(R.id.contentPanel);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void setRefreshListener(SwipeRefreshLayout.OnRefreshListener listener){
        refreshListener = listener;
    }

    public void setLoadMoreListener(OnLoadMoreListener listener) {
        loadMoreListener = listener;
    }

    public void stopRefresh(){
        isRefreshing = false;
        setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        isRefreshing = true;
        if(refreshListener != null) {
            refreshListener.onRefresh();
        }
    }


    private class ScrollListener extends OnScrollListener {
            private int scrollState;
        private int lastDy = -1;
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            scrollState = newState;
            if(scrollState == 0) {
                onScrolledList(recyclerView);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if(dy != -1) {
                lastDy = dy;
            }

        }

        private void onScrolledList(RecyclerView recyclerView) {
            if(isRefreshing || isLoading || lastDy <= 0) {
                return;
            }
            int visibleItemCount = recyclerView.getChildCount();
            int firstVisibleItem = lineLayoutManager.findFirstVisibleItemPosition();
            int total = lineLayoutManager.getItemCount();
            if(firstVisibleItem + visibleItemCount >= total) {
                LogUtil.d(TAG, "onLoad");
                isLoading = true;
                if(loadMoreListener != null) {
                    loadMoreListener.onLoad();
                }
                showFooter();
            }

        }
    }



    public void setFooter(View view){
        footerView = view;
        hiddenFooter();
        contentPanel.addView(footerView);
    }

    private void showFooter() {
        if(footerView != null) {
            footerView.setVisibility(VISIBLE);
            recyclerView.smoothScrollBy(0, 100);
        }
    }

    private void hiddenFooter(){
        if(footerView != null) {
            footerView.setVisibility(GONE);
        }
    }

    public void stopLoadMore(){
        isLoading = false;
        hiddenFooter();
    }

    public interface OnLoadMoreListener {
        void onLoad();
    }


    public void setEmptyView(View emptyV) {
        emptyView = emptyV;
        emptyView.setVisibility(GONE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        contentPanel.addView(emptyView, params);
    }

    public void setErrorView(View errorV) {
        errorView = errorV;
        errorView.setVisibility(GONE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentPanel.addView(errorView, params);
    }

    public void showEmptyView() {
        emptyView.setVisibility(VISIBLE);
        errorView.setVisibility(GONE);
        recyclerView.setVisibility(GONE);
    }

    public void hiddenEmptyView(){
        emptyView.setVisibility(GONE);
    }

    public void showErrorView() {
        errorView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
        recyclerView.setVisibility(GONE);
    }

    public void hiddenErrorView(){
        errorView.setVisibility(GONE);
    }

    public void showRecyclerView(){
        recyclerView.setVisibility(VISIBLE);
        emptyView.setVisibility(GONE);
        errorView.setVisibility(GONE);
    }
}
