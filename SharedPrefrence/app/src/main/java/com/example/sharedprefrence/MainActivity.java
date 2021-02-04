package com.example.sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    TextView save,retrive,clear;
    Switch aSwitch;

    public static final String MyPreferences = "MyPrefs";
//    public static final String UserName = "namekey";
//    public static final String UserPass = "pass";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user_name);
        pass = findViewById(R.id.user_password);
        aSwitch = findViewById(R.id.switch_btn);
        save = findViewById(R.id.save);
        retrive = findViewById(R.id.retrive);
        clear = findViewById(R.id.clear);

            sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

            if (sharedPreferences.contains("email")) {
                user.setText(sharedPreferences.getString("email", ""));
            }
            if (sharedPreferences.contains("pass")) {
                pass.setText(sharedPreferences.getString("pass", ""));
            }

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearData(v);
                }
            });

            retrive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    retriveData(v);
                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveData(v);
                }
            });

    }

    public void saveData(View view) {
        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);


        String s = user.getText().toString();
        String s1 = pass.getText().toString();




        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("isopenfirsttime", true);
        if (!(s.isEmpty() && s1.isEmpty() && aSwitch.isChecked())) {
            editor.putString("pass", s1);
            editor.putString("email", s);
            editor.putBoolean(MyPreferences,true);
            editor.apply();
            aSwitch.setChecked(true);
            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "field can't empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void retriveData(View view) {
        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        if (sharedPreferences.contains("email")) {
            user.setText(sharedPreferences.getString("email", ""));
        }
        if (sharedPreferences.contains("pass")) {
            pass.setText(sharedPreferences.getString("pass", ""));
        }
    }

    public void clearData(View view) {
        user.setText("");
        pass.setText("");
    }


}
