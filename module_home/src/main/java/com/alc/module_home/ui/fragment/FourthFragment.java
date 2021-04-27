package com.alc.module_home.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.alc.lib_common.Constants;
import com.alc.module_home.R;
import com.alc.module_home.base.BaseMainFragment;
import com.alc.module_use.ui.use.UseFragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class FourthFragment  extends BaseMainFragment {
    private Toolbar mToolbar;
    private View mView;

    public static FourthFragment newInstance() {
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_fourth, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UseFragment fragment = (UseFragment) ARouter.getInstance().build(Constants.Router.Use.FRAGMENT_USE).navigation();
        if (findChildFragment(fragment.getClass()) == null) {
            loadRootFragment(R.id.fl_fourth_container, fragment.newInstance());
        }
    }

//    @Override
//    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
//        super.onLazyInitView(savedInstanceState);
//        if (findChildFragment(AvatarFragment.class) == null) {
//            loadFragment();
//        }
//
//        mToolbar = (Toolbar) mView.findViewById(R.id.toolbar);
//        mToolbar.setTitle(R.string.me);
//    }

//    private void loadFragment() {
//        loadRootFragment(R.id.fl_fourth_container_upper, AvatarFragment.newInstance());
//        loadRootFragment(R.id.fl_fourth_container_lower, MeFragment.newInstance());
//    }
//
//    public void onBackToFirstFragment() {
//        _mBackToFirstListener.onBackToFirstFragment();
//    }
}
