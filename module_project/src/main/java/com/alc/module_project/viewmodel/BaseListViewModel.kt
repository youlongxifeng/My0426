package com.alc.module_project.viewmodel

import android.app.Application
import com.alc.module_project.base.mvvm.BaseViewModel

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
open class BaseListViewModel(application: Application) : BaseViewModel(application) {
    var mPage = 0

    open fun getPage(): Int {
        return mPage
    }

    open fun setPage(mPage: Int) {
        this.mPage = mPage
    }
}
