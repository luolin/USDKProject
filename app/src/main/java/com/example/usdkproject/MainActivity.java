package com.example.usdkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.profile.ProfileManager;
import com.ubx.usdk.USDKManager;

public class MainActivity extends AppCompatActivity {

    ProfileManager profileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.text_view);


        final USDKManager usdkManager = USDKManager.getInstance(getApplicationContext());
        Log.d("luolin", "getFeatureManagerAsync:");
        profileManager = (ProfileManager) usdkManager.getFeatureManagerAsync(USDKManager.FEATURE_TYPE.PROFILE, new USDKManager.StatusListener() {
            @Override
            public void onStatus(USDKManager.FEATURE_TYPE featureType, USDKManager.STATUS status) {
                Log.d("luolin", "StatusListener:" + status);
                if(status == USDKManager.STATUS.SUCCESS && profileManager != null) {
                    Log.d("luolin", "getVersion:" + profileManager.getVersion());
                    tv.append("\n");
                    Log.d("luolin","getDeviceId:" + profileManager.getDeviceId());
                }
            }
        });

        new Thread() {
            @Override
            public void run() {
                while(profileManager.getStatus() != USDKManager.STATUS.SUCCESS){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if(profileManager.getStatus() == USDKManager.STATUS.SUCCESS) {
                    LogUtil.d("getFeatureType:" + profileManager.getFeatureType());
                    LogUtil.d("getStatus:" + profileManager.getStatus());
                    LogUtil.d("getVersion:" + profileManager.getVersion());
                    LogUtil.d("getDeviceId:" + profileManager.getDeviceId());

//                   profileManager.release();
                }
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(profileManager !=null) {
            profileManager.release();
        }
    }
}
