package com.example.trungtrucnguyen.thucdonhangngay;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FoodDetailsActivity extends AppCompatActivity {
    TabLayout foodDetailTabLayout;
    ViewPager foodDetailViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        // Set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        foodDetailTabLayout = (TabLayout) findViewById(R.id.foodDetailTabLayout);
        foodDetailViewPager = (ViewPager) findViewById(R.id.foodDetailViewPager);

        FoodDetailsPagerAdapter foodDetailsPagerAdapter = new FoodDetailsPagerAdapter(getSupportFragmentManager());
        foodDetailViewPager.setAdapter(foodDetailsPagerAdapter);
        foodDetailTabLayout.setupWithViewPager(foodDetailViewPager);
    }

}
