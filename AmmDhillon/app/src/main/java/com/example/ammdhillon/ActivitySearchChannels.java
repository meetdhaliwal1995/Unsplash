package com.example.ammdhillon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

public class ActivitySearchChannels extends AppCompatActivity {

    ImageView back;
    TextView search;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_channels);

        back = findViewById(R.id.back_btn);
        search = findViewById(R.id.search_text);
        recyclerView = findViewById(R.id.recycler_viewsearch);


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        String s = getIntent().getStringExtra("search_channels");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        networkInterface.getSearchChannels(s).enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
//                same adapter use in meme activity bcz same model class
                AdapterChannel adapterChannel = new AdapterChannel(ActivitySearchChannels.this,response.body().getLIVETV());
                recyclerView.setAdapter(adapterChannel);
            }

            @Override
            public void onFailure(Call<Channel> call, Throwable t) {

            }
        });

    }
}
