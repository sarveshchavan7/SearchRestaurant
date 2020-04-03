
package com.example.restaurantsearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AllReviews {

    @SerializedName("reviews")
    private List<Review> mReviews;

    public List<Review> getReviews() {
        return mReviews;
    }

    public void setReviews(List<Review> reviews) {
        mReviews = reviews;
    }

}
