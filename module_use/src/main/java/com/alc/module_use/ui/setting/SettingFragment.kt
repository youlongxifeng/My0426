package com.alc.module_use.ui.setting

import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_use.R
import com.alc.module_use.ui.message.MessageFragment
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Use.F_SETTING)
class SettingFragment  : BaseSupportFragment() {
    fun newInstance(): SettingFragment? {
        return SettingFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.message_fragment
    }




}
