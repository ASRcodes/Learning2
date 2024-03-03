package com.example.wscubepractice2.AllAboutNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityNotificationPracBinding;

public class PracNotification extends AppCompatActivity {
    ActivityNotificationPracBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityNotificationPracBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.normalNOti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent defaultnoti = new Intent(PracNotification.this, defaultNOTI.class);
                startActivity(defaultnoti);
            }
        });
        binding.customNOTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customnoti = new Intent(PracNotification.this, customNOTI.class);
                startActivity(customnoti);
            }
        });

    }
}