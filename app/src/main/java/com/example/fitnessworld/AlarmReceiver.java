package com.example.fitnessworld;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context,insert2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,i,0);



    NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"Reminder")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Drinking Water Reminder ")
                .setContentText("Time to drink water..!")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompatCompat = NotificationManagerCompat.from(context);
        notificationManagerCompatCompat.notify(123,builder.build());

    }
}
