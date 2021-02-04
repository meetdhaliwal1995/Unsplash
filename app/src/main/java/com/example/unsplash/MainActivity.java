package com.example.unsplash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FragmentMain fragmentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMain = new FragmentMain();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragmentMain)
                .addToBackStack("dd")
                .commit();
    }
}