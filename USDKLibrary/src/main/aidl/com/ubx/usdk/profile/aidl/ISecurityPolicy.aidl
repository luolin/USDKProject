// ISecurityPolicy.aidl
package com.ubx.usdk.profile.aidl;

// Declare any non-default types here with import statements

interface ISecurityPolicy {
        void saveLockPattern(String pattern);
        void saveLockPassword(String password, int quality);
        void clearLock();
        void setForceLockScreen(boolean lock);
        void setLockScreenDisabled(boolean disable);
        boolean isLockScreenDisabled();

        void setDeviceOwner(inout ComponentName name);
        boolean isDeviceOwner(String  packageName);
        void cleanDeviceOwner(String  packageName);
        String getDeviceOwner();
}
