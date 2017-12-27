package com.yunhua.maproject;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by yunhua on 2017/12/27.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        SDKInitializer.initialize(getApplicationContext());
    }
}
