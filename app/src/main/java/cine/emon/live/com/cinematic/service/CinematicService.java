package cine.emon.live.com.cinematic.service;

import java.util.List;

import cine.emon.live.com.cinematic.model.Movie;
import cine.emon.live.com.cinematic.model.UserActivity;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CinematicService {

    @GET("users/{user}/repos")
    Call<List<Movie>> listRepos(@Path("user") String user);

    @GET("movie/top_rated")
    Call<Movie> getTopRatedMovies(@Query("api_key") String apiKey);



    @POST("emon/useractivity")
    @FormUrlEncoded
    Call<UserActivity> postUserActivity(@Field("userId") String userId,
                                        @Field("contentId") String contentId,
                                        @Field("viewTime") String viewTime);

  /*  @GET("group/{id}/users")

    Call<List<User>> groupList(@Path("id") int groupId);
*/


}
