package com.alc.my0426

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alc.my0426.myapp.Nav1Fragment
import com.alc.my0426.myapp.Nav2Fragment
import com.alc.my0426.myapp.Nav3Fragment
import com.alc.my0426.myapp.Nav4Fragment

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/21
 */
class MainFragmentStateAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return Nav1Fragment.getInstance("名字：$position")
            1 -> return Nav2Fragment.getInstance("名字：$position")
            2 -> return Nav3Fragment.getInstance("名字：$position")
            3 -> return Nav4Fragment.getInstance("名字：$position")
            else -> return Nav1Fragment.getInstance("名字：$position")
        }


    }
}