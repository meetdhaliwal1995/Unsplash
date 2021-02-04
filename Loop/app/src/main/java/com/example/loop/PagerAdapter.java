package com.example.loop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Frag1();
            case 1:
                return new Frag2();
            case 2:
                return new Frag3();
            case 3:
                return new Frag4();
            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
