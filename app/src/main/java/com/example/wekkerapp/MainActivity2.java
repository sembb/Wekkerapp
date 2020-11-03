package com.example.wekkerapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Button stopbutton = findViewById(R.id.button2);
        final Intent terug = new Intent(this, MainActivity.class);
        final Intent stopService = new Intent(this, WekkerService.class);
        stopService.putExtra("switch", true);
        terug.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationService.mp.stop();
                NotificationService.vibe.cancel();
                MainActivity.notificationManager.cancel(1);
                startService(stopService);
                startActivity(terug);
            }
        });

    }
}