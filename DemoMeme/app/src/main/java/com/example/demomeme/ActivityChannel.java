package com.example.demomeme;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomeme.ModelChannel.GetChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityChannel extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        textView = findViewById(R.id.text_meme);
        recyclerView = findViewById(R.id.recycler_channels);
        imageView = findViewById(R.id.back_btn);

        String s = getIntent().getStringExtra("singleChannel_id");
        String s1 = getIntent().getStringExtra("channel_name");
        textView.setText(s1);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getChannel(s).enqueue(new Callback<GetChannel>() {
            @Override
            public void onResponse(Call<GetChannel> call, Response<GetChannel> response) {
                AdapterChannel channel = new AdapterChannel(ActivityChannel.this, response.body().getLIVETV());
                recyclerView.setAdapter(channel);
            }

            @Override
            public void onFailure(Call<GetChannel> call, Throwable t) {

            }
        });

    }
}
