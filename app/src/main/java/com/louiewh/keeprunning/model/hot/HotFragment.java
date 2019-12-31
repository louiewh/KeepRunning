package com.louiewh.keeprunning.model.hot;

import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.base.BaseFragment;
import com.louiewh.keeprunning.model.home.HomeFragment;

public class HotFragment extends BaseFragment {

    static private HomeFragment sInstance;
    synchronized static public HomeFragment getInstance(){

        if (sInstance == null){
            sInstance = new HomeFragment();
        }

        return sInstance;
    }

    @Override
    public int getContView() {
        return R.layout.fragment_home;
    }
}
