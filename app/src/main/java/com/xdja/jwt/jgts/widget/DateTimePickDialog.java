package com.xdja.jwt.jgts.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;
import com.xdja.jwt.jgts.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by gouhao on 3/30/2017.
 * 月份从1开始
 */

public class DateTimePickDialog extends Dialog implements View.OnClickListener {
    private WheelView<Integer> yearView, monthView, dayView, hourView, minuteView;
    private int startYear;
    private Calendar calendar;

    private OnSetDataListener listener;

    public interface OnSetDataListener{
        void onSetData(int year, int month, int day, int hour, int minute);
    }

    public DateTimePickDialog(Context context, int startYear, OnSetDataListener listener) {
        super(context, R.style.CustomDialog);
        calendar = Calendar.getInstance();
        this.startYear = startYear;
        this.listener = listener;
        init();
    }

    private void initDataAndView() {
        initYearData();
        initMonthData();
        initDayData();
        initHourData();
        initMinuteData();
        initSelection();
    }

    private void initMonthData() {
        List<Integer> monthList = new ArrayList<>();
        for(int i = 1; i <= 12; i++) {
            monthList.add(i);
        }
        monthView.setWheelData(monthList);
        monthView.setWheelAdapter(new ArrayWheelAdapter<Integer>(getContext()));
        monthView.setExtraText(getContext().getString(R.string.month), Color.parseColor("#0288ce"), 40, 70);
    }

    private void initSelection() {
        yearView.setSelection(calendar.get(Calendar.YEAR) - startYear);
        monthView.setSelection(calendar.get(Calendar.MONTH));
        dayView.setSelection(calendar.get(Calendar.DAY_OF_MONTH) - 1);
        hourView.setSelection(calendar.get(Calendar.HOUR_OF_DAY) - 1);
        minuteView.setSelection(calendar.get(Calendar.MINUTE) - 1);
    }

    private void initMinuteData() {
        List<Integer> minuteList = new ArrayList<>();
        for(int i = 1; i <= 60; i++) {
            minuteList.add(i);
        }
        minuteView.setWheelData(minuteList);
        minuteView.setWheelAdapter(new ArrayWheelAdapter<Integer>(getContext()));
        minuteView.setExtraText(getContext().getString(R.string.minute), Color.parseColor("#0288ce"), 40, 70);
    }


    private void initHourData() {
        List<Integer> hourList = new ArrayList<>();
        for(int i = 1; i <= 24; i++) {
            hourList.add(i);
        }
        hourView.setWheelData(hourList);
        hourView.setWheelAdapter(new ArrayWheelAdapter<Integer>(getContext()));
        hourView.setExtraText(getContext().getString(R.string.hour), Color.parseColor("#0288ce"), 40, 70);
    }

    private void initDayData() {
        List<Integer> dayList = new ArrayList<>();
        for(int i = 1; i <= 31; i++) {
            dayList.add(i);
        }
        dayView.setWheelData(dayList);
        dayView.setWheelAdapter(new ArrayWheelAdapter<Integer>(getContext()));
        dayView.setExtraText(getContext().getString(R.string.day), Color.parseColor("#0288ce"), 40, 70);
    }

    private void initYearData() {
        int nowYear = calendar.get(Calendar.YEAR);
        if(nowYear < startYear) {
            throw new IllegalArgumentException("start year > now year");
        }
        List<Integer> yearDataList = new ArrayList<>();
        for(int i = startYear; i <= nowYear; i++) {
            yearDataList.add(i);
        }
        yearView.setWheelData(yearDataList);
        yearView.setWheelAdapter(new ArrayWheelAdapter<Integer>(getContext()));
        yearView.setExtraText(getContext().getString(R.string.year), Color.parseColor("#0288ce"), 40, 70);
    }

    private void init() {
        setContentView(R.layout.dialog_date_time_picker);
        yearView = (WheelView<Integer>) findViewById(R.id.wv_year);
        monthView = (WheelView<Integer>) findViewById(R.id.wv_month);
        dayView = (WheelView<Integer>) findViewById(R.id.wv_day);
        hourView = (WheelView<Integer>) findViewById(R.id.wv_hour);
        minuteView = (WheelView<Integer>) findViewById(R.id.wv_minute);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        initDataAndView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                cancel();
                break;
            case R.id.btn_ok:
                setData();
                break;
        }
    }

    private void setData() {
        cancel();
        if(listener != null) {
            listener.onSetData(yearView.getSelectionItem(), monthView.getSelectionItem(),
                    dayView.getSelectionItem(), hourView.getSelectionItem(), minuteView.getSelectionItem());
        }
    }
}
