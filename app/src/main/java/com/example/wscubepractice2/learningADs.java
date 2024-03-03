package com.example.wscubepractice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.wscubepractice2.databinding.ActivityLearningAdsBinding;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class learningADs extends AppCompatActivity {
    ActivityLearningAdsBinding binding;
    InterstitialAd minterstitialAd;
    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityLearningAdsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


//        initializing the MobileAd over our app
            MobileAds.initialize(this);

//            adding unit_id
//        binding.bannerAds.setAdUnitId("ca-app-pub-3951957290391672/1819925078");

//        adding the adSize as BANNER
//        binding.bannerAds.setAdSize(AdSize.BANNER);

//        getting the ad reQuests
            adRequest = new AdRequest.Builder().build();

//        Loading ad over the set-uped ui in xml
        binding.bannerAds.loadAd(adRequest);

        binding.bannerAds.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.e("BannerAdFAILED",loadAdError.getMessage());
            }
        });


//        Code to integrate interstitial Ads

        InterstitialAd.load(this, getString(R.string.inter_ad_unit_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
//                if failed to load ads then will get error from Log.e
                Log.e("Error",loadAdError.toString());
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);

                minterstitialAd = interstitialAd;
                minterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                        super.onAdFailedToShowFullScreenContent(adError);
                    }

                    @Override
                    public void onAdImpression() {
                        super.onAdImpression();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent();
                        minterstitialAd=null;
                    }
                });
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (minterstitialAd!=null) {
                    minterstitialAd.show(learningADs.this);
                }
                else {
                    Log.e("Adpending","Ad is not loaded");
            }
        }
    },10000);

    }
}