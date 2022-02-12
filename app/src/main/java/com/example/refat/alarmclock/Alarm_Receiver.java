package com.example.refat.alarmclock;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by REFAT on 10/11/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver
{

    Ringtone ringtone;public boolean isRunning;public  int state;MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        state = intent.getIntExtra("extra",1);

        Toast.makeText(context, "ALARM OFF"+state, Toast.LENGTH_SHORT).show();


        //if(state==1)
        //{
        Vibrator vibrator=(Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        Notification noti=new Notification.Builder(context)
                .setContentTitle("Alarm is on")
                .setContentText("You had set the alarm.")
                .setSmallIcon(R.drawable.sounds)
                .setContentIntent(pendingIntent).getNotification();

        noti.flags=Notification.FLAG_AUTO_CANCEL;
        NotificationManager manager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        //Intent intent_main_activity = new Intent(context, MainActivity.class);
        manager.notify(0,noti);
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            ringtone = RingtoneManager.getRingtone(context,alarmUri);
                ringtone.play();

           // mp = MediaPlayer.create(context, alarmUri);
                //mp.setLooping(true);
               // mp.start();

        //destroy();Toast.makeText(context, "Alarm!"+state, Toast.LENGTH_LONG).show();
       // }
        //if (alarmUri == null)
       // {
            //alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
       // }
    }

    private void destroy() {
        mp.stop();
    }

}