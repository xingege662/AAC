package com.changxin.aac.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.changxin.aac.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //防止重复创建
        if (null == savedInstanceState) {
            MovieFragment movieFragment = MovieFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content,movieFragment)
                    .commit();
        }
    }
}
