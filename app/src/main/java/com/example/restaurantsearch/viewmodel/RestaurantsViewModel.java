package com.example.restaurantsearch.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.restaurantsearch.model.Restaurant;
import com.example.restaurantsearch.model.RestaurantList;
import com.example.restaurantsearch.service.ApiResponse;
import com.example.restaurantsearch.service.EndPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsViewModel extends ViewModel {

    public MutableLiveData<ApiResponse<RestaurantList>> apiResponseLiveData = new MutableLiveData<>();

    public static final String TAG = RestaurantsViewModel.class.getSimpleName();

    private final EndPoints endPoints;

    @Inject
    RestaurantsViewModel(EndPoints endPoints) {
        this.endPoints = endPoints;
    }

    public void searchRestaurants(String query) {
        apiResponseLiveData.postValue(ApiResponse.loading((RestaurantList) null));
        endPoints.searchRestaurants(query).enqueue(new Callback<RestaurantList>() {
            @Override
            public void onResponse(Call<RestaurantList> call, Response<RestaurantList> response) {
                if (response.code() == 200) {
                    apiResponseLiveData.postValue(ApiResponse.success(response.body()));
                } else {
                    apiResponseLiveData.postValue(ApiResponse.error("SOME THING WENT WRONG " + response.code(), (RestaurantList) null));
                }
            }

            @Override
            public void onFailure(Call<RestaurantList> call, Throwable t) {
                apiResponseLiveData.postValue(ApiResponse.error(t.getMessage(), (RestaurantList) null));
            }
        });
    }

    private HashMap<String, List<Restaurant>> toMap(List<Restaurant> restaurants) {
        HashMap<String, List<Restaurant>> map = new HashMap<>();

        for (Restaurant restaurant : restaurants) {

            String[] Cuisines = restaurant.getRestaurant().getCuisines().split(",");

            for (String cuisine : Cuisines) {

                List<Restaurant> restaurantList = map.get(cuisine);

                if (restaurantList == null) {
                    restaurantList = new ArrayList<>();
                    map.put(cuisine, restaurantList);
                }

                restaurantList.add(restaurant);
            }
        }


        return map;
    }

    private void printMap(HashMap<String, List<Restaurant>> hashMap) {
        for (Map.Entry<String, List<Restaurant>> entry : hashMap.entrySet()) {
            Log.d(TAG, "CUISINES : " + entry.getKey() + "\n");
            for (Restaurant restaurant : entry.getValue()) {
                Log.d(TAG, " - " + restaurant.getRestaurant().getName() + "\n");
            }
            Log.d(TAG, "\n");
        }
    }

}
