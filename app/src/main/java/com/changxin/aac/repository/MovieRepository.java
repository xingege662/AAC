package com.changxin.aac.repository;

import com.changxin.aac.model.MovieListModel;
import com.changxin.aac.net.api.MovieApi;
import com.changxin.aac.net.retrofit.RetrofitManager;

import retrofit2.Call;

public class MovieRepository {


    public static final String LOCATION_ID = "290";

    static class  MovieRepositoryInstance{
        static MovieRepository mInstance = new MovieRepository();
    }

    public static MovieRepository getInstance(){
        return MovieRepositoryInstance.mInstance;
    }

    public Call<MovieListModel> getMovieListModel(){
        return RetrofitManager.getInstance().getRetrofitInstance().create(MovieApi.class).getMovieInfo(LOCATION_ID);
    }
}
