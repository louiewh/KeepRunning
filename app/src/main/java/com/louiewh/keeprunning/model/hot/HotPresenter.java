package com.louiewh.keeprunning.model.hot;

import com.louiewh.keeprunning.api.ApiZhihu;
import com.louiewh.keeprunning.data.HotStory;
import com.louiewh.keeprunning.mvp.BasePresenter;
import com.louiewh.keeprunning.mvp.IBaseView;
import com.louiewh.keeprunning.retrofit.RetrofitFactory;

import io.reactivex.Observable;

public class HotPresenter extends BasePresenter {
    public HotPresenter(IBaseView view) {
        super(view);
    }

    public void getHotStory(){
        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<HotStory> observable =  service.getHotStory();

        subscribe(observable);
    }
}
