package com.example.ammdhillon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ammdhillon.ModelUserLogin.ListLogin;
import com.example.ammdhillon.ModelUserLogin.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    EditText email, password;
    Button logIn;
    TextView forgot;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login);
        password = findViewById(R.id.password);
        logIn = findViewById(R.id.login_btn);
        forgot = findViewById(R.id.forgot_btn);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this,ActivityResetPass.class);
                startActivity(intent);
            }
        });


        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "enter email", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "enter password", Toast.LENGTH_SHORT).show();

                } else {
                    networkInterface.getUserLogin(email.getText().toString(),password.getText().toString()).enqueue(new Callback<UserLogin>() {
                        @Override
                        public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                            ListLogin listLogin = response.body().getLIVETV().get(0);
                            if (listLogin.getSuccess().equals("1")){
                                Toast.makeText(ActivityLogin.this,"welcome",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ActivityLogin.this,MainActivity.class);
                                intent.putExtra("user_id",listLogin.getUserId());
                                startActivity(intent);
                            }else {
                                Toast.makeText(ActivityLogin.this,"wrong password",Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<UserLogin> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
