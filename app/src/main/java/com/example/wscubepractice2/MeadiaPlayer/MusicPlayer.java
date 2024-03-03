package com.example.wscubepractice2.MeadiaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityMusicPlayerBinding;

import java.io.IOException;

public class MusicPlayer extends AppCompatActivity {

    ActivityMusicPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        MediaPlayer mediaPlayer = new MediaPlayer();

//        Now  we have to define the  streaming type of the media player because there are several types of media players alarm,ringtone,etc...
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

//        Now we'll set path of the audio file
        String path1 = "android.resource://"+getPackageName()+"/raw/adharam_madharam";

//        path for online music
//        String path2 = "put online music url here";

//        uri path2
//        Uri onlineAudio = Uri.parse(path2);
//        try {
//            mediaPlayer.setDataSource(this,onlineAudio);
//            mediaPlayer.prepareAsync();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        Now we'll set our path in URI
        Uri audioURI = Uri.parse(path1);
        try {
            mediaPlayer.setDataSource(this,audioURI);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        binding.play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        binding.pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        binding.reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                here directly don't stop the media player because it will cause null pointer if we'll
//                try to play it again.....because mp.stop() delete the reference of the mp
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });





        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });



    }
}