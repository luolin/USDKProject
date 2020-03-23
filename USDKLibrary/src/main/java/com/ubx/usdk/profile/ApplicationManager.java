package com.ubx.usdk.profile;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.ubx.usdk.LogUtil;
import com.ubx.usdk.profile.aidl.IApplicationPolicy;

import java.util.List;

/**
 * @author lin.luo
 * @ClassName:
 * @Description: TODO
 * @date 2019.12.26
 * @Copyright ubx
 */
public class ApplicationManager {

    private ProfileManager mProfileManager;
    private IApplicationPolicy mIApplicationPolicy;

    protected ApplicationManager(ProfileManager profileManager) {
        this.mProfileManager = profileManager;
    }

    private IApplicationPolicy getService() throws RemoteException,NullPointerException{
        if(mIApplicationPolicy == null) {
            mIApplicationPolicy = IApplicationPolicy.Stub.asInterface(mProfileManager.getIProfileManager().getApplicationIBinder());
        }
        return mIApplicationPolicy;
    }


    public boolean setDefaultLauncher(ComponentName componentName) {
        try {
            return getService().setDefaultLauncher(componentName);
        } catch (RemoteException | NullPointerException e) {
            LogUtil.e("setDefaultLauncher", e);
        }
        return false;
    }

    public boolean removeDefaultLauncher(String packageName) throws RemoteException {
        return false;
    }

    public boolean grantRuntimePermission(String packageName, String permName) throws RemoteException {
        return false;
    }

    public boolean revokeRuntimePermission(String packageName, String permName) throws RemoteException {
        return false;
    }

    public void setOpsUidMode(int code, int uid, int mode) throws RemoteException {

    }

    public double getAppPowerUsage(String packagename) throws RemoteException {
        return 0;
    }

    public double getAllAppsPowerUsage() throws RemoteException {
        return 0;
    }

    public Bundle getPowerUsage() throws RemoteException {
        return null;
    }

    public void setPackageInstaller(String packageName, int action) throws RemoteException {

    }

    public List<String> getPackageInstaller() throws RemoteException {
        return null;
    }

    public void setAutoRunningApp(ComponentName componentName, int action) throws RemoteException {

    }

    public List<String> getAutoRunningApp() throws RemoteException {
        return null;
    }

    public void setHideApplicationIcon(String packageName, int action) throws RemoteException {

    }

    public List<String> getHideApplicationIcon() throws RemoteException {
        return null;
    }

    public boolean getApplicationEnabledSetting(String packageName) throws RemoteException {
        return false;
    }

    public void setApplicationEnabledSetting(String packageName, boolean enable) throws RemoteException {

    }

    public void setAllowInstallApps(int type, String packageName, int mode, int action) throws RemoteException {

    }

    public List<String> getAllowInstallApps(int type, int mode) throws RemoteException {
        return null;
    }

    public boolean forceStopPackage(String packageName) throws RemoteException {
        return false;
    }

    public boolean removeTask(int taskid) throws RemoteException {
        return false;
    }

    public void setLockTaskMode(String packageName, boolean enable) throws RemoteException {

    }
}
