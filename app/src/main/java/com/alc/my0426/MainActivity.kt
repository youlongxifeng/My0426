package com.alc.my0426

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2;

class MainActivity : AppCompatActivity() {
    lateinit var mview_page: ViewPager2;
    lateinit var mMainFragmentStateAdapter: MainFragmentStateAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mview_page = findViewById(R.id.view_page)
        mMainFragmentStateAdapter = MainFragmentStateAdapter(this)
        mview_page.adapter = mMainFragmentStateAdapter
        //是否可滑动
        mview_page.isUserInputEnabled = true
        mview_page.offscreenPageLimit = 5
        var list = listOf<String>("1", "2")
        var list2: MutableList<String> = mutableListOf()
        println("=====$list")
        for (i in list) {
            println("=====$i")
            list2.add(i)
        }

    }


}