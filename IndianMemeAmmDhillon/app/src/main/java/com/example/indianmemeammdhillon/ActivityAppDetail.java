package com.example.indianmemeammdhillon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.indianmemeammdhillon.ModelApi.ModelAppDetail.AppDetail;
import com.example.indianmemeammdhillon.ModelApi.ModelAppDetail.ListAppDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAppDetail extends AppCompatActivity {

    TextView appName, verson, author, email, website, description;
    ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);

        bindView();
        retrofit    ();

    }

    private void bindView() {
        appName = findViewById(R.id.name1);
        verson = findViewById(R.id.version);
        author = findViewById(R.id.author);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        description = findViewById(R.id.description);
        logo = findViewById(R.id.logo);
    }

    private void retrofit() {
        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getAppDetail().enqueue(new Callback<AppDetail>() {
            @Override
            public void onResponse(Call<AppDetail> call, Response<AppDetail> response) {

                final ListAppDetail appDetail = response.body().getLIVETV().get(0);

                appName.setText(appDetail.getAppName());
                verson.setText(appDetail.getAppVersion());
                author.setText(appDetail.getAppAuthor());
                email.setText(appDetail.getAppEmail());
                website.setText(appDetail.getAppWebsite());
                description.setText(appDetail.getAppDescription());

                Glide.with(ActivityAppDetail.this).load(appDetail.getAppLogo()).into(logo);

                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(appDetail.getAppWebsite()));
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
