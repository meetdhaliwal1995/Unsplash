package com.example.loop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.widget.Toast.LENGTH_SHORT;

public class Frag1 extends Fragment {

    EditText edit;
    TextView text, enterText, clearText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text = view.findViewById(R.id.tv_view);
        edit = view.findViewById(R.id.et_view);
        enterText = view.findViewById(R.id.enter_text);
        clearText = view.findViewById(R.id.clear_text);


        clearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
                text.setText("");
            }
        });

        enterText.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String s = edit.getText().toString();

                try {
                    Integer.parseInt(s);
                } catch (NumberFormatException d) {
                    Toast.makeText(getContext(), "invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!s.isEmpty()) {
                    float d = Float.parseFloat(s);
                    float cal = (d / 2);
                    float cal1 = (d / 4);

                    if (cal == (int) cal) {
                        text.setText(2 + "=" + (int) cal + "\n");
                    } else {
                        text.setText(2 + "="+"can't match" + "\n");
                    }
                    if (cal1 == (int) cal1) {
                        text.setText(text.getText().toString() + 4 + "=" + (int) cal1 + "\n");
                    } else {
                        text.setText(text.getText().toString() + 4 + "=" + "can't match"+"\n");
                    }
                } else {
                    Toast.makeText(getContext(), "empty field", LENGTH_SHORT).show();
                }
            }
        });
    }
}
