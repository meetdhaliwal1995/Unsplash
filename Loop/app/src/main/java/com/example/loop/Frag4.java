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

import java.util.ArrayList;

public class Frag4 extends Fragment {
    EditText editText;
    TextView textView;
    ArrayList<String> days;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_4,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.edit_text1);
        textView = view.findViewById(R.id.text_view1);

        days = new ArrayList<>();

        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thrusday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = editText.getText().toString();
                    if (!editText.getText().toString().isEmpty()){
                    boolean bool = false;
                    for (int i = 0; i<(days.size() -2); i++){
                        if (days.get(i).equalsIgnoreCase(s)){
                                bool = true;
                        }
                    }
                    if (bool){
                        Toast.makeText(getContext(),"weekday",Toast.LENGTH_SHORT).show();
                    }else if (days.contains(s.toLowerCase())){
                        Toast.makeText(getContext(),"holiday",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(),"invalid input", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }
}
