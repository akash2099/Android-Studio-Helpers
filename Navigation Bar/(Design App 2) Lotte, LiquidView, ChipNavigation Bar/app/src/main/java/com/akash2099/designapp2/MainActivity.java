package com.akash2099.designapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.cuberto.liquid_swipe.LiquidPager;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_PAGES=3;
    private LiquidPager liquidPager;
    private ScreenSlidePagerAdapter screenSlidePagerAdapter;
    Animation pager_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liquidPager=findViewById(R.id.pager_liquid);

        // Setting the liquid pager
        screenSlidePagerAdapter=new ScreenSlidePagerAdapter(getSupportFragmentManager(),1,NUM_PAGES);
        liquidPager.setAdapter(screenSlidePagerAdapter);
        // Later add SKIP buttons or texts in each fragments

//        pager_anim= AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
//        liquidPager.startAnimation(pager_anim);

    }

}
