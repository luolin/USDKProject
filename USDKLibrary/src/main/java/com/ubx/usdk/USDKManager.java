package com.ubx.usdk;

import android.content.Context;

import com.ubx.usdk.profile.ProfileManager;

public class USDKManager {

    private volatile static USDKManager mInstance;
    private static Context mContext;
    private com.ubx.usdk.profile.ProfileManager mProfileMananger;


    public static enum FEATURE_TYPE {
        PROFILE,
        BARCODE,
        RFID,
        PSAM
    }

    public static enum STATUS {
        NOT_SUPPORTED,
        NO_SERVICE,
        NOT_READY,
        SUCCESS,
        RELEASE,
        NOT_ALIVE,
        UNKNOWN
    }

    public interface StatusListener {
        void onStatus(USDKManager.FEATURE_TYPE featureType, STATUS status);
    }

    private USDKManager(Context context){
        mContext = context.getApplicationContext();
    }

    public static USDKManager getInstance(Context context) {
        if(mInstance == null) {
            synchronized (USDKManager.class) {
                mInstance = new USDKManager(context);
            }
        }
        return mInstance;
    }

    public static USDKBaseManager getFeatureManager(Context context, FEATURE_TYPE featureType) {
        if(mInstance == null) {
            synchronized (USDKManager.class) {
                mInstance = new USDKManager(context);
            }
        }

        return mInstance.getFeatureManager(featureType);
    }

    public USDKBaseManager getFeatureManagerAsync(USDKManager.FEATURE_TYPE featureType, USDKManager.StatusListener statusListener) {
        switch (featureType) {
            case PROFILE:
                if (mProfileMananger == null || mProfileMananger.getStatus() == STATUS.RELEASE) {
                    mProfileMananger = new ProfileManager(mContext);
                    mProfileMananger.addStatusListener(statusListener);
                    mProfileMananger.initialize();
                }else {
                    if(statusListener != null) {
                        mProfileMananger.addStatusListener(statusListener);
                        mProfileMananger.initialize();
                    }
                }
                return mProfileMananger;
            case BARCODE:

                ;
            case RFID:

                ;
            case PSAM:

                ;
            default:
                return new USDKBaseManager();
        }
    }

    public USDKBaseManager getFeatureManager(FEATURE_TYPE featureType) {
        switch (featureType) {
            case PROFILE:
                if (mProfileMananger == null) {
                    mProfileMananger = new ProfileManager(mContext);
                    mProfileMananger.initialize();
                }
                return mProfileMananger;
            case BARCODE:

                ;
            case RFID:

                ;
            case PSAM:

                ;
            default:
                return new USDKBaseManager();
        }
    }

    public void release() {
        if (mProfileMananger != null) {
            mProfileMananger.release();
            mProfileMananger = null;
        }

    }

    public void release(FEATURE_TYPE featureType){
        switch (featureType) {
            case PROFILE:
                if (mProfileMananger != null) {
                    mProfileMananger.release();
                    mProfileMananger = null;
                }
            case BARCODE:

                ;
            case RFID:

                ;
            case PSAM:

                ;
            default:

        }
    }
}
