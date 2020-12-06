package com.akash2099.designapp2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.cuberto.liquid_swipe.LiquidPager;

public class IntroductoryActivity extends AppCompatActivity {

//    private static final int NUM_PAGES=3;
//    private LiquidPager viewPager;
//    private ScreenSlidePagerAdapter screenSlidePagerAdapter;
//    Animation pager_anim;



//    private static int STATIC_SCREEN_TIME = 5200;
    TextView app_name_text;
    LottieAnimationView lottieAnimationView;
    Button next_button;
    Animation next_bottom_anim,top_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        app_name_text = (TextView) findViewById(R.id.app_name_text);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie);
        next_button=(Button)findViewById(R.id.next_button);

        // Liquid display
//        viewPager=findViewById(R.id.pager_liquid);
//        screenSlidePagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager(),1,NUM_PAGES);
//        viewPager.setAdapter(screenSlidePagerAdapter);
//        pager_anim= AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
//        viewPager.startAnimation(pager_anim);

        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);

//        app_name_text.animate().translationY(-2000).setDuration(1000).setStartDelay(5400);
//        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(5400);

        next_bottom_anim= AnimationUtils.loadAnimation(this,R.anim.next_anim);
        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_anim);

        next_button.startAnimation(next_bottom_anim);
        app_name_text.startAnimation(top_anim);

        // Move to the next activity after lotte animation is over
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(IntroductoryActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, STATIC_SCREEN_TIME);
//
    }

    public void go_to_next(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}