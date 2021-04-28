package com.alc.module_official.ui.official

import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_official.R
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Official.FRAGMENT_OFFICIAL)
class OfficialFragment :  BaseSupportFragment() {
    override fun getLayoutId(): Int {
        return R.layout.official_fragment
    }
}