package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    String fname = "manjit";
    String lname = "singh";
    int age = 26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        textView = findViewById(R.id.rr);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();

                String[] strings = s.split(",");
                boolean sum = String.valueOf(Utils.sumArray1(strings)).equalsIgnoreCase("100");

                if (sum) {
                    Utils.show("true", MainActivity.this);
                } else {
                    Utils.show("Log", MainActivity.this);
                }

//                Utils.show(sum, MainActivity.this);
            }
        });

//        int[] _arr = new int[]{1,2,4,6,74,34,23,45,546,23,545};


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sw = editText.getText().toString();

                sw.split("");

                int convert = Integer.parseInt(sw);


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main();
            }
        });

    }

    protected void main() {
        MainActivity mainActivity = new MainActivity();
        MainActivity mainActivity1 = new MainActivity();
        mainActivity1.age = 24;
        Log.e("name : ", fname);
        Log.e("last name :", lname);
        Log.e("age :",String.valueOf(mainActivity1.age));

    }
}
