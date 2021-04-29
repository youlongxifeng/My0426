package com.alc.module_project.http

import com.alc.module_project.bean.HomeListBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
interface ApiService {
    /**
     * 玩安卓，首页第二tab 项目；列表
     *
     * @param page 页码，从0开始
     */
    @GET("article/listproject/{page}/json")
    suspend  fun getProjectList(@Path("page") page: Int): HomeListBean
}