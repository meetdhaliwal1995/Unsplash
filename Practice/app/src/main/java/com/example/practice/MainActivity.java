package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edit, edit1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.et_1);
        edit1 = findViewById(R.id.et_2);
        textView = findViewById(R.id.tv_enter);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s1 = edit1.getText().toString();

                if (s.matches("")){
                    showToast("can't empty");
                    return;
                }else if (s1.matches("")){
                    showToast("can't empty");
                    return;
                }
                if (!(s.length()==4)){
                    showToast("enter 4 digit");
                    return;
                }

                String str = String.valueOf(s.charAt(0));
                String str1 = String.valueOf(s.charAt(1));
                String str2 = String.valueOf(s.charAt(2));
                String str3 = String.valueOf(s.charAt(3));
                String newStr = str+str1+s1+str2+str3;
                    showToast(""+newStr);
            }
        });

    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
