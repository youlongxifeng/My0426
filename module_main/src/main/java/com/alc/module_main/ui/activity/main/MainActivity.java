package com.alc.module_main.ui.activity.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportActivity;
import com.alc.module_main.R;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.SupportHelper;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/26
 */
@Route(path = Constants.Router.Main.A_MAIN)
public class MainActivity extends BaseSupportActivity {
    @Override
    public int getContentViewID() {
        return R.layout.main_activity;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation(this, new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.d("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.d("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.d("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.d("ARouter", "被拦截了");
            }
        });
        DemoMainFragment mainFragment = SupportHelper.findFragment(getSupportFragmentManager(), DemoMainFragment.class);
        if (mainFragment == null) {
            mainFragment = DemoMainFragment.newInstance();
            loadRootFragment(R.id.container, mainFragment);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

    }
}
