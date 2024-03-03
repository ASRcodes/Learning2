package com.example.wscubepractice2.AllAboutSensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wscubepractice2.R;

public class Proximity extends AppCompatActivity implements SensorEventListener {
TextView proxy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        proxy = findViewById(R.id.proxy);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null){
            Sensor proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proximity != null){
                sensorManager.registerListener((SensorEventListener) this,proximity,sensorManager.SENSOR_DELAY_NORMAL);
            }
            else {
                Toast.makeText(this, "Error no sensor found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_PROXIMITY){
            proxy.setText("Value = "+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}