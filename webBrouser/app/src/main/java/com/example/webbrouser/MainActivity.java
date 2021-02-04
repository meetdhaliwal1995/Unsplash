package com.example.webbrouser;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView more,newtab,closebtn,tabBtn;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    ArrayList<Fragment> _fragments = new ArrayList<>();
    boolean isTabAnimated = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        more = findViewById(R.id.more);
        newtab = findViewById(R.id.newtab);
        closebtn = findViewById(R.id.close_btn);
        tabBtn = findViewById(R.id.tab_btn);
        viewPager = findViewById(R.id.view_pager);

        _fragments.add(new BrouserFrag());

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), _fragments);
        viewPager.setAdapter(pagerAdapter);


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menupopup();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTabAnimated){
                    viewPager.animate().scaleX(0.8f).scaleY(0.8f).start();
                    closebtn.setVisibility(View.VISIBLE);
                    isTabAnimated = false;
                }else{
                        restoreTabScale
                }
            }
        });

        public void generateTab(String url){
            BrouserFrag brouserFrag = new BrouserFrag();
            pagerAdapter.updateFrag(brouserFrag);
            viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
            viewPager.setCurrentItem(pagerAdapter.getCount()-1);
        }
    }

    private void menupopup() {
        PopupMenu popupMenu = new PopupMenu(this, more);
        popupMenu.inflate(R.menu.menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:

                        break;
                    case R.id.item_2:
                        Intent intent = new Intent();
                        intent.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                        startActivity(intent);
                        break;
                    case R.id.item_3:
                        BookmarkFrag bookmarkFrag = new BookmarkFrag();
                        getSupportFragmentManager().beginTransaction()
                                .add(android.R.id.content, bookmarkFrag)
                                .addToBackStack(bookmarkFrag.getTag())
                                .commit();
                        break;
                    case R.id.item_4:
                        HistoryFrag historyFrag = new HistoryFrag();
                        getSupportFragmentManager().beginTransaction()
                                .add(android.R.id.content, historyFrag)
                                .addToBackStack(historyFrag.getTag())
                                .commit();
                        break;
                    case R.id.item_5:
                        SettingFrag settingFrag = new SettingFrag();
                        getSupportFragmentManager().beginTransaction()
                                .add(android.R.id.content, settingFrag)
                                .addToBackStack(settingFrag.getTag())
                                .commit();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();

    }
}
