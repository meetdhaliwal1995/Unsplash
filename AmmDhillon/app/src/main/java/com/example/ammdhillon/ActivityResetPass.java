package com.example.ammdhillon;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ammdhillon.ModelResetPassword.ForgotPassword;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityResetPass extends AppCompatActivity {

    TextView reset;
    EditText emailText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        reset = findViewById(R.id.button_reset);
        emailText = findViewById(R.id.edit_text);

        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailText.getText().toString().isEmpty()){
                    Toast.makeText(ActivityResetPass.this,"enter valid email",Toast.LENGTH_SHORT).show();
                }else {
                    networkInterface.getResetPass(emailText.getText().toString()).enqueue(new Callback<ForgotPassword>() {
                        @Override
                        public void onResponse(Call<ForgotPassword> call, Response<ForgotPassword> response) {
                           if (response.body().getLIVETV().get(0).getSuccess().equals("1")){
                               String s = response.body().getLIVETV().get(0).getMsg();
                               Toast.makeText(ActivityResetPass.this,s,Toast.LENGTH_SHORT).show();
                           }else {
                               String s = response.body().getLIVETV().get(0).getMsg();
                               Toast.makeText(ActivityResetPass.this,s,Toast.LENGTH_SHORT).show();
                           }
                        }

                        @Override
                        public void onFailure(Call<ForgotPassword> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }
}
