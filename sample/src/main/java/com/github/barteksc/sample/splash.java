package com.github.barteksc.sample;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    private TextView name, slogan;
    private ImageView logo;
    private View topView1, topView2, topView3;
    private View bottomView1, bottomView2, bottomView3;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_IMMERSIVE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        name = findViewById(R.id.name);
        slogan = findViewById(R.id.slogan);
        logo = findViewById(R.id.logo);
        topView1=findViewById(R.id.topView1);
        topView2 = findViewById(R.id.topView2);
        topView3 = findViewById(R.id.topView3);
        bottomView1=findViewById(R.id.bottomView1);
        bottomView2=findViewById(R.id.bottomView2);
        bottomView3 = findViewById(R.id.bottomView3);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity
                Intent intent = new Intent(splash.this, PDFViewActivity_.class);
                startActivity(intent);
                finish(); // Finish the splash activity to prevent going back to it
            }
        }, 6500);
        final Animation logoAnimation= AnimationUtils.loadAnimation(splash.this, R.anim.zoom_animation);
        final Animation nameAnimation=AnimationUtils.loadAnimation( splash.this, R.anim.zoom_animation);
        Animation topView1Animation =AnimationUtils.loadAnimation(splash.this, R.anim.top_views_animation);
        final Animation topView2Animation =AnimationUtils.loadAnimation(splash.this, R.anim.top_views_animation);
        final Animation topView3Animation = AnimationUtils.loadAnimation(splash.this, R.anim.top_views_animation);
        Animation bottomView1Animation =AnimationUtils.loadAnimation(splash.this, R.anim.bottom_views_animation);
        final Animation bottomView2Animation = AnimationUtils.loadAnimation(splash.this, R.anim.bottom_views_animation);
        final Animation bottomView3Animation = AnimationUtils.loadAnimation(splash.this, R.anim.bottom_views_animation);

        topView1.startAnimation (topView1Animation);
        bottomView1.startAnimation (bottomView1Animation);

        topView1Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                topView2.setVisibility(View.VISIBLE);
                bottomView2.setVisibility(View.VISIBLE);
                topView2.startAnimation(topView2Animation);
                bottomView2.startAnimation (bottomView2Animation);
            }
            @Override
            public void onAnimationRepeat (Animation animation) {

            }
        });

        topView2Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                topView3.setVisibility(View.VISIBLE);
                bottomView3.setVisibility(View.VISIBLE);
                topView3.startAnimation(topView3Animation);
                bottomView3.startAnimation (bottomView3Animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        topView3Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.setVisibility(View.VISIBLE);
                logo.startAnimation(logoAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                name.setVisibility(View.VISIBLE);
                name.startAnimation(nameAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        nameAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                slogan.setVisibility(View.VISIBLE);
                final String animatetxt=slogan.getText().toString();
                slogan.setText("");
                count= 0;
                new CountDownTimer(animatetxt.length()*100,100) {
                    @Override
                    public void onTick(long millisuntilFinished) {
                        slogan.setText(slogan.getText().toString() + animatetxt.charAt(count));
                        count++;
                    }
                    @Override
                    public void onFinish() {

                    }
                }.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}