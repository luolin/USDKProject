// INetworkPolicy.aidl
package com.ubx.usdk.profile.aidl;

// Declare any non-default types here with import statements

interface INetworkPolicy {

        boolean setDefaultWifi(String name,String password,int mode);
        void setWifiWhiteList(String ssid,int mode,int action);
        List<String> getWifiWhiteList();
        boolean setHotpotInfo(String name,String password,int mode);
        void setAPN(String name, String apn, String proxy, String port, String user,
                String server, String password, String mmsc, String mcc, String mnc, String mmsproxy,
                String mmsport, int authtype, String type, String protocol, int bearer, String roamingprotocol, boolean current);
        int deleteAPN(String where, in String[] whereArgs);
        String queryAPN(String selection, in String[] selectionArgs);
        int getCurrentApn();
        boolean setCurrentApn(int appid);

        void connectVPN(String name, int type, String server, String username
                , String password, String dnsServers, String searchDomains, String routes, boolean mppe
                , String l2tpSecret, String ipsecIdentifier, String ipsecSecret, String ipsecUserCert
                , String ipsecCaCert, String ipsecServerCert);

        int getVpnState();
        void disconnectVpn();

        long getTrafficInfo(long startTime, long endTime, int type);
        long getAppTrafficInfo(String packagename, int type);

        void setFirewallUidChainRule(int uid, int networkType, boolean allow);
        void clearFirewallChain(String chain);

        void setBTWhiteList(String ssid,int mode,int action);
        List<String> getBTWhiteList();
}
