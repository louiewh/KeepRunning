package com.louiewh.keeprunning.model.content;

import com.louiewh.keeprunning.api.ApiZhihu;
import com.louiewh.keeprunning.data.StoryContent;
import com.louiewh.keeprunning.mvp.BasePresenter;
import com.louiewh.keeprunning.retrofit.RetrofitFactory;

import io.reactivex.Observable;

public class StoryPresenter extends BasePresenter {

    public StoryPresenter(IStoryView view) {
        super(view);
    }

    public void getStory(int id){
        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<StoryContent> observable =  service.getZhihuContent(id);

        mLogic.subscribe(observable);
    }
}
