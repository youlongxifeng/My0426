package com.alc.my0426.myapp

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.alc.my0426.MainFragmentStateAdapter
import com.alc.my0426.R
import com.alc.my0426.base.BaseFragment
import com.alc.my0426.eventbus.MessageEvent
import com.alc.my0426.utils.MyUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
class MainFragment : BaseFragment() {
    lateinit var mMainFragmentStateAdapter: MainFragmentStateAdapter;
    lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mViewPager2: ViewPager2
    var img_menu =
        intArrayOf(
            R.mipmap.img_util,
            R.mipmap.img_view,
            R.mipmap.img_other,
            R.mipmap.img_resources
        )
    companion object{
        public   fun  getInstance(value: String): MainFragment {
            var homeFragment: MainFragment = MainFragment()
            var bundle: Bundle = Bundle()
            bundle.putString("name", value)
            homeFragment.arguments=bundle
            return homeFragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return super.onCreateView(inflater, container, savedInstanceState)
        var view: View =inflater.inflate(R.layout.main_fragmeng, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBottomNavigationView=view.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        mViewPager2=view.findViewById(R.id.view_page2)
        // Navigation.findNavController(text_name).navigate(R.id.action_nav1Fragment_to_nav2Fragment2,parms);
        val menus: List<String>? = MyUtils.getArray(activity?.baseContext, R.array.bottom_menu)
        val menu: Menu = mBottomNavigationView.menu
        for (i in menus!!.indices) {
            menu.add(1, i, i, menus.get(i))
            val item = menu.findItem(i)
            item.setIcon(img_menu[i])
        }
        mBottomNavigationView.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    0 -> mViewPager2.currentItem = 0
                    1 -> mViewPager2.currentItem = 1
                    2 -> mViewPager2.currentItem = 2
                    3 -> mViewPager2.currentItem = 3
                    4 -> mViewPager2.currentItem = 4
                }
                return true
            }
        })

        mMainFragmentStateAdapter = MainFragmentStateAdapter(activity as AppCompatActivity)
        mViewPager2.adapter = mMainFragmentStateAdapter
        //是否可滑动
        mViewPager2.isUserInputEnabled = false
        mViewPager2.offscreenPageLimit = menus.size

        mViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                mBottomNavigationView.selectedItemId = position
            }
        })

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    override fun onMessageEvent(event: MessageEvent?) { /* Do something */
        Log.i("YYY", "onMessageEvent== MainFragment")
        mViewPager2.currentItem = 0
    }
}


