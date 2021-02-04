package com.example.slidepanel;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlayPauseInterface {

    public static List<PhnSongs> _list = new ArrayList<>();
    public List<ModelArtistSong> _listArtist = new ArrayList<>();
    public List<ModelAbum> _listAlbumSong = new ArrayList<>();
    FragmentSongs fragmentSongs;
    ImageView down, view, more, search;
    SeekBar seekBar;
    ImageView play, back, next, backiv;
    TextView textView, songText, libery;
    SongClass songClass;
    PerformThred performThred;
    int position;
    FragmentArtist fragmentArtist;
    FragmentAlbum fragmentAlbum;
    FragmentMore fragmentMore;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seek_bar);
        play = findViewById(R.id.play);
        back = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        textView = findViewById(R.id.song_name5);
        search = findViewById(R.id.search);
        searchView = findViewById(R.id.search_tv);
        down = findViewById(R.id.down);
        songText = findViewById(R.id.song_text);
        backiv = findViewById(R.id.back_iv);
        view = findViewById(R.id.view);
        more = findViewById(R.id.more);
        libery = findViewById(R.id.libery_text);

        songClass = new SongClass();
        songClass.getPlayer();
        fragmentArtist = new FragmentArtist();
        fragmentSongs = new FragmentSongs();
        fragmentAlbum = new FragmentAlbum();
        fragmentMore = new FragmentMore();


        getSong();
        getArtist();
        getAlbum();
        fragmentArtist.setlist(_listArtist);
        fragmentAlbum.setlist(_listAlbumSong);
        fragmentSongs.set_list(_list);
        fragmentMore.set_list(_list);


//        fragmentSongs = new FragmentSongs();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout2, fragmentSongs)
                .addToBackStack(fragmentSongs.getTag())
                .commit();


        play.setBackgroundResource(R.drawable.ic_play);
        songText.setText("Songs");


        final Animation a = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce_animation);
        final Animation b = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce_animation);
        final Animation c = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink_animation);

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memuPopup();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setVisibility(View.GONE);
                libery.setVisibility(View.GONE);
                more.setVisibility(View.GONE);
                down.setVisibility(View.GONE);
                view.setVisibility(View.GONE);
                songText.setVisibility(View.GONE);

                searchView.setVisibility(View.VISIBLE);
                backiv.setVisibility(View.VISIBLE);
            }
        });

        backiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setVisibility(View.VISIBLE);
                libery.setVisibility(View.VISIBLE);
                more.setVisibility(View.VISIBLE);
                down.setVisibility(View.VISIBLE);
                view.setVisibility(View.VISIBLE);
                songText.setVisibility(View.VISIBLE);

                searchView.setVisibility(View.GONE);
                backiv.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fragmentSongs.setString(newText);
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songClass.playSong();
                play.setAnimation(c);
                Log.e("ddd", "ddd");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    songPlay(_list.size() - 1);
                    back.setAnimation(a);
                } else {
                    songPlay(position - 1);
                    back.setAnimation(a);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == _list.size() - 1) {
                    songPlay(0);
                    next.setAnimation(b);

                } else {
                    songPlay(position + 1);
                    next.setAnimation(b);
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

    private void getSong() {

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0";
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    PhnSongs song = null;
                    try {
                        long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                        String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                        String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                        String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
//                        String art = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
                        String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                        song = new PhnSongs();

                        Log.e("ssd", url);
                        song.setArtist(artist);
                        song.setUri(url);
                        song.setAlbumName(album);
                        song.setTitle(name);
//                        song.setAlbumArt(art);
                        song.setId(String.valueOf(id));
                        _list.add(song);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

    }

    private void memuPopup() {

        PopupMenu popupMenu = new PopupMenu(this, down);
        popupMenu.inflate(R.menu.menu_pop_up);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        songText.setText("Songs");

                        if (!fragmentSongs.isAdded()) {
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.container_layout2, fragmentSongs)
                                    .addToBackStack(fragmentSongs.getTag())
                                    .commit();
                        }
                        break;

                    case R.id.item2:

                        songText.setText("Folders");

                        break;
                    case R.id.item3:
                        songText.setText("Artist");

                        if (!fragmentArtist.isAdded()) {

                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.container_layout2, fragmentArtist)
                                    .addToBackStack(fragmentArtist.getTag())
                                    .commit();
                        }


                        break;
                    case R.id.item4:
                        songText.setText("Album");

                        if (!fragmentAlbum.isAdded()) {
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.container_layout2, fragmentAlbum)
                                    .addToBackStack(fragmentAlbum.getTag())
                                    .commit();
                        }


                        break;
                }
                return false;
            }
        });
        popupMenu.show();
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


    public void songPlay(final int position) {
        this.position = position;
        String url = _list.get(position).getUri();
        String songTitle = _list.get(position).getTitle();
        textView.setText(songTitle);
        songClass.songStop();
        songClass.songPlay(getApplicationContext(), url, this);
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

    public void getArtist() {

        ArrayList<String> _chacker = new ArrayList<>();

        for (int i = 0; i < _list.size(); i++) {
            ModelArtistSong modelArtistSong = new ModelArtistSong();
            modelArtistSong.setArtist(_list.get(i).getArtist());

            ArrayList<PhnSongs> _listSongArtist = new ArrayList<>();

            for (int j = 0; j < _list.size(); j++) {
                if (_list.get(j).getArtist().toLowerCase().contains(modelArtistSong.getArtist().toLowerCase())) {
                    _listSongArtist.add(_list.get(j));
                }
            }

            modelArtistSong.set_list(_listSongArtist);

            if (!_chacker.contains(modelArtistSong.getArtist())) {
                _chacker.add(modelArtistSong.getArtist());
                _listArtist.add(modelArtistSong);
            }
        }
    }

    public void getAlbum() {
        ArrayList<String> _chacker = new ArrayList<>();
        for (int i = 0; i < _list.size(); i++) {
            ModelAbum modelAbum = new ModelAbum();
            modelAbum.setAlbum(_list.get(i).getAlbumName());

            ArrayList<PhnSongs> _listAlbum = new ArrayList<>();
            for (int j = 0; j < _list.size(); j++) {
                if (_list.get(j).getAlbumName().toLowerCase().contains(modelAbum.getAlbum().toLowerCase())) {
                    _listAlbum.add(_list.get(j));
                }
            }
            modelAbum.set_list(_listAlbum);

            if (!_chacker.contains(modelAbum.getAlbum())) {
                _chacker.add(modelAbum.getAlbum());
                _listAlbumSong.add(modelAbum);
            }
        }
    }
}


