package com.louiewh.keeprunning.mvp;

abstract public class BasePresenter {

    protected IBaseView mIBaseView;
    protected Logic mLogic;
    protected LogicListener mLogicListener;


    public BasePresenter(IBaseView view) {

        mIBaseView = view;
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

    public void notifyDataChange(Object data) {
        mIBaseView.notifyViewDataChange(data);
    }

    public void notifyThrowable(Throwable throwable) {
        mIBaseView.notifyThrowable(throwable);
    }
}
