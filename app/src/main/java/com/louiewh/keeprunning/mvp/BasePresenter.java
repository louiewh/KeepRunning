package com.louiewh.keeprunning.mvp;

abstract public class BasePresenter {

    protected IBaseView mIBaseView;
    protected Logic mLogic;
    protected LogicListener mLogicListener;


    public BasePresenter(IBaseView view){

        mIBaseView = view;
        mLogic = new Logic();
        mLogicListener = new LogicListener() {
            @Override
            public void notifyDataChange(Object data) {
                BasePresenter.this.notifyDataChange(data);
            }
        };
        mLogic.registerListener(mLogicListener);
    }

    public void notifyDataChange(Object data){
        mIBaseView.notifyViewDataChange(data);
    }
}
