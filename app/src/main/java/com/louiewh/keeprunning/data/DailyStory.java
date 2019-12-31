
package com.louiewh.keeprunning.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class DailyStory {

    @SerializedName("date")
    public String mDate;

    @SerializedName("stories")
    public List<Story> mStories;
}
