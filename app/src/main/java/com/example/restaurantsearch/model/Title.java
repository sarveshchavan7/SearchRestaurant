
package com.example.restaurantsearch.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Title {

    @SerializedName("text")
    private String mText;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
