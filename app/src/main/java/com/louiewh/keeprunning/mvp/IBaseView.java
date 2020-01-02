package com.louiewh.keeprunning.mvp;

import androidx.lifecycle.Lifecycle;

public interface IBaseView {

    void notifyViewDataChange(Object data);

    void notifyThrowable(Throwable throwable);

    Lifecycle getLifecycle();
}
