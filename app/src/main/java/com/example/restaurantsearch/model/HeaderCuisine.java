package com.example.restaurantsearch.model;

public class HeaderCuisine extends ListItems {

    private String cuisine;

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public HeaderCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public int getType() {
        return TYPE_CUISINES;
    }
}
