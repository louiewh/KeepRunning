
package com.louiewh.keeprunning.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class HotStory {

    @SerializedName("recent")
    public List<Recent> mRecent;


    public class Recent {

        @SerializedName("news_id")
        public int mNewsId;

        @SerializedName("thumbnail")
        public String mThumbnail;

        @SerializedName("title")
        public String mTitle;

        @SerializedName("url")
        public String mUrl;
    }
}
