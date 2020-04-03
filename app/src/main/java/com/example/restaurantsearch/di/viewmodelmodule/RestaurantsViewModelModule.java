package com.example.restaurantsearch.di.viewmodelmodule;

import androidx.lifecycle.ViewModel;

import com.example.restaurantsearch.di.app.ViewModelKey;
import com.example.restaurantsearch.viewmodel.RestaurantsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class RestaurantsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantsViewModel.class)
    public abstract ViewModel bindRestaurantsViewModelModule(RestaurantsViewModel restaurantsViewModel);
}
