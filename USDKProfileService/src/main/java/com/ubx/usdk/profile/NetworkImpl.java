package com.ubx.usdk.profile;

import android.os.RemoteException;

import com.ubx.usdk.profile.aidl.INetworkPolicy;

import java.util.List;

/**
 * @author lin.luo
 * @ClassName:
 * @Description: TODO
 * @date 2019.12.26
 * @Copyright ubx
 */
public class NetworkImpl extends INetworkPolicy.Stub {
    @Override
    public boolean setDefaultWifi(String name, String password, int mode) throws RemoteException {
        return false;
    }

    @Override
    public void setWifiWhiteList(String ssid, int mode, int action) throws RemoteException {

    }

    @Override
    public List<String> getWifiWhiteList() throws RemoteException {
        return null;
    }

    @Override
    public boolean setHotpotInfo(String name, String password, int mode) throws RemoteException {
        return false;
    }

    @Override
    public void setAPN(String name, String apn, String proxy, String port, String user, String server, String password, String mmsc, String mcc, String mnc, String mmsproxy, String mmsport, int authtype, String type, String protocol, int bearer, String roamingprotocol, boolean current) throws RemoteException {

    }

    @Override
    public int deleteAPN(String where, String[] whereArgs) throws RemoteException {
        return 0;
    }

    @Override
    public String queryAPN(String selection, String[] selectionArgs) throws RemoteException {
        return null;
    }

    @Override
    public int getCurrentApn() throws RemoteException {
        return 0;
    }

    @Override
    public boolean setCurrentApn(int appid) throws RemoteException {
        return false;
    }

    @Override
    public void connectVPN(String name, int type, String server, String username, String password, String dnsServers, String searchDomains, String routes, boolean mppe, String l2tpSecret, String ipsecIdentifier, String ipsecSecret, String ipsecUserCert, String ipsecCaCert, String ipsecServerCert) throws RemoteException {

    }

    @Override
    public int getVpnState() throws RemoteException {
        return 0;
    }

    @Override
    public void disconnectVpn() throws RemoteException {

    }

    @Override
    public long getTrafficInfo(long startTime, long endTime, int type) throws RemoteException {
        return 0;
    }

    @Override
    public long getAppTrafficInfo(String packagename, int type) throws RemoteException {
        return 0;
    }

    @Override
    public void setFirewallUidChainRule(int uid, int networkType, boolean allow) throws RemoteException {

    }

    @Override
    public void clearFirewallChain(String chain) throws RemoteException {

    }

    @Override
    public void setBTWhiteList(String ssid, int mode, int action) throws RemoteException {

    }

    @Override
    public List<String> getBTWhiteList() throws RemoteException {
        return null;
    }
}
