
package com.example.restaurantsearch.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class HasMenuStatus {

    @SerializedName("delivery")
    private Long mDelivery;
    @SerializedName("takeaway")
    private Long mTakeaway;

    public Long getDelivery() {
        return mDelivery;
    }

    public void setDelivery(Long delivery) {
        mDelivery = delivery;
    }

    public Long getTakeaway() {
        return mTakeaway;
    }

    public void setTakeaway(Long takeaway) {
        mTakeaway = takeaway;
    }

}
