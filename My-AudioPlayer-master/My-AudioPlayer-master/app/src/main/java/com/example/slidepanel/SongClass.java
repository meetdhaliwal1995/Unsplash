package com.example.slidepanel;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class SongClass {


    MediaPlayer player;
    private PlayPauseInterface playPauseInterface;

    public MediaPlayer getPlayer() {
        return player;
    }


    public void songPlay(Context context, String url, MainActivity playPauseInterface) {
        try {
            this.playPauseInterface = playPauseInterface;
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(context, Uri.parse(url));
            player.prepare();
            player.start();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    public void songStop() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void playSong() {

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
}
