package com.ubx.usdk.profile;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.profile.aidl.IProfileManager;

public class USDKProfileService extends Service {
    public USDKProfileService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        LogUtil.d("USDKProfileService:onBind");
        return new ProfileStub();
    }

    final public class ProfileStub extends IProfileManager.Stub {
        @Override
        public String getVersion() throws RemoteException {
            PackageManager packageManager = getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        getPackageName(), 0);
                return packageInfo.versionName;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        public String getDeviceId() throws RemoteException {
            return Build.ID;
        }
    }
}
