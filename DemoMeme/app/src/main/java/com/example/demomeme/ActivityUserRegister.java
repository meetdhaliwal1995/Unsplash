package com.example.demomeme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demomeme.ModelRegister.ListRegister;
import com.example.demomeme.ModelRegister.UserRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUserRegister extends AppCompatActivity {

    EditText name,email,pass,phone;
    Button signup;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        name = findViewById(R.id.edit_name);
        email = findViewById(R.id.edit_email);
        pass = findViewById(R.id.edit_pass);
        phone = findViewById(R.id.edit_phone);
        signup = findViewById(R.id.text_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
                if (name.getText().toString().isEmpty()){
                    Toast.makeText(ActivityUserRegister.this,"field can't empty",Toast.LENGTH_SHORT).show();
                }else if (email.getText().toString().isEmpty()){
                    Toast.makeText(ActivityUserRegister.this,"field can't empty",Toast.LENGTH_SHORT).show();
                }else if (pass.getText().toString().isEmpty()){
                    Toast.makeText(ActivityUserRegister.this,"field can't empty",Toast.LENGTH_SHORT).show();
                }else if (phone.getText().toString().isEmpty()){
                    Toast.makeText(ActivityUserRegister.this,"field can't empty",Toast.LENGTH_SHORT).show();
                }else {
                    networkInterface.getUserRegister(name.getText().toString(),email.getText().toString(),pass.getText().toString(),phone.getText().toString()).enqueue(new Callback<UserRegister>() {
                        @Override
                        public void onResponse(Call<UserRegister> call, Response<UserRegister> response) {
                            ListRegister listRegister = response.body().getLIVETV().get(0);
                            if (listRegister.getSuccess().equals(1)){
                                    String s  = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityUserRegister.this,s,Toast.LENGTH_SHORT).show();
                            }else {
                                    listRegister.getSuccess().equals(0);
                                    String s1 = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityUserRegister.this,s1,Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<UserRegister> call, Throwable t) {

                        }
                    });
                }

            }
        });


    }
}
