package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.indianmemeammdhillon.ModelApi.ModelSingleChannel.ListSingleChannel;
import com.example.indianmemeammdhillon.ModelApi.ModelSingleChannel.SingleChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySingleChannel extends AppCompatActivity {

    ImageView channelImage, btn;

    TextView name,title,thumbnail,view,url,textmeme;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlechannel);

        bindView();
        retrofit();
        listner();
    }




    private void retrofit(){
        String id = getIntent().getStringExtra("single_detail");


        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getSingleChannel(id).enqueue(new Callback<SingleChannel>() {
            @Override
            public void onResponse(Call<SingleChannel> call, Response<SingleChannel> response) {

                ListSingleChannel singel = response.body().getLIVETV().get(0);

                Glide.with(ActivitySingleChannel.this).load(singel.getChannelThumbnail()).into(channelImage);
                name.setText(singel.getCategoryName());
                thumbnail.setText(singel.getChannelUrl());
                view.setText(singel.getTotalViews());
                title.setText(singel.getChannelTitle());
                url.setText(singel.getChannelDesc());
            }

            @Override
            public void onFailure(Call<SingleChannel> call, Throwable t) {

            }
        });
    }

    private void listner(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void bindView(){

            channelImage = findViewById(R.id.single_imz);
            btn = findViewById(R.id.back_btn);
            name = findViewById(R.id.text_name);
            title = findViewById(R.id.text_title);
            thumbnail = findViewById(R.id.text_thumbnail);
            view = findViewById(R.id.text_view);
            url = findViewById(R.id.text_url);
            textmeme = findViewById(R.id.text_meme);

    }

}


