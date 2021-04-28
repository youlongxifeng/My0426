package com.alc.module_project.base
import android.app.Activity
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.lib_common.uitle.ClassUtil
import com.alc.module_project.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
abstract class BaseFragment<VM : AndroidViewModel?, SV : ViewDataBinding?> :
    BaseSupportFragment() {
    // ViewModel
    protected var viewModel: VM? = null

    // 布局view
    protected var bindingView: SV? = null

    // fragment是否显示了
    protected var mIsVisible = false

    // 加载中
    private var loadingView: View? = null

    // 加载失败
    private var errorView: View? = null

    // 空布局
    private var emptyView: View? = null

    // 动画
    private var mAnimationDrawable: AnimationDrawable? = null
    private var mCompositeDisposable: CompositeDisposable? = null
    private lateinit var activity: Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate: View = inflater.inflate(R.layout.fragment_base, null)
        bindingView = DataBindingUtil.inflate(activity.layoutInflater, setContent(), null, false)
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        bindingView?.getRoot()?.layoutParams = params
        val mContainer = inflate.findViewById<RelativeLayout>(R.id.container)
        mContainer.addView(bindingView?.getRoot())
        bindingView?.getRoot()?.visibility = View.GONE
        return inflate
    }

    /**
     * 在这里实现Fragment数据的缓加载.
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint) {
            mIsVisible = true
            onVisible()
        } else {
            mIsVisible = false
            onInvisible()
        }
    }

    override fun onInvisible() {
        super.onInvisible()
    }

    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected fun loadData() {}
    override fun onVisible() {
        loadData()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    /**
     * 初始化ViewModel
     */
    private fun initViewModel() {
        val viewModelClass: Class<VM>? = ClassUtil.getViewModel(activity.application)
        if (viewModelClass != null) {
            viewModel = ViewModelProvider(this)[viewModelClass]
        }
    }

    protected fun <T : View?> getView(id: Int): T {
        return view?.findViewById<View>(id) as T
    }

    /**
     * 布局
     */
    abstract fun setContent(): Int

    /**
     * 加载失败后点击后的操作
     */
    protected fun onRefresh() {}

    /**
     * 显示加载中状态
     */
    protected fun showLoading() {
        val viewStub = getView<ViewStub>(R.id.vs_loading)
        if (viewStub != null) {
            loadingView = viewStub.inflate()
            val img = loadingView?.findViewById<ImageView>(R.id.img_progress)
            mAnimationDrawable = img?.drawable as AnimationDrawable
        }
        if (loadingView != null && loadingView!!.visibility != View.VISIBLE) {
            loadingView!!.visibility = View.VISIBLE
        }
        // 开始动画
        if (mAnimationDrawable != null && !mAnimationDrawable!!.isRunning) {
            mAnimationDrawable!!.start()
        }
        if (bindingView!!.root.visibility != View.GONE) {
            bindingView!!.root.visibility = View.GONE
        }
        if (errorView != null) {
            errorView!!.visibility = View.GONE
        }
        if (emptyView != null && emptyView!!.visibility != View.GONE) {
            emptyView!!.visibility = View.GONE
        }
    }

    /**
     * 加载完成的状态
     */
    protected fun showContentView() {
        if (bindingView!!.root.visibility != View.VISIBLE) {
            bindingView!!.root.visibility = View.VISIBLE
        }
        if (loadingView != null && loadingView!!.visibility != View.GONE) {
            loadingView!!.visibility = View.GONE
        }
        // 停止动画
        if (mAnimationDrawable != null && mAnimationDrawable!!.isRunning) {
            mAnimationDrawable!!.stop()
        }
        if (errorView != null) {
            errorView!!.visibility = View.GONE
        }
        if (emptyView != null && emptyView!!.visibility != View.GONE) {
            emptyView!!.visibility = View.GONE
        }
    }

    /**
     * 加载失败点击重新加载的状态
     */
    protected fun showError() {
        val viewStub = getView<ViewStub>(R.id.vs_error_refresh)
        if (viewStub != null) {
            errorView = viewStub.inflate()
            // 点击加载失败布局
            errorView?.setOnClickListener(View.OnClickListener {
                showLoading()
                onRefresh()
            })
        }
        if (errorView != null) {
            errorView!!.visibility = View.VISIBLE
        }
        if (loadingView != null && loadingView!!.visibility != View.GONE) {
            loadingView!!.visibility = View.GONE
        }
        // 停止动画
        if (mAnimationDrawable != null && mAnimationDrawable!!.isRunning) {
            mAnimationDrawable!!.stop()
        }
        if (bindingView!!.root.visibility != View.GONE) {
            bindingView!!.root.visibility = View.GONE
        }
        if (emptyView != null && emptyView!!.visibility != View.GONE) {
            emptyView!!.visibility = View.GONE
        }
    }

    protected fun showEmptyView(text: String?) {
        // 需要这样处理，否则二次显示会失败
        val viewStub = getView<ViewStub>(R.id.vs_empty)
        if (viewStub != null) {
            emptyView = viewStub.inflate()
            (emptyView?.findViewById<View>(R.id.tv_tip_empty) as TextView).text = text
        }
        if (emptyView != null) {
            emptyView!!.visibility = View.VISIBLE
        }
        if (loadingView != null && loadingView!!.visibility != View.GONE) {
            loadingView!!.visibility = View.GONE
        }
        // 停止动画
        if (mAnimationDrawable != null && mAnimationDrawable!!.isRunning) {
            mAnimationDrawable!!.stop()
        }
        if (errorView != null) {
            errorView!!.visibility = View.GONE
        }
        if (bindingView != null && bindingView!!.root.visibility != View.GONE) {
            bindingView!!.root.visibility = View.GONE
        }
    }

    fun addSubscription(disposable: Disposable?) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable!!.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable!!.clear()
        }
    }

    fun removeDisposable() {
        if (mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable!!.dispose()
        }
    }
}
