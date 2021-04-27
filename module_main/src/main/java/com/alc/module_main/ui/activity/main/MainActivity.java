package com.alc.module_main.ui.activity.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportActivity;
import com.alc.module_main.R;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.weikaiyun.fragmentation.ISupportFragment;
import com.weikaiyun.fragmentation.SupportFragment;
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
        ISupportFragment mainFragment = SupportHelper.findFragment(getSupportFragmentManager(), Main2Fragment.class);
        if (mainFragment == null) {
            mainFragment = Main2Fragment.newInstance();
            loadRootFragment(R.id.container, mainFragment);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

    }
}
