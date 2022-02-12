package com.example.refat.alarmclock;

import static android.R.attr.contextUri;
import static android.R.attr.value;
import static com.example.refat.alarmclock.R.id.stopalarm;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.os.Build;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public  AlarmManager alarmManager;
    public static PendingIntent pendingIntent;
    private  TimePicker alarmTimePicker;
    private  TextView alarmTextView;
    Intent intent;
    SharedPreferences sharedPreferences;
    public static  final int DEFAULT=34;
    long time;public static  String s;
    int h,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int mscore = getIntent().getIntExtra("ID_KEY",0);
        alarmTextView = (TextView) findViewById(R.id.updatetext);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmTimePicker = (TimePicker) findViewById(R.id.timepicker);
        Button start_alarm = (Button) findViewById(R.id.startalarm);
        start_alarm.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
             //   id =1;
                Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                Calendar calendar = Calendar.getInstance();
                int hour = alarmTimePicker.getCurrentHour();
                int minute = alarmTimePicker.getCurrentMinute();
                Log.e("MyActivity", "In the receiver with " + hour + " and " + minute);
                //setAlarmText("You clicked a " + hour + " and " + minute);
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());

                intent = new Intent(MainActivity.this, Alarm_Receiver.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //alarmTextView.setText(""+pendingIntent);
                //intent.putExtra("extra", 0);
                time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
                if (System.currentTimeMillis() >= time) {
                    if (calendar.AM_PM == 0)
                        time = time + (1000 * 60 * 60 * 12);
                    else
                        time = time + (1000 * 60 * 60 * 24);

                }
                if (hour > 12) {
                    hour = hour - 12;
                }
                if (minute < 10)
                {
                    alarmTextView.setText("Alarm set to " + hour + ":" + "0" + minute);
                } else
                    {
                    alarmTextView.setText("Alarm set to " + hour + ":" + minute);
                }
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,1, pendingIntent);
            }
        });

        Button stop_alarm = (Button) findViewById(R.id.stopalarm);

                stop_alarm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent.putExtra("extra", 0);
                        //sendBroadcast(intent);
                        alarmManager.cancel(pendingIntent);

                        Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                        //Intent quesintent = new Intent(MainActivity.this, Main2Activity.class);
                        //startActivity(quesintent);

                        //Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
            }
        });//&&pendingIntent != null
             if(mscore==3){

                 //Toast.makeText(MainActivity.this, " hi="+pendingIntent, Toast.LENGTH_SHORT).show();
                 }

        //Toast.makeText(MainActivity.this, " hi="+mscore, Toast.LENGTH_SHORT).show();
    }
    //public void setAlarmText(String alarmText) {
        //alarmTextView.setText(alarmText);
   // }

}