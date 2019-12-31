package com.louiewh.keeprunning.model.topic;

import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.base.BaseFragment;

public class TopicFragment extends BaseFragment {

    static private TopicFragment sInstance;

    synchronized static public TopicFragment getInstance(){

        if (sInstance == null){
            sInstance = new TopicFragment();
        }

        return sInstance;
    }

    @Override
    public int getContView() {
        return R.layout.fragment_home;
    }
}
