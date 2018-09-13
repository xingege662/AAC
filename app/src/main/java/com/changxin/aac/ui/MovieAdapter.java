package com.changxin.aac.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.changxin.aac.R;
import com.changxin.aac.model.MovieListModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends Adapter {

    private List<MovieListModel.MovieModel> mDataList = new ArrayList<>();

    private Context mContext;

    public MovieAdapter(Context context) {
        this.mContext = context;
    }

    public void setListData(List<MovieListModel.MovieModel> dataList){
        if(!mDataList.isEmpty()){
            mDataList.clear();
        }
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.movie_item_layout,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MovieViewHolder) {
            ((MovieViewHolder) viewHolder).tvMovie.setText(mDataList.get(i).aN1);
            Glide.with(mContext).load(mDataList.get(i).img).into(((MovieViewHolder) viewHolder).ivMoview);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMovie;
        private ImageView ivMoview;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMovie = itemView.findViewById(R.id.tv_movie);
            ivMoview = itemView.findViewById(R.id.iv_movie);
        }
    }

}
