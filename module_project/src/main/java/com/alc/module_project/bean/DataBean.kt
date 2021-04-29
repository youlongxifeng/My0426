package com.alc.module_project.bean

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
data class DataBean(val curPage:Int=0,
                    val offset:Int=0,
                    val pageCount:Int=0,
                    val size:Int=0,
                    val total:Int=0,
                    val datas: List<ArticlesBean>? = null){

}
