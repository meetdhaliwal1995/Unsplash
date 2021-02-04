package com.example.webbrouser;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> _fragment;

    public PagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> _fragment) {
        super(fm);
        this._fragment = _fragment;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return _fragment.get(position);
    }

    @Override
    public int getCount() {
        return _fragment.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
    public void updateFrag(Fragment fragment) {
        this._fragment.add(fragment);
        notifyDataSetChanged();
    }
    public void removeFragment(int position){
        this._fragment.remove(position);
        notifyDataSetChanged();
    }
}
