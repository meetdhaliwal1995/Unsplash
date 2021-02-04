package com.example.recycleviewadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_1);
        recyclerView = findViewById(R.id.recycleview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<DetailList> _list = new ArrayList<>();
        _list.add(new DetailList("AAA","BBB",7  ));

        AdapterClass adapterClass = new AdapterClass(_list,this);
        recyclerView.setAdapter(adapterClass);
    }

}
