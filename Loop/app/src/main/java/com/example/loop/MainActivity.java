package com.example.loop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    TextView text, text1, text3;
    ViewPager viewPager;
    int count;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.et_view);
        text = findViewById(R.id.tv_view);
        text1 = findViewById(R.id.enter_text);
        text3 = findViewById(R.id.clear_text);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(pagerAdapter);

        tabLayout.getTabAt(0).setIcon(getDrawable(R.drawable.ic_person));
        tabLayout.getTabAt(1).setIcon(getDrawable(R.drawable.ic_person));
        tabLayout.getTabAt(2).setIcon(getDrawable(R.drawable.ic_person));
        tabLayout.getTabAt(3).setIcon(getDrawable(R.drawable.ic_person));

        tabLayout.setTabTextColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));
    }


    private void ForLoop() {

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();

                List<String> list = Arrays.asList(s.split(""));

                Set<String> repeat = new HashSet<String>(list);
                for (String word : repeat) {
                    text.setText(word + ":" + Collections.frequency(list, word));
                }
            }
        });
    }

    private void ForLoop1() {
        text1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String[] word = s.split("");
                int count = 1;

                for (int i = 0; i < s.length(); i++) {
                    for (int j = i + 1; j < word.length; j++) {
                        if (word[i].equals(word[j])) {
                            count = count + 1;
                            word[j] = "0";
                        }
                    }
                    String s1 = text.getText().toString() + word[i] + "-" + count + "\n";
                    text.setText(s1);
                }
            }
        });
    }

    private void ForLoop2() {
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                s = s.toLowerCase();
                String words[] = s.split("");
                Log.e("length", valueOf(words.length));
                for (int i = 0; i < words.length; i++) {
                    count = 0;

                    for (int j = i + 0; j < words.length; j++) {
                        if (words[i].equalsIgnoreCase(words[j])) {
                            count++;
                        }
                    }

                    if (!text.getText().toString().contains(words[i])) {
                        text.setText(text.getText().toString() + words[i] + " = " + count + "\n");
                    }
                }
            }

        });

    }
}
