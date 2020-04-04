package com.example.restaurantsearch.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.restaurantsearch.R;
import com.example.restaurantsearch.model.HeaderCuisine;
import com.example.restaurantsearch.model.ItemRestaurant;
import com.example.restaurantsearch.model.ListItems;
import com.example.restaurantsearch.model.Restaurant;
import com.example.restaurantsearch.model.RestaurantsItem;
import com.example.restaurantsearch.model.SearchRestaurant;
import com.example.restaurantsearch.service.ApiResponse;
import com.example.restaurantsearch.service.EndPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsViewModel extends ViewModel {

    public MutableLiveData<ApiResponse<List<ListItems>>> apiResponseLiveData = new MutableLiveData<>();

    public static final String TAG = RestaurantsViewModel.class.getSimpleName();

    private final EndPoints endPoints;

    @Inject
    RestaurantsViewModel(EndPoints endPoints) {
        this.endPoints = endPoints;
        searchRestaurants("");
    }

    public void searchRestaurants(String query) {
        apiResponseLiveData.postValue(ApiResponse.loading((List<ListItems>) null));
        endPoints.searchRestaurants(query).enqueue(new Callback<SearchRestaurant>() {
            @Override
            public void onResponse(Call<SearchRestaurant> call, Response<SearchRestaurant> response) {
                if (response.code() == 200 && response.body() != null) {
                    List<ListItems> listItems = convertMapToList(toMap(response.body().getRestaurants()));
                    apiResponseLiveData.postValue(ApiResponse.success(listItems));
                } else {
                    apiResponseLiveData.postValue(ApiResponse.error("SOME THING WENT WRONG" + response.code(), (List<ListItems>) null));
                }
            }

            @Override
            public void onFailure(Call<SearchRestaurant> call, Throwable t) {
                apiResponseLiveData.postValue(ApiResponse.error(t.getMessage() == null ? "" : t.getMessage(), (List<ListItems>) null));
            }
        });
    }

    private HashMap<String, List<Restaurant>> toMap(List<RestaurantsItem> restaurants) {
        HashMap<String, List<Restaurant>> map = new HashMap<>();

        for (RestaurantsItem restaurant : restaurants) {

            String[] Cuisines = restaurant.getRestaurant().getCuisines().split("\\s*,\\s*");

            for (String cuisine : Cuisines) {

                List<Restaurant> restaurantList = map.get(cuisine);

                if (restaurantList == null) {
                    restaurantList = new ArrayList<>();
                    restaurantList.add(restaurant.getRestaurant());
                    map.put(cuisine, restaurantList);
                } else {
                    restaurantList.add(restaurant.getRestaurant());
                }
            }
        }


        return map;
    }

    private List<ListItems> convertMapToList(HashMap<String, List<Restaurant>> hashMap) {
        List<ListItems> listItems = new ArrayList<>();
        for (String cuisines : hashMap.keySet()) {
            HeaderCuisine headerCuisine = new HeaderCuisine(cuisines);
            listItems.add(headerCuisine);
            List<Restaurant> restaurantList = hashMap.get(cuisines);
            if (restaurantList != null) {
                for (Restaurant restaurant : restaurantList) {
                    ItemRestaurant itemRestaurant = new ItemRestaurant(restaurant);
                    listItems.add(itemRestaurant);
                }
            }
        }
        return listItems;
    }


}
