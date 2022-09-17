package com.board.exams.myresult.fication;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;
import com.google.firebase.database.FirebaseDatabase;
import com.vungle.warren.InitCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;


public class save extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AudienceNetworkAds.initialize(this);
        Vungle.init("60fa3b770c30827f6301edf3", getApplicationContext(), new InitCallback() {
            @Override
            public void onSuccess() {
                // SDK has successfully initialized
            }

            @Override
            public void onError(VungleException exception) {
                // SDK has failed to initialize
            }

            @Override
            public void onAutoCacheAdAvailable(String placementId) {
                // Ad has become available to play for a cache optimized placement
            }
        });
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }

}
