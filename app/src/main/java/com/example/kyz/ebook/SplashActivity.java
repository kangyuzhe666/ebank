package com.example.kyz.ebook;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("Registered")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,Switchxml.class);
                startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        };
        timer.schedule(timerTask,1700);


    }
}
