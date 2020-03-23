package com.ubx.usdk.profile;

import android.content.ComponentName;
import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.ISecurityPolicy;

/**
 * @author lin.luo
 * @ClassName:
 * @Description: TODO
 * @date 2019.12.26
 * @Copyright ubx
 */
public class SecurityImpl extends ISecurityPolicy.Stub {
    @Override
    public void saveLockPattern(String pattern) throws RemoteException {

    }

    @Override
    public void saveLockPassword(String password, int quality) throws RemoteException {

    }

    @Override
    public void clearLock() throws RemoteException {

    }

    @Override
    public void setForceLockScreen(boolean lock) throws RemoteException {

    }

    @Override
    public void setLockScreenDisabled(boolean disable) throws RemoteException {

    }

    @Override
    public boolean isLockScreenDisabled() throws RemoteException {
        return false;
    }

    @Override
    public void setDeviceOwner(ComponentName name) throws RemoteException {

    }

    @Override
    public boolean isDeviceOwner(String packageName) throws RemoteException {
        return false;
    }

    @Override
    public void cleanDeviceOwner(String packageName) throws RemoteException {

    }

    @Override
    public String getDeviceOwner() throws RemoteException {
        return null;
    }
}
