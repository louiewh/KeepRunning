package com.louiewh.keeprunning.model.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.louiewh.keeprunning.App;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.data.Story;
import com.louiewh.keeprunning.zhihu.RouteZhihu;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeRecyclerViewAdapter extends XRecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder> {

    public static final String TAG = "HomeRecyclerViewAdapter";
    private List<Story> mStory;

    public void setStoryData(List<Story> list){
        mStory = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HomeViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_home_recycler, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        if (mStory != null) {
            holder.mTextViewHome.setText(mStory.get(position).title);

            Glide.with(App.getInstance()).load(mStory.get(position).images.get(0)).into(holder.mImageView);
            holder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RouteZhihu.startActivityForStory(mStory.get(position).id);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return (mStory == null) ? 0:mStory.size();
    }

    class HomeViewHolder extends XRecyclerView.ViewHolder {

        @BindView(R.id.tv_home_item)
        TextView mTextViewHome;

        @BindView(R.id.img_home_item)
        ImageView mImageView;

        @BindView(R.id.card_home_recycler_item)
        CardView mCardView;

        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.setDebug(true);
            ButterKnife.bind(this, itemView);
        }
    }
}
