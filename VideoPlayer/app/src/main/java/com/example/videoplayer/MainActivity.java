package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button searchbtn, cancelbtn,btn1;
    EditText search;
    RecyclerView recyclerView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchbtn = findViewById(R.id.search_btn);
        cancelbtn = findViewById(R.id.cancel_btn);
//        btn1 = findViewById(R.id.btn_1);
        search = findViewById(R.id.search_url);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Music1> _list = new ArrayList<>();

        _list.add(new Music1("Track1","https://vipkhan.mobi/cache/CAT_punjabi-videos/CAT_punjabi-video-song/5086/mp4/mp4-1080p/Pagal%20Gurnam%20Bhullar%20-%20HDYaar.Com.mp4","Gurnaam Bhuller"));
        _list.add(new Music1("Track2","https://vipkhan.mobi/cache/CAT_punjabi-videos/CAT_punjabi-video-song/5085/mp4/mp4-720p/Kohinoor%20Divine%20-%20HDYaar.Com.mp4","kohinor"));
        _list.add(new Music1("Track3","https://vipkhan.mobi/cache/CAT_bollywood-videos/CAT_hindi-video-songs/5088/mp4/mp4-720p/Ik%20Mulaqaat%20Unplugged%20Ayushmann%20Khurrana%20-%20HDYaar.Com.mp4","ayushmaan"));
        _list.add(new Music1("Track4", "https://vipkhan.mobi/cache/CAT_bollywood-videos/CAT_hindi-video-songs/5068/mp4/mp4-720p/Pepeta%20Nora%20Fatehi%20Ray%20Vanny%20-%20HDYaar.Com.mp4","fatehi"));
        _list.add(new Music1("Track5", "https://vipkhan.mobi/cache/CAT_bollywood-videos/CAT_hindi-video-songs/5055/mp4/mp4-720p/Ghungroo%20Song%20War%20Arijit%20Singh%20-%20HDYaar.Com.mp4","arjit singh"));
        _list.add(new Music1("Track6","https://vipkhan.mobi/cache/CAT_punjabi-videos/CAT_punjabi-video-song/5083/mp4/mp4-1080p/Subaah%20Ammy%20Virk%20Nikka%20Zaildar%203%20-%20HDYaar.Com.mp4","ammyvirk"));


        AdapterRecycler adapterRecycler = new AdapterRecycler(this,R.layout.song_list,_list);
        recyclerView.setAdapter(adapterRecycler);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "plzz enter url", Toast.LENGTH_SHORT).show();
                } else {
                    url = search.getText().toString();
                    startIntent();
                    }
                }
        });

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.getText().toString().isEmpty();
                Toast.makeText(getApplicationContext(),"Add Url",Toast.LENGTH_SHORT).show();
            }
        });



//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                url = "https://vipkhan.mobi/cache/CAT_punjabi-videos/CAT_punjabi-video-song/5086/mp4/mp4-1080p/Pagal%20Gurnam%20Bhullar%20-%20HDYaar.Com.mp4";
//                startIntent();
//            }
//        });

    }

    private void startIntent() {
        if (!url.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.setAction(url);
            startActivity(intent);
        }
    }
}