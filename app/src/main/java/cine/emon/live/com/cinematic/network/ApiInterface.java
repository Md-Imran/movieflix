package cine.emon.live.com.cinematic.network;


import com.google.gson.JsonObject;

import org.json.JSONObject;

import cine.emon.live.com.cinematic.model.ItemResponse;
import cine.emon.live.com.cinematic.model.UserActivity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterface {
    @GET("emon/content")
    Call<ItemResponse> getItems();


    @GET("emon/category")
    Call<ItemResponse> getCategories();


    @POST("emon/useractivity")
    @FormUrlEncoded
    @Headers({
            "Content-type: application/json"
    })
    Call<UserActivity> postUserActivity(@Body UserActivity body);


    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("emon/useractivity")
    Call<JSONObject> postRawJSON(@Body JSONObject locationPost);
}
