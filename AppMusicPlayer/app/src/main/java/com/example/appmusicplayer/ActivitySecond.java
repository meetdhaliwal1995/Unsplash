package com.example.appmusicplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {

    ImageView imageView;
    SeekBar seekBar;
    MediaPlayer player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentseek);


        String url = getIntent().getStringExtra("url");

//        mediaPlayer = MediaPlayer.create(ActivitySecond.this, Uri.parse(url));
//        mediaPlayer = new MediaPlayer();

        try {
            Uri uri = Uri.parse(url);
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(this, uri);
            player.prepare();
            player.start();
        } catch (Exception e) {
            Log.e("ddd", e.toString());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mediaPlayer.stop();
        player.release();

    }
}
