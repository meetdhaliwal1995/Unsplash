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

public class Frag3 extends Fragment {

    EditText edit, edit2;
    TextView enter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit = view.findViewById(R.id.et_view);
        edit2 = view.findViewById(R.id.et_view2);
        enter = view.findViewById(R.id.enter_text);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = edit.getText().toString();
                String s1 = edit2.getText().toString();

                if (s.matches("")) {
                    showToast("field 1 is empty");
                    return;
                } else if (s1.matches("")) {
                    showToast("field 2 is empty");
                    return;
                }
                if (!(s.length() == 4)) {
                    showToast("plz enter 4 digit");
                } else {
                    String sr = String.valueOf(s.charAt(0));
                    String sr1 = String.valueOf(s.charAt(1));
                    String sr2 = String.valueOf(s.charAt(2));
                    String sr3 = String.valueOf(s.charAt(3));
                    String str = sr + sr1 + s1 + sr2 + sr3;
                    showToast("" + str);
                }
            }
        });


    }

    private void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
