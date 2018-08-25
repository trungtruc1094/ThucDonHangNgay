package com.example.trungtrucnguyen.thucdonhangngay.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trungtrucnguyen.thucdonhangngay.CardAdapter;
import com.example.trungtrucnguyen.thucdonhangngay.FoodDetailsActivity;
import com.example.trungtrucnguyen.thucdonhangngay.R;


public class CardFragment extends Fragment {
    private Activity context;
    private static final String POSITION = "POSITION";
    private int pos;
    private CardView cardView;

    public CardFragment() {
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
        View view = inflater.inflate(R.layout.item_viewpager, container, false);
        this.context = getActivity();

        // Refer to cardView of fragment's layout
        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView foodTitle = (TextView) view.findViewById(R.id.foodTitle);
        foodTitle.setText(String.format("Canh kho qua %d", pos));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create an Intent object
                Intent intent=new Intent(context, FoodDetailsActivity.class);

                //Start the second activity
                startActivity(intent);
            }
        });
    }

    public static CardFragment getInstance(int position){
        CardFragment fm = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fm.setArguments(bundle);
        return fm;
    }

    public CardView getCardView(){
        return cardView;
    }
}
