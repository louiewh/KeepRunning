package com.louiewh.keeprunning.route;

import android.content.Intent;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.louiewh.keeprunning.App;
import com.louiewh.keeprunning.model.content.StoryActivity;
import com.louiewh.keeprunning.util.LogWrapper;

public class RouteZhihu {
    final static private String TAG = "RouteZhihu";

    final static public String ZHIHU_STORY_CONTENT = "/ZhiHu/storyContent";

    public static void startActivityForStory( int id) {
        ARouter.getInstance().build(ZHIHU_STORY_CONTENT)
                .withInt(StoryActivity.STORY_ID, id)
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation(App.getInstance(), new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        LogWrapper.dWithoutline(TAG, "onFound");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        LogWrapper.dWithoutline(TAG, "onLost");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        LogWrapper.dWithoutline(TAG, "onArrival");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        LogWrapper.dWithoutline(TAG, "onInterrupt");
                    }
                });
    }
}
