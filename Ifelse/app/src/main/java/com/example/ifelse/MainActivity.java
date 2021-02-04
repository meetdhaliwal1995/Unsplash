package com.example.ifelse;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);
        textView = findViewById(R.id.text_enter);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = editText1.getText().toString();
                String edit2 = editText2.getText().toString();

                if (edit.matches("")){
                    showToast("can't empty");
                    return;
                }else if (edit2.matches("")){
                    showToast("can't empty");
                    return;
                }

                int convert1 = Integer.parseInt(edit);
                int convert2 = Integer.parseInt(edit2);


                int plus = convert1 + convert2;


                if (convert1 != convert2) {
                    showToast("" + plus);
                } else {
                    int mul = plus * 2;
                    showToast("" + mul);
                }
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
