package com.louiewh.keeprunning.model.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.louiewh.keeprunning.App;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.data.TopStory;
import com.louiewh.keeprunning.model.content.StoryActivity;

import java.util.List;

import androidx.viewpager.widget.PagerAdapter;


public class HomeViewPagerAdapter extends PagerAdapter {

    public List<TopStory> mTopStoryList = null;

    public List<TopStory> getTopStoriesBean() {
        return mTopStoryList;
    }

    public void setTopStoriesBean(List<TopStory> topStoryList) {
        this.mTopStoryList = topStoryList;
    }

    public HomeViewPagerAdapter() {
    }

    @Override
    public int getCount() {
        return mTopStoryList == null ? 0 : mTopStoryList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.head_home_viewpager_content, null);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_description);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.img_view);

        if (mTopStoryList != null) {
            textView.setText(mTopStoryList.get(position).title);
            Glide.with(App.getInstance()).load(mTopStoryList.get(position).image).into(imageView);
        }

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoryActivity.lanuch(App.getInstance(), mTopStoryList.get(position).id);
            }
        });

        container.addView(relativeLayout);

        return relativeLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        RelativeLayout view = (RelativeLayout) object;
        container.removeView(view);
    }
}