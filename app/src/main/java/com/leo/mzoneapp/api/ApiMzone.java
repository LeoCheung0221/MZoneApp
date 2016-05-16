package com.leo.mzoneapp.api;

import com.leo.mzoneapp.api.request.RequestAutocomplete;
import com.leo.mzoneapp.api.request.RequestCategoryList;
import com.leo.mzoneapp.api.request.RequestMzone;
import com.leo.mzoneapp.api.request.RequestMzoneList;
import com.leo.mzoneapp.api.request.RequestOrderStatus;
import com.leo.mzoneapp.api.request.RequestPhone;
import com.leo.mzoneapp.api.request.RequestPush;
import com.leo.mzoneapp.api.request.RequestSearch;
import com.leo.mzoneapp.api.request.RequestSession;
import com.leo.mzoneapp.api.request.RequestSongList;
import com.leo.mzoneapp.api.request.RequestSongOrder;
import com.leo.mzoneapp.api.request.RequestToken;
import com.leo.mzoneapp.api.response.ResponseAutocomplete;
import com.leo.mzoneapp.api.response.ResponseCityList;
import com.leo.mzoneapp.api.response.ResponseMzone;
import com.leo.mzoneapp.api.response.ResponseMzoneList;
import com.leo.mzoneapp.api.response.ResponseOrder;
import com.leo.mzoneapp.api.response.ResponseSearchSongResultList;
import com.leo.mzoneapp.api.response.ResponseSongCategoryList;
import com.leo.mzoneapp.api.response.ResponseSongList;
import com.leo.mzoneapp.api.response.ResponseToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author：leo on 2016/5/15 23:54
 * email： leocheung4ever@gmail.com
 * description: application interface
 * what & why is modified:
 */
public interface ApiMzone {
    //todo retrofit interface
    String BASE_URL = "http://mzone.net/api-app/v1/";

    //todo methods
    //todo in our api used plain JSON and POST requests
    //todo server can return response with 200 status and put error message into response json
    //todo I parse response in Response' classes with ResponseBase classes provided error
    @POST("auth")
    Call<ResponseToken> getToken(@Body RequestPhone phone);

    @POST("confirm")
    Call<Void> authSession(@Body RequestSession body);

    @POST("cities")
    Call<ResponseCityList> getCityList();

    @POST("boozers")
    Call<ResponseMzoneList> getMzoneList(@Body RequestMzoneList body);

    @POST("boozer")
    Call<ResponseMzone> getMzone(@Body RequestMzone body);

    @POST("songs")
    Call<ResponseSongList> getSongList(@Body RequestSongList body);

    @POST("top_songs")
    Call<ResponseSongCategoryList> getSongCategoryList(@Body RequestCategoryList body);

    @POST("search_songs")
    Call<ResponseSearchSongResultList> searchSongs(@Body RequestSearch body);

    @POST("autocomplete_songs")
    Call<ResponseAutocomplete> getSearchSongAutocomplete(@Body RequestAutocomplete body);

    //private
    @POST("logout")
    Call<Void> logout(@Body RequestToken body);

    @POST("order_song")
    Call<ResponseOrder> orderSong(@Body RequestSongOrder body);

    @POST("order_status")
    Call<ResponseOrder> orderStatus(@Body RequestOrderStatus body);

    @POST("subscribe")
    Call<Void> pushSubscribe(@Body RequestPush body);
}
