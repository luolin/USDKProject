// IDeviceControlPolicy.aidl
package com.ubx.usdk.profile.aidl;

// Declare any non-default types here with import statements

interface IDeviceControlPolicy {

        String getDeviceId();
        void wipeData(boolean wipeTwoSystem, int flags);
        void shutdown(boolean reboot);
        Bundle getBatteryInfo();

        String getFlashId(int type);

        int setSplash(String Path);
        int setSettingsXml(String Path);
        int setCustomizeApp(String Path,String filename);
        int setBootanimation(String Path);
        int setBootanimationState(int state);

        void setWallpaper(in Bitmap bitmap, int which);
        int changeUsbMode(int status);
        int getUsbMode();

        void setCurrentTime(long when);
}
