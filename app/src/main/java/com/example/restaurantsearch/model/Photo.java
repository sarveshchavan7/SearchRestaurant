
package com.example.restaurantsearch.model;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Photo {

    @SerializedName("caption")
    private String mCaption;
    @SerializedName("friendly_time")
    private String mFriendlyTime;
    @SerializedName("height")
    private Long mHeight;
    @SerializedName("id")
    private String mId;
    @SerializedName("photo")
    private Photo mPhoto;
    @SerializedName("res_id")
    private Long mResId;
    @SerializedName("thumb_url")
    private String mThumbUrl;
    @SerializedName("timestamp")
    private Long mTimestamp;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user")
    private User mUser;
    @SerializedName("width")
    private Long mWidth;

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getFriendlyTime() {
        return mFriendlyTime;
    }

    public void setFriendlyTime(String friendlyTime) {
        mFriendlyTime = friendlyTime;
    }

    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    public Long getResId() {
        return mResId;
    }

    public void setResId(Long resId) {
        mResId = resId;
    }

    public String getThumbUrl() {
        return mThumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        mThumbUrl = thumbUrl;
    }

    public Long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(Long timestamp) {
        mTimestamp = timestamp;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

}
