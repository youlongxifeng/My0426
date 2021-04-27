package com.alc.module_main.ui.activity.main

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.module_main.R
import com.alc.module_main.ui.activity.adapter.MainFragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
class Main2Fragment : BaseSupportFragment() {
    lateinit var mview_page: ViewPager2;
    lateinit var mTabLayout: TabLayout ;
    lateinit var mMainFragmentStateAdapter: MainFragmentStateAdapter

    companion object {
        const val HOME = 0
        const val REMIND = 1
        const val COMMUNITY = 2
        const val MINE = 3

        @JvmStatic
        fun newInstance(): Main2Fragment {
            return Main2Fragment()
        }
    }

    private val tabs = arrayOf(
        "项目" to R.drawable.icon_bottom_homepage,
        "商场" to R.drawable.icon_bottom_remind,
        "我的" to R.drawable.icon_bottom_community,
        "我的" to R.drawable.icon_bottom_mine
    )

    override fun getLayoutId(): Int {
         return R.layout.main2_fragment;
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        super.initView(view, savedInstanceState)
        mview_page = view.findViewById(R.id.view_page)
        mTabLayout=view.findViewById(R.id.tabLayout)
        mMainFragmentStateAdapter = activity?.let { MainFragmentStateAdapter(it) }!!
        mview_page.adapter = mMainFragmentStateAdapter
        //是否可滑动
        mview_page.isUserInputEnabled = true
        mview_page.offscreenPageLimit = 5

        TabLayoutMediator(
            mTabLayout, mview_page
        ) { tab, position -> tab.setText(tabs.get(position).first) }.attach()
    }
}