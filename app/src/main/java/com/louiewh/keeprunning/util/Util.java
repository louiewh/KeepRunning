package com.louiewh.keeprunning.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

/**
 * Created by louie.wang on 2017/12/28.
 */

public class Util {
    private final static String TAG = "Util";
    private static Context mContext;

    public static void init(Context context){
        mContext = context;
    }

    public static boolean isDebug() {
        try {
            ApplicationInfo info= mContext.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) !=0;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return false;
    }
}
