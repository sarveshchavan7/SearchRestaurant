
package com.example.restaurantsearch.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Restaurant {

    @SerializedName("all_reviews")
    private AllReviews mAllReviews;
    @SerializedName("all_reviews_count")
    private Long mAllReviewsCount;
    @SerializedName("apikey")
    private String mApikey;
    @SerializedName("average_cost_for_two")
    private Long mAverageCostForTwo;
    @SerializedName("book_again_url")
    private String mBookAgainUrl;
    @SerializedName("book_form_web_view_url")
    private String mBookFormWebViewUrl;
    @SerializedName("cuisines")
    private String mCuisines;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("deeplink")
    private String mDeeplink;
    @SerializedName("establishment")
    private List<String> mEstablishment;
    @SerializedName("establishment_types")
    private List<Object> mEstablishmentTypes;
    @SerializedName("events_url")
    private String mEventsUrl;
    @SerializedName("featured_image")
    private String mFeaturedImage;
    @SerializedName("has_online_delivery")
    private Long mHasOnlineDelivery;
    @SerializedName("has_table_booking")
    private Long mHasTableBooking;
    @SerializedName("highlights")
    private List<String> mHighlights;
    @SerializedName("id")
    private String mId;
    @SerializedName("include_bogo_offers")
    private Boolean mIncludeBogoOffers;
    @SerializedName("is_book_form_web_view")
    private Long mIsBookFormWebView;
    @SerializedName("is_delivering_now")
    private Long mIsDeliveringNow;
    @SerializedName("is_table_reservation_supported")
    private Long mIsTableReservationSupported;
    @SerializedName("is_zomato_book_res")
    private Long mIsZomatoBookRes;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("menu_url")
    private String mMenuUrl;
    @SerializedName("mezzo_provider")
    private String mMezzoProvider;
    @SerializedName("name")
    private String mName;
    @SerializedName("offers")
    private List<Object> mOffers;
    @SerializedName("opentable_support")
    private Long mOpentableSupport;
    @SerializedName("phone_numbers")
    private String mPhoneNumbers;
    @SerializedName("photo_count")
    private Long mPhotoCount;
    @SerializedName("photos")
    private List<Photo> mPhotos;
    @SerializedName("photos_url")
    private String mPhotosUrl;
    @SerializedName("price_range")
    private Long mPriceRange;
    @SerializedName("R")
    private R mR;
    @SerializedName("restaurant")
    private Restaurant mRestaurant;
    @SerializedName("store_type")
    private String mStoreType;
    @SerializedName("switch_to_order_menu")
    private Long mSwitchToOrderMenu;
    @SerializedName("thumb")
    private String mThumb;
    @SerializedName("timings")
    private String mTimings;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user_rating")
    private UserRating mUserRating;

    public AllReviews getAllReviews() {
        return mAllReviews;
    }

    public void setAllReviews(AllReviews allReviews) {
        mAllReviews = allReviews;
    }

    public Long getAllReviewsCount() {
        return mAllReviewsCount;
    }

    public void setAllReviewsCount(Long allReviewsCount) {
        mAllReviewsCount = allReviewsCount;
    }

    public String getApikey() {
        return mApikey;
    }

    public void setApikey(String apikey) {
        mApikey = apikey;
    }

    public Long getAverageCostForTwo() {
        return mAverageCostForTwo;
    }

    public void setAverageCostForTwo(Long averageCostForTwo) {
        mAverageCostForTwo = averageCostForTwo;
    }

    public String getBookAgainUrl() {
        return mBookAgainUrl;
    }

    public void setBookAgainUrl(String bookAgainUrl) {
        mBookAgainUrl = bookAgainUrl;
    }

    public String getBookFormWebViewUrl() {
        return mBookFormWebViewUrl;
    }

    public void setBookFormWebViewUrl(String bookFormWebViewUrl) {
        mBookFormWebViewUrl = bookFormWebViewUrl;
    }

    public String getCuisines() {
        return mCuisines;
    }

    public void setCuisines(String cuisines) {
        mCuisines = cuisines;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getDeeplink() {
        return mDeeplink;
    }

    public void setDeeplink(String deeplink) {
        mDeeplink = deeplink;
    }

    public List<String> getEstablishment() {
        return mEstablishment;
    }

    public void setEstablishment(List<String> establishment) {
        mEstablishment = establishment;
    }

    public List<Object> getEstablishmentTypes() {
        return mEstablishmentTypes;
    }

    public void setEstablishmentTypes(List<Object> establishmentTypes) {
        mEstablishmentTypes = establishmentTypes;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getFeaturedImage() {
        return mFeaturedImage;
    }

    public void setFeaturedImage(String featuredImage) {
        mFeaturedImage = featuredImage;
    }

    public Long getHasOnlineDelivery() {
        return mHasOnlineDelivery;
    }

    public void setHasOnlineDelivery(Long hasOnlineDelivery) {
        mHasOnlineDelivery = hasOnlineDelivery;
    }

    public Long getHasTableBooking() {
        return mHasTableBooking;
    }

    public void setHasTableBooking(Long hasTableBooking) {
        mHasTableBooking = hasTableBooking;
    }

    public List<String> getHighlights() {
        return mHighlights;
    }

    public void setHighlights(List<String> highlights) {
        mHighlights = highlights;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Boolean getIncludeBogoOffers() {
        return mIncludeBogoOffers;
    }

    public void setIncludeBogoOffers(Boolean includeBogoOffers) {
        mIncludeBogoOffers = includeBogoOffers;
    }

    public Long getIsBookFormWebView() {
        return mIsBookFormWebView;
    }

    public void setIsBookFormWebView(Long isBookFormWebView) {
        mIsBookFormWebView = isBookFormWebView;
    }

    public Long getIsDeliveringNow() {
        return mIsDeliveringNow;
    }

    public void setIsDeliveringNow(Long isDeliveringNow) {
        mIsDeliveringNow = isDeliveringNow;
    }

    public Long getIsTableReservationSupported() {
        return mIsTableReservationSupported;
    }

    public void setIsTableReservationSupported(Long isTableReservationSupported) {
        mIsTableReservationSupported = isTableReservationSupported;
    }

    public Long getIsZomatoBookRes() {
        return mIsZomatoBookRes;
    }

    public void setIsZomatoBookRes(Long isZomatoBookRes) {
        mIsZomatoBookRes = isZomatoBookRes;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public String getMenuUrl() {
        return mMenuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        mMenuUrl = menuUrl;
    }

    public String getMezzoProvider() {
        return mMezzoProvider;
    }

    public void setMezzoProvider(String mezzoProvider) {
        mMezzoProvider = mezzoProvider;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Object> getOffers() {
        return mOffers;
    }

    public void setOffers(List<Object> offers) {
        mOffers = offers;
    }

    public Long getOpentableSupport() {
        return mOpentableSupport;
    }

    public void setOpentableSupport(Long opentableSupport) {
        mOpentableSupport = opentableSupport;
    }

    public String getPhoneNumbers() {
        return mPhoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        mPhoneNumbers = phoneNumbers;
    }

    public Long getPhotoCount() {
        return mPhotoCount;
    }

    public void setPhotoCount(Long photoCount) {
        mPhotoCount = photoCount;
    }

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

    public String getPhotosUrl() {
        return mPhotosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        mPhotosUrl = photosUrl;
    }

    public Long getPriceRange() {
        return mPriceRange;
    }

    public void setPriceRange(Long priceRange) {
        mPriceRange = priceRange;
    }

    public R getR() {
        return mR;
    }

    public void setR(R r) {
        mR = r;
    }

    public Restaurant getRestaurant() {
        return mRestaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        mRestaurant = restaurant;
    }

    public String getStoreType() {
        return mStoreType;
    }

    public void setStoreType(String storeType) {
        mStoreType = storeType;
    }

    public Long getSwitchToOrderMenu() {
        return mSwitchToOrderMenu;
    }

    public void setSwitchToOrderMenu(Long switchToOrderMenu) {
        mSwitchToOrderMenu = switchToOrderMenu;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getTimings() {
        return mTimings;
    }

    public void setTimings(String timings) {
        mTimings = timings;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public UserRating getUserRating() {
        return mUserRating;
    }

    public void setUserRating(UserRating userRating) {
        mUserRating = userRating;
    }

}
