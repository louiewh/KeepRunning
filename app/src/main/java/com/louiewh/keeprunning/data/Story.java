package com.louiewh.keeprunning.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Story {

    @SerializedName("image_hue")
    @Expose
    public String imageHue;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("hint")
    @Expose
    public String hint;
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

}
