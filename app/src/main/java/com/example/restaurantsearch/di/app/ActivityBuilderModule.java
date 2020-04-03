package com.example.restaurantsearch.di.app;

import com.example.restaurantsearch.di.viewmodelmodule.RestaurantsViewModelModule;
import com.example.restaurantsearch.ui.RestaurantsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {
            RestaurantsViewModelModule.class,
    })
    abstract RestaurantsActivity contributeRestaurantsActivity();
}
