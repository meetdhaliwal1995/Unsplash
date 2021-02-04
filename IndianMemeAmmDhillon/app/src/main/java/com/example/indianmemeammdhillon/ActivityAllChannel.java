package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianmemeammdhillon.Adapters.AdapterAllChanels;
import com.example.indianmemeammdhillon.ModelApi.ModelAllChannels.AllChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAllChannel extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ImageView backbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_channel_activity);

        bindView();
        retrofit();
        listner();


    }

    private void retrofit() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getAllChannesl().enqueue(new Callback<AllChannel>() {
            @Override
            public void onResponse(Call<AllChannel> call, Response<AllChannel> response) {
                AdapterAllChanels adapter = new AdapterAllChanels(ActivityAllChannel.this, response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AllChannel> call, Throwable t) {

            }
        });
    }

    private void listner() {
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void bindView() {
        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.text_meme);
        backbtn = findViewById(R.id.back_btn);
    }
}
