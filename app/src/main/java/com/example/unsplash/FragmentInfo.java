package com.example.unsplash;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.example.unsplash.ModelApi.Download.DownloadPic;
import com.example.unsplash.views.DownloadContract;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Fetch;
import com.tonyodev.fetch2.FetchConfiguration;
import com.tonyodev.fetch2.FetchListener;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Func;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

public class FragmentInfo extends Fragment implements DownloadContract.downloadView {
    TextView textone, texttwo, textthree, textfour, info, download;
    AllPhoto allPhoto;
    ImageView image;
    Fetch fetch;
    String url;
    private int STORAGE_PERMISSION_CODE = 1;
    private String CHANNEL_ID;
    NotificationManagerCompat notificationManager;
    Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textone = view.findViewById(R.id.text_one);
        texttwo = view.findViewById(R.id.text_two);
        textthree = view.findViewById(R.id.text_three);
        textfour = view.findViewById(R.id.text_four);
        image = view.findViewById(R.id.image_info);
        info = view.findViewById(R.id.user_info);
        download = view.findViewById(R.id.download_pic);

        //DownloadPresenter downloadPresenter = new DownloadPresenter(this);
        //downloadPresenter.getData();

        String s = String.valueOf(getContext());


        Glide.with(getContext()).load(allPhoto.getUrls().getRegular()).into(image);
        textone.setText(allPhoto.getUser().getName());
        textfour.setText(String.valueOf(allPhoto.getUser().getTotalPhotos()));
        textthree.setText(allPhoto.getAltDescription());
        texttwo.setText(String.valueOf(allPhoto.getLikes()));


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUser fragmentUser = new FragmentUser();
                fragmentUser.setDetail(allPhoto.getUser().getUsername());
                getFragmentManager().beginTransaction()
                        .add(R.id.container_layout, fragmentUser)
                        .addToBackStack("ddd")
                        .commit();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUserInfo fragmentUserInfo = new FragmentUserInfo();
                fragmentUserInfo.setuserName(allPhoto.getUser().getUsername());
//                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction()
                        .add(R.id.container_layout, fragmentUserInfo)
                        .addToBackStack("ddd")
                        .commit();
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Log.e("aaa", "eeee");

                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Downloader downloader = new Downloader();
                    downloader.setContext(getContext());
                    downloader.setAllPhoto(allPhoto);
                    downloader.getDownload();
//                    getDownloadPic();
                    setNoti();
                } else {
                    requestStoragePermission();
                }
            }

        });
    }


    public void setInfo(AllPhoto allPhoto) {

        this.allPhoto = allPhoto;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override

    public void setLatestData(DownloadPic downloadPic) {
        url = downloadPic.getUrl();

    }


    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(getContext())
                    .setTitle("Permission Needed")
                    .setMessage("This Permisson is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(getContext(), "Permission DENIED", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();

            }
        }
    }


    public void getDownloadPic() {
        FetchConfiguration fetchConfiguration = new FetchConfiguration.Builder(getContext())
                .setDownloadConcurrentLimit(3)
                .build();

        fetch = Fetch.Impl.getInstance(fetchConfiguration);

//        String url = "http:www.example.com/test.txt";

        //        String filePath = Environment.getExternalStorageDirectory() + "/Download/test.jpg";
        String filePath = getActivity().getExternalFilesDir(null) + "/" + allPhoto.getId() + ".jpg";


        final Request request = new Request(allPhoto.getUrls().getRegular(), filePath);
        request.setPriority(Priority.HIGH);
        request.setNetworkType(NetworkType.ALL);
//        request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG");
        Log.e("sss", "ffff");

        fetch.enqueue(request, new Func<Request>() {
            @Override
            public void call(@NotNull Request updatedRequest) {
                //Request was successfully enqueued for download.
                Toast.makeText(getContext(), updatedRequest.getFile(), Toast.LENGTH_SHORT).show();
            }
        }, new Func<Error>() {
            @Override
            public void call(@NotNull Error error) {
                //An error occurred enqueuing the request.
                Log.e("www", error.getThrowable().getMessage());
            }
        });

        FetchListener fetchListener = new FetchListener() {
            @Override
            public void onAdded(@NotNull Download download) {


            }

            @Override
            public void onQueued(@NotNull Download download, boolean b) {

            }

            @Override
            public void onWaitingNetwork(@NotNull Download download) {

            }

            @Override
            public void onCompleted(@NotNull Download download) {
                NotificationManager notificationManager =
                        (NotificationManager) getContext().getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancelAll();

            }

            @Override
            public void onError(@NotNull Download download, @NotNull Error error, @org.jetbrains.annotations.Nullable Throwable throwable) {

            }

            @Override
            public void onDownloadBlockUpdated(@NotNull Download download, @NotNull DownloadBlock downloadBlock, int i) {

            }

            @Override
            public void onStarted(@NotNull Download download, @NotNull List<? extends DownloadBlock> list, int i) {


            }

            @Override
            public void onProgress(@NotNull Download download, long l, long l1) {

            }

            @Override
            public void onPaused(@NotNull Download download) {

            }

            @Override
            public void onResumed(@NotNull Download download) {

            }

            @Override
            public void onCancelled(@NotNull Download download) {

            }

            @Override
            public void onRemoved(@NotNull Download download) {

            }

            @Override
            public void onDeleted(@NotNull Download download) {

            }
        };
    }

    public void setNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_white)
                .setContentTitle("dddd")
                .setContentText("dddd")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    public void setNoti() {
        String CHANNEL_ID = "MESSAGE";
        String CHANNEL_NAME = "MESSAGE";


        NotificationManagerCompat manager = NotificationManagerCompat.from(getContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_person_white)
                .setContentTitle("Unsplash")
                .setContentText(allPhoto.getUser().getName())
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("eeeee"))
                .build();
        manager.notify(1, notification);


    }

    public void getInput() {
        String KEY_TEXT_REPLY = "key_text_reply";

        String replyLabel = "kkk";
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .build();


    }
}
