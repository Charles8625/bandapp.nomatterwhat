package com.woythaltech.bandapp.nomatterwhat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTabs();
    }

    public void setupTabs() {

        TabLayout tabLayout = findViewById(R.id.toolbar);
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab t;

        t = tabLayout.getTabAt(0);
        if (t != null)
            t.setIcon(R.drawable.round_audiotrack_white_36);

        t = tabLayout.getTabAt(1);
        if (t != null)
            t.setIcon(R.drawable.round_auto_awesome_mosaic_white_36);

        t = tabLayout.getTabAt(2);
        if (t != null)
            t.setIcon(R.drawable.round_music_video_white_36);

        t = tabLayout.getTabAt(3);
        if (t != null)
            t.setIcon(R.drawable.round_groups_white_36);

        t = tabLayout.getTabAt(4);
        if (t != null)
            t.setIcon(R.drawable.round_store_white_36);

        t = tabLayout.getTabAt(5);
        if (t != null)
            t.setIcon(R.drawable.round_account_box_white_36);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: " + tab.getContentDescription());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabUnselected: " + tab.getContentDescription());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabReselected: " + tab.getContentDescription());
            }
        });


    }
}