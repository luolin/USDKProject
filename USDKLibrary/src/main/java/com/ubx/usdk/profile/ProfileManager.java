package com.ubx.usdk.profile;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.USDKBaseManager;
import com.ubx.usdk.USDKManager;
import com.ubx.usdk.USDKManager.STATUS;
import com.ubx.usdk.USDKManager.FEATURE_TYPE;
import com.ubx.usdk.profile.aidl.IApplicationPolicy;
import com.ubx.usdk.profile.aidl.IProfileManager;

public class ProfileManager extends USDKBaseManager implements USDKManager.StatusListener {

    private IProfileManager mIProfileManager;

    private ApplicationManager mApplicationManager;

    public ProfileManager(Context context) {
        super(context, USDKManager.FEATURE_TYPE.PROFILE);
        Intent intent = new Intent();
        intent.setPackage("com.ubx.usdk.profile");
        intent.setAction("com.ubx.usdk.profileservice");
        setIntent(intent);
        addStatusListener(this);
    }

    @Override
    public void onStatus(FEATURE_TYPE featureType, STATUS status) {
        if(status == STATUS.SUCCESS) {
            mIProfileManager = IProfileManager.Stub.asInterface(getIBinder());
            LogUtil.d("onStatus mIProfileManager:"+mIProfileManager);
        } else {
            mIProfileManager = null;
        }
    }

    public IProfileManager getIProfileManager() {
        return mIProfileManager;
    }

    @Override
    public void release() {
        super.release();
        mIProfileManager = null;

        mApplicationManager = null;
    }

    public String getVersion() {
        if(mIProfileManager != null) {
            try {
                return mIProfileManager.getVersion();
            } catch (RemoteException | NullPointerException e) {
                LogUtil.e("getVersion", e);
            }
        }
        return "";
    }

    public ApplicationManager getApplicationManager(){
        if(mApplicationManager == null) {
            mApplicationManager = new ApplicationManager(this);
        }
        return mApplicationManager;
    }
}
