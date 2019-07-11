package com.example.alc4phase1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class AboutAlc extends AppCompatActivity {
    WebView webView;
    LinearLayout layoutAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAlc.this,MainActivity.class);
                startActivity(intent);
            }
        });

        layoutAbout = findViewById(R.id.layoutAbout);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebClient());

        try {
            webView.loadUrl("https://andela.com/alc/");
        }catch (Exception e){
            Snackbar.make(layoutAbout,"Failed to load the webpage",Snackbar.LENGTH_LONG).show();
        }
    }

}
