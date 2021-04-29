package com.alc.module_project.base.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
open class BaseViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var mCompositeDisposable: CompositeDisposable
    protected fun addDisposable(disposable: Disposable?) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed) {
            mCompositeDisposable.clear()
        }
    }
}