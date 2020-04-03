package com.example.restaurantsearch.ui;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.RequestManager;
import com.example.restaurantsearch.adapters.RestaurantRecyclerAdapter;
import com.example.restaurantsearch.model.RestaurantList;
import com.example.restaurantsearch.R;
import com.example.restaurantsearch.di.app.ViewModelProviderFactory;
import com.example.restaurantsearch.service.ApiResponse;
import com.example.restaurantsearch.viewmodel.RestaurantsViewModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RestaurantsActivity extends DaggerAppCompatActivity {

    public final String TAG = getClass().getSimpleName();

    private SearchView searchView;

    RestaurantsViewModel restaurantsViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    RequestManager requestManager;

    @Inject
    RestaurantRecyclerAdapter restaurantRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        restaurantsViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(RestaurantsViewModel.class);
        restaurantsViewModel.searchRestaurants("bagels");

        initViews();

        subscribeObserver();

        setUpSearchObservable();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.search_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(restaurantRecyclerAdapter);
    }

    private void setUpSearchObservable() {
        // Create the Observable
        Observable<String> observableQueryText = Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {

                        // Listen for text input into the SearchView
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(final String newText) {
                                if (!emitter.isDisposed()) {
                                    emitter.onNext(newText); // Pass the query to the emitter
                                }
                                return false;
                            }
                        });
                    }
                })
                .debounce(600, TimeUnit.MILLISECONDS) // Apply Debounce() operator to limit requests
                .subscribeOn(Schedulers.io());

        // Subscribe an Observer
        observableQueryText.subscribe(new io.reactivex.Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                // Make Network call
                restaurantsViewModel.searchRestaurants(s);
                Log.d(TAG, s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void subscribeObserver() {
        restaurantsViewModel.apiResponseLiveData.removeObservers(this);
        restaurantsViewModel.apiResponseLiveData.observe(this, new Observer<ApiResponse<RestaurantList>>() {
            @Override
            public void onChanged(ApiResponse<RestaurantList> restaurantListApiResponse) {
                switch (restaurantListApiResponse.status) {
                    case SUCCESS:
                        restaurantRecyclerAdapter.setRestaurants(restaurantListApiResponse.data.getRestaurants());
                        break;
                    case LOADING:
                        Log.d(TAG, "Loading");
                        break;
                    case ERROR:
                        //TODO: log error in some error logging tool
                        break;
                }
            }
        });
    }


}
