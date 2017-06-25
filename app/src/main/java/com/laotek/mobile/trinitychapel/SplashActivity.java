package com.laotek.mobile.trinitychapel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by larryoke on 27/05/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean detected = DetectConnection.checkInternetConnection(this);
        if (!detected) {
            Toast.makeText(getApplicationContext(), "No Internet!", Toast.LENGTH_SHORT).show();

        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Start home activity
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    // close splash activity
                    finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
    }
}
