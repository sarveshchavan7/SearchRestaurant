package com.example.restaurantsearch.adapters;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.restaurantsearch.R;
import com.example.restaurantsearch.model.Restaurant;
import com.example.restaurantsearch.model.UserRating;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Restaurant> restaurants = new ArrayList<>();

    private RequestManager requestManager;
    public static final String TAG = RestaurantRecyclerAdapter.class.getSimpleName();

    public RestaurantRecyclerAdapter(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_restaurant, parent, false);
        return new RestaurantViewHolder(v, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ((RestaurantViewHolder) holder).bindData(restaurants.get(position).getRestaurant());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbNail;
        TextView tvRating, tvName, tvCuisines, tvPerPersonCost;
        RequestManager requestManager;

        public RestaurantViewHolder(@NonNull View itemView, RequestManager requestManager) {
            super(itemView);
            imgThumbNail = itemView.findViewById(R.id.img_thumbnail);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCuisines = itemView.findViewById(R.id.tv_cuisines);
            tvPerPersonCost = itemView.findViewById(R.id.tv_per_person_cost);
            this.requestManager = requestManager;
        }

        public void bindData(Restaurant restaurant) {
            if (restaurant != null) {
                tvRating.setText(restaurant.getUserRating().getAggregateRating());
                tvRating.setBackgroundColor(Color.parseColor("#" + restaurant.getUserRating().getRatingColor()));
                tvName.setText(restaurant.getName());
                tvCuisines.setText(restaurant.getCuisines());
                tvPerPersonCost.setText(String.valueOf(restaurant.getAverageCostForTwo()));
                requestManager.load(restaurant.getThumb()).into(imgThumbNail);
            }

        }

    }
}
