package com.example.appmusicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.util.List;

public class SongClass {

    public MediaPlayer player;
    private PlayPauseInterface playPauseInterface;
    List<PhnSongs> _list;

    public void song(Context context, String url, PlayPauseInterface playPauseInterface) {
        try {
            this.playPauseInterface = playPauseInterface;
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(context, Uri.parse(url));
            player.prepare();
            player.start();
        } catch (Exception e) {
            Log.e("ddd", e.toString());
        }
    }

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void play() {

        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
                playPauseInterface.onPlayPause(false);


            } else {
                player.start();
                playPauseInterface.onPlayPause(true);
            }
        }
    }

    public void nextSong(int position) {

        position = position + 1;
        try {
            player.reset();
            player.setDataSource(_list.get(position).getUri());
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (Exception e) {

            e.printStackTrace();

        }
//        Toast.makeText(SongClass.this,"dddd",Toast.LENGTH_SHORT).show();
    }


    public MediaPlayer getPlayer() {

        return player;
    }


}
