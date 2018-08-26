package com.example.trungtrucnguyen.thucdonhangngay;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.trungtrucnguyen.thucdonhangngay.fragments.HowToCookFragment;
import com.example.trungtrucnguyen.thucdonhangngay.fragments.IngredientFragment;

public class FoodDetailsPagerAdapter extends FragmentStatePagerAdapter {


    public FoodDetailsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new IngredientFragment();
            case 1:
                return new HowToCookFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Nguyên Liệu";
            case 1: return "Cách Nấu";
            default: return null;
        }
    }
}
