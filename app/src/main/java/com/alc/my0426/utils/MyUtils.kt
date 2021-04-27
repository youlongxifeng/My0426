package com.alc.my0426.utils

import android.content.Context

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
class MyUtils {

    companion object {
        /**
         * 获取数组
         * @param activity
         * @param a
         * @return
         */
        fun getArray(activity: Context?, a: Int): List<String>? {
//        val lists = ArrayList<String>()
//        lists.addAll(listOf(*activity!!.resources.getStringArray(a)))
            return listOf(*activity!!.resources.getStringArray(a))
        }
    }

}