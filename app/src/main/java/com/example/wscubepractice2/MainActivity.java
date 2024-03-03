package com.example.wscubepractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wscubepractice2.AlarmService.serviceAlarm;
import com.example.wscubepractice2.AllAboutDatabase.learningDataBases;
import com.example.wscubepractice2.AllAboutDatabase.practiceRoomData;
import com.example.wscubepractice2.AllAboutNotification.PracNotification;
import com.example.wscubepractice2.AllAboutSensors.sensors;
import com.example.wscubepractice2.AllAboutServices.services;
import com.example.wscubepractice2.ImageUpload.ImageUploading;
import com.example.wscubepractice2.MeadiaPlayer.PlayerMUandVDO;
import com.example.wscubepractice2.MessageReceivingNsending.Yomessaging;
import com.example.wscubepractice2.NotesApp.contentNtitle;
import com.example.wscubepractice2.databinding.ActivityMainBinding;
import com.example.wscubepractice2.sharedPreference.splashForSharedpref;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
   Button webview,button,sens,service,alarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
         button =  findViewById(R.id.prefshared);
         sens = findViewById(R.id.senses);
         service = findViewById(R.id.services);
         alarm = findViewById(R.id.alarm);


        Intent intent = new Intent(this,com.example.wscubepractice2.webview.class);
        Intent splahsharepref = new Intent(this, splashForSharedpref.class);
        Intent senses = new Intent(this, sensors.class);
        Intent servicess = new Intent(this, services.class);
        Intent alaarmm = new Intent(this, serviceAlarm.class);
        Intent sms = new Intent(this, Yomessaging.class);
        Intent iIMG = new Intent(this, ImageUploading.class);
        Intent mediaPlay = new Intent(this, PlayerMUandVDO.class);
        Intent dataBase = new Intent(this, learningDataBases.class);
        Intent roomDataBase = new Intent(this, practiceRoomData.class);
        Intent noteii = new Intent(this, contentNtitle.class);

        binding.webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(splahsharepref);
            }
        });
        sens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(senses);
            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(servicess);
            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(alaarmm);
            }
        });
        binding.sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(sms);
            }
        });
        binding.imageupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iIMG);
            }
        });
        binding.noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti = new Intent(MainActivity.this, PracNotification.class);
                startActivity(noti);
            }
        });
        binding.media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mediaPlay);
            }
        });
        binding.dataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(dataBase);
            }
        });
        binding.roomDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(roomDataBase);
            }
        });
        binding.notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(noteii);
            }
        });
        binding.ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ads = new Intent(MainActivity.this, learningADs.class);
                startActivity(ads);
            }
        });




    }

}