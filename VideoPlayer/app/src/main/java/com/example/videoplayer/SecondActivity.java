package com.example.videoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, OnPreparedListener {

    VideoView videoView;
    ImageButton back, forward, play, stop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        videoView = findViewById(R.id.video);
        back = findViewById(R.id.back);
//        stop = findViewById(R.id.stop_btn);
        forward = findViewById(R.id.forward);
        play = findViewById(R.id.play);

        videoView.setOnPreparedListener(this);
//        stop.setOnClickListener(this);
        play.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);

        videoView.setVideoURI(Uri.parse(getIntent().getAction()));


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("hhh", "hh");
                if (!videoView.isPlaying()) {
                    Log.e("hhh", "hhjj");
                    videoView.start();
                    play.setImageDrawable(getResources().getDrawable(R.drawable.exomedia_ic_pause_white));
                } else {
                    videoView.pause();
                    play.setImageDrawable(getResources().getDrawable(R.drawable.exomedia_ic_play_arrow_white));
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(videoView.getCurrentPosition()-5000);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(videoView.getCurrentPosition()+5000);
            }
        });


    }

    @Override
    public void onPrepared() {
        videoView.start();
    }

    @Override
    public void onClick(View v) {

    }
}
