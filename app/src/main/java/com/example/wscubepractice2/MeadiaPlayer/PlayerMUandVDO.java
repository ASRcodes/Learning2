package com.example.wscubepractice2.MeadiaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityPlayerMuandVdoBinding;

public class PlayerMUandVDO extends AppCompatActivity {
    ActivityPlayerMuandVdoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityPlayerMuandVdoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent music = new Intent(this, MusicPlayer.class);
        Intent video = new Intent(this, VideoPlayer.class);

        binding.music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(music);
            }
        });
        binding.video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(video);
            }
        });



    }
}