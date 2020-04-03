
package com.example.restaurantsearch.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class BgColor {

    @SerializedName("tint")
    private String mTint;
    @SerializedName("type")
    private String mType;

    public String getTint() {
        return mTint;
    }

    public void setTint(String tint) {
        mTint = tint;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
