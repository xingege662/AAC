package com.changxin.aac.net.api;


import com.changxin.aac.model.MovieListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET(value = "Showtime/LocationMovies.api")
    public Call<MovieListModel> getMovieInfo(@Query("locationId") String locationId);
}
