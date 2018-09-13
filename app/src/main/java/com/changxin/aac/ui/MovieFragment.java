package com.changxin.aac.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changxin.aac.R;
import com.changxin.aac.lifecycle.MovieLifeCicleOberver;
import com.changxin.aac.model.MovieListModel;
import com.changxin.aac.viewModel.MovieViewModel;

public class MovieFragment extends Fragment {

    private MovieAdapter mMoviewAdapter;
    private MovieViewModel mMovieViewModel;
    public static MovieFragment newInstance(){
        MovieFragment movieFragment = new MovieFragment();
        return movieFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mMoviewAdapter = new MovieAdapter(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mMoviewAdapter);
        //获取ViewModel,ViewModel只获取一次，如果已经存在，则返回上一次的ViewModel
        mMovieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        //绑定观察者对象到ViewModel
        subscribeData();
        mMovieViewModel.getMovieListModel();
        getLifecycle().addObserver(new MovieLifeCicleOberver());

    }

    private void subscribeData() {
        mMovieViewModel.mutableLiveData.observe(this, new Observer<MovieListModel>() {
            @Override
            public void onChanged(@Nullable MovieListModel movieListModel) {
                //当数据变化时通知到UI的观察者来刷新数据
                mMoviewAdapter.setListData(movieListModel.ms);
            }
        });
    }
}
