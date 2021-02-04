package com.example.replesh2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter2 extends FragmentPagerAdapter {
    public PagerAdapter2(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragPhotos();
            case 1:
                return new FragCollect();
            case 2:
                return new FragUsers();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
