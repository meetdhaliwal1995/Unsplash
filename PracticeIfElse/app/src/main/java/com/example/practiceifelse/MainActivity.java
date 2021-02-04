package com.example.practiceifelse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.user_edit);
        text = findViewById(R.id.enter_text);


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                if (!s.isEmpty()) {
                    if (String.valueOf(s.charAt(0)).equalsIgnoreCase("o")) {
                        showToast(s);
                    } else {
                        if (s.length() >= 2) {
                            showToast("" + s.substring(0, 2));
                        } else {
                            Log.e("ghdfh", "usjf");
                            showToast("" + s.substring(0, 1));
                        }
                    }
                }
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
