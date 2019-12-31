package com.louiewh.keeprunning.model.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.mvp.BaseFragment;
import com.louiewh.keeprunning.data.DailyStory;
import com.louiewh.keeprunning.data.Lastest;
import com.louiewh.keeprunning.data.Story;
import com.louiewh.keeprunning.data.TopStory;
import com.louiewh.keeprunning.model.home.adapter.HomeRecyclerViewAdapter;
import com.louiewh.keeprunning.model.home.adapter.HomeViewPagerAdapter;
import com.louiewh.keeprunning.util.LogWrapper;
import com.tmall.ultraviewpager.UltraViewPager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeView{
    public static final String TAG = "HomeFragment";

    static private HomeFragment sInstance;

    private HomePresenter mHomePresenter;
    private HomeRecyclerViewAdapter mHomeRecyclerViewAdapter;

    private HomeViewPagerAdapter mHomePagerAdapter;
    private UltraViewPager mUltraViewPager;

    private List<Story> mStoryList = new ArrayList<>();
    private List<TopStory> mTopStoryList = new ArrayList<>();
    private int mBeforeData;


    @BindView(R.id.recycle_view_home)
    XRecyclerView mRecyclerView;


    synchronized static public HomeFragment getInstance(){

        if (sInstance == null){
            sInstance = new HomeFragment();
        }

        return sInstance;
    }

    public @LayoutRes int getContView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initXRecycleView();
        initUltraViewPager();

        mHomePresenter = new HomePresenter(this);
        mHomePresenter.getLastest();
        mHomePresenter.getBeforeStory(getBeforeDayTime(mBeforeData));
    }

    @Override
    public void updateLastest(Lastest lastest) {
        LogWrapper.d(TAG, "updateLastest");
        mStoryList.addAll(lastest.stories);
        mHomeRecyclerViewAdapter.notifyDataSetChanged();

        notifyHeadViewUpdate(lastest);
        mRecyclerView.refreshComplete();
    }

    @Override
    public void updateBefore(DailyStory dailyStory) {
        LogWrapper.d(TAG, "updateBefore");
        mStoryList.addAll(dailyStory.mStories);
        mHomeRecyclerViewAdapter.notifyDataSetChanged();
        mRecyclerView.loadMoreComplete();
        mRecyclerView.refreshComplete();
    }

    private void initXRecycleView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mHomeRecyclerViewAdapter = new HomeRecyclerViewAdapter( );
        mRecyclerView.setAdapter(mHomeRecyclerViewAdapter);
        mHomeRecyclerViewAdapter.setStoryData(mStoryList);

        mRecyclerView.setLoadingMoreEnabled( true );
        mRecyclerView.setPullRefreshEnabled( true );

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.loading_01);

        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);

        mRecyclerView.getDefaultFootView().setLoadingHint("自定义加载中提示");
        mRecyclerView.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");
        mRecyclerView.setLimitNumberToCallLoadMore(0);
        // TODO  loadMore work depend on  the content must over screen

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                LogWrapper.d(TAG, "onRefresh");
                mHomePresenter.getLastest();
            }

            @Override
            public void onLoadMore() {
                LogWrapper.e(TAG, "onLoadMore");

                mBeforeData--;
                mHomePresenter.getBeforeStory(getBeforeDayTime(mBeforeData));
            }
        });
    }

    private void initUltraViewPager() {

        View viewRoot = LayoutInflater.from(this.getContext()).inflate(R.layout.head_home_viewpager, null);
        mUltraViewPager = viewRoot.findViewById(R.id.ultra_viewpager);

        mHomePagerAdapter = new HomeViewPagerAdapter();

        mUltraViewPager.setAdapter(mHomePagerAdapter);

        //initialize built-in indicator
        mUltraViewPager.initIndicator();
        //set style of indicators
        mUltraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(R.color.colorPrimary)
                .setNormalColor(Color.WHITE)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));
        //set the alignment
        mUltraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        //construct built-in indicator, and add it to  UltraViewPager
        mUltraViewPager.getIndicator().build();

        mUltraViewPager.setInfiniteLoop(true);
        mUltraViewPager.setAutoScroll(3000);

        mRecyclerView.addHeaderView(viewRoot);         // TODO bug why mUltraViewPager must layout at a parent layout
    }

    public void notifyHeadViewUpdate(Lastest lastest) {

        mUltraViewPager.setInfiniteLoop(false);
        mTopStoryList.clear();
        mTopStoryList.addAll(lastest.topStories);
        mHomePagerAdapter.setTopStoriesBean(mTopStoryList);
        mUltraViewPager.refresh();
    }

    public static String getBeforeDayTime(int index) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, index);
        date = calendar.getTime();

        String str = dateFormat.format(date);
        LogWrapper.d(TAG, "CurrentData：" + str);
        return str;
    }

    @Override
    public void notifyViewDataChange(Object data) {
        if(data instanceof Lastest){
            updateLastest((Lastest) data);
        } else if(data instanceof DailyStory){
            updateBefore((DailyStory) data);
        }
    }
}
