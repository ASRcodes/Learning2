package com.example.wscubepractice2.MeadiaPlayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.wscubepractice2.R;
import com.example.wscubepractice2.databinding.ActivityVideoPlayerBinding;

public class VideoPlayer extends AppCompatActivity {
    private static final String PLAYBACK_POSITION_KEY="playback_position";
    ActivityVideoPlayerBinding binding;
    private int playBackPosition = 0;
//    private int playbackPosition = 0;
//    private boolean isVideoPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        String vdopath = "android.resource://" + getPackageName() + "/raw/jamal";
        Uri videoURI = Uri.parse(vdopath);
        binding.videoplay.setVideoURI(videoURI);
//        binding.videoplay.start();


        MediaController mediaController = new MediaController(this);
        binding.videoplay.setMediaController(mediaController);
        mediaController.setAnchorView(binding.videoplay);

//        this code is to get the playBack position
        if (savedInstanceState != null) {
            playBackPosition = savedInstanceState.getInt(PLAYBACK_POSITION_KEY);
        }
//        binding.videoplay.setOnPreparedListener(mp -> {
//            if (savedInstanceState != null) {
//                playbackPosition = savedInstanceState.getInt("playbackPosition");
//                isVideoPlaying = savedInstanceState.getBoolean("isVideoPlaying");
//                if (isVideoPlaying) {
//                    binding.videoplay.seekTo(playbackPosition);
//                    binding.videoplay.start();
//                }
//            }
//        });
//        binding.videoplay.start();
//    }
//        if (savedInstanceState != null) {
//            playbackPosition = savedInstanceState.getInt("playbackPosition");
//            isVideoPlaying = savedInstanceState.getBoolean("isVideoPlaying");
//        }
//
//        binding.videoplay.setOnPreparedListener(mp -> {
//            if (isVideoPlaying) {
//                binding.videoplay.seekTo(playbackPosition);
//                binding.videoplay.start();
//            }
//        });
//
//        binding.videoplay.start();
    }

//    this code will take the playback position and seek from there and then start the video
    @Override
        protected void onStart() {
            super.onStart();
            binding.videoplay.seekTo(playBackPosition);
            binding.videoplay.start();
        }

    //    Add this code in menifest in your activity
//    android:configChanges="keyboardHidden|orientation|screenSize"
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PLAYBACK_POSITION_KEY, binding.videoplay.getCurrentPosition());
//        outState.putInt("playbackPosition", binding.videoplay.getCurrentPosition());
//        outState.putBoolean("isVideoPlaying", binding.videoplay.isPlaying());
    }

    //    This code is to set the landscape and potrait position and according to the orientation it will call the function
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape mode
            setFullScreen();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Portrait mode
            setOriginalScreen();
        }
    }

//    this function will set the video in landscape of the relative layout in fullScreen that is match parent both width and hight.
    private void setFullScreen() {
//        RelativeLayout.LayoutParams layoutParams =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                        RelativeLayout.LayoutParams.MATCH_PARENT);
//        binding.videoplay.setLayoutParams(layoutParams);
//        binding.videoplay.setPadding(0,0,0,0);
        ViewGroup.LayoutParams layoutParams = binding.videoplay.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        binding.videoplay.setLayoutParams(layoutParams);
        binding.videoplay.setPadding(0, 0, 0, 0);
    }

//    this for the default potrait screen.
    private void setOriginalScreen() {
//        RelativeLayout.LayoutParams layoutParams =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
//        binding.videoplay.setLayoutParams(layoutParams);
//        binding.videoplay.setPadding(0,0,0,0);
        ViewGroup.LayoutParams layoutParams = binding.videoplay.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        binding.videoplay.setLayoutParams(layoutParams);
        binding.videoplay.setPadding(0, 0, 0, 0);

    }
}