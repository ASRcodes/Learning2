package com.example.wscubepractice2.AlarmService;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityAlarmServiceBinding;
import com.example.wscubepractice2.databinding.ActivityServicesBinding;

public class serviceAlarm extends AppCompatActivity {
ActivityAlarmServiceBinding binding;
    static final int ALARM_REQ_CODE = 100;
    EditText editText,inMins,inHRS;
    Button button,inMin,inHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAlarmServiceBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        button = findViewById(R.id.setAlarm);
        editText = findViewById(R.id.alramsec);

//        Get the System's alarm service
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                taken the values from user and converted it into milisecond for further use......
                int time = Integer.parseInt(editText.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000);

//                intent to call the broadcast receiver class
                Intent iBroadcast = new Intent(serviceAlarm.this, MyBroadcastReceiver.class);
//                pending intent which will do the background work of setting the alarm and playing it.....
                PendingIntent pi = PendingIntent.getBroadcast
                        (serviceAlarm.this,ALARM_REQ_CODE,iBroadcast, PendingIntent.FLAG_IMMUTABLE);

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
                Toast.makeText(serviceAlarm.this, "Alarm will ring after "+(time)+" Seconds", Toast.LENGTH_SHORT).show();
            }
        });
        binding.setAlarminMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(binding.alramMin.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*60000);

//                intent to call the broadcast receiver class
                Intent iBroadcast = new Intent(serviceAlarm.this, MyBroadcastReceiver.class);
//                pending intent which will do the background work of setting the alarm and playing it.....
                PendingIntent pi = PendingIntent.getBroadcast
                        (serviceAlarm.this,ALARM_REQ_CODE,iBroadcast, PendingIntent.FLAG_IMMUTABLE);

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
                Toast.makeText(serviceAlarm.this, "Alarm will ring after "+(time)+" Minutes", Toast.LENGTH_SHORT).show();
            }
        });
        binding.setAlarminHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(binding.alramHours.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*3600000);

//                intent to call the broadcast receiver class
                Intent iBroadcast = new Intent(serviceAlarm.this, MyBroadcastReceiver.class);
//                pending intent which will do the background work of setting the alarm and playing it.....
                PendingIntent pi = PendingIntent.getBroadcast
                        (serviceAlarm.this,ALARM_REQ_CODE,iBroadcast, PendingIntent.FLAG_IMMUTABLE);

                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);

                Toast.makeText(serviceAlarm.this, "Alarm will ring after "+(time)+" HRS", Toast.LENGTH_SHORT).show();
            }
        });
    }
}