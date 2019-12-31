package com.louiewh.keeprunning.api;

import com.louiewh.keeprunning.data.DailyStory;
import com.louiewh.keeprunning.data.HotStory;
import com.louiewh.keeprunning.data.Lastest;
import com.louiewh.keeprunning.data.StoryContent;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;


/*
* https://blog.csdn.net/fanpeihua123/article/details/51210499
*
* */
public interface ApiZhihu {

    String  ZHIHU_DAILY_BASE = "http://news-at.zhihu.com/api/4/";
    // http://news-at.zhihu.com/api/4/news/latest
    // http://news-at.zhihu.com/api/4/news/3892357
    // http://news.at.zhihu.com/api/4/news/before/20191119
    // http://news-at.zhihu.com/api/3/news/hot
    // http://news-at.zhihu.com/api/4/news/3892357/comments

    @GET("news/latest")
    Observable<Lastest> getlatest();

    @GET("news/{id}")
    Observable<StoryContent> getZhihuContent(@Path("id") int id);

    @GET("news/before/{date}")
    Observable<DailyStory> getBeforeStory(@Path("date") String date);

//    @GET("news/{id}/comments")
//    Observable<Comment> getComment(@Path("id") int id);

//
//    Observable<SectionsModel> loadSectionItem();
//
//
//    Observable<SectionItemModel> loadSectionItemContentForId(@Path("id") Integer sectionId);

    @HTTP(path = "http://news-at.zhihu.com/api/3/news/hot", method = "GET")
    Observable<HotStory> getHotStory();
}
