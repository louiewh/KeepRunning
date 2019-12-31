package com.louiewh.keeprunning.model.home;

import com.louiewh.keeprunning.api.ApiZhihu;
import com.louiewh.keeprunning.data.DailyStory;
import com.louiewh.keeprunning.data.Lastest;
import com.louiewh.keeprunning.mvp.BasePresenter;
import com.louiewh.keeprunning.retrofit.RetrofitFactory;

import io.reactivex.Observable;

public class HomePresenter extends BasePresenter {


    public HomePresenter(IHomeView view) {
        super(view);
    }

    public void getLastest(){
        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<Lastest> observable =  service.getlatest();

        mLogic.subscribe(observable);
    }


    public void getBeforeStory(String data){

        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<DailyStory> observable =  service.getBeforeStory(data);

        mLogic.subscribe(observable);
    }

}
