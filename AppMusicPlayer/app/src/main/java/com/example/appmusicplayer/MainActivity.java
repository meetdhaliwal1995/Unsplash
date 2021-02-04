package com.example.appmusicplayer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetUrlInterface {


    RecyclerView recyclerView;
    public static List<PhnSongs> _list = new ArrayList<>();
    public List<ModelArtistSong> _listArtist = new ArrayList<>();
    FragmntSeek fragmntSeek;
    AdapterSongs adapterSongs;
    ImageView down;
    FragmentSongs fragmentSongs;
    FragmentArtist fragmentArtist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        down = findViewById(R.id.down);

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memuPopup();
            }
        });

        getSong();

        getArtistListq();

        fragmentSongs = new FragmentSongs();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout2, fragmentSongs)
                .addToBackStack(fragmentSongs.getTag())
                .commit();

        fragmntSeek = new FragmntSeek();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragmntSeek)
                .addToBackStack(fragmntSeek.getTag())
                .commit();

        fragmentArtist = new FragmentArtist();

        fragmntSeek.set_list(_list);
        fragmentArtist.setList(_listArtist);
        fragmentSongs.setList(_list);
        fragmentSongs.setFragmntSeek(fragmntSeek);


        adapterSongs = new AdapterSongs(MainActivity.this, _list, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapterSongs);
    }

    @Override

    public void onItemClick(int position) {
        fragmntSeek.songPlay(position);
    }

    @Override
    public void onLongClick(int position) {

        _list.remove(position);
        adapterSongs.notifyItemRemoved(position);

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
                        fragmentSongs = new FragmentSongs();
                        getSupportFragmentManager().beginTransaction()
                                .add(R.id.container_layout2, fragmentSongs)
                                .addToBackStack(fragmentSongs.getTag())
                                .commit();
                        break;

                    case R.id.item2:

                        break;
                    case R.id.item3:

//                        fragmentArtist = new FragmentArtist();
                        getSupportFragmentManager().beginTransaction()
                                .add(R.id.container_layout2, fragmentArtist)
                                .addToBackStack(fragmentArtist.getTag())
                                .commit();

                        break;
                    case R.id.item4:

                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void getArtistList() {
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


            _listArtist.add(modelArtistSong);
        }
    }

    //
    public void getArtistListq() {
        ArrayList<String> _checker = new ArrayList<>();

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

            if (!_checker.contains(modelArtistSong.getArtist())) {
                _checker.add(modelArtistSong.getArtist());
                _listArtist.add(modelArtistSong);
            }
        }
    }
}



