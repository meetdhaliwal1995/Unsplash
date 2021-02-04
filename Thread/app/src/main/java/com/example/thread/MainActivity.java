package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DefaultInterface {

    TextView textView1,textView2;
    Handler mainHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);


        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadClass threadClass  = new ThreadClass(MainActivity.this);
                threadClass.start();
            }
        });



    }


    @Override
    public void getValue(final String string) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                textView1.setText(string);
            }
        });

        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                textView1.setText(string);
            }
        });

        textView1.post(new Runnable() {
            @Override
            public void run() {
                textView1.setText(string);
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView1.setText(string    );
            }
        });
    }


}
