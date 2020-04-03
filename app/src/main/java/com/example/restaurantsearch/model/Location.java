
package com.example.restaurantsearch.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Location {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("city")
    private String mCity;
    @SerializedName("city_id")
    private Long mCityId;
    @SerializedName("country_id")
    private Long mCountryId;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("locality")
    private String mLocality;
    @SerializedName("locality_verbose")
    private String mLocalityVerbose;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("zipcode")
    private String mZipcode;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public Long getCityId() {
        return mCityId;
    }

    public void setCityId(Long cityId) {
        mCityId = cityId;
    }

    public Long getCountryId() {
        return mCountryId;
    }

    public void setCountryId(Long countryId) {
        mCountryId = countryId;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLocality() {
        return mLocality;
    }

    public void setLocality(String locality) {
        mLocality = locality;
    }

    public String getLocalityVerbose() {
        return mLocalityVerbose;
    }

    public void setLocalityVerbose(String localityVerbose) {
        mLocalityVerbose = localityVerbose;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getZipcode() {
        return mZipcode;
    }

    public void setZipcode(String zipcode) {
        mZipcode = zipcode;
    }

}
