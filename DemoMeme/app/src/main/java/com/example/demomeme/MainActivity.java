package com.example.demomeme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomeme.ModelCategory.CategoryMeme;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.demomeme.ActivityUserLogin.MyPre;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    ImageView more;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.recycler_view);
        more = findViewById(R.id.more_iv);

        String intent = getIntent().getStringExtra("user_id");


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("dsds", "sdf");
                menuPopup();
            }
        });
//
//            Boolean Registered;
//
//        SharedPreferences sharedPreferences = getSharedPreferences(MyPres,MODE_PRIVATE);
//        Registered = sharedPreferences.getBoolean("Register",false);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getMemeCategory().enqueue(new Callback<CategoryMeme>() {
            @Override
            public void onResponse(Call<CategoryMeme> call, Response<CategoryMeme> response) {
                AdapterMain adapterMain = new AdapterMain(response.body().getLIVETV(), MainActivity.this);
                recyclerView.setAdapter(adapterMain);
            }

            @Override
            public void onFailure(Call<CategoryMeme> call, Throwable t) {

            }
        });
    }

    public void menuPopup() {
        PopupMenu popupMenu = new PopupMenu(this, more);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.memu_1:
                        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                        Log.e("sss", "hello");
                        break;

                    case R.id.menu_4:
                        Log.e("ddd", "logout");
                        sharedPreferences = getSharedPreferences(MyPre, Context.MODE_PRIVATE);
                        sharedPreferences.edit().putBoolean("saveData", false).apply();
                        Intent intent = new Intent(MainActivity.this, ActivityUserLogin.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
