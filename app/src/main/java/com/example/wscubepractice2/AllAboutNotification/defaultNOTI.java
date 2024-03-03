package com.example.wscubepractice2.AllAboutNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.wscubepractice2.R;

public class defaultNOTI extends AppCompatActivity {
    private static final String CHANNEL_ID = "100";
    private static final int NOTIFICATION_ID = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_noti);

        //        getting resource from drawable....
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.anubhav,null);
//        making the drawable resource bitmap
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//        getting the bitmaped IMG in variable..
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            Here this this above code is used to check if the version of Android in oreo or above then this notification channel is required other wise iska kaam nhi hai
            notification = new Notification.Builder(this)
                    //                here the large icon is set in Bitmap so we'll first create it...
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anubhav)
                    .setContentText("NEW MESSAGE")
                    .setSubText("Hello we are sending this new message to check that if its working or not")
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else {
            notification = new Notification.Builder(this)
                    // here the large icon is set in Bitmap so we'll first create it...
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anubhav)
                    .setContentText("NEW MESSAGE")
                    .setSubText("Hello we are sending this new message to check that if its working or not")
//                    this notification is for Android 4 or older so no notification channel is required....
                    .build();
        }
//        it will take a notification ID to create the instance of already sent message
        notificationManager.notify(NOTIFICATION_ID,notification);

    }
}