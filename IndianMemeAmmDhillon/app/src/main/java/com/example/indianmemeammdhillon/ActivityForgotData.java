package com.example.indianmemeammdhillon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indianmemeammdhillon.ModelApi.ModelForgotData.ResetData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityForgotData extends AppCompatActivity {

    Button reset;
    EditText email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

       bindView();
       retrofit();
    }
    private void bindView(){
        reset = findViewById(R.id.button_reset);
        email = findViewById(R.id.edit_text);
    }

    private void retrofit(){
        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty()){
                    Toast.makeText(ActivityForgotData.this,"something wrong",Toast.LENGTH_SHORT).show();
                }else {
                    networkInterface.resetData(email.getText().toString()).enqueue(new Callback<ResetData>() {
                        @Override
                        public void onResponse(Call<ResetData> call, Response<ResetData> response) {
                            if (response.body().getLIVETV().get(0).getSuccess().equals("1"))
                            {
                                String s = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityForgotData.this,s,Toast.LENGTH_SHORT).show();
                            }else {
                                String s = response.body().getLIVETV().get(0).getMsg();
                                Toast.makeText(ActivityForgotData.this,s,Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResetData> call, Throwable t) {
                        }
                    });
                }
            }
        });
    }
}
