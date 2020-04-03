package com.example.restaurantsearch.service;

import com.example.restaurantsearch.model.RestaurantList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {

    @GET("search")
    Call<RestaurantList> searchRestaurants(@Query("q") String queryString);

}
