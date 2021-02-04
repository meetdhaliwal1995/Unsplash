package com.example.indianmemeammdhillon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indianmemeammdhillon.ModelApi.ModelLogin.ListLogin;
import com.example.indianmemeammdhillon.ModelApi.ModelLogin.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    TextView textView, signup;
    EditText login, password;
    Button loginBtn;
    boolean saveData;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    public static final String Mypre = "Mypres";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(Mypre, Context.MODE_PRIVATE);


        bindView();
        retrofit();
        listner();

        saveData = sharedPreferences.getBoolean("saveData", false);
        if (saveData) {
            login.setText(sharedPreferences.getString("email", ""));
            password.setText(sharedPreferences.getString("pass", ""));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void bindView() {

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);
        textView = findViewById(R.id.reset_password);
        signup = findViewById(R.id.signup_text);
        checkBox = findViewById(R.id.chack);


    }

    private void listner() {

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityForgotData.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityUserRegister.class);
                startActivity(intent);
            }
        });
    }

    private void retrofit() {
        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "enter id", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "enter password", Toast.LENGTH_SHORT).show();

                } else {
                    networkInterface.userLogin(login.getText().toString(), password.getText().toString()).enqueue(new Callback<UserLogin>() {
                        @Override
                        public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                            if (response.body().getLIVETV().get(0).getSuccess().equals("1")) {
                                saveData();
                                ListLogin list = response.body().getLIVETV().get(0);
                                Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                                intent.putExtra("user_id", list.getUserId());
                                startActivity(intent);
                            } else {

                                Toast.makeText(ActivityLogin.this, "something wrong", Toast.LENGTH_SHORT).show();
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

    private void saveData() {
        sharedPreferences = getSharedPreferences(Mypre, MODE_PRIVATE);
        String mail = login.getText().toString();
        String pass = password.getText().toString();

        if (checkBox.isChecked()) {
            sharedPreferences.edit()
                    .putBoolean("saveData", true)
                    .putString("email", mail)
                    .putString("pass", pass)
                    .apply();
            Toast.makeText(this, "Data Save", Toast.LENGTH_SHORT).show();
        }
    }
}
