package com.akash2099.designapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Time splash screen
    private static int STATIC_SCREEN = 5000; // 5seconds

    // Variables
    Animation topAnim, bottomAnim;
    ImageView logo_image;
    TextView slogan_head, slogan_body;

    // Beautiful app drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Hooks
        logo_image = findViewById(R.id.start_logo);
        slogan_head = findViewById(R.id.slogan_heading);
        slogan_body = findViewById(R.id.slogan_normal);

        // Setting animations
        logo_image.setAnimation(topAnim);
        slogan_head.setAnimation(bottomAnim);
        slogan_body.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SampleActivity.class);
//        intent.putExtra(key:,value:);
                startActivity(intent);
                finish();
            }
        },STATIC_SCREEN);

    }
}
