package com.example.wekkerapp;

        import android.app.AlarmManager;
        import android.app.IntentService;
        import android.app.Notification;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.util.Log;
        import android.widget.Toast;

        import androidx.annotation.Nullable;
        import androidx.core.app.NotificationCompat;
        import androidx.core.app.NotificationManagerCompat;

        import java.util.Calendar;

public class WekkerService extends IntentService {
    private static final String CHANNEL_ID = "my_channel";
    static final String FULL_SCREEN_ACTION = "full_screen_action";
    static final int NOTIFICATION_ID = 1;

    public WekkerService() {
        super("WekkerService");

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        boolean swit = intent.getBooleanExtra("switch", false);
        if(swit == false) {

            int uur = intent.getIntExtra("uur", 0);
            int minuut = intent.getIntExtra("minuut", 0);

            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, 0);
            Notification notification = new NotificationCompat.Builder(this, "2")
                    .setContentTitle("Alarm klok app")
                    .setContentText("Er is een alarm gezet om "+uur+":"+minuut+".")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(pendingIntent)
                    .build();

            startForeground(2, notification);

            final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            Intent intent2 = new Intent(FULL_SCREEN_ACTION, null, getApplicationContext(), NotificationService.class);
            PendingIntent pendingIntent2 = PendingIntent.getService(getApplicationContext(), 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, uur);
            cal.set(Calendar.MINUTE, minuut);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            if (System.currentTimeMillis() > cal.getTimeInMillis()) {
                cal.add(Calendar.DATE, 1);
            }
            Toast.makeText(getApplication().getApplicationContext(), "Alarm gaat om " + uur + ":" + minuut, Toast.LENGTH_LONG).show();
            long delay = 24 * 60 * 60 * 1000;
            alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent2);


            //do heavy work on a background thread
            //stopSelf();
        }else{
            stopforeground();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
    }

    public void stopforeground(){
        stopForeground(true);
        stopSelf();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
