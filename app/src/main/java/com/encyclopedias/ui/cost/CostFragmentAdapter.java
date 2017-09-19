package com.encyclopedias.ui.cost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.encyclopedias.ui.base.BaseFragment;

import java.util.List;

/**
 * Created by zhuangjie on 2016/8/15.
 */
public class CostFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private List<String> titles;

    public CostFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles= titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }
    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {


        return titles.get(position);
    }
}
