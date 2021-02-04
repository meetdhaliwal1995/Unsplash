package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianmemeammdhillon.Adapters.AdapterChannels;
import com.example.indianmemeammdhillon.ModelApi.ModelChannel.MemeChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityChannels extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView memeName;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        bindView();
        retrofit();
    }

    private void bindView() {
        recyclerView = findViewById(R.id.recycler_channels);
        memeName = findViewById(R.id.text_meme);
        imageView = findViewById(R.id.back_btn);
    }

    private void retrofit() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String id = getIntent().getStringExtra("cat_id");
        String category_name = getIntent().getStringExtra("cat_name");
        memeName.setText(category_name);


        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getMemeChannel(id).enqueue(new Callback<MemeChannel>() {
            @Override
            public void onResponse(Call<MemeChannel> call, Response<MemeChannel> response) {
                AdapterChannels adapter = new AdapterChannels(ActivityChannels.this, response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MemeChannel> call, Throwable t) {

            }
        });
    }
}
