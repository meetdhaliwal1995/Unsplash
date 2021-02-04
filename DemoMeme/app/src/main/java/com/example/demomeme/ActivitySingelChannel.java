package com.example.demomeme;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.demomeme.SingleChannel.SingelChannelList;
import com.example.demomeme.SingleChannel.SingleChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySingelChannel extends AppCompatActivity {

    ImageView channelImage, btn;

    TextView name,title,thumbnail,view,url,textmeme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlechannel);

        channelImage = findViewById(R.id.single_imz);
        btn = findViewById(R.id.back_btn);
        name = findViewById(R.id.text_name);
        title = findViewById(R.id.text_title);
        thumbnail = findViewById(R.id.text_thumbnail);
        view = findViewById(R.id.text_view);
        url = findViewById(R.id.text_url);
        textmeme = findViewById(R.id.text_meme);

        String s = getIntent().getStringExtra("single_image");

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getSingelChannel(s).enqueue(new Callback<SingleChannel>() {
            @Override
            public void onResponse(Call<SingleChannel> call, Response<SingleChannel> response) {

//                SingelChannelList singel = response.body().getLIVETV().get(0);

//
                Glide.with(ActivitySingelChannel.this).load(response.body().getLIVETV().get(0).getChannelThumbnail()).into(channelImage);
            }

            @Override
            public void onFailure(Call<SingleChannel> call, Throwable t) {

            }
        });
    }
}
