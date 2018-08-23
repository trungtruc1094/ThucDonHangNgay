package com.example.trungtrucnguyen.thucdonhangngay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.trungtrucnguyen.thucdonhangngay.fragments.ByDayFragment;
import com.example.trungtrucnguyen.thucdonhangngay.fragments.ByWeekFragment;

class PagerAdapter2 extends FragmentStatePagerAdapter {
    public PagerAdapter2(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ByWeekFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Hai";
            case 1: return "Ba";
            case 2: return "Tư";
            case 3: return "Năm";
            case 4: return "Sáu";
            case 5: return "Bảy";
            case 6: return "CN";
            default: return null;
        }
    }
}
