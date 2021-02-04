package com.example.webbrouser;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.nio.file.WatchEvent;

import static android.content.Context.DOWNLOAD_SERVICE;

public class BrouserFrag extends Fragment {

    private ImageView home, search, facebook, youtube, insta, back, forward, closebtn;
    EditText searchet;
    MainActivity activity;
    ConstraintLayout homeLayout;
    ProgressBar progressBar;
    private WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;
    String url = "https://google.com";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.brouser_tab, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        home = view.findViewById(R.id.home_iv);
        search = view.findViewById(R.id.search_iv);
        facebook = view.findViewById(R.id.facebook);
        youtube = view.findViewById(R.id.youtube);
        insta = view.findViewById(R.id.insta);
        back = getActivity().findViewById(R.id.back);
        forward = getActivity().findViewById(R.id.forward);
        closebtn = getActivity().findViewById(R.id.close_btn);
        searchet = view.findViewById(R.id.search_et);
        webView = view.findViewById(R.id.web_view);
        swipeRefreshLayout = view.findViewById(R.id.swipe_layout);
        homeLayout = view.findViewById(R.id.home_layout);
        progressBar = view.findViewById(R.id.progress_bar);

//        searchet.setOnEditorActionListener();
        activity = (MainActivity) getContext();


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

        Loadweb();
        webView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Name of your downloadble file goes here, example: Mathematics II ");
                DownloadManager dm = (DownloadManager) activity.getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(activity.getApplicationContext(), "Downloading File", //To notify the Client that the file is being downloaded
                        Toast.LENGTH_LONG).show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SDS", "AA");
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(View.GONE);
                homeLayout.setVisibility(View.VISIBLE);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = searchet.getText().toString().trim();
                if (!url.isEmpty()) {
                    webView.loadUrl("https://" + url);
                } else
                    Toast.makeText(getContext(), "plzz load url", Toast.LENGTH_SHORT).show();

                webView.setVisibility(View.VISIBLE);
                homeLayout.setVisibility(View.GONE);

            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeLayout.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl("https://youtube.com");
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeLayout.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl("https://instagram.com");
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeLayout.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl("https://facebook.com");
            }
        });

    }
    private Void Loadweb () {
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                    progressBar.setProgress(newProgress);

                if (progressBar.getProgress() == 100) {
                    progressBar.setVisibility(View.GONE);
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        return null;
    }

}