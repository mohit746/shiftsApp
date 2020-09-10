package com.example.shiftsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftsdemo.database.DBManager;
import com.example.shiftsdemo.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = "SplashActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new DBManager(this).open();

        //Requesting for permission...
        Log.d(TAG, "onCreate: calling initializeApp...");
        Thread mythread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Log.d(TAG, "run: moving to login screen");
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }
}