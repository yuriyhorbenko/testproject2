package com.example.bestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class BrowserActivity extends AppCompatActivity {

    WebView webview;
    EditText url_field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        webview = findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());
         url_field = findViewById(R.id.edit_data);
        Button click_bnt = findViewById(R.id.go_button);
        click_bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url_str = url_field.getText().toString();
                if(url_str.length()>0){
                    webview.loadUrl(url_str);
                }
            }
        });
    }
}
