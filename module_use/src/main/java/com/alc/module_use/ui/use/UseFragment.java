package com.alc.module_use.ui.use;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.module_use.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
@Route(path = Constants.Router.Use.FRAGMENT_USE)
public class UseFragment  extends BaseSupportFragment {
    public static UseFragment newInstance() {
        return new UseFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.use_fragment;
    }
}
