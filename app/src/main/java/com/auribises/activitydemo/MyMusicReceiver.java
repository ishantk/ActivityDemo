package com.auribises.activitydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyMusicReceiver extends BroadcastReceiver {

    Context context;

    String songName;

    void showNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("This is Title");
        builder.setContentText("This is Text");
        builder.setSmallIcon(R.drawable.sunny);

        // You need to give Vibrate Permission in manifest file
        builder.setDefaults(Notification.DEFAULT_ALL); // LED, Sound, Vibration


        Intent intent = new Intent(context,AllSongsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("This is Big Text..!!"));
        builder.addAction(android.R.drawable.ic_menu_add,"Add",pendingIntent);
        builder.addAction(android.R.drawable.ic_menu_delete,"Delete",pendingIntent);

        Notification notification = builder.build();


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;

        String action = intent.getAction();
        songName = intent.getStringExtra("keySong");

        if(action.equals("a.b.c.d")){
            Toast.makeText(context,"a.b.c.d received... and song is: "+songName,Toast.LENGTH_LONG).show();
            showNotification();
        }


        //if(action.equals(Intent.ACTION_POWER_CONNECTED)){

        //}

        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")){

        }

    }
}
