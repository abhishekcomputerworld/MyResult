package com.board.exams.myresult.add;

import android.app.Activity;
import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class Interstitial {
    private InterstitialAd interstitialAd;
  public void  load(Activity activity){
      IronSource.setInterstitialListener(new InterstitialListener() {
          @Override
          public void onInterstitialAdReady() {
              Log.d("IronSource_", "onInterstitialAdReady mainactivity "+String.valueOf(""));
              IronSource.showInterstitial("5861449");

          }

          @Override
          public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
              Log.d("IronSource_", "onInterstitialAdLoadFailed mainactivity "+String.valueOf(ironSourceError));
              if (Vungle.isInitialized()) {
                  Vungle.loadAd("INTERSTITIAL_1-1897893", new LoadAdCallback() {
                      @Override
                      public void onAdLoad(String id) {
                          AdConfig adConfig = new AdConfig();
                          adConfig.setAdOrientation(AdConfig.AUTO_ROTATE);
                          adConfig.setMuted(true);
                          Vungle.playAd("INTERSTITIAL_1-1897893", adConfig, new PlayAdCallback() {
                              @Override
                              public void onAdStart(String id) {
                                  Log.d("abhishek_ads", "Vungle mainactivity onAdStart");

                              }

                              @Override
                              public void onAdEnd(String id, boolean completed, boolean isCTAClicked) {
                                  Log.d("abhishek_ads", "Vungle mainactivity onAdEnd1");

                              }

                              @Override
                              public void onAdEnd(String id) {
                                  Log.d("abhishek_ads", "Vungle  onAdEnd2");
                              }

                              @Override
                              public void onAdClick(String id) {

                              }

                              @Override
                              public void onAdRewarded(String id) {
                                  Log.d("abhishek_ads", "Vungle  onAdRewarded");

                              }

                              @Override
                              public void onAdLeftApplication(String id) {

                              }

                              @Override
                              public void onError(String id, VungleException exception) {
                                  Log.d("abhishek_ads", "Vungle  onError");
                              }

                              @Override
                              public void onAdViewed(String id) {

                              }
                          });

                      }

                      @Override
                      public void onError(String id, VungleException exception) {
                          interstitialAd = new InterstitialAd(activity, "2675200819398732_2846268448958634");
                          loadAd();
                      }
                  });
              }
          }

          @Override
          public void onInterstitialAdOpened() {

          }

          @Override
          public void onInterstitialAdClosed() {
          }

          @Override
          public void onInterstitialAdShowSucceeded() {

          }

          @Override
          public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {

          }

          @Override
          public void onInterstitialAdClicked() {

          }
      });
      IronSource.init(activity, "10e786ebd", IronSource.AD_UNIT.INTERSTITIAL);
      IronSource.loadInterstitial();
    }

    public void loadAd() {
        interstitialAd.loadAd(interstitialAd.buildLoadAdConfig()
                .withAdListener(new InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {


                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {



                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        if(interstitialAd != null && interstitialAd.isAdLoaded()&&!interstitialAd.isAdInvalidated() ) {
                            interstitialAd.show();
                        }
                    }

                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {

                    }
                })
                .build());
    }

}
