package com.example.wscubepractice2.ImageUpload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wscubepractice2.R;

public class ImageUploading extends AppCompatActivity {
Button camera,gall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_uploading);
        camera = findViewById(R.id.camer);
        gall = findViewById(R.id.gallery);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icam = new Intent(ImageUploading.this, CameraIMG.class);
                startActivity(icam);
            }
        });
        gall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(ImageUploading.this, GalleryIMG.class);
                startActivity(iGallery);
            }
        });
    }
}