package com.ubx.usdk;

import android.content.Context;

public class USDKManager {

    private volatile static USDKManager mInstance;
    private static Context mContext;
    private ProfileManager mProfileMananger;


    public static enum FEATURE_TYPE {
        PROFILE,
        BARCODE,
        RFID,
        PSAM
    }

    public static enum STATUS {
        SUCCESS,
        NOT_SUPPORTED,
        NO_SERVICE,
        BINDING,
        DISCONNECT,
        UNKNOWN
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

    public static USDKBaseManager getInstance(Context context, FEATURE_TYPE featureType) {
        if(mInstance == null) {
            synchronized (USDKManager.class) {
                mInstance = new USDKManager(context);
            }
        }

        return mInstance.getUSDKManager(featureType);
    }

    public USDKBaseManager getUSDKManager(FEATURE_TYPE featureType) {
        switch (featureType) {
            case PROFILE:
                if (mProfileMananger == null) {
                    mProfileMananger = new ProfileManager(mContext);
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

    }

    public void release(FEATURE_TYPE featureType){
        switch (featureType) {
            case PROFILE:
                if (mProfileMananger == null) {
                    mProfileMananger = new ProfileManager(mContext);
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
