package com.ubx.usdk.profile;

import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.IRestrictionPolicy;

/**
 * @author lin.luo
 * @ClassName:
 * @Description: TODO
 * @date 2019.12.26
 * @Copyright ubx
 */
public class RestrictionImpl extends IRestrictionPolicy.Stub {
    @Override
    public boolean setSettingProperty(String name, String value) throws RemoteException {
        return false;
    }

    @Override
    public String getSettingProperty(String name) throws RemoteException {
        return null;
    }

    @Override
    public int getRestrictionPolicy(int action) throws RemoteException {
        return 0;
    }

    @Override
    public int setRestrictionPolicy(int faction, int status) throws RemoteException {
        return 0;
    }

    @Override
    public void setUserRestriction(String key, boolean value) throws RemoteException {

    }

    @Override
    public boolean hasUserRestriction(String restrictionKey) throws RemoteException {
        return false;
    }

    @Override
    public void setKeyEventAllowed(int keycode, boolean allowed) throws RemoteException {

    }

    @Override
    public boolean isKeyEventAllowed(int keycode) throws RemoteException {
        return false;
    }

    @Override
    public void disableStatusBar(int what) throws RemoteException {

    }

    @Override
    public int getStatusBarFlags() throws RemoteException {
        return 0;
    }

    @Override
    public void setNTPServer(String urlServer) throws RemoteException {

    }

    @Override
    public String getNTPServer() throws RemoteException {
        return null;
    }
}
