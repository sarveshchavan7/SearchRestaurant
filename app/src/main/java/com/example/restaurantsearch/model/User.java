
package com.example.restaurantsearch.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class User {

    @SerializedName("foodie_color")
    private String mFoodieColor;
    @SerializedName("name")
    private String mName;
    @SerializedName("profile_deeplink")
    private String mProfileDeeplink;
    @SerializedName("profile_image")
    private String mProfileImage;
    @SerializedName("profile_url")
    private String mProfileUrl;

    public String getFoodieColor() {
        return mFoodieColor;
    }

    public void setFoodieColor(String foodieColor) {
        mFoodieColor = foodieColor;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getProfileDeeplink() {
        return mProfileDeeplink;
    }

    public void setProfileDeeplink(String profileDeeplink) {
        mProfileDeeplink = profileDeeplink;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(String profileImage) {
        mProfileImage = profileImage;
    }

    public String getProfileUrl() {
        return mProfileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        mProfileUrl = profileUrl;
    }

}
