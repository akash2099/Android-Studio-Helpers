package com.akash2099.designapp2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private int NUM_PAGES;
    public ScreenSlidePagerAdapter(@NonNull FragmentManager fm, int behaviour,int page_count) {
        super(fm,behaviour);
        this.NUM_PAGES=page_count;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        // right now i considered that NUM_PAGES=3
        switch(position){
            case 0:
                selectedFragment=new Fragment_1();
                break;
            case 1:
                selectedFragment=new Fragment_2();
                break;
            case 2:
                selectedFragment=new Fragment_3();
                break;
            default:
                selectedFragment=null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}

