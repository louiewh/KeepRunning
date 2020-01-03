package com.louiewh.keeprunning.route;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.louiewh.keeprunning.util.LogWrapper;

@Interceptor(priority = 5)
public class ARouteIInterceptor implements IInterceptor {
    private final static String TAG = "ARoute";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        if (postcard.getPath().equals(RouteZhihu.ZHIHU_STORY_CONTENT)) {
            LogWrapper.e(TAG, "process:"+RouteZhihu.ZHIHU_STORY_CONTENT);
        }

        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        LogWrapper.e(TAG, "init");
    }
}
