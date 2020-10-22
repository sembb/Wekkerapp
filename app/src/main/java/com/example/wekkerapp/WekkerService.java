package com.example.wekkerapp;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class WekkerService extends IntentService {
    public WekkerService() {
        super("WekkerService");

    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("handling", "is aan het handlen");

        Intent alarmIntent = new Intent(this, MainActivity2.class);
        alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(alarmIntent);
    }
}
