package com.board.exams.myresult.fication;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.board.exams.myresult.R;
import com.board.exams.myresult.ficationoti;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String channelId ="one";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification() != null) {

            String title= remoteMessage.getNotification().getTitle();
            String body= remoteMessage.getNotification().getBody();


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(channelId, "Channel name readable title",
                        NotificationManager.IMPORTANCE_DEFAULT);
                  NotificationManager notificationManager = getSystemService(NotificationManager.class);

                notificationManager.createNotificationChannel(channel);
            }
            sendNotification(body,title);
        }
    }
    private void sendNotification(String messageBody,String title) {
        Intent intent = new Intent(this, ficationoti.class);
       //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_launcher_web)
                        .setContentTitle(title)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        // Since android Oreo notification channel is needed.


        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
