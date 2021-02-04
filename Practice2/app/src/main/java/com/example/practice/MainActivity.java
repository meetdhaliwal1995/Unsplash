package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    int aLong = 0;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et_1);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        et2 = findViewById(R.id.et2);

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String d = et1.getText().toString();

             Double parseDouble = Double.parseDouble(d);

             String div = String.valueOf(12 / parseDouble);

             et1.setText(div);
            }
        });



    }

    private void addInt(){
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et1.getText().toString();

                if (!(s.isEmpty())) {
                    for (int i = 0; i < s.length(); i++) {

                        String str = String.valueOf(s.charAt(i));
                        int convert = Integer.parseInt(str);
                        aLong = aLong + convert;

                    }

                    Toast.makeText(MainActivity.this, String.valueOf(aLong), Toast.LENGTH_SHORT).show();
                    tv1.setText(String.valueOf(aLong));
                }
            }
        });
    }
}
