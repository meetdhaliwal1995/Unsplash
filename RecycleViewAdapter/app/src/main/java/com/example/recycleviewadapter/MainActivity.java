package com.example.recycleviewadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_iv);
        recyclerView = findViewById(R.id.recycler_View);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<DetailList> _list = new ArrayList<>();

        _list.add(new DetailList("ssss","dd","gggg"));
        _list.add(new DetailList("aaa","dd","vvvv"));
        _list.add(new DetailList("ffff","dd","bbbb"));

        Adapter adapterRecycleView = new Adapter(_list, this);
        recyclerView.setAdapter(adapterRecycleView);
    }
}
