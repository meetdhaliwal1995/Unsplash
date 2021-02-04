package com.example.replesh2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView list, search, listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        list = findViewById(R.id.list);
        search = findViewById(R.id.search_iv);
        listItem = findViewById(R.id.list_2);


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListFrag listFrag = new ListFrag();
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, listFrag)
                        .addToBackStack(listFrag.getTag())
                        .commit();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFrag searchFrag = new SearchFrag();
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content,searchFrag)
                        .addToBackStack(searchFrag.getTag())
                        .commit();
            }
        });

        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menupopup();
            }
        });

        TabLayout();

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//        viewPager.setOffscreenPageLimit(2);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        Log.e("SDS", "a");
                        listItem.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                menupopup();
                            }
                        });
                        break;

                    case 1:
                        Log.e("SDS", "b");
                        listItem.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                menupopup2();
                            }
                        });
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void TabLayout() {

        tabLayout.getTabAt(0).setText("Home");
        tabLayout.getTabAt(1).setText("Collection");
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));


    }
    private void menupopup(){
        PopupMenu popupMenu = new PopupMenu(this,listItem);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_1:
                        break;

                    case R.id.item_2:
                        break;

                    case R.id.item_3:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void menupopup2() {
        PopupMenu popupMenu = new PopupMenu(this, listItem);
        popupMenu.inflate(R.menu.menu_popup2);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        break;

                    case R.id.item_2:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }



}

