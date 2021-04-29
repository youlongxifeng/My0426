package com.alc.module_project.ui.project

import androidx.recyclerview.widget.RecyclerView
import com.alc.lib_common.Constants
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_project.R
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Project.FRAGMENT_PROJECT)
class ProjectFragment : BaseSupportFragment() {
    lateinit var demo: RecyclerView
    override fun getLayoutId(): Int {
        return R.layout.project_fragment
    }
}