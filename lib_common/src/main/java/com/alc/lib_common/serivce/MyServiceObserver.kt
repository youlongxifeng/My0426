package com.alc.lib_common.serivce

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/29
 */
class MyServiceObserver: LifecycleObserver {

    
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun initVideo() {
       
        Log.d("TAG", "initVideo")
    }
}