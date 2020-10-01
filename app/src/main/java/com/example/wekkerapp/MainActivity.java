package com.example.wekkerapp;
import java.util.Calendar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimePicker klok = findViewById(R.id.timePicker1);
        klok.setIs24HourView(true);
        final Button getTimeBtn = findViewById(R.id.getTimeBtn);
        final TextView showText = findViewById(R.id.showText);
        Intent intent = new Intent(this, AlarmActivation.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (5 * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + 5 + " seconds",Toast.LENGTH_LONG).show();


        getTimeBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                int uur = klok.getHour();
                int minuut = klok.getMinute();
                showText.setText(Integer.toString(uur) + ':' + Integer.toString(minuut));

            }
        });
    }
}