package com.example.wekkerapp;

import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Path;
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
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Button stopbutton = findViewById(R.id.button2);

        AnimationSet animationSet = new AnimationSet(true);

        RotateAnimation rotate = new RotateAnimation(-20, 20, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(500);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.INFINITE);

        ImageView image= (ImageView) findViewById(R.id.imageView2);

        image.startAnimation(rotate);


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