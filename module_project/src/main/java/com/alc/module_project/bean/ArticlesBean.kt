package com.alc.module_project.bean

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
data class ArticlesBean(val apkLink: String?,val author: String?,val chapterId:Int=0,
                        val chapterName: String? = null,
                        var courseId :Int = 0,
                        var desc :String?,
                        var envelopePic: String?,
                        var id :Int = 0,
                        var userId :Int = 0,
                        var originId :Int = -1,
                        var link: String? = null,
                        var niceDate: String? = null,
                        var origin: String? = null,
                        var projectLink: String? = null,
                        var publishTime: Long? = null,
                        var title: String? = null,
                        var visible: Int? = 0,
                        var zan: Int? = null,
                        var fresh: Boolean? = false,
                        val isShowImage :Boolean= true,
                        var navigationName: String? = null,
                        var shareUser: String? = null
){


    // 分类name

}
