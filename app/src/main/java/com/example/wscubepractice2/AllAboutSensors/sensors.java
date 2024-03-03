package com.example.wscubepractice2.AllAboutSensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wscubepractice2.R;

public class sensors extends AppCompatActivity {
    Button acclero,light,proxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        acclero = findViewById(R.id.accelerometer);
        light = findViewById(R.id.light);
        proxi = findViewById(R.id.proximity);

        Intent acc = new Intent(this,Accelerometer.class);
        Intent lightIntent = new Intent(this, Light.class);
        Intent proximeter = new Intent(this, Proximity.class);


        acclero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(acc);
            }
        });
        proxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(proximeter);
            }
        });
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(lightIntent);
            }
        });

    }
}