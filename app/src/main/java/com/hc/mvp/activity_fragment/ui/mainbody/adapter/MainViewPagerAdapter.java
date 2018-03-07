package com.hc.mvp.activity_fragment.ui.mainbody.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private final String TAG = "MainViewPagerAdapter";
    FragmentManager fragmentManager;
    private List<Fragment> fragmentList;

    public MainViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
