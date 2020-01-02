package com.louiewh.keeprunning;

import com.louiewh.keeprunning.util.ARouteUtil;
import com.louiewh.keeprunning.util.StethoUtil;
import com.louiewh.keeprunning.util.Util;

import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    private static App sInstance;
    public static App getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        Util.init(this);
        StethoUtil.init(this);
        ARouteUtil.init(this);
    }
}
