package com.changxin.aac.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.changxin.aac.model.MovieListModel;
import com.changxin.aac.repository.MovieRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends AndroidViewModel {

    //通过LiveData来通知数据的改变，刷新UI的数据
    public MutableLiveData<MovieListModel> mutableLiveData = new MutableLiveData<>();

    private Application mApplication;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        this.mApplication = application;
    }

    public void getMovieListModel(){
        //ViewModel中获取数据
        MovieRepository.getInstance().getMovieListModel().enqueue(new Callback<MovieListModel>() {
            @Override
            public void onResponse(Call<MovieListModel> call, Response<MovieListModel> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieListModel> call, Throwable t) {
                Toast.makeText(mApplication,"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
