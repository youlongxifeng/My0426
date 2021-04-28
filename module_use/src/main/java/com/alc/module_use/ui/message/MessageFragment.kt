package com.alc.module_use.ui.message

import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_use.R
import com.alc.module_use.ui.use.UseFragment
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
@Route(path = Constants.Router.Use.F_MESSAGE)
class MessageFragment  : BaseSupportFragment() {
    fun newInstance(): MessageFragment? {
        return MessageFragment()
    }

    override fun getLayoutId(): Int {
      return R.layout.message_fragment
    }




}
