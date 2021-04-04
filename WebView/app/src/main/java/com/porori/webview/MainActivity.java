package com.porori.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "https://pororiri.tistory.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);   //자바스크립트Enable 설정.
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());  //웹뷰 최적화를 위해 chrome 사용
        webView.setWebViewClient(new WebViewClientClass());


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //뒤로가기 눌렀을때 뒤로 갈수 있으면 웹뷰 뒤로가기 실행
            webView.goBack();
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) { //현재페이지에 URL을 읽어올수 있는 메소드
            view.loadUrl(url);
            return true;
        }
    }


}