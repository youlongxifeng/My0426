package com.alc.my0426.base

import androidx.fragment.app.Fragment
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
open class BaseFragment :Fragment() {
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    open  fun onMessageEvent(event: MessageEvent?) { /* Do something */

    }
}