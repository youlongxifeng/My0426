package com.alc.lib_common;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.alc.lib_third.third.ThirdHelper;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/26
 */
public class BaseApplication extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ThirdHelper.getInstance(this)
                .initRouter()
              //  .initBugly(false)
              .initCrashView();
            //    .initUM();
    }
}
