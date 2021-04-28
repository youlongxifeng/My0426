package com.alc.module_main.ui.activity.main

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.alc.lib_common.ui.base.BaseSupportFragment
import com.alc.lib_common.uitle.ResUtils
import com.alc.module_main.R
import com.alc.module_official.ui.official.OfficialFragment
import com.alc.module_project.ui.project.ProjectFragment
import com.alc.module_square.ui.square.SquareFragment
import com.alc.module_use.ui.use.UseFragment
import com.weikaiyun.fragmentation.SupportHelper
import kotlinx.android.synthetic.main.fragment_demo_main.*

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class DemoMainFragment : BaseSupportFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_demo_main

    private lateinit var homeFragment: ProjectFragment
    private lateinit var remindFragment: OfficialFragment
    private lateinit var communityFragment: SquareFragment
    private lateinit var mineFragment: UseFragment

    private var currentTab = HOME

    private val iconArr = arrayListOf<Drawable>(
        ResUtils.getDrawable(R.drawable.icon_bottom_homepage),
        ResUtils.getDrawable(R.drawable.icon_bottom_remind),
        ResUtils.getDrawable(R.drawable.icon_bottom_community),
        ResUtils.getDrawable(R.drawable.icon_bottom_mine)
    )
    private val selectedIconArr = arrayListOf<Drawable>(
        ResUtils.getDrawable(R.drawable.icon_bottom_homepage_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_remind_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_community_selected),
        ResUtils.getDrawable(R.drawable.icon_bottom_mine_selected)
    )

    @RequiresApi(Build.VERSION_CODES.M)
    private val textColor = ResUtils.getColor(R.color.color_normal)
    @RequiresApi(Build.VERSION_CODES.M)
    private val selectedTextColor = ResUtils.getColor(R.color.color_selected)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView(view: View, savedInstanceState: Bundle?) {
        val homeFragmentInStack: ProjectFragment? = SupportHelper.findFragment(childFragmentManager, ProjectFragment::class.java)
        if (homeFragmentInStack != null) {
            homeFragment = homeFragmentInStack
            remindFragment = SupportHelper.findFragment(childFragmentManager, OfficialFragment::class.java)
            communityFragment = SupportHelper.findFragment(childFragmentManager, SquareFragment::class.java)
            mineFragment = SupportHelper.findFragment(childFragmentManager, UseFragment::class.java)
        } else {
            homeFragment = ProjectFragment()
            remindFragment = OfficialFragment()
            communityFragment = SquareFragment()
            mineFragment = UseFragment()
            loadMultipleRootFragment(R.id.fl_container, currentTab, homeFragment, remindFragment, communityFragment, mineFragment)
        }

        cl_home.setOnClickListener {
            if (currentTab != HOME) {
                showHideFragment(homeFragment)
                checkTab(HOME)
            }
        }

        cl_remind.setOnClickListener {
            if (currentTab != REMIND) {
                showHideFragment(remindFragment)
                checkTab(REMIND)
            }
        }

        cl_community.setOnClickListener {
            if (currentTab != COMMUNITY) {
                showHideFragment(communityFragment)
                checkTab(COMMUNITY)
            }
        }

        cl_mine.setOnClickListener {
            if (currentTab != MINE) {
                showHideFragment(mineFragment)
                checkTab(MINE)
            }
        }

        checkTab(HOME)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkTab(tab: Int) {
        currentTab = tab
        when(currentTab) {
            HOME -> {
                img_home.setImageDrawable(selectedIconArr[HOME])
                tv_home.setTextColor(selectedTextColor)
                img_remind.setImageDrawable(iconArr[REMIND])
                tv_remind.setTextColor(textColor)
                img_community.setImageDrawable(iconArr[COMMUNITY])
                tv_community.setTextColor(textColor)
                img_mine.setImageDrawable(iconArr[MINE])
                tv_mine.setTextColor(textColor)
            }
            REMIND -> {
                img_home.setImageDrawable(iconArr[HOME])
                tv_home.setTextColor(textColor)
                img_remind.setImageDrawable(selectedIconArr[REMIND])
                tv_remind.setTextColor(selectedTextColor)
                img_community.setImageDrawable(iconArr[COMMUNITY])
                tv_community.setTextColor(textColor)
                img_mine.setImageDrawable(iconArr[MINE])
                tv_mine.setTextColor(textColor)
            }
            COMMUNITY -> {
                img_home.setImageDrawable(iconArr[HOME])
                tv_home.setTextColor(textColor)
                img_remind.setImageDrawable(iconArr[REMIND])
                tv_remind.setTextColor(textColor)
                img_community.setImageDrawable(selectedIconArr[COMMUNITY])
                tv_community.setTextColor(selectedTextColor)
                img_mine.setImageDrawable(iconArr[MINE])
                tv_mine.setTextColor(textColor)
            }
            MINE -> {
                img_home.setImageDrawable(iconArr[HOME])
                tv_home.setTextColor(textColor)
                img_remind.setImageDrawable(iconArr[REMIND])
                tv_remind.setTextColor(textColor)
                img_community.setImageDrawable(iconArr[COMMUNITY])
                tv_community.setTextColor(textColor)
                img_mine.setImageDrawable(selectedIconArr[MINE])
                tv_mine.setTextColor(selectedTextColor)
            }
        }
    }

    companion object {
        const val HOME = 0
        const val REMIND = 1
        const val COMMUNITY = 2
        const val MINE = 3

        @JvmStatic
        fun newInstance(): DemoMainFragment {
            return DemoMainFragment()
        }
    }
}