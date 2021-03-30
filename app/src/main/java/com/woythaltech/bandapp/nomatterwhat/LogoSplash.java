package com.woythaltech.bandapp.nomatterwhat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LogoSplash extends AppCompatActivity {

    private ImageView nmwEnter;
    private static final int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_splash);

        nmwEnter = findViewById(R.id.nmwEnterSplash);
        Animation animateIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        //Animation animateOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        nmwEnter.startAnimation(animateIn);
        //nmwEnter.startAnimation(animateOut);

        new Handler().postDelayed(() -> {

            Intent i = new Intent(LogoSplash.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, SPLASH_TIME_OUT);
    }


    @Override
    public void onBackPressed() {
    }

    }
