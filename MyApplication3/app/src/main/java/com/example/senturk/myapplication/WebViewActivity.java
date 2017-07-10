package com.example.senturk.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Bundle bnd=getIntent().getExtras();
        String value=bnd.getString("gonder");

        webView=(WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(value);

        final ProgressDialog progress=ProgressDialog.show(this,"Sayfa yükleniyor!","Yükleniyor...",true);
        progress.show();

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "Sayfa yüklendi\n"+url, Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failinUrl) {
                Toast.makeText(getApplicationContext(), "Bir hata oluştı\n"+description, Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }
}
