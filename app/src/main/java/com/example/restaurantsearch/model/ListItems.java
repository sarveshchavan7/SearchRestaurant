package com.example.restaurantsearch.model;

public abstract class ListItems {

    public static final int TYPE_CUISINES = 1;
    public static final int TYPE_RESTAURANT = 0;

    abstract public int getType();
}
