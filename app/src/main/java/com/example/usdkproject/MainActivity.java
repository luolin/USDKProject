package com.example.usdkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.profile.ProfileManager;
import com.ubx.usdk.USDKManager;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ProfileManager profileManager;
    TextView mTv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.text_view);
        mTv_data = findViewById(R.id.textViewData);


        final USDKManager usdkManager = USDKManager.getInstance(getApplicationContext());
        Log.d("luolin", "getFeatureManagerAsync:");
        profileManager = (ProfileManager) usdkManager.getFeatureManagerAsync(USDKManager.FEATURE_TYPE.PROFILE, new USDKManager.StatusListener() {
            @Override
            public void onStatus(USDKManager.FEATURE_TYPE featureType, final USDKManager.STATUS status) {
                Log.d("luolin", "StatusListener:" + status);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(status.toString());
                    }
                });

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(profileManager != null) {
            profileManager.release();
        }
    }

    public void onClick(View v) {
        if(profileManager != null && profileManager.getStatus() == USDKManager.STATUS.SUCCESS) {
            mTv_data.append("getVersion:" + profileManager.getVersion());
            mTv_data.append("\n");
            mTv_data.append("getDeviceId:" + profileManager.getDeviceId());
            mTv_data.append("\n");
        }
    }
}
