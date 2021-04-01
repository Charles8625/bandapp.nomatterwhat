package com.woythaltech.bandapp.nomatterwhat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView albumCover;
    private static final String TAG = "MainActivity";
    private TextView lyricScroll;
    private RecyclerView recyclerViewShows;
    private Show show;
    private ImageButton play;
    private ImageButton pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        albumCover = findViewById(R.id.albumCover);
        recyclerViewShows = findViewById(R.id.recyclerViewShows);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        pause.setVisibility(View.GONE);

        setupTabs();

        // Hide Action Bar
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

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

    public void onClick(View view) {

        // Bring up scrollable dialog showing the lyrics
        // Lyrics will be taken from a file instead of hard coded
        if (view.getId() == R.id.lyricMenu){

            LayoutInflater inflater = LayoutInflater.from(this);
            @SuppressLint("InflateParams")
            final View lyricView = inflater.inflate(R.layout.lyric_dialog, null);

            lyricScroll = lyricView.findViewById(R.id.lyricScroll);
            lyricScroll.setMovementMethod(new ScrollingMovementMethod());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Trance");
            builder.setView(lyricView);
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        // Bring up BandCamp page
        if (view.getId() == R.id.albumCover){
            Toast.makeText(this, "This will bring up bandcamp", Toast.LENGTH_SHORT).show();
        }

        // Bring up pictures for this show
        if (view.getId() == R.id.leftImage){
            Toast.makeText(this, "This will bring up slideshow of pictures", Toast.LENGTH_LONG).show();
        }

        // Bring up pictures for this show
        if (view.getId() == R.id.rightImage){
            Toast.makeText(this, "This will bring up slideshow of pictures", Toast.LENGTH_LONG).show();
        }

        // Bring up YouTube
        if (view.getId() == R.id.videoPicture){
            Toast.makeText(this, "This will bring up our YouTube", Toast.LENGTH_LONG).show();
        }

        // Media Buttons
        if (view.getId() == R.id.play){
            play.setVisibility(View.GONE);
            pause.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Play  song", Toast.LENGTH_SHORT).show();
        }

        if (view.getId() == R.id.pause){
            pause.setVisibility(View.GONE);
            play.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Pause song", Toast.LENGTH_SHORT).show();
        }

        if (view.getId() == R.id.song_back){
            Toast.makeText(this, "Move to last song", Toast.LENGTH_SHORT).show();
        }

        if (view.getId() == R.id.song_forward){
            Toast.makeText(this, "Move to next song", Toast.LENGTH_SHORT).show();
        }

        // Need action for clicking the shows
        // Need action for clicking the songs
    }
}