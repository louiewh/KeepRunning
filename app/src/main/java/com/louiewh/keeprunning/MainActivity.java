package com.louiewh.keeprunning;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.louiewh.keeprunning.adpter.ViewPagerFragmentStateAdapter;
import com.louiewh.keeprunning.mvp.BaseActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewpager2)
    ViewPager2 mViewPager;

    private ViewPagerFragmentStateAdapter mAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);

        mAdapter = new ViewPagerFragmentStateAdapter(getSupportFragmentManager(), this.getLifecycle());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        setTitle(R.string.home);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void initListeners() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.na_home:
                        setTitle(R.string.home);
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.na_hot:
                        setTitle(R.string.hot);
                        mViewPager.setCurrentItem(1);
                        break;
//                    case R.id.na_topic:
//                        setTitle(R.string.topic);
//                        break;
//                    case R.id.na_column:
//                        setTitle(R.string.column);
//                        break;
                        default:break;
                }

                return false;
            }
        });
    }

    @Override
    public void bind() {

    }
}
