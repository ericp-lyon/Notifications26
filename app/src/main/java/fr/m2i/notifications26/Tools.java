package fr.m2i.notifications26;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;

import java.util.Locale;

import static android.provider.Settings.Global.getString;

/**
 * Created by Administrateur on 09/01/2018.
 */





public class Tools {


private static int notifId =0;


 public static int showNotification(Context ctxt, String channel) {

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
   return showNotification_v26(ctxt, "ok");

  } else {
   return showNotification_v25(ctxt, "ko");
  }
 }


 public static int showNotification_v26(Context ctxt, String channel){



  // d abord creation du channel
  NotificationManager mNotificationManager = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);

  // id du channel
  String id = "my_channel_01";
  notifId++;

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


   // The user-visible name of the channel.
   String name = channel;
   // The user-visible description of the channel.
   String description = channel;
   int importance = NotificationManager.IMPORTANCE_HIGH;
   NotificationChannel mChannel = new NotificationChannel(id, name, importance);
// Configure the notification channel.
   mChannel.setDescription(description);
   mChannel.enableLights(true);
// Sets the notification light color for notifications posted to this
// channel, if the device supports this feature.
   mChannel.setLightColor(Color.RED);
   mChannel.enableVibration(true);
   mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
   mNotificationManager.createNotificationChannel(mChannel);


/// creation de la notification
   String CHANNEL_ID = "my_channel_01";
   NotificationCompat.Builder mBuilder =
           new NotificationCompat.Builder(ctxt, CHANNEL_ID)
                   .setSmallIcon(R.drawable.notification_icon)
                   .setContentTitle("M2i")
                   .setContentText("hello v26");

   mBuilder.build();
   mNotificationManager.notify(1, mBuilder.build());
  }
  return notifId;
 }


 public static int showNotification_v25(Context ctxt, String str) {


  NotificationManager mNotificationManager = (NotificationManager) ctxt.getSystemService(Context.NOTIFICATION_SERVICE);
  String CHANNEL_ID = "my_channel_01";
  Notification.Builder mbuilder = new Notification.Builder(ctxt);
  mbuilder.setContentText("ok v25");
  mbuilder.setContentTitle("notification");
  mbuilder.setSmallIcon(R.drawable.notification_icon);

  mbuilder.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


  mNotificationManager.notify(notifId, mbuilder.build());


  return notifId;

 }

}
