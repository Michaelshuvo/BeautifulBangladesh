package com.example.beautifulbangladesh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class ReadingPage extends AppCompatActivity {
   WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muslim);
        web1 = (WebView) findViewById(R.id.webview);
        String data=getIntent().getStringExtra("title");
        if(data!="0") {


            // web.loadData("<p style=\"text-align:justify\">"+text+"<br><br>"+"<b>"+text1+"<b>"+text2+"<br><br>"+"</p>","text/html","UTF-8");
            String url = "file:////android_asset/"+data+".html";
            web1.loadUrl(url);
        }
        else{
            web1.loadData("Error something","text/html","UTF-8");
        }

    }
}
