package com.alc.module_project.ui.project;

import com.alc.lib_common.Constants;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.module_project.R;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
@Route(path = Constants.Router.Project.FRAGMENT_PROJECT)
public class ProjectFragment extends BaseSupportFragment {
    public static ProjectFragment newInstance() {
        return new ProjectFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.project_fragment;
    }
}
