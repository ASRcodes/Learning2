package com.example.wscubepractice2.AllAboutNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.wscubepractice2.R;

public class customNOTI extends AppCompatActivity {
    private static final String CHANNEL_ID = "100";
    private static final int NOTIFICATION_ID = 200;
//    In our app we'll throw notification for  different works for that we have to define REQ_CODE
    private static final int REQ_CODE = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_noti);

        //        getting resource from drawable....
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.anubhav,null);
//        making the drawable resource bitmap
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//        getting the bitmaped IMG in variable..
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
//        We'll create a pending intent here which will open when user will click on the notification.
        Intent iNotify = new Intent(getApplicationContext(), customNOTI.class);
//        If App is already opened and then there a notification comes for that we'll have this fag
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,REQ_CODE,iNotify,PendingIntent.FLAG_MUTABLE);



//        Here we'll set a big picture to show in our notification.......
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(largeIcon)
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Hello How are you are you Enjoying the ANDROID development journey")
                .setSummaryText("hehehehehhehehehehehehe");

//        we'll create an inbox jiske ander bada message rahega........
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("Anubhav")
                .addLine("Hoon")
                .addLine("main")
                .addLine("yo heheheheheh")
                .addLine("Anubhav")
                .addLine("Hoon")
                .addLine("main")
                .addLine("yo heheheheheh")
                .setBigContentTitle("Hi this is Anubhav")
                .setSummaryText("I am 18 yrs OLD right now");



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            Here this this above code is used to check if the version of Android in oreo or above then this notification channel is required other wise iska kaam nhi hai
            notification = new Notification.Builder(this)
                    //                here the large icon is set in Bitmap so we'll first create it...
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anubhav)
                    .setContentText("NEW MESSAGE")
                    .setSubText("Hello we are sending this new message to check that if its working or not")
                    .setContentIntent(pendingIntent)
                    .setChannelId(CHANNEL_ID)
                    .setStyle(bigPictureStyle)
//                    This Line is used to cancel the notification once clicked if its true
                    .setAutoCancel(true)
                    //This code is for that our notification will not be cancelled on slide true kardoge to ho jayega
                    .setOngoing(false)
                    .setStyle(inboxStyle)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel
                    (CHANNEL_ID,"New channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else {
            notification = new Notification.Builder(this)
                    // here the large icon is set in Bitmap so we'll first create it...
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anubhav)
                    .setContentText("NEW MESSAGE")
                    .setSubText("Hello we are sending this new message to check that if its working or not")
                    .setContentIntent(pendingIntent)
                    // This Line is used to cancel the notification once clicked if its true
                    .setAutoCancel(true)
                    //This code is for that our notification will not be cancelled on slide true kardoge to ho jayega
                    .setOngoing(false)
                    .setStyle(bigPictureStyle)
//                    this notification is for Android 4 or older so no notification channel is required....
                    .build();
        }
//        it will take a notification ID to create the instance of already sent message
        notificationManager.notify(NOTIFICATION_ID,notification);


    }
}