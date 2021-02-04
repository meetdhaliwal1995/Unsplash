package com.example.demomeme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demomeme.ModelLogin.ListLogin;
import com.example.demomeme.ModelLogin.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUserLogin extends AppCompatActivity {

    EditText pass, email;
    Button enter;
    TextView signup, reset;
    CheckBox saveLogin;
    private Boolean saveData;

    public static final String MyPre = "MyPres";

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass = findViewById(R.id.password);
        email = findViewById(R.id.login);
        enter = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup_text);
        reset = findViewById(R.id.reset_password);
        saveLogin = findViewById(R.id.check);

        sharedPreferences = getSharedPreferences(MyPre, Context.MODE_PRIVATE);

        saveData = sharedPreferences.getBoolean("saveData", false);

        if (saveData) {
            Log.e("ssss", "save");
            email.setText(sharedPreferences.getString("userEmail", null));
            pass.setText(sharedPreferences.getString("userPass", null));
            Log.e("ssss", "openActivity");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            email.setText("");
            pass.setText("");
        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityUserLogin.this, ActivityUserRegister.class);
                startActivity(intent);
            }
        });

        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserLogin.this, "email empty", Toast.LENGTH_SHORT).show();
                } else if (pass.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserLogin.this, "pass empty", Toast.LENGTH_SHORT).show();
                } else {
                    networkInterface.getUserLogin(email.getText().toString(), pass.getText().toString()).enqueue(new Callback<UserLogin>() {
                        @Override
                        public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                            if (response.body().getLIVETV().get(0).getSuccess().equals("1")) {
                                Log.e("ddd", "ddd");
                                saveData();
                                ListLogin s = response.body().getLIVETV().get(0);
                                Intent intent = new Intent(ActivityUserLogin.this, MainActivity.class);
                                intent.putExtra("user_id", s.getUserId());
                                startActivity(intent);
                            } else {
                                Toast.makeText(ActivityUserLogin.this, "not exist", Toast.LENGTH_SHORT).show();
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

        sharedPreferences = getSharedPreferences(MyPre, Context.MODE_PRIVATE);
        String s = email.getText().toString();
        String s1 = pass.getText().toString();
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (saveLogin.isChecked()) {
            sharedPreferences.edit()
                    .putBoolean("saveData", true)
                    .putString("userEmail", s)
                    .putString("userPass", s1)
                    .apply();
            Toast.makeText(this, "data save", Toast.LENGTH_SHORT).show();
        }
    }


    public void retriveData() {

        sharedPreferences = getApplicationContext().getSharedPreferences(MyPre, Context.MODE_PRIVATE);

        if (sharedPreferences.contains("userEmail")) {
            email.setText(sharedPreferences.getString("userEmail", ""));
        }
        if (sharedPreferences.contains("userPass")) {
            pass.setText(sharedPreferences.getString("userPass", ""));
        }

    }

}

