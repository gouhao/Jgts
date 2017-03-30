package com.xdja.jwt.jgts.activity.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xdja.jwt.jgts.R;

import java.util.List;

/**
 * Created by gouhao on 3/30/2017.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private int[] stringRes = {R.string.query, R.string.collection, R.string.task, R.string.map};
    private String[] titles;

    public MainViewPagerAdapter(Context context, List<Fragment> l, FragmentManager fm) {
        super(fm);
        this.fragments = l;
        initTitles(context);
    }

    private void initTitles(Context context) {
        titles = new String[stringRes.length];
        for(int i = 0; i < stringRes.length; i++) {
            titles[i] = context.getString(stringRes[i]);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
