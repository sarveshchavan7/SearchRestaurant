package com.example.restaurantsearch.model;

public class ItemRestaurant extends ListItems {

    private Restaurant restaurant;


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ItemRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public int getType() {
        return TYPE_RESTAURANT;
    }
}
