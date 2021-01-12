package com.example.wekkerapp;

import android.animation.ObjectAnimator;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class NotificationService extends IntentService {
    public static MediaPlayer mp;
    public static Vibrator vibe;

    public NotificationService(){
        super("Notificationservice");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        vibe = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);


        mp = mp.create(getApplicationContext(), R.raw.alarmpie);
        mp.start();
        mp.setLooping(true);
        vibe.vibrate(999999999);

        MainActivity.CreateFullScreenNotification(this);
        final Intent stopKnop = new Intent(this, MainActivity2.class);
        stopKnop.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(stopKnop);
        return START_NOT_STICKY;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
    }
}
