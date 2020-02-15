package com.ubx.usdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.IProfileManager;

public class ProfileManager extends USDKBaseManager {
    private IProfileManager mIProfileManager;

    public ProfileManager(Context context) {
        super(context, USDKManager.FEATURE_TYPE.PROFILE);
        Intent intent = new Intent();
        intent.setPackage("com.ubx.usdk.profile");
        intent.setAction("com.ubx.usdk.profileservice");
        setIntent(intent);
        init();
    }

    private IProfileManager getService() {
        if(mIProfileManager == null) {
            mIProfileManager = IProfileManager.Stub.asInterface(getIBinder());
        }
        return mIProfileManager;
    }

    public String getVersion() {
        try {
            return getService().getVersion();
        } catch (RemoteException e) {

        }
        return "";
    }
}
