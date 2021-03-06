package com.louiewh.keeprunning.mvp;

public abstract class LogicListener<T extends Object> {


    abstract public void notifyDataChange(Object data);

    abstract public void notifyThrowable(Throwable throwable);

}
