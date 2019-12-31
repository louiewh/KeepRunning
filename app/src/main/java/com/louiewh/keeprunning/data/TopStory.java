package com.louiewh.keeprunning.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopStory {
    @SerializedName("image_hue")
    @Expose
    public String imageHue;
    @SerializedName("hint")
    @Expose
    public String hint;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("ga_prefix")
    @Expose
    public String gaPrefix;
    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("id")
    @Expose
    public Integer id;
}
