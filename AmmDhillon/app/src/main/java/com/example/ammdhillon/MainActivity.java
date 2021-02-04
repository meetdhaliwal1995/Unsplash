    package com.example.ammdhillon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.ammdhillon.ModelClass.CategoryParent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        ImageView home,search;
        SearchView searchView;
        TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        home = findViewById(R.id.home_btn);
        search= findViewById(R.id.search_btn);
        searchView = findViewById(R.id.search_view);
        textView = findViewById(R.id.name);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this,ActivitySearchChannels.class);
                intent.putExtra("search_channels", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                menuPopup();
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);

        networkInterface.getCategory().enqueue(new Callback<CategoryParent>() {
            @Override
            public void onResponse(Call<CategoryParent> call, Response<CategoryParent> response) {
                AdapterCategoryMain adapter = new AdapterCategoryMain(MainActivity.this, response.body().getLIVETV());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<CategoryParent> call, Throwable t) {

            }
        });
        }
        private void menuPopup () {
            PopupMenu popupMenu = new PopupMenu(this, home);
            popupMenu.inflate(R.menu.popup);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.item_1:
                            Intent intent = new Intent(MainActivity.this, AllChannelActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.item_2:
                            Intent intent1 = new Intent(MainActivity.this,ActivityAllVideo.class);
                            startActivity(intent1);
                            break;
                        case R.id.item_3:
                            Intent intent2 = new Intent(MainActivity.this, ActivityUserDetail.class);
                            String s = getIntent().getStringExtra("user_id");
//                            intent2.putExtra("id",getIntent().getStringExtra("user_id"));
                            intent2.putExtra("id",s);
                            startActivity(intent2);
                            break;
                        case R.id.item_4:
                            Intent intent3 = new Intent(MainActivity.this,ActivityAppDetail.class);
                            startActivity(intent3);
                            break;
                    }
                    return false;
                }
            });
            popupMenu.show();
    }
}
