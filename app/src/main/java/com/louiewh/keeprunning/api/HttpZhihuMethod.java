package com.louiewh.keeprunning.api;

import com.louiewh.keeprunning.data.StoryContent;
import com.louiewh.keeprunning.data.Lastest;
import com.louiewh.keeprunning.retrofit.RetrofitFactory;
import com.louiewh.keeprunning.util.LogWrapper;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HttpZhihuMethod {

    public  void getLast(){
        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<Lastest> observable =  service.getlatest();
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Lastest>() {
                    @Override
                    public void accept(Lastest lastest) throws Exception {
                        LogWrapper.e("AAA", lastest.toString());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogWrapper.e("AAA", throwable.toString());
                    }
                });
    }


    public void getZhihuContent(int id){
        ApiZhihu service = RetrofitFactory.getZhihuService();
        Observable<StoryContent> observableContent =  service.getZhihuContent(id);
        observableContent
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<StoryContent>() {
                    @Override
                    public void accept(StoryContent content) throws Exception {
                        LogWrapper.e("AAA", content.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogWrapper.e("AAA", throwable.toString());
                    }
                });
    }
}
