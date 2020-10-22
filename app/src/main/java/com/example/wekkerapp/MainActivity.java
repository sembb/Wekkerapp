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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimePicker klok = findViewById(R.id.timePicker1);
        klok.setIs24HourView(true);
        final Button getTimeBtn = findViewById(R.id.getTimeBtn);
        final TextView showText = findViewById(R.id.showText);
        Intent intent = new Intent(this, AlarmActivation.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        getTimeBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                int uur = klok.getHour();
                int minuut = klok.getMinute();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, uur);
                cal.set(Calendar.MINUTE, minuut);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Toast.makeText(getApplication().getApplicationContext(), "Alarm gaat om " + uur + ":" + minuut,Toast.LENGTH_LONG).show();
                alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);


                showText.setText(Integer.toString(uur) + ':' + Integer.toString(minuut));

            }
        });
    }
}