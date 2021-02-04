package com.example.exomedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnPreparedListener {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.video_view);

        videoView.setOnPreparedListener(this);


    }

    @Override
    public void onClick(View v) {

        videoView.setVideoURI(Uri.parse("https://vipkhan.mobi/cache/CAT_punjabi-videos/CAT_punjabi-video-song/5086/mp4/mp4-1080p/Pagal%20Gurnam%20Bhullar%20-%20HDYaar.Com.mp4"));

    }

    @Override
    public void onPrepared() {

        videoView.start();
    }
}
