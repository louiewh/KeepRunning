package com.louiewh.keeprunning.mvp;

import com.louiewh.keeprunning.util.LogWrapper;

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
}
