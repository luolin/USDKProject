package com.ubx.usdk.profile;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.IDeviceControlPolicy;

/**
 * @author lin.luo
 * @ClassName:
 * @Description: TODO
 * @date 2019.12.26
 * @Copyright ubx
 */
public class DeviceControlImpl extends IDeviceControlPolicy.Stub {
    @Override
    public String getDeviceId() throws RemoteException {
        return null;
    }

    @Override
    public void wipeData(boolean wipeTwoSystem, int flags) throws RemoteException {

    }

    @Override
    public void shutdown(boolean reboot) throws RemoteException {

    }

    @Override
    public Bundle getBatteryInfo() throws RemoteException {
        return null;
    }

    @Override
    public String getFlashId(int type) throws RemoteException {
        return null;
    }

    @Override
    public int setSplash(String Path) throws RemoteException {
        return 0;
    }

    @Override
    public int setSettingsXml(String Path) throws RemoteException {
        return 0;
    }

    @Override
    public int setCustomizeApp(String Path, String filename) throws RemoteException {
        return 0;
    }

    @Override
    public int setBootanimation(String Path) throws RemoteException {
        return 0;
    }

    @Override
    public int setBootanimationState(int state) throws RemoteException {
        return 0;
    }

    @Override
    public void setWallpaper(Bitmap bitmap, int which) throws RemoteException {

    }

    @Override
    public int changeUsbMode(int status) throws RemoteException {
        return 0;
    }

    @Override
    public int getUsbMode() throws RemoteException {
        return 0;
    }

    @Override
    public void setCurrentTime(long when) throws RemoteException {

    }
}
