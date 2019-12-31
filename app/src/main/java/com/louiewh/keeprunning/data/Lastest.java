package com.louiewh.keeprunning.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Lastest {


    @SerializedName("date")
    @Expose
    public String date;

    @SerializedName("stories")
    @Expose
    public List<Story> stories;

    @SerializedName("top_stories")
    @Expose
    public List<TopStory> topStories;
}


