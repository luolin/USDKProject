package com.ubx.usdk.profile;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.IProfileManager;

public class USDKProfileService extends Service {
    public USDKProfileService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new ProfileStub();
    }

    final public class ProfileStub extends IProfileManager.Stub {
        @Override
        public String getVersion() throws RemoteException {
            return "gawegasdf";
        }
    }
}
