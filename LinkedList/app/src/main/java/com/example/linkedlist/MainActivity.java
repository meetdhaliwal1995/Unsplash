package com.example.linkedlist;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edit, edit2;
    TextView text, text1;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit_text);
        text = findViewById(R.id.btn_enter);
        text1 = findViewById(R.id.text_value);
        edit2 = findViewById(R.id.edit_text1);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = edit.getText().toString();

                for (int i = 0; i<e.length(); i++) {
                for (int j = i+1; j<e.length();)
                }

            }
        });


    }

    private void Check() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();

                try {
                    Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "invaid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                int convert = Integer.parseInt(s);


                if (convert <= 21) {
                    int s1 = 21 - convert;
                    Toast.makeText(MainActivity.this, "" + s1, Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this, "" + (convert - 21) * 2, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Check2() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s1 = edit2.getText().toString();

                if (!s.isEmpty() && (!s1.isEmpty())) {
                    String s2 = s.substring(s.length() - 1);

                    text1.setText(s2 + s1 + s2);
                } else {
                    Toast.makeText(MainActivity.this, "field empty", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void Check3() {
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();

                if (s.length() < 2) {
                    Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s1 = s.substring(0, 2);

                if (s1.equals("hi")) {
                    text1.setText("true");
                } else {
                    text1.setText("false");
                }
            }
        });

    }

    private void Check4() {

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s1 = edit2.getText().toString();

                int convert = Integer.parseInt(s);
                int convert1 = Integer.parseInt(s1);

                if ((convert >= 13 && convert <= 20) || (convert1 >= 13 && convert1 <= 20)) {
                    text1.setText("true");
                } else {
                    text1.setText("false");
                }


            }
        });
    }
    private void Check5(){
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s1 = edit2.getText().toString();

                int convert = Integer.parseInt(s);
                int convert1 = Integer.parseInt(s1);

                int val = Math.abs(convert - 10);
                int val1 = Math.abs(convert1 - 10);

                if (val < val1) {
                    text1.setText(String.valueOf(convert));
                } else if (val1 < val) {
                    text1.setText(String.valueOf(convert1));
                } else {
                    text1.setText("0");
                }
            }
        });
    }
}
