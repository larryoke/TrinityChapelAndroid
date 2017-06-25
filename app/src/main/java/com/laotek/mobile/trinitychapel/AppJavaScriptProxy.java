package com.laotek.mobile.trinitychapel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;

/**
 * Created by larryoke on 28/05/2017.
 */

public class AppJavaScriptProxy {
    private Activity activity = null;

    public AppJavaScriptProxy(Activity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void closeApp() {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Write your message here.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
