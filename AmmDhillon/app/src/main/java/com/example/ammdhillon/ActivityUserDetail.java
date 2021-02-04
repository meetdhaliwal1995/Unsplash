package com.example.ammdhillon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ammdhillon.ModelProfileUpdate.UpdateData;
import com.example.ammdhillon.ModelUserProfile.ListProfile;
import com.example.ammdhillon.ModelUserProfile.UserProfile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUserDetail extends AppCompatActivity {
    EditText name, email, pass, success, phone;
    TextView ussr_id;
    Button update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        name = findViewById(R.id.name_text);
        success = findViewById(R.id.success_text);
        pass = findViewById(R.id.password_text);
        phone = findViewById(R.id.phone_text);
        ussr_id = findViewById(R.id.user_id);
        email = findViewById(R.id.email_text);
        update = findViewById(R.id.update_btn);

        String s = getIntent().getStringExtra("id");

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getUserProfile(s).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {

                ListProfile livetv = response.body().getLIVETV().get(0);

                name.setText(livetv.getName());
                success.setText(livetv.getSuccess());
                phone.setText(livetv.getPhone());
                ussr_id.setText(livetv.getUserId());
                email.setText(livetv.getEmail());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (name.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserDetail.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                        } else if (success.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserDetail.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                        } else if (phone.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserDetail.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                        } else if (email.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserDetail.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                        } else {
                            networkInterface.getProfielupdate(ussr_id.getText().toString(), name.getText().toString(), email.getText().toString(), pass.getText().toString(), phone.getText().toString()).enqueue(new Callback<UpdateData>() {
                                @Override
                                public void onResponse(Call<UpdateData> call, Response<UpdateData> response) {
                                    Log.e("ss", response.raw().toString());
                                    response.body().getLIVETV().get(0).getSuccess().equals("1");
                                    String s = response.body().getLIVETV().get(0).getMsg();
                                    Toast.makeText(ActivityUserDetail.this, s, Toast.LENGTH_SHORT).show();
                                }
                                @Override
                                public void onFailure(Call<UpdateData> call, Throwable t) {

                                }
                            });
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }
}