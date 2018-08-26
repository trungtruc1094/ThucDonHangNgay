package com.example.trungtrucnguyen.thucdonhangngay;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout navigationItem;
    DrawerLayout drawerLayout;
    NavigationView drawerLeft;
    ViewPager viewPager;
    TabLayout tabLayoutBy;
    TabLayout tabLayoutDayOfWeek;
    LinearLayout currentDateLayout;
    LinearLayout dayOfWeekLayout;
    private PagerAdapter pagerAdapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationItem = (LinearLayout) findViewById(R.id.navigationItem);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        drawerLeft = (NavigationView) findViewById(R.id.left_drawer);

        navigationItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionCloseOpenNavDrawer();
            }
        });

        currentDateLayout = (LinearLayout) findViewById(R.id.currentDateLayout);
        dayOfWeekLayout = (LinearLayout) findViewById(R.id.dayOfWeekLayout);

        /* Create tab views */
        viewPager = findViewById(R.id.pager);
//        viewPager.setPagingEnabled(false);

        tabLayoutBy = (TabLayout) findViewById(R.id.tabLayout);
        tabLayoutDayOfWeek = (TabLayout) findViewById(R.id.dayOfWeek);

        pagerAdapter1 = new PagerAdapter1(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter1);
        setupTabLayoutWithViewPager();

    }

    // Toggle
    public void setupTabLayoutWithViewPager(){
        //tabLayout.setupWithViewPager(viewPager);

        setUpTabLayout();

        tabLayoutBy.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        currentDateLayout.setVisibility(View.VISIBLE);
                        dayOfWeekLayout.setVisibility(View.INVISIBLE);
                        pagerAdapter1 = new PagerAdapter1(getSupportFragmentManager());
                        viewPager.setAdapter(pagerAdapter1);
                        break;
                    case 1:
                        currentDateLayout.setVisibility(View.INVISIBLE);
                        dayOfWeekLayout.setVisibility(View.VISIBLE);
                        viewPager.setAdapter(new PagerAdapter2(getSupportFragmentManager()));
                        tabLayoutDayOfWeek.setupWithViewPager(viewPager);
                        tabLayoutDayOfWeek.setTabTextColors(getResources().getColor(R.color.tab_selected), getResources().getColor(R.color.tab_selected));
                        tabLayoutDayOfWeek.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_selected));
                        tabLayoutDayOfWeek.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpTabLayout() {
        tabLayoutBy.addTab(tabLayoutBy.newTab().setText("Theo Ngày"));
        tabLayoutBy.addTab(tabLayoutBy.newTab().setText("Theo Tuần"));
        tabLayoutBy.setTabTextColors(getResources().getColor(R.color.tab_unselected), getResources().getColor(R.color.tab_selected));
        tabLayoutBy.setSelectedTabIndicatorColor(getResources().getColor(R.color.tab_selected));
        tabLayoutBy.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
    }

    // Toggle Sliding Menu
    private void actionCloseOpenNavDrawer(){
        if (drawerLayout.isDrawerOpen(drawerLeft)){
            drawerLayout.closeDrawer(drawerLeft);
        } else {
            drawerLayout.openDrawer(drawerLeft);
        }
    }
}
