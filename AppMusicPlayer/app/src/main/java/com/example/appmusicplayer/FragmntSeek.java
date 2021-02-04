package com.example.appmusicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

public class FragmntSeek extends Fragment implements PlayPauseInterface {

    SeekBar seekBar;
    ImageView play, back, next;
    TextView textView;
    SongClass songClass;
    PerformThred performThred;
    List<PhnSongs> _list;
    private int     position;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentseek, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        play = view.findViewById(R.id.play);
        back = view.findViewById(R.id.previous);
        next = view.findViewById(R.id.next);
        seekBar = view.findViewById(R.id.seek_bar);
        textView = view.findViewById(R.id.song_name5);

        songClass = new SongClass();

        songClass.getPlayer();

        play.setBackgroundResource(R.drawable.ic_play);

        final Animation fadein = AnimationUtils.loadAnimation(getContext(), R.anim.bounce_animation);
        final Animation zoom = AnimationUtils.loadAnimation(getContext(),R.anim.bounce_animation);
        final Animation animate = AnimationUtils.loadAnimation(getContext(),R.anim.blink_animation);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songClass.play();
                play.startAnimation(animate);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == _list.size() - 1) {
                    songPlay(0);
                    next.startAnimation(fadein);
                } else {
                    songPlay(position + 1);
                    next.startAnimation(fadein);
//                    next.animate().setDuration(300).rotationBy(360).start();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    songPlay(_list.size() - 1);
                    back.startAnimation(zoom);
                } else {
                    songPlay(position - 1);
                    back.startAnimation(zoom);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                if (fromUser) {
                    if (songClass.getPlayer() == null) {
                        return;
                    }
                    songClass.getPlayer().seekTo(progress);

                    Log.e("ggg", String.valueOf(progress));
                }

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void songPlay(final int position) {
        this.position = position;
        String url = _list.get(position).getUri();
        String songTitle = _list.get(position).getTitle();
        textView.setText(songTitle);
        songClass.stop();
        songClass.song(getContext(), url, this);
        seekBar.setMax(songClass.getPlayer().getDuration());
        play.setBackgroundResource(R.drawable.ic_pause_black_24dp);

        if (performThred != null) {
            performThred.interrupt();
            performThred = null;

        }

        performThred = new PerformThred();
        performThred.start();
        songClass.getPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (position == _list.size() - 1) {
                    songPlay(0);

                } else {
                    songPlay(position + 1);
                }
            }
        });

    }


    @Override
    public void onPlayPause(boolean isPlaying) {
        if (isPlaying) {
            performThred = new PerformThred();
            performThred.start();
            play.setBackgroundResource(R.drawable.ic_pause_black_24dp);
        } else {
            if (performThred != null && performThred.isAlive()) {
                performThred.interrupt();
                performThred = null;
                play.setBackgroundResource(R.drawable.ic_play);
            }
        }
    }

    public void set_list(List<PhnSongs> _list) {
        this._list = _list;
        Log.e("total song", String.valueOf(_list.size()));
    }

    public class PerformThred extends Thread {

        @Override
        public void run() {

            try {
                while (songClass.getPlayer().isPlaying()) {
                    seekBar.setProgress(songClass.getPlayer().getCurrentPosition());
                    Log.e("ddd", "Thred");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.e("ddd", "Thred not pass");
                    }
                }
            } catch (Exception e) {

            }

        }
    }

}

//    private class MyThread extends Thread {
//
//        @Override
//        public void run() {
//            //seekBar.setProgress(0);
//            int currentPosfition;
//            while (songClass.getPlayer().isPlaying()) {
//                try {
//                    Thread.sleep(1000);
//                    seekBar.setMax((int) songClass.getPlayer().getDuration());
//                    currentPosition = (int) songClass.getPlayer().getCurrentPosition();
//                    //Log.e("HH", "JJJJ");
//                } catch (InterruptedException e) {
//                    //Log.e("SeekBar Thread", "Interrupted");
//                    return;
//                } catch (Exception e) {
//                    return;
//                }
//                if (songClass.getPlayer().isPlaying()) {
//                    seekBar.setProgress(currentPosition);
//                } else {
//                    seekBar.setProgress(0);
//                }
//            }
//        }
//    }


    


