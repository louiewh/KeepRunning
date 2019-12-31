package com.louiewh.keeprunning.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryContent {

    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("image_source")
    @Expose
    public String imageSource;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("share_url")
    @Expose
    public String shareUrl;
    @SerializedName("js")
    @Expose
    public List<Object> js = null;
    @SerializedName("ga_prefix")
    @Expose
    public String gaPrefix;
    @SerializedName("images")
    @Expose
    public List<String> images = null;
    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("css")
    @Expose
    public List<String> css = null;

}


