package com.louiewh.keeprunning.retrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.louiewh.keeprunning.api.ApiZhihu;
import com.louiewh.keeprunning.util.LogWrapper;
import com.louiewh.keeprunning.util.Util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    static ApiZhihu sApiZhihu;

    synchronized static public ApiZhihu getZhihuService(){

        if(sApiZhihu == null){
            sApiZhihu = createApiZhihu();
        }

        return sApiZhihu;
    }


    private static ApiZhihu createApiZhihu(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> {
            LogWrapper.dWithoutline("OKHttp-----", message);
        });

        if (Util.isDebug()) {
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        }

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())   //添加Stetho的拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiZhihu.ZHIHU_DAILY_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiZhihu service = retrofit.create(ApiZhihu.class);

        return service;
    }

}
