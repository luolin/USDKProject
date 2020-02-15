package com.ubx.usdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.ubx.usdk.USDKManager.FEATURE_TYPE;
import com.ubx.usdk.USDKManager.STATUS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.ubx.usdk.LogUtil.LOGE;

public class USDKBaseManager implements ServiceConnection{
    private Context mContext;
    private FEATURE_TYPE mFeatureType;
    private Intent mServiceIntent;
    private IBinder mIBinder;
    private STATUS mStatus = STATUS.UNKNOWN;

    protected USDKBaseManager(){
    }

    protected USDKBaseManager(Context context, FEATURE_TYPE featureType) {
        mContext = context;
        mFeatureType = featureType;
    }

    protected void setIntent(Intent intent){
        mServiceIntent = intent;
    }

    protected IBinder getIBinder(){
        return mIBinder;
    }

    protected void setType(FEATURE_TYPE featureType) {
        mFeatureType = featureType;
    }

    public FEATURE_TYPE getType() {
        return mFeatureType;
    }

    protected void setStatus(STATUS status){
        mStatus = status;
    }

    public STATUS getStatus(){
        return  mStatus;
    }

    public void init(){
        if(mStatus != STATUS.SUCCESS || mStatus != STATUS.BINDING) {
            boolean status = mContext.bindService(mServiceIntent, this, Context.BIND_AUTO_CREATE);
            if(status) {
                mStatus = STATUS.BINDING;
            } else {
                mStatus = STATUS.NO_SERVICE;
            }
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogUtil.d("onServiceConnected: "+ name.toShortString());
        mIBinder = service;
        mStatus = STATUS.SUCCESS;
        try {
            service.linkToDeath(mDeathHandle, 0);
        }catch (RemoteException e) {
            LogUtil.e("linkToDeath RemoteException");
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        LogUtil.d("onServiceDisconnected: "+ name.toShortString());
        mStatus = STATUS.DISCONNECT;
    }

    @Override
    public void onBindingDied(ComponentName name) {
        LogUtil.d("onBindingDied: "+ name.toShortString());
        mStatus = STATUS.DISCONNECT;
        init();
    }

    @Override
    public void onNullBinding(ComponentName name) {
        LogUtil.d("onNullBinding: "+ name.toShortString());
        mStatus = STATUS.DISCONNECT;
    }

    final IBinder.DeathRecipient mDeathHandle = new IBinder.DeathRecipient() {

        @Override
        public void binderDied() {
            // TODO Auto-generated method stub
            if(mIBinder != null) {
                mIBinder.unlinkToDeath(mDeathHandle, 0);
            }
            LogUtil.e("DeathRecipient binderDied");
            init();
        }
    };
}
