package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView pubg;
    ImageView dice,dice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = findViewById(R.id.dice);
        pubg = findViewById(R.id.pubg);
        dice2 = findViewById(R.id.dice_2);
        pubg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag_1 searchFrag = new Frag_1();
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, searchFrag)
                        .addToBackStack(searchFrag.getTag())
                        .commit();
            }
        });

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frag_2 searchFrag = new Frag_2();
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, searchFrag)
                        .addToBackStack(searchFrag.getTag())
                        .commit();

            }
        });

        dice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Frag_2 frag_2 = new Frag_2();
//                getSupportFragmentManager().beginTransaction()
//                        .add(android.R.id.content,frag_2)
//                        .addToBackStack(frag_2.getTag())
//                        .commit();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    }
