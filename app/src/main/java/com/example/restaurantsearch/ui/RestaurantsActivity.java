package com.example.restaurantsearch.ui;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.example.restaurantsearch.adapters.RestaurantRecyclerAdapter;
import com.example.restaurantsearch.R;
import com.example.restaurantsearch.di.app.ViewModelProviderFactory;
import com.example.restaurantsearch.model.ListItems;
import com.example.restaurantsearch.service.ApiResponse;
import com.example.restaurantsearch.viewmodel.RestaurantsViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RestaurantsActivity extends DaggerAppCompatActivity {

    public final String TAG = getClass().getSimpleName();

    private SearchView searchView;

    private ShimmerFrameLayout shimmerFrameLayout;

    RestaurantsViewModel restaurantsViewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    RequestManager requestManager;

    @Inject
    RestaurantRecyclerAdapter restaurantRecyclerAdapter;

    @Inject
    CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        restaurantsViewModel = new ViewModelProvider(this, viewModelProviderFactory).get(RestaurantsViewModel.class);

        initViews();

        subscribeObserver();

        setUpSearchObservable();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(restaurantRecyclerAdapter);

        searchView = findViewById(R.id.search_view);
        searchView.setQueryHint(getResources().getString(R.string.search_for_restaurant));

        shimmerFrameLayout = findViewById(R.id.shimmer_layout);
        shimmerFrameLayout.startShimmerAnimation();
    }

    private void setUpSearchObservable() {
        Observable<String> observableQueryText = Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(final ObservableEmitter<String> emitter) throws Exception {

                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(final String newText) {
                                if (!emitter.isDisposed()) {
                                    emitter.onNext(newText);
                                }
                                return false;
                            }
                        });
                    }
                })
                .debounce(600, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io());

        observableQueryText.subscribe(new io.reactivex.Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposables.add(d);
            }

            @Override
            public void onNext(String s) {

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
        restaurantsViewModel.apiResponseLiveData.observe(this, new Observer<ApiResponse<List<ListItems>>>() {
            @Override
            public void onChanged(ApiResponse<List<ListItems>> listApiResponse) {
                hideShimmerAnimation();
                switch (listApiResponse.status) {
                    case LOADING:
                        showShimmerAnimation();
                        break;
                    case SUCCESS:
                        restaurantRecyclerAdapter.setCuisineAndRestaurant(listApiResponse.data);
                        break;
                    case ERROR:
                        Toast.makeText(RestaurantsActivity.this, getResources().getString(R.string.some_thing_went_wrong), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void showShimmerAnimation() {
        shimmerFrameLayout.startShimmerAnimation();
        shimmerFrameLayout.setVisibility(View.VISIBLE);
    }

    private void hideShimmerAnimation() {
        shimmerFrameLayout.stopShimmerAnimation();
        shimmerFrameLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }


}
