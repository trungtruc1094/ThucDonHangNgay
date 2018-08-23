package com.example.trungtrucnguyen.thucdonhangngay.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trungtrucnguyen.thucdonhangngay.R;


public class ByWeekFragment extends Fragment {
    private static final String POSITION = "POSITION";
    private int pos;

    public ByWeekFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt(POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_by_week, container, false);
        ((TextView)v.findViewById(R.id.tv)).setText(""+pos);
        return v;
    }


    public static Fragment getInstance(int position) {
        ByWeekFragment fm = new ByWeekFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fm.setArguments(bundle);
        return fm;
    }
}
