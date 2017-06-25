package com.laotek.mobile.trinitychapel;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by larryoke on 28/05/2017.
 */

public class DetectConnection {
    public static boolean checkInternetConnection(Context context) {

        ConnectivityManager con_manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean result;

        if (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
