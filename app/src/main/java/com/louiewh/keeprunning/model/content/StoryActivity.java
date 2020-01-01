package com.louiewh.keeprunning.model.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.louiewh.keeprunning.R;
import com.louiewh.keeprunning.mvp.BaseActivity;
import com.louiewh.keeprunning.data.StoryContent;
import com.louiewh.keeprunning.util.LogWrapper;

import androidx.appcompat.app.ActionBar;
import butterknife.BindView;

public class StoryActivity extends BaseActivity implements IStoryView {

    public static final String  STORY_ID = "story_id";

    @BindView(R.id.img_toolbar_content_activity)
    ImageView mContentImage;

    @BindView(R.id.tv_toolbar_content_activity)
    TextView mContentText;

    @BindView(R.id.tv_source_toolbar_content_activity)
    TextView mContentTextSource;

    @BindView(R.id.webview_content)
    WebView mWebView;

    @BindView(R.id.view_toolbar)
    View mToolBarContent;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    private StoryPresenter mStoryPresenter;
    private String mShareUrl;

    public static void lanuch(Context context, int id) {
        Intent mIntent = new Intent(context, StoryActivity.class);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mIntent.putExtra(STORY_ID, id);
        context.startActivity(mIntent);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int storyId = intent.getIntExtra(STORY_ID, 0);
        mStoryPresenter = new StoryPresenter(this);
        mStoryPresenter.getStory(storyId);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_story;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");
        }
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void notifyViewDataChange(Object data) {

        updateContent(data);
        mProgressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        }, 500);
    }

    @Override
    public void notifyThrowable(Throwable throwable) {
        LogWrapper.exception("notifyThrowable", throwable);
        mProgressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.INVISIBLE);
                showToast(throwable.getMessage());
            }
        }, 500);
    }

    private void updateContent(Object data) {
        if(data instanceof StoryContent){
            StoryContent story = (StoryContent) data;
            if(story.image == null || story.image.length() == 0){
                mToolBarContent.setVisibility(View.GONE);

            }else{
                mToolBarContent.setVisibility(View.VISIBLE);

                Glide.with(StoryActivity.this).load(story.image).into(mContentImage);
                mContentText.setText(story.title);
                mContentTextSource.setText(story.imageSource);
            }

             mShareUrl = story.shareUrl;

            String html = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"ZhiHuCSS.css\"/></head><body>"+story.body+"</body></html>";
            mWebView.loadDataWithBaseURL("file:///android_asset/", html , "text/html", "utf-8", null);
            mWebView.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_story_activity,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.story_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, mShareUrl);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "分享给"));
                break;
//            case R.id.story_comment:
//                Intent intentToComment = new Intent(StoryActivity.this,CommentActivity.class);
//                intentToComment.putExtra("story_id",storyId);
//                startActivity(intentToComment);
//                break;

        }

        return true;
    }
}
