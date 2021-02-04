package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button enter;
    ArrayList<String> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        enter = findViewById(R.id.btn_enter);

        days = new ArrayList<>();

        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().isEmpty()) {
                    boolean isWeekDay = false;
                    for (int i = 0; i < (days.size() - 2); i++) {
                        if (days.get(i).equalsIgnoreCase(editText.getText().toString())) {
                            isWeekDay = true;
                        }
                    }

                    if (isWeekDay) {
                        Toast.makeText(MainActivity.this, "Is a weekday", Toast.LENGTH_SHORT).show();
                    } else if (days.contains(editText.getText().toString().toLowerCase())) {
                        Toast.makeText(MainActivity.this, "is holiday", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
