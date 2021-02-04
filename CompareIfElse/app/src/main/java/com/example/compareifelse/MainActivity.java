package com.example.compareifelse;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button btn;
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.edit_1);
        editText2 = findViewById(R.id.edit_2);
        editText3 = findViewById(R.id.edit_3);
        btn = findViewById(R.id.button);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edit1 = editText1.getText().toString();
                String edit2 = editText2.getText().toString();
                String edit3 = editText3.getText().toString();

                int convert1, convert2, convert3;


                try {
                    convert1 = Integer.parseInt(edit1);
                    convert2 = Integer.parseInt(edit2);
                    convert3 = Integer.parseInt(edit3);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ((convert1 == 0 || convert1 == 1) && (convert2 == 0 || convert2 == 1) && (convert3 == 0 || convert3 == 1)) {
                    Log.e("sdds","sdg");
                } else {
                    showToast("input 0 or 1");
                    return;
                }

                if (checkBox1.isChecked()) {
                    if (convert1 == 1 || convert2 == 1 || convert3 == 1) {
                        showToast("its true");
                    } else {
                        showToast("its false");
                    }
                } else {
                    if (convert1 == 1 && convert2 == 1 && convert3 == 1) {
                        showToast("true");
                    } else {
                        showToast("false");
                    }

                }
            }
        });
    }

    private void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
