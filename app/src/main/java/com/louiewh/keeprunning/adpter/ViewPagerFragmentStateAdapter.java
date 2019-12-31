package com.louiewh.keeprunning.adpter;

import com.louiewh.keeprunning.model.home.HomeFragment;
import com.louiewh.keeprunning.model.hot.HotFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerFragmentStateAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> mFragment= new ArrayList<>();

    public ViewPagerFragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        mFragment.add(HomeFragment.getInstance());
        mFragment.add(HotFragment.getInstance());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragment.size();
    }
}
