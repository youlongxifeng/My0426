package com.alc.module_project.http

import com.alc.module_project.bean.HomeListBean
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class HttpClient {
    object Builder {
        fun getWanAndroidServer():  HttpClient? {
            return BuildFactory.getInstance()!!
                .create(
                  HttpClient::class.java,
                    HttpUtils.API_WAN_ANDROID
                )
        }
    }


}