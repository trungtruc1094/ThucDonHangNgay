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
import com.example.trungtrucnguyen.thucdonhangngay.ShadowTransformer;
import com.example.trungtrucnguyen.thucdonhangngay.utils.DimensionUtils;


public class ByDayFragment extends Fragment {

    //    private static float baseElevation = 10;
    private ViewPager viewPagerBreakfast;
    private ViewPager viewPagerLunch;
    private ViewPager viewPagerDinner;

    private CardFragmentPagerAdapter cardFragmentPagerAdapter;

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
        viewPagerBreakfast = view.findViewById(R.id.pagerMorning);
        viewPagerLunch = view.findViewById(R.id.pagerLunch);
        viewPagerDinner = view.findViewById(R.id.pagerDinner);

        setUpShadowTransformerForFragments(viewPagerBreakfast);
        setUpShadowTransformerForFragments(viewPagerLunch);
        setUpShadowTransformerForFragments(viewPagerDinner);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        int[] initialPositions = new int[3];
        initialPositions[0] = getMiddlePositionForFragmentsOfViewPager(viewPagerBreakfast);
        initialPositions[1] = getMiddlePositionForFragmentsOfViewPager(viewPagerLunch);
        initialPositions[2] = getMiddlePositionForFragmentsOfViewPager(viewPagerDinner);

        viewPagerBreakfast.setCurrentItem(initialPositions[0]);
        viewPagerLunch.setCurrentItem(initialPositions[1]);
        viewPagerDinner.setCurrentItem(initialPositions[2]);
    }

    private int getMiddlePositionForFragmentsOfViewPager(ViewPager viewPager){
        int numberOfViewPagerBreakfast = viewPager.getAdapter().getCount();
        int initialPosition =  (int) (numberOfViewPagerBreakfast / 2);
        return initialPosition;
    }

    private void setUpShadowTransformerForFragments(ViewPager viewPager) {
        cardFragmentPagerAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(), DimensionUtils.dpToPixels(2, getActivity()));
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, cardFragmentPagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(cardFragmentPagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
    }
}
