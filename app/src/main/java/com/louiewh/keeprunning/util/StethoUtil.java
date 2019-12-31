package com.louiewh.keeprunning.util;

import android.content.Context;

import com.facebook.stetho.Stetho;

public class StethoUtil {


    static public void init(Context context){
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                        .build());
    }

}
