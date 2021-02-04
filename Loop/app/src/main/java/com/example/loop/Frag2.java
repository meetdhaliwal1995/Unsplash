package com.example.loop;

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

public class Frag2 extends Fragment {

    EditText edit, edit2;
    TextView text, enterText, clearText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit = view.findViewById(R.id.et_view);
        text = view.findViewById(R.id.tv_view);
        enterText = view.findViewById(R.id.enter_text);
        clearText = view.findViewById(R.id.clear_text);
        edit2 = view.findViewById(R.id.edit_2);

        enterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                String s1 = edit2.getText().toString();

                try {
                    Integer.parseInt(s);
                    Integer.parseInt(s1);

                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "invalid Input", Toast.LENGTH_SHORT).show();
                    return;
                }
                int convert = Integer.parseInt(s);
                int convert1 = Integer.parseInt(s1);

                int plus = convert + convert1;

                if ((convert1 != convert)) {
                    text.setText(String.valueOf(plus));
                } else {
                    int mul = plus * 2;
                    text.setText(String.valueOf(mul));

                }
            }
        });

    }
}
