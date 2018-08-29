package com.example.trungtrucnguyen.thucdonhangngay.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.trungtrucnguyen.thucdonhangngay.DataManager.IngredientDataManager;
import com.example.trungtrucnguyen.thucdonhangngay.IngredientItem;
import com.example.trungtrucnguyen.thucdonhangngay.IngredientListAdapter;
import com.example.trungtrucnguyen.thucdonhangngay.R;

import java.util.ArrayList;

public class IngredientFragment extends Fragment {
    private Context mContext;
    private IngredientListAdapter ingredientListAdapter;
    private ArrayList<IngredientItem> ingredientItemArrayList;
    private ListView ingredientListView;

    public IngredientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        ingredientItemArrayList = IngredientDataManager.getIngredientList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        ingredientListView = (ListView) view.findViewById(R.id.ingredient_listview);

        // Create values for Dropdown list
        String[] arraySpinner = new String[]{"1", "2", "3", "4"};

        Spinner spinner = view.findViewById(R.id.spinnerRation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Show list of ingredient
        populateFruitList();
        return view;
    }

    private void populateFruitList() {
        if (ingredientItemArrayList != null && ingredientItemArrayList.size() > 0){
            if (ingredientListAdapter == null) {
                ingredientListAdapter = new IngredientListAdapter(mContext, ingredientItemArrayList);
            }
            ingredientListView.setAdapter(ingredientListAdapter);
        } else {
            ingredientListAdapter.setmItemsList(ingredientItemArrayList);
        }
    }

    @Override
    public void onDestroy() {
        if(mContext != null){
            mContext = null;
            ingredientListAdapter = null;
            ingredientListView = null;
            ingredientItemArrayList = null;
        }
        super.onDestroy();
    }
}
