package com.alc.lib_common.uitle

import android.content.Context
import android.net.ConnectivityManager

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class CheckNetwork {
    companion object {

        /**
         * 判断网络是否连通
         */
        public fun isNetworkConnected(context: Context?): Boolean {
            return try {
                if (context != null) {
                    val cm = context
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    val info = cm.activeNetworkInfo
                    info != null && info.isConnected
                } else {
                    /**如果context为空，就返回false，表示网络未连接 */
                    false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }
    }
}