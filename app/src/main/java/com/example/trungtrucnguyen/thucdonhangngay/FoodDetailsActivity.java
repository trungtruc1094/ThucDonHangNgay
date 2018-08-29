package com.example.trungtrucnguyen.thucdonhangngay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.trungtrucnguyen.thucdonhangngay.utils.DimensionUtils;

import static java.security.AccessController.getContext;

public class FoodDetailsActivity extends AppCompatActivity {
    private TabLayout foodDetailTabLayout;
    private ViewPager foodDetailViewPager;
    private ImageButton backButton;
    private ToggleButton favoriteBtn;
    private RelativeLayout favoriteLayout;
    private Button cookingBtn;
    private boolean currentFavoriteStatus = true;

    private float actionBarHeightValue;

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
        setUpTabLayout();
        foodDetailTabLayout.setupWithViewPager(foodDetailViewPager);

        // Set height of Cooking button
        actionBarHeightValue = getActionBarHeight();

        cookingBtn = findViewById(R.id.cookingBtn);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) cookingBtn.getLayoutParams();
        layoutParams.setAnchorId(R.id.nestedScrollView);
        layoutParams.anchorGravity = Gravity.BOTTOM;
        layoutParams.width = CoordinatorLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = (int) (actionBarHeightValue * 2 / 3);
        cookingBtn.setLayoutParams(layoutParams);


        // Set back button
        backButton = findViewById(R.id.backItem);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set favorite button
        favoriteBtn = findViewById(R.id.button_favorite);
        if (currentFavoriteStatus){
            favoriteBtn.setChecked(true);
        } else {
            favoriteBtn.setChecked(false);
        }

        // Listen to favorite button
        favoriteBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast.makeText(FoodDetailsActivity.this, "Add to my favorite", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FoodDetailsActivity.this, "Remove from my favorite", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setUpTabLayout() {
        foodDetailTabLayout.setTabTextColors(getResources().getColor(R.color.tab_unselected_detail), getResources().getColor(R.color.tab_selected_detail));
        foodDetailTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_selected_detail));
        foodDetailTabLayout.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
    }

    private float getActionBarHeight(){
        // Calculate ActionBar height
        float actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }

//    private void toggleFavoriteButton(boolean favorite){
//        if (favorite) {
//            favoriteBtn.setImageDrawable(R.drawable.ic_favorite);
//        } else {
//            favoriteBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border));
//        }
//    }
}
