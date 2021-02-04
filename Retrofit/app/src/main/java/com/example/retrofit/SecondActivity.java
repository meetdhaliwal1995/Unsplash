package com.example.retrofit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private WebView webV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        webV = findViewById(R.id.web);

        webV.getSettings().setJavaScriptEnabled(true);
        webV.setWebChromeClient(new WebChromeClient());
        webV.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(SecondActivity.this,"page loading",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(SecondActivity.this,"page loaded",Toast.LENGTH_SHORT).show();
            }
        });

        webV.loadUrl(getIntent().getStringExtra("url"));

    }
}
