package com.changxin.aac.net.retrofit;

import com.changxin.aac.net.ConstantKey;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private Retrofit mRetrofit;

    private RetrofitManager() {

    }

    public static class InnerInstance {
        public static RetrofitManager instance = new RetrofitManager();
    }


    public static RetrofitManager getInstance() {

        return InnerInstance.instance;
    }

    public Retrofit getRetrofitInstance() {
        if (null == mRetrofit) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ConstantKey.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
