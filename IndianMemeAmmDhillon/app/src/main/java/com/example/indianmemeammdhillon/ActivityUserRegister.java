package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indianmemeammdhillon.ModelApi.ModelRegisterUser.ListRegisterUser;
import com.example.indianmemeammdhillon.ModelApi.ModelRegisterUser.RegisterUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUserRegister extends AppCompatActivity {

    EditText name, email, pass, phone;
    TextView signUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        bindView();
        retrofit();

    }

    private void retrofit() {
        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserRegister.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserRegister.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                } else if (pass.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserRegister.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                } else if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUserRegister.this, "field can't be empty", Toast.LENGTH_SHORT).show();

                } else {
                    networkInterface.getUserRegister(name.getText().toString(), email.getText().toString(), pass.getText().toString(), phone.getText().toString()).enqueue(new Callback<RegisterUser>() {
                        @Override
                        public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                            ListRegisterUser list = response.body().getLIVETV().get(0);
                            if (list.getSuccess().equals("1")) {
                                String s = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityUserRegister.this, s, Toast.LENGTH_SHORT).show();
                            } else {
                                list.getSuccess().equals("0");
                                String st = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityUserRegister.this, st, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterUser> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    private void bindView() {
        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        pass = findViewById(R.id.edit_pass);
        phone = findViewById(R.id.edit_phone);
        signUp = findViewById(R.id.text_signup);
    }
}
