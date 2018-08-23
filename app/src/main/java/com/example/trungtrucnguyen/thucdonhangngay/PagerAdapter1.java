package com.example.trungtrucnguyen.thucdonhangngay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.trungtrucnguyen.thucdonhangngay.fragments.ByDayFragment;
import com.example.trungtrucnguyen.thucdonhangngay.fragments.ByWeekFragment;

public class PagerAdapter1 extends FragmentStatePagerAdapter {

    PagerAdapter1(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ByDayFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }

}
