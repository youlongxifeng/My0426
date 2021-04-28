package com.alc.module_use.ui.upgrade;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.module_use.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Route(path = Constants.Router.Use.F_UPGRADE)
public class UpgradeFragment extends BaseSupportFragment {
    @Override
    public int getLayoutId() {
        return R.layout.message_fragment;
    }
}
