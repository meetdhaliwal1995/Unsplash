package com.example.ammdhillon;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ammdhillon.AllVideos.AllVideos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ammdhillon.Constant.ALL_VIDEO;

public class ActivityAllVideo extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_channels);

        recyclerView = findViewById(R.id.recycler_view1);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        networkInterface.getAllVideo().enqueue(new Callback<AllVideos>() {
            @Override
            public void onResponse(Call<AllVideos> call, Response<AllVideos> response) {
                Log.e("sss",response.raw().toString());
                AdapterAllVideo adapterAllVideo = new AdapterAllVideo(ActivityAllVideo.this,response.body().getLIVETV());
                recyclerView.setAdapter(adapterAllVideo);
            }

            @Override
            public void onFailure(Call<AllVideos> call, Throwable t) {
                Log.e("ssss","ggg");

            }
        });
    }
}
