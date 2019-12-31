package com.louiewh.keeprunning.model.column;

import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.base.BaseFragment;

import androidx.annotation.LayoutRes;

public class ColumnFragment extends BaseFragment {

    static private ColumnFragment sInstance;
    synchronized static public ColumnFragment getInstance(){

        if (sInstance == null){
            sInstance = new ColumnFragment();
        }

        return sInstance;
    }

    public @LayoutRes int getContView() {
        return R.layout.fragment_home;
    }
}
