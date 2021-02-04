package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indianmemeammdhillon.ModelApi.ModelUpdateProfile.UpdateData;
import com.example.indianmemeammdhillon.ModelApi.ModelUserProfile.ListUserProfile;
import com.example.indianmemeammdhillon.ModelApi.ModelUserProfile.UserProfile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUserProfile extends AppCompatActivity {

    EditText email, name, phone, success, password;
    TextView user;
    Button update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        bindView();
        retrofit();
    }

    private void retrofit() {

        final String id = getIntent().getStringExtra("user");

        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.userProfile(id).enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                ListUserProfile list = response.body().getLIVETV().get(0);
                user.setText(list.getUserId());
                name.setText(list.getName());
                email.setText(list.getEmail());
                phone.setText(list.getPhone());
                success.setText(list.getSuccess());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (user.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserProfile.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                        } else if (email.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserProfile.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                        } else if (name.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserProfile.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                        } else if (phone.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserProfile.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                        } else if (success.getText().toString().isEmpty()) {
                            Toast.makeText(ActivityUserProfile.this, "field can't be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            networkInterface.userUpdate(user.getText().toString(), name.getText().toString(), phone.getText().toString(), email.getText().toString(), password.getText().toString()).enqueue(new Callback<UpdateData>() {
                                @Override
                                public void onResponse(Call<UpdateData> call, Response<UpdateData> response) {
                                    if (response.body().getLIVETV().get(0).getSuccess().equals("1")) {
                                        String s = response.body().getLIVETV().get(0).getMsg();
                                        Toast.makeText(ActivityUserProfile.this, s, Toast.LENGTH_SHORT).show();
                                    } else {
                                        String s = response.body().getLIVETV().get(0).getMsg();
                                        Toast.makeText(ActivityUserProfile.this, s, Toast.LENGTH_SHORT).show();
                                    }
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

    private void bindView() {
        user = findViewById(R.id.user_id);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        success = findViewById(R.id.success);
        update = findViewById(R.id.update_btn);
        password = findViewById(R.id.password);

    }
}
