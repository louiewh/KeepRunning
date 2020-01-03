package com.louiewh.keeprunning.model.hot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.louiewh.keeprunning.App;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.data.HotStory;
import com.louiewh.keeprunning.util.LogWrapper;
import com.louiewh.keeprunning.route.RouteZhihu;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HotRecyclerViewAdapter extends XRecyclerView.Adapter<HotRecyclerViewAdapter.HotViewHolder> {

    private HotStory mHotStory;

    public HotRecyclerViewAdapter() {

    }

    public void setHotStoryList(HotStory list){
        mHotStory = list;
    }

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_home_recycler, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {

        LogWrapper.d("Hot", "onBindViewHolder");
        if (mHotStory != null) {
            holder.mTextViewHome.setText(mHotStory.mRecent.get(position).mTitle);

            Glide.with(App.getInstance()).load(mHotStory.mRecent.get(position).mThumbnail).into(holder.mImageView);
            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RouteZhihu.startActivityForStory(mHotStory.mRecent.get(position).mNewsId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {

        if(mHotStory != null && mHotStory.mRecent != null){
            return  mHotStory.mRecent.size();
        }

        return 0;
    }

    public static class HotViewHolder extends XRecyclerView.ViewHolder {

        @BindView(R.id.card_home_recycler_item)
        public CardView mCardView;

        @BindView(R.id.tv_home_item)
        public TextView mTextViewHome;

        @BindView(R.id.img_home_item)
        public ImageView mImageView;

        public HotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
