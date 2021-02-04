package com.example.ammdhillon;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ammdhillon.ModelSingle.LIVETV;
import com.example.ammdhillon.ModelSingle.SingleChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivitySingleChannel extends AppCompatActivity {

    ImageView single;
    TextView textView, textView1, textView2, textView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_channel);

        single = findViewById(R.id.image_single);
        textView = findViewById(R.id.text_view);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);

        String string = getIntent().getStringExtra("single_channel");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);

        networkInterface.getSingle(string).enqueue(new Callback<SingleChannel>() {
            @Override
            public void onResponse(Call<SingleChannel> call, Response<SingleChannel> response) {

                LIVETV singel = response.body().getLIVETV().get(0);

                textView.setText(singel.getChannelTitle());
                textView1.setText(singel.getCategoryName());
                textView2.setText(singel.getChannelType());
                textView3.setText(singel.getTotalViews());
                Glide.with(ActivitySingleChannel.this).load(singel.getChannelThumbnail()).into(single);
            }

            @Override
            public void onFailure(Call<SingleChannel> call, Throwable t) {

            }
        });
    }
}
