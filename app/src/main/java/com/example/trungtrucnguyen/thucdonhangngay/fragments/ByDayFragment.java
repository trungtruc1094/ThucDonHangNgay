package com.example.trungtrucnguyen.thucdonhangngay.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trungtrucnguyen.thucdonhangngay.CardFragmentPagerAdapter;
import com.example.trungtrucnguyen.thucdonhangngay.R;
import com.example.trungtrucnguyen.thucdonhangngay.utils.DimensionUtils;


public class ByDayFragment extends Fragment {

    //    private static float baseElevation = 10;
    private ViewPager viewPager;

    public ByDayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_by_day, container, false);
        viewPager = view.findViewById(R.id.pagerMorning);
        viewPager.setAdapter(new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(), DimensionUtils.dpToPixels(2, getActivity())));

        return view;
    }



}
