package com.alc.module_project.http

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class BuildFactory {
    private var instance: BuildFactory? = null
    private var gankHttps: Any? = null
    private var doubanHttps: Any? = null
    private var dongtingHttps: Any? = null
    private var firHttps: Any? = null
    private var wanAndroidHttps: Any? = null
    private var qsbkHttps: Any? = null
    private var mtimeHttps: Any? = null
    private var mtimeTicketHttps: Any? = null

    fun getInstance(): BuildFactory? {
        if (instance == null) {
            synchronized(BuildFactory::class.java) {
                if (instance == null) {
                    instance = BuildFactory()
                }
            }
        }
        return instance
    }
    fun <T> create(a: Class<T>?, type: String?): T {
        return when (type) {
            HttpUtils.API_GANKIO -> {
                if (gankHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (gankHttps == null) {
                            gankHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                gankHttps as T
            }
            HttpUtils.API_DOUBAN -> {
                if (doubanHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (doubanHttps == null) {
                            doubanHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                doubanHttps as T
            }
            HttpUtils.API_TING -> {
                if (dongtingHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (dongtingHttps == null) {
                            dongtingHttps =
                                HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                dongtingHttps as T
            }
            HttpUtils.API_GITEE -> {
                if (firHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (firHttps == null) {
                            firHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                firHttps as T
            }
            HttpUtils.API_WAN_ANDROID -> {
                if (wanAndroidHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (wanAndroidHttps == null) {
                            wanAndroidHttps =
                                HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                wanAndroidHttps as T
            }
            HttpUtils.API_QSBK -> {
                if (qsbkHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (qsbkHttps == null) {
                            qsbkHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                qsbkHttps as T
            }
            HttpUtils.API_MTIME -> {
                if (mtimeHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (mtimeHttps == null) {
                            mtimeHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                mtimeHttps as T
            }
            HttpUtils.API_MTIME_TICKET -> {
                if (mtimeTicketHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (mtimeTicketHttps == null) {
                            mtimeTicketHttps =
                                HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                mtimeTicketHttps as T
            }
            else -> {
                if (gankHttps == null) {
                    synchronized(BuildFactory::class.java) {
                        if (gankHttps == null) {
                            gankHttps = HttpUtils.getInstance().getBuilder(type).build().create(a)
                        }
                    }
                }
                gankHttps as T
            }
        }
    }
}