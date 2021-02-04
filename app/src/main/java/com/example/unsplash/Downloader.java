package com.example.unsplash;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2core.Func;

import org.jetbrains.annotations.NotNull;

public class Downloader {
    String url;
    Fetch fetch;
    Context context;
    AllPhoto allPhoto;
    private int STORAGE_PERMISSION_CODE = 1;
    private String CHANNEL_ID;
    NotificationManagerCompat notificationManager;

//    public Downloader(Context context) {
//        this.context = context;
//    }


    public void getDownload() {

        FetchConfiguration fetchConfiguration = new FetchConfiguration.Builder(context)
                .setDownloadConcurrentLimit(3)
                .build();

        fetch = Fetch.Impl.getInstance(fetchConfiguration);

//        String url = "http:www.example.com/test.txt";

//        String filePath = Environment.getExternalStorageDirectory() + "/Download/test.jpg";
//        String filePath = context.getExternalFilesDir(null) + "/test.jpg";
        String filePath = context.getExternalFilesDir(null) + "/" + allPhoto.getId() + ".jpg";


        final Request request = new Request(allPhoto.getUrls().getRegular(), filePath);
        request.setPriority(Priority.HIGH);
        request.setNetworkType(NetworkType.ALL);
//        request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG");
        Log.e("sss", "ffff");

        fetch.enqueue(request, new Func<Request>() {
            @Override
            public void call(@NotNull Request updatedRequest) {
                //Request was successfully enqueued for download.
                Toast.makeText(context, updatedRequest.getFile(), Toast.LENGTH_SHORT).show();
            }
        }, new Func<Error>() {
            @Override
            public void call(@NotNull Error error) {
                //An error occurred enqueuing the request.
                Log.e("www", error.getThrowable().getMessage());
            }
        });
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setAllPhoto(AllPhoto allPhoto) {
        this.allPhoto = allPhoto;
    }

    public void setNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_white)
                .setContentTitle("dddd")
                .setContentText("dddd")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    }

    public void setNotification1() {
        notificationManager = NotificationManagerCompat.from(context);

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_white)
                .setContentTitle("Splash")
                .setContentText("ddd")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }

    public void setNoti() {
        String CHANNEL_ID = "MESSAGE";
        String CHANNEL_NAME = "MESSAGE";

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_white)
                .setContentTitle("dddd")
                .setContentText("hhh")
                .build();
        manager.notify(1, notification);

    }
}
