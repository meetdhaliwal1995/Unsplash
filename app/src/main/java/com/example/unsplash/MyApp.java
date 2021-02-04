package com.example.unsplash;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    private static Retrofit retrofit;
//    public static final String CHANNEL_1 = "channel1";


    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.e("rrr","ttt");
//        createNotificationChannels();

    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
//
//    private void createNotificationChannels() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel1 = new NotificationChannel(
//                    CHANNEL_1, "channel1",
//                    NotificationManager.IMPORTANCE_HIGH
//            );
//            channel1.setDescription("Channel One");
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            Log.e("ddd", "ggg");
//
//        }
//    }
}
