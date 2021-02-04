package com.example.ammdhillon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ammdhillon.ModelAppDetail.AppDetail;
import com.example.ammdhillon.ModelAppDetail.LIVETV;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityAppDetail extends AppCompatActivity {

    TextView name,version,author,email,website,description;
    ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_app);

        name = findViewById(R.id.name1);
        version = findViewById(R.id.version);
        author = findViewById(R.id.author);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        description = findViewById(R.id.description);
        logo = findViewById(R.id.logo);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        networkInterface.getAppDetail().enqueue(new Callback<AppDetail>() {
            @Override
            public void onResponse(Call<AppDetail> call, Response<AppDetail> response) {
                LIVETV livetv = response.body().getLIVETV().get(0);

                name.setText(livetv.getAppName());
                version.setText(livetv.getAppVersion());
                author.setText(livetv.getAppAuthor());
                email.setText(livetv.getAppEmail());
                website.setText(livetv.getAppWebsite());
                description.setText(livetv.getAppDescription());
                Glide.with(ActivityAppDetail.this).load(livetv.getAppLogo()).into(logo);
                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(livetv.getAppWebsite()));
                        startActivity(intent);
                    }
                });


            }

            @Override
            public void onFailure(Call<AppDetail> call, Throwable t) {

            }
        });
    }
}
