package com.louiewh.keeprunning.zhihu;

import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.louiewh.keeprunning.model.content.StoryActivity;

public class RouteZhihu {

    final static public String ZHIHU_STORY_CONTENT = "/ZhiHu/storyContent";

    public static void startActivityForStory( int id) {
        ARouter.getInstance().build(ZHIHU_STORY_CONTENT)
                .withInt(StoryActivity.STORY_ID, id)
                .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .navigation();
    }
}
