package com.ubx.usdk.profile;

import android.content.ComponentName;
import android.os.Bundle;
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
public class ApplicationImpl extends IApplicationPolicy.Stub {

    public ApplicationImpl() {

    }

    @Override
    public boolean setDefaultLauncher(ComponentName componentName) throws RemoteException {
        LogUtil.d("setDefaultLauncher------------------------------:");
        return false;
    }

    @Override
    public boolean removeDefaultLauncher(String packageName) throws RemoteException {
        return false;
    }

    @Override
    public boolean grantRuntimePermission(String packageName, String permName) throws RemoteException {
        return false;
    }

    @Override
    public boolean revokeRuntimePermission(String packageName, String permName) throws RemoteException {
        return false;
    }

    @Override
    public void setOpsUidMode(int code, int uid, int mode) throws RemoteException {

    }

    @Override
    public double getAppPowerUsage(String packagename) throws RemoteException {
        return 0;
    }

    @Override
    public double getAllAppsPowerUsage() throws RemoteException {
        return 0;
    }

    @Override
    public Bundle getPowerUsage() throws RemoteException {
        return null;
    }

    @Override
    public void setPackageInstaller(String packageName, int action) throws RemoteException {

    }

    @Override
    public List<String> getPackageInstaller() throws RemoteException {
        return null;
    }

    @Override
    public void setAutoRunningApp(ComponentName componentName, int action) throws RemoteException {

    }

    @Override
    public List<String> getAutoRunningApp() throws RemoteException {
        return null;
    }

    @Override
    public void setHideApplicationIcon(String packageName, int action) throws RemoteException {

    }

    @Override
    public List<String> getHideApplicationIcon() throws RemoteException {
        return null;
    }

    @Override
    public boolean getApplicationEnabledSetting(String packageName) throws RemoteException {
        return false;
    }

    @Override
    public void setApplicationEnabledSetting(String packageName, boolean enable) throws RemoteException {

    }

    @Override
    public void setAllowInstallApps(int type, String packageName, int mode, int action) throws RemoteException {

    }

    @Override
    public List<String> getAllowInstallApps(int type, int mode) throws RemoteException {
        return null;
    }

    @Override
    public boolean forceStopPackage(String packageName) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeTask(int taskid) throws RemoteException {
        return false;
    }

    @Override
    public void setLockTaskMode(String packageName, boolean enable) throws RemoteException {

    }
}
