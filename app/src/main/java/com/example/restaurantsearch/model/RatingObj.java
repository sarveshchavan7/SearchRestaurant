
package com.example.restaurantsearch.model;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RatingObj {

    @SerializedName("bg_color")
    private BgColor mBgColor;
    @SerializedName("title")
    private Title mTitle;

    public BgColor getBgColor() {
        return mBgColor;
    }

    public void setBgColor(BgColor bgColor) {
        mBgColor = bgColor;
    }

    public Title getTitle() {
        return mTitle;
    }

    public void setTitle(Title title) {
        mTitle = title;
    }

}
