package com.louiewh.keeprunning.mvp;

public interface IBaseView {

    void notifyViewDataChange(Object data);

    void notifyThrowable(Throwable throwable);
}
