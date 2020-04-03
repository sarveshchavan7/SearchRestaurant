
package com.example.restaurantsearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class RestaurantList {

    @SerializedName("restaurants")
    private List<Restaurant> mRestaurants;
    @SerializedName("results_found")
    private Long mResultsFound;
    @SerializedName("results_shown")
    private Long mResultsShown;
    @SerializedName("results_start")
    private Long mResultsStart;

    public List<Restaurant> getRestaurants() {
        return mRestaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        mRestaurants = restaurants;
    }

    public Long getResultsFound() {
        return mResultsFound;
    }

    public void setResultsFound(Long resultsFound) {
        mResultsFound = resultsFound;
    }

    public Long getResultsShown() {
        return mResultsShown;
    }

    public void setResultsShown(Long resultsShown) {
        mResultsShown = resultsShown;
    }

    public Long getResultsStart() {
        return mResultsStart;
    }

    public void setResultsStart(Long resultsStart) {
        mResultsStart = resultsStart;
    }

}
