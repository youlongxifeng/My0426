package com.alc.module_main.ui.activity.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alc.lib_common.Constants
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
class MainFragmentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
      return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT)
                .navigation() as Fragment
            1 -> return ARouter.getInstance().build(Constants.Router.Official.FRAGMENT_OFFICIAL)
                .navigation()as Fragment
            2 -> return ARouter.getInstance().build(Constants.Router.Square.FRAGMENT_SQUARE)
                .navigation()as Fragment
            3 -> return ARouter.getInstance().build(Constants.Router.Use.FRAGMENT_USE)
                .navigation()as Fragment
            else -> return ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT)
                .navigation()as Fragment}
    }
}