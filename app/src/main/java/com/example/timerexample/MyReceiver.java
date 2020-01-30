package com.example.timerexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {
    private static int fCount = 1;
    private static int sCount = 0;

    public MyReceiver() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity main = new MainActivity();

        if (fCount < 10) {
            fCount++;
            notify(context);
            main.alarm(context, 60);

        } else {
            if (sCount < 10) {
                sCount++;
                notify(context);
                main.alarm(context, 10);

            } else {
                fCount = 0;
                sCount = 0;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void notify(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "default");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setTicker("h1");
        mBuilder.setContentTitle("h2");
        mBuilder.setContentText("h3");
        mBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        mBuilder.setAutoCancel(true);
        nm.notify(111, mBuilder.build());

    }
}
