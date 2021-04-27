package com.alc.my0426.base

import androidx.appcompat.app.AppCompatActivity
import com.alc.my0426.eventbus.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/23
 */
open class BaseActivity :AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onMessageEvent(event: MessageEvent?) { /* Do something */

    }
}