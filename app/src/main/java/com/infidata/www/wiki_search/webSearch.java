package com.infidata.www.wiki_search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webSearch extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_search);
        Intent in=getIntent();
        String a=in.getStringExtra("data");
        WebView wv=findViewById(R.id.wv);
        String url="https://en.wikipedia.org/wiki/"+a;
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);
    }
}
