package com.alc.module_use.ui.use

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_use.R
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.weikaiyun.fragmentation.ISupportFragment
import kotlinx.android.synthetic.main.use_fragment.*

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Use.FRAGMENT_USE)
class UseFragment : BaseSupportFragment() {
    override fun getLayoutId(): Int {
        return R.layout.use_fragment
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
       var fragment= mRouter.build(Constants.Router.Use.F_UPGRADE).navigation()
        ARouter.getInstance().build(Constants.Router.Use.F_UPGRADE)
            .navigation(activity, object : NavCallback() {
                override fun onFound(postcard: Postcard) {
                    Log.d("ARouter", "找到了")
                }

                override fun onLost(postcard: Postcard) {
                    Log.d("ARouter", "找不到了")
                }

                override fun onArrival(postcard: Postcard) {
                    Log.d("ARouter", "跳转完了")
                }

                override fun onInterrupt(postcard: Postcard) {
                    Log.d("ARouter", "被拦截了")
                }
            })
        image_view.setOnClickListener(View.OnClickListener {
            Log.d("ARouter", "被拦截了444444")
            _mActivity.start(fragment as ISupportFragment?)
            Log.d("ARouter", "被拦截了555555")
        })
    }
}