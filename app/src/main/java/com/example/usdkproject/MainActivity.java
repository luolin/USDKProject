package com.example.usdkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.symbol.emdk.EMDKBase;
import com.symbol.emdk.EMDKManager;
import com.ubx.usdk.LogUtil;
import com.ubx.usdk.ProfileManager;
import com.ubx.usdk.USDKManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("luolin", "testadfasdfasdf");

        ProfileManager usdkManager = (ProfileManager)USDKManager.getInstance(this, USDKManager.FEATURE_TYPE.PROFILE);

        try {
            Thread.sleep(100);
            LogUtil.d(usdkManager.getStatus() +"");
            if(usdkManager.getStatus() == USDKManager.STATUS.SUCCESS) {
                LogUtil.d(usdkManager.getVersion() +"");
            }
        }catch (Exception e) {

        }


    }
}
