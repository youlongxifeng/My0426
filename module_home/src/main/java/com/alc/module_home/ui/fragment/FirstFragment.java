package com.alc.module_home.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alc.lib_common.Constants;
import com.alc.module_home.R;
import com.alc.module_home.base.BaseMainFragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class FirstFragment   extends BaseMainFragment {

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProjectFragment fragment = (ProjectFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
        if (findChildFragment(fragment.getClass()) == null) {
           loadRootFragment(R.id.fl_first_container, fragment.newInstance());
         }
    }

    @Override
    public void lazyInit() {
        super.lazyInit();
    }

    //    @Override
//    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
//        super.onLazyInitView(savedInstanceState);
//
//        if (findChildFragment(FirstHomeFragment.class) == null) {
//            loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
//        }
//    }
}
