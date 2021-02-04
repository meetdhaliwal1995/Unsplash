package com.example.ammdhillon;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;

public class ActivityPlayVideo extends AppCompatActivity implements OnPreparedListener {

    VideoView videoView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);

        videoView = findViewById(R.id.video);

        videoView.setVideoURI(Uri.parse(getIntent().getStringExtra("video_url")));
        Log.e("dsd", getIntent().getStringExtra("video_url"));

        videoView.setOnPreparedListener(this);
    }


    @Override
    public void onPrepared() {
        videoView.start();
    }
}
