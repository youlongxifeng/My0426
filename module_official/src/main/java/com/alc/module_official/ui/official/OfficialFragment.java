package com.alc.module_official.ui.official;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.module_official.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
@Route(path = Constants.Router.Official.FRAGMENT_OFFICIAL)
public class OfficialFragment  extends BaseSupportFragment {
    public static OfficialFragment newInstance() {
        return new OfficialFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.official_fragment;
    }
}
