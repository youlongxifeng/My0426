package com.alc.my0426

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.alc.my0426.base.BaseActivity
import com.alc.my0426.eventbus.MessageEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.greenrobot.eventbus.EventBus


/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
class Main2Acitivity : BaseActivity()  {
    var exitTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val nav = Navigation.findNavController(
                    this@Main2Acitivity,
                    R.id.nav_host_fragment_container
                )
                if (nav.currentDestination != null && nav.currentDestination!!.id != R.id.mainfragment) {
                    //如果当前界面不是主页，那么直接调用返回即可
                    Log.i("YYY", "nav.currentDestination!!.id==${nav.currentDestination!!.id}")
                    nav.navigateUp()
                } else {
                    Log.i("YYY", "nav.currentDestination!!.id==${(nav.currentDestination!!.id != R.id.nav1Fragment)}")

                    if (nav.currentDestination!!.id != R.id.nav1Fragment) {
                        EventBus.getDefault().post(MessageEvent())
                    } else {

                        //是主页
                        if (System.currentTimeMillis() - exitTime > 2000) {
                            //  ToastUtils.showShort("再按一次退出程序")
                            Toast.makeText(this@Main2Acitivity, "再按一次退出程序", Toast.LENGTH_LONG)
                                .show()
                            exitTime = System.currentTimeMillis()
                        } else {
                            finish()
                        }
                    }
                }
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}