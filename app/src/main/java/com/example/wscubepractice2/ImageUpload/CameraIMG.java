package com.example.wscubepractice2.ImageUpload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wscubepractice2.R;

public class CameraIMG extends AppCompatActivity {
    static final int CAMERA_REQ_CODE = 100;
ImageView imageView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_img);
        imageView = findViewById(R.id.CameraIMGg);
        button = findViewById(R.id.setIMG);

//        NOw we'll fire default Camere app of phone on button's click......
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                Now we'll not normally just start the Activity we'll start the REsult activity because we are coming here with some result.
                startActivityForResult(iCamera,CAMERA_REQ_CODE);

            }
        });
//        A method to get result..
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode==RESULT_OK){
            if (requestCode==CAMERA_REQ_CODE){
//                to get the image data we need to use BItmap
                Bitmap img = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(img);
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}