package com.jinzhong.jiguangdemo;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by ${sheldon} on 2018/6/11.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
    //    String  IF=JPushInterface.getRegistrationID(this);
        JPushInterface.init(this);
       // JPushInterface.resumePush(this);
     //   boolean isStop = JPushInterface.isPushStopped(this);
    }
}
