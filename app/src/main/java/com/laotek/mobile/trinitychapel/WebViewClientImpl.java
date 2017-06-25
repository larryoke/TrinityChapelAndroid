package com.laotek.mobile.trinitychapel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by larryoke on 27/05/2017.
 */

public class WebViewClientImpl extends WebViewClient {
    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (!DetectConnection.checkInternetConnection(activity)) {
            Toast.makeText(activity.getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();
            return false;

        } else {
            if (url.indexOf(MainActivity.HOSTNAME) > -1 || url.indexOf("paypal.com") > -1) return false;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }
    }

//    @Override
//    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//        handler.proceed(); // Ignore SSL certificate errors
//    }
}
