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

public class Accelerometer extends AppCompatActivity implements SensorEventListener{
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        textView = findViewById(R.id.accText);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null){
            Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//            Now we'll register the sensor with a SensorEvent Listener
//            first check if the sensor is working or not
            if (accelerometer != null){
                sensorManager.registerListener((SensorEventListener) this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
            }
            else {
                Toast.makeText(this, "Accelerometer is not available", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            textView.setText("X: "+event.values[0]+", Y: "+event.values[1]+", Z: "+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}