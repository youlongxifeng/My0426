package com.alc.lib_common.uitle;

import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;

import com.alc.lib_common.BaseApplication;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class ResUtils {
    public static Drawable getDrawable(int resId) {
        return AppCompatResources.getDrawable(BaseApplication.getInstance(), resId);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static int getColor(int resId) {
        return BaseApplication.getInstance().getColor(resId);
    }
}
