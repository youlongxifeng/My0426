package com.alc.module_square.ui.square

import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_square.R
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Square.FRAGMENT_SQUARE)
class SquareFragment : BaseSupportFragment() {
    override fun getLayoutId(): Int {
       return R.layout.square_fragment
    }
}