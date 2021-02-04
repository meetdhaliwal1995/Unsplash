package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofit.Profile.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView1,textView2,textView3,textView4,restext,startcount;
    ImageView profileImze;
    Button followers,following,repose,overView,project,star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.name_text);
        textView1 = findViewById(R.id.login_text);
        textView2 = findViewById(R.id.bio_text);
        textView3 = findViewById(R.id.blog_text);
        textView4 = findViewById(R.id.block_text);
        profileImze = findViewById(R.id.profile_pic);
        followers = findViewById(R.id.btn_followers);
        following = findViewById(R.id.btn_following);
        repose = findViewById(R.id.btn_repositories);
        overView = findViewById(R.id.btn_overview);
        project = findViewById(R.id.btn_project);
        star = findViewById(R.id.btn_star);
        restext = findViewById(R.id.repos_count);
        startcount = findViewById(R.id.star_count);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface  = retrofit.create(NetworkInterface.class);

        Call<Profile> call = networkInterface.profile();

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

                textView.setText(response.body().getName());
                textView1.setText(response.body().getLogin());
                textView2.setText(response.body().getBio());
                textView3.setText(response.body().getBlog());
                startcount.setText(String.valueOf(response.body().getFollowers()));
                restext.setText(String.valueOf(response.body().getPublicRepos()));

                Glide.with(MainActivity.this).load(response.body().getAvatarUrl()).into(profileImze);

                repose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("url",response.body().getReposUrl());
                        startActivity(intent);
                    }
                });

                followers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("url",response.body().getFollowersUrl());
                        startActivity(intent);
                    }
                });

                overView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("url",response.body().getGistsUrl());
                        startActivity(intent);
                    }
                });
                    star.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                            intent.putExtra("url",response.body().getStarredUrl());
                            startActivity(intent);
                        }
                    });

                    following.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                            intent.putExtra("url",response.body().getFollowingUrl());
                            startActivity(intent);
                        }
                    });
                    project.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                            intent.putExtra("url",response.body().getGistsUrl());
                            startActivity(intent);
                        }
                    });
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }


}
