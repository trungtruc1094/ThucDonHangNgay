package com.example.trungtrucnguyen.thucdonhangngay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;

import com.example.trungtrucnguyen.thucdonhangngay.fragments.CardFragment;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {
    private List<CardFragment> fragments;
    private float baseElevation;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation) {
        super(fm);
        fragments = new ArrayList<>();
        this.baseElevation = baseElevation;
        for (int i = 0; i < 3; i++) {
            fragments.add(CardFragment.getInstance(i));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);//CardFragment.getInstance(position);
    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return fragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addCardFragment(CardFragment fragment){
        fragments.add(fragment);
    }
}
