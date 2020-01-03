package com.louiewh.keeprunning.mvp;

import android.annotation.SuppressLint;

import com.louiewh.keeprunning.util.LogWrapper;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import androidx.lifecycle.Lifecycle;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Logic {

    private LogicListener mLogicListener;


    public void registerListener(LogicListener listener){
        mLogicListener = listener;

    }

    public void unregisterListener(){
        mLogicListener = null;
    }

    @SuppressLint("CheckResult")
    public <T> void subscribe(Observable<T> observable) {

        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object data) throws Exception {

                        if(mLogicListener != null){
                            mLogicListener.notifyDataChange(data);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogWrapper.e("AAA", throwable.toString());
                        if(mLogicListener != null){
                            mLogicListener.notifyThrowable(throwable);
                        }
                    }
                });
    }

    public <T> void subscribeWithDisposable(Observable<T> observable, Lifecycle lifecycle) {

        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycle)))
                .subscribe(new Consumer<Object>() {
                            @Override
                            public void accept(Object data) throws Exception {

                                if(mLogicListener != null){
                                    mLogicListener.notifyDataChange(data);
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                LogWrapper.e("AAA", throwable.toString());
                                if(mLogicListener != null){
                                    mLogicListener.notifyThrowable(throwable);
                                }
                            }
                        });
    }
}
