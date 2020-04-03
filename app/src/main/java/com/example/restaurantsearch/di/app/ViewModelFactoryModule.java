package com.example.restaurantsearch.di.app;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
