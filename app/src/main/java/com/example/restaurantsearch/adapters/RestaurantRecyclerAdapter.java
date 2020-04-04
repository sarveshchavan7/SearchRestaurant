package com.example.restaurantsearch.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.restaurantsearch.R;
import com.example.restaurantsearch.model.HeaderCuisine;
import com.example.restaurantsearch.model.ItemRestaurant;
import com.example.restaurantsearch.model.ListItems;
import com.example.restaurantsearch.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ListItems> cuisineAndRestaurant = new ArrayList<>();

    private RequestManager requestManager;

    public static final String TAG = RestaurantRecyclerAdapter.class.getSimpleName();

    public RestaurantRecyclerAdapter(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ListItems.TYPE_CUISINES: {
                View itemViewCuisine = layoutInflater.inflate(R.layout.layout_item_cuisine, parent, false);
                return new CuisineViewHolder(itemViewCuisine);
            }
            case ListItems.TYPE_RESTAURANT: {
                View itemViewRestaurant = layoutInflater.inflate(R.layout.layout_item_restaurant, parent, false);
                return new RestaurantViewHolder(itemViewRestaurant, parent.getContext());
            }
            default:
                throw new IllegalStateException("unsupported type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case ListItems.TYPE_CUISINES: {
                HeaderCuisine headerCuisine = (HeaderCuisine) cuisineAndRestaurant.get(position);
                CuisineViewHolder cuisineViewHolder = (CuisineViewHolder) holder;
                cuisineViewHolder.bindData(headerCuisine.getCuisine());
                break;
            }
            case ListItems.TYPE_RESTAURANT: {
                ItemRestaurant itemRestaurant = (ItemRestaurant) cuisineAndRestaurant.get(position);
                RestaurantViewHolder restaurantViewHolder = (RestaurantViewHolder) holder;
                restaurantViewHolder.bindData(itemRestaurant.getRestaurant());
                break;
            }
            default:
                throw new IllegalStateException("unsupported type");
        }
    }

    @Override
    public int getItemCount() {
        return cuisineAndRestaurant.size();
    }

    public void setCuisineAndRestaurant(List<ListItems> cuisineAndRestaurant) {
        this.cuisineAndRestaurant = cuisineAndRestaurant;
        notifyDataSetChanged();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbNail;
        TextView tvRating, tvName, tvCuisines, tvPerPersonCost;
        Resources resources;

        RestaurantViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            imgThumbNail = itemView.findViewById(R.id.img_thumbnail);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCuisines = itemView.findViewById(R.id.tv_cuisines);
            tvPerPersonCost = itemView.findViewById(R.id.tv_per_person_cost);
            resources = ctx.getResources();
        }

        void bindData(Restaurant restaurant) {

            if (restaurant != null) {
                tvRating.setText(restaurant.getUserRating().getAggregateRating());
                tvRating.setBackgroundColor(Color.parseColor("#" + restaurant.getUserRating().getRatingColor()));
                tvName.setText(restaurant.getName());
                tvCuisines.setText(restaurant.getCuisines());
                tvPerPersonCost.setText(resources.getString(R.string.rupees_for_two, String.valueOf(restaurant.getAverageCostForTwo())));
                requestManager.load(restaurant.getThumb()).into(imgThumbNail);
            }

        }

    }

    public class CuisineViewHolder extends RecyclerView.ViewHolder {
        TextView tvCuisineName;

        CuisineViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCuisineName = itemView.findViewById(R.id.tv_cuisine_name);
        }

        void bindData(String cuisineName) {
            tvCuisineName.setText(cuisineName);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return cuisineAndRestaurant.get(position).getType();
    }
}
