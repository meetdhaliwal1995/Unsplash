package com.example.demoapppd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new Fragment();
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, fragment)
                .addToBackStack(fragment.getTag())
                .commit();
    }
}
