package com.example.wscubepractice2.MessageReceivingNsending;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityMessagingBinding;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.security.Permission;

public class Yomessaging extends AppCompatActivity {
ActivityMessagingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMessagingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Dexter.withContext(this)
                .withPermission(Manifest.permission.READ_SMS)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        if (permissionGrantedResponse==null){
                            Toast.makeText(Yomessaging.this, "Permission granted", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
        Dexter.withContext(this)
                .withPermission(Manifest.permission.SEND_SMS)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        // Permission granted, you can now send SMS
                        // Your SMS sending code goes here
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        // Permission denied
                        Toast.makeText(Yomessaging.this, "SEND_SMS permission denied", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        // Show a rationale message if needed
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();

//            Now we are going to code for Sending Messages.......
//            From that we'll take EditText and a Button in our UI to do this work..
                binding.sendMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(binding.phoneNo.getText().toString(),null,binding.message.getText().toString(),null,null);
                        Toast.makeText(Yomessaging.this, "Message sent Successfully", Toast.LENGTH_SHORT).show();

                        binding.message.setText("");
                        binding.phoneNo.setText("+91");
                    }
                });

    }
}