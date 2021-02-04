package com.example.replesh2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.e("ccc","c");
                return new FragHome();
            case 1:
                Log.e("ddd","d");
                return new FragCollections();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
