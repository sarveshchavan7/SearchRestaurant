
package com.example.restaurantsearch.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class R {

    @SerializedName("has_menu_status")
    private HasMenuStatus mHasMenuStatus;
    @SerializedName("res_id")
    private Long mResId;

    public HasMenuStatus getHasMenuStatus() {
        return mHasMenuStatus;
    }

    public void setHasMenuStatus(HasMenuStatus hasMenuStatus) {
        mHasMenuStatus = hasMenuStatus;
    }

    public Long getResId() {
        return mResId;
    }

    public void setResId(Long resId) {
        mResId = resId;
    }

}
