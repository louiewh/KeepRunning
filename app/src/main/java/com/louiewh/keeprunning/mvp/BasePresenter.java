package com.louiewh.keeprunning.mvp;

import androidx.lifecycle.Lifecycle;
import io.reactivex.Observable;

abstract public class BasePresenter {

    protected IBaseView mIBaseView;
    protected Logic mLogic;
    protected LogicListener mLogicListener;
    protected Lifecycle mLifecycle;

    public BasePresenter(IBaseView view) {

        mIBaseView = view;
        mLifecycle = mIBaseView.getLifecycle();
        mLogic = new Logic();
        mLogicListener = new LogicListener() {
            @Override
            public void notifyDataChange(Object data) {
                BasePresenter.this.notifyDataChange(data);
            }

            @Override
            public void notifyThrowable(Throwable throwable) {
                BasePresenter.this.notifyThrowable(throwable);
            }
        };
        mLogic.registerListener(mLogicListener);
    }

    public <T> void subscribe(Observable<T> observable) {
        mLogic.subscribeWithDisposable(observable, mLifecycle);
    }

    public void notifyDataChange(Object data) {
        mIBaseView.notifyViewDataChange(data);
    }

    public void notifyThrowable(Throwable throwable) {
        mIBaseView.notifyThrowable(throwable);
    }
}
