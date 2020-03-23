package com.ubx.usdk.profile;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.RemoteException;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.profile.aidl.IProfileManager;

public class USDKProfileService extends Service {
    private ProfileManagerStub mProfileManagerStub;

    private ApplicationImpl mApplicationImpl;

    private DeviceControlImpl mDeviceControlImpl;

    private NetworkImpl mNetworkImpl;

    private RestrictionImpl mRestrictionImpl;

    private SecurityImpl mSecurityImpl;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        LogUtil.d("USDKProfileService:onBind");
        if(mProfileManagerStub == null) {
            mProfileManagerStub = new ProfileManagerStub();
        }
        return mProfileManagerStub;
    }

    final public class ProfileManagerStub extends IProfileManager.Stub {
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
        public IBinder getApplicationIBinder() throws RemoteException {
            if(mApplicationImpl == null) {
                mApplicationImpl = new ApplicationImpl();
            }
            return mApplicationImpl;
        }

        @Override
        public IBinder getDeviceControlIBinder() throws RemoteException {
            if(mDeviceControlImpl == null) {
                mDeviceControlImpl = new DeviceControlImpl();
            }
            return mDeviceControlImpl;
        }

        @Override
        public IBinder getNetworkPolicyIBinder() throws RemoteException {
            if(mNetworkImpl == null) {
                mNetworkImpl = new NetworkImpl();
            }
            return mNetworkImpl;
        }

        @Override
        public IBinder getRestrictionIBinder() throws RemoteException {
            if(mRestrictionImpl == null) {
                mRestrictionImpl = new RestrictionImpl();
            }
            return mRestrictionImpl;
        }

        @Override
        public IBinder getSecurityPolicyIBinder() throws RemoteException {
            if(mSecurityImpl == null) {
                mSecurityImpl = new SecurityImpl();
            }
            return mSecurityImpl;
        }
    }
}
