package com.mjschievous.docbaoonline.main;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mjschievous.docbaoonline.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        view = findViewById(R.id.web_view);
        Intent intent = getIntent();
        String link = (String) intent.getSerializableExtra("link");
        view.setWebViewClient(new WebViewClient());
        view.loadUrl(link);
    }
}
