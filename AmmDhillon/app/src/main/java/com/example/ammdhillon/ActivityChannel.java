package com.example.ammdhillon;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ammdhillon.ModelChannel.Channel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityChannel extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_channels);

        recyclerView = findViewById(R.id.recycler_view1);

        recyclerView.setLayoutManager(new GridLayoutManager(ActivityChannel.this,2));

        String cid = getIntent().getStringExtra("cat_id");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        networkInterface.getChannel(cid).enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
                AdapterChannel adapter = new AdapterChannel(ActivityChannel.this,response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Channel> call, Throwable t) {

            }
        });

    }
}
