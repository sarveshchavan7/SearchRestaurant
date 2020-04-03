
package com.example.restaurantsearch.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class UserRating {

    @SerializedName("aggregate_rating")
    private String mAggregateRating;
    @SerializedName("rating_color")
    private String mRatingColor;
    @SerializedName("rating_obj")
    private RatingObj mRatingObj;
    @SerializedName("rating_text")
    private String mRatingText;
    @SerializedName("votes")
    private String mVotes;

    public String getAggregateRating() {
        return mAggregateRating;
    }

    public void setAggregateRating(String aggregateRating) {
        mAggregateRating = aggregateRating;
    }

    public String getRatingColor() {
        return mRatingColor;
    }

    public void setRatingColor(String ratingColor) {
        mRatingColor = ratingColor;
    }

    public RatingObj getRatingObj() {
        return mRatingObj;
    }

    public void setRatingObj(RatingObj ratingObj) {
        mRatingObj = ratingObj;
    }

    public String getRatingText() {
        return mRatingText;
    }

    public void setRatingText(String ratingText) {
        mRatingText = ratingText;
    }

    public String getVotes() {
        return mVotes;
    }

    public void setVotes(String votes) {
        mVotes = votes;
    }

}
