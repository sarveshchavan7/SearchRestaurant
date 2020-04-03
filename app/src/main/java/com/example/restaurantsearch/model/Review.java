
package com.example.restaurantsearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Review {

    @SerializedName("review")
    private List<Review> mReview;

    public List<Review> getReview() {
        return mReview;
    }

    public void setReview(List<Review> review) {
        mReview = review;
    }

}
