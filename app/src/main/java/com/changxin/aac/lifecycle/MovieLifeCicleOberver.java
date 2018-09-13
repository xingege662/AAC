package com.changxin.aac.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MovieLifeCicleOberver implements LifecycleObserver {

    private static final String TAG = "MovieLifeCicleOberver";

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        Log.e(TAG, "onResume: =============>UI显示出来了");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){
        Log.e(TAG,"onStop:=============>UI消失了");
    }
}

