package com.example.hotro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Tintuc2 extends AppCompatActivity {

    WebView webView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintuc2);
        webView = findViewById(R.id.webview1);
        intent = getIntent();
        String link = intent.getStringExtra("openlink");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());

    }
}