package com.example.replesh2;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class SearchFrag extends Fragment {

    ImageView backarrow, downarrow;
    TextView allTv;
    EditText search;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_frag,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.view_pager2);
        tabLayout = view.findViewById(R.id.tab_layout2);
        search = view.findViewById(R.id.search_iv);
        allTv = view.findViewById(R.id.all_tv);
        backarrow = view.findViewById(R.id.back_arrow);
        downarrow = view.findViewById(R.id.down_iv);

        PagerAdapter2 pagerAdapter2 = new PagerAdapter2(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter2);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setText("PHOTOS");
        tabLayout.getTabAt(1).setText("COLLECTIONS");
        tabLayout.getTabAt(2).setText("USERS");
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorPrimary),getResources().getColor(R.color.colorAccent));


        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }
}
