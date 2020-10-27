package com.example.wekkerapp;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.annotation.Nullable;

public class WekkerService extends IntentService {

    public static MediaPlayer mediaPlayer;
    public WekkerService() {
        super("WekkerService");

    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("test", "onHandleIntent: ");
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmpie);
        if (MainActivity.FULL_SCREEN_ACTION.equals(intent.getAction()))

            mediaPlayer.setLooping(true);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
        MainActivity.CreateFullScreenNotification(getApplicationContext());

    }
}
