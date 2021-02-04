package com.example.indianmemeammdhillon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianmemeammdhillon.Adapters.AdapterCategory;
import com.example.indianmemeammdhillon.ModelApi.ModelCategory.MemeCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.indianmemeammdhillon.ActivityLogin.Mypre;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    TextView memeText;
    ImageView more;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.search_view);
        memeText = findViewById(R.id.text_meme);
        more = findViewById(R.id.more_iv);


        listner();
        retrofit();

    }

    private void memuPopup() {

        PopupMenu popupMenu = new PopupMenu(this, more);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.memu_1:
                        Intent intent = new Intent(MainActivity.this, ActivityAppDetail.class);
                        startActivity(intent);
                        break;

                    case R.id.menu_2:
                        Intent intent1 = new Intent(MainActivity.this, ActivityAllChannel.class);
                        startActivity(intent1);
                        break;
                    case R.id.menu_3:
                        Intent intent2 = new Intent(MainActivity.this, ActivityUserProfile.class);
                        String string = getIntent().getStringExtra("user_id");
//                        intent2.putExtra("user_id", getIntent().getStringExtra("user_id"));
                        intent2.putExtra("user", string);
                        startActivity(intent2);
                        break;
                    case R.id.menu_4:
                        sharedPreferences = getSharedPreferences(Mypre, Context.MODE_PRIVATE);
                        sharedPreferences.edit().putBoolean("saveData", false).apply();
                        Intent intent3 = new Intent(getApplicationContext(), ActivityLogin.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void listner() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, ActivitySearchChannels.class);
                intent.putExtra("search_channels", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memuPopup();
            }
        });


    }

    private void retrofit() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getMemeCategory().enqueue(new Callback<MemeCategory>() {
            @Override
            public void onResponse(Call<MemeCategory> call, Response<MemeCategory> response) {
                AdapterCategory adapter = new AdapterCategory(MainActivity.this, response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MemeCategory> call, Throwable t) {
            }
        });
    }
}
