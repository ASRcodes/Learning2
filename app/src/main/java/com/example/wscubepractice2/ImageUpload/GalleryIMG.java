package com.example.wscubepractice2.ImageUpload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wscubepractice2.R;

public class GalleryIMG extends AppCompatActivity {
    static final int GALLERY_REQ_CODE =101;
ImageView imageView;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_img);
        button = findViewById(R.id.setIMG);
        imageView = findViewById(R.id.GalleryIMGg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode==RESULT_OK){
            if (requestCode==GALLERY_REQ_CODE){
                imageView.setImageURI(data.getData());
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}