package com.example.restaurantsearch.di.app;

import android.app.Application;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.restaurantsearch.BuildConfig;
import com.example.restaurantsearch.R;
import com.example.restaurantsearch.adapters.RestaurantRecyclerAdapter;
import com.example.restaurantsearch.service.EndPoints;
import com.example.restaurantsearch.utils.Constants;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    static OkHttpClient.Builder provideOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                okhttp3.Request request = chain.request().newBuilder()
                        .addHeader("user-key", Constants.API_KEY)
                        .build();
                okhttp3.Response response = chain.proceed(request);
                return response;
            }
        });
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(OkHttpClient.Builder client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build();
    }

    @Singleton
    @Provides
    static RequestOptions providerRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
    }

    @Singleton
    @Provides
    static RequestManager providerGlideInstance(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static EndPoints provideEndPoint(Retrofit retrofit) {
        return retrofit.create(EndPoints.class);
    }

    @Singleton
    @Provides
    static RestaurantRecyclerAdapter provideRestaurantRecyclerAdapter(RequestManager requestManager) {
        return new RestaurantRecyclerAdapter(requestManager);
    }

}
