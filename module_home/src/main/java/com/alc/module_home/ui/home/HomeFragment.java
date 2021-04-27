package com.alc.module_home.ui.home;

import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.module_home.R;
import com.weikaiyun.fragmentation.ISupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class HomeFragment extends BaseSupportFragment {
    public static ISupportFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }
}
