package com.laotek.mobile.trinitychapel;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {


    static final String HOSTNAME = "trinitychapel.churchg.com";
    //static final String HOSTNAME = "10.0.2.2";
    static final String URL = String.format("https://%s/mobi.htm", HOSTNAME);


    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        boolean detected = DetectConnection.checkInternetConnection(this);
        if (!detected) {
            Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();

        } else {
            webView = (WebView)
                    findViewById(R.id.webview);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);



            webView.setBackgroundColor(0);
            webView.setBackgroundResource(R.drawable.theyearofprogress);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView.getSettings().setAppCacheEnabled(false);
            webView.getSettings().setLoadWithOverviewMode(true);
            //webView.getSettings().setPluginsEnabled(true);
            //webView.getSettings().setPluginState(PluginState.ON);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(false);




            WebViewClientImpl webViewClient = new WebViewClientImpl(this);
            webView.setWebViewClient(webViewClient);

            webView.addJavascriptInterface(new AppJavaScriptProxy(this), "androidAppProxy");




            webView.loadUrl(URL);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
