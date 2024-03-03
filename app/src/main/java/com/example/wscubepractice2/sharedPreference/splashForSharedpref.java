package com.example.wscubepractice2.sharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.wscubepractice2.R;

public class splashForSharedpref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_for_sharedpref);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
//                here we are mode the mode as private but if we have to pass this preference we'll do it in diff mode.
                Boolean check = sharedPreferences.getBoolean("flag",false);
                Intent inext;
                if (check) {
                     inext = new Intent(splashForSharedpref.this, sharedPref.class);
                }
                else {
                    inext = new Intent(splashForSharedpref.this, sharedLogin.class);
                }
                startActivity(inext);
                finish();
            }
        },2000);
    }
}