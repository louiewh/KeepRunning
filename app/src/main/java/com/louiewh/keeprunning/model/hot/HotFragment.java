package com.louiewh.keeprunning.model.hot;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.data.HotStory;
import com.louiewh.keeprunning.model.hot.adapter.HotRecyclerViewAdapter;
import com.louiewh.keeprunning.mvp.BaseFragment;
import com.louiewh.keeprunning.util.LogWrapper;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;

public class HotFragment extends BaseFragment implements IHotView {

    static private HotFragment sInstance;
    synchronized static public HotFragment getInstance(){

        if (sInstance == null){
            sInstance = new HotFragment();
        }

        return sInstance;
    }

    private HotPresenter mHotPresenter;
    private HotRecyclerViewAdapter mHotRecyclerViewAdapter;


    @BindView(R.id.recycle_view_hot)
    XRecyclerView mXRecyclerView;

    @Override
    public int getContView() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);

        mHotRecyclerViewAdapter = new HotRecyclerViewAdapter();
        mXRecyclerView.setAdapter(mHotRecyclerViewAdapter);
    }

    @Override
    protected void initData() {
        mHotPresenter = new HotPresenter(this);
        mHotPresenter.getHotStory();
    }

    @Override
    public void notifyViewDataChange(Object data) {

        LogWrapper.d("Hot", "notifyViewDataChange");
        if(data instanceof HotStory){
            HotStory hotStory = (HotStory) data;
            mHotRecyclerViewAdapter.setHotStoryList(hotStory);
            mHotRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void notifyThrowable(Throwable throwable) {
        showToast(throwable.getMessage());
    }
}
