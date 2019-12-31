package com.louiewh.keeprunning.api;

import com.louiewh.keeprunning.data.StoryContent;
import com.louiewh.keeprunning.data.DailyStory;
import com.louiewh.keeprunning.data.Lastest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiZhihu {

    String  ZHIHU_DAILY_BASE = "http://news-at.zhihu.com/api/4/";
    // http://news-at.zhihu.com/api/4/news/latest
    // http://news-at.zhihu.com/api/4/news/3892357
    // http://news.at.zhihu.com/api/4/news/before/20191119

    @GET("news/latest")
    Observable<Lastest> getlatest();

    @GET("news/{id}")
    Observable<StoryContent> getZhihuContent(@Path("id") int id);

    @GET("news/before/{date}")
    Observable<DailyStory> getBeforeStory(@Path("date") String date);

//    @GET("themes")
//    Observable<TopicItemModel> loadTopicItem();
//
//    @GET("theme/{path}")
//    Observable<ThemeItemModel> loadThemeItem(@Path("path") Integer id);
//
//    Observable<SectionsModel> loadSectionItem();
//
//
//    Observable<SectionItemModel> loadSectionItemContentForId(@Path("id") Integer sectionId);
//
//    @GET("3/news/hot")
//    Observable<HotModel> loadHotModel();
}
