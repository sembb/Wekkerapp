package com.example.wekkerapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button stopbutton = findViewById(R.id.button2);
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WekkerService.mediaPlayer.stop();
            }
        });

    }
}