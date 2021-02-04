package com.example.indianmemeammdhillon;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianmemeammdhillon.Adapters.AdapterChannels;
import com.example.indianmemeammdhillon.ModelApi.ModelChannel.MemeChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySearchChannels extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        recyclerView = findViewById(R.id.recycler_channels);

        retrofit();
    }

    private void retrofit() {
        String key = getIntent().getStringExtra("search_channels");
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));


        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getSearchChannel(key).enqueue(new Callback<MemeChannel>() {
            @Override
            public void onResponse(Call<MemeChannel> call, Response<MemeChannel> response) {
                AdapterChannels adapter = new AdapterChannels(ActivitySearchChannels.this, response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MemeChannel> call, Throwable t) {

            }
        });
    }
}
