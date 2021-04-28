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
public class ThirdFragment  extends BaseMainFragment {

    public static ThirdFragment newInstance() {

        Bundle args = new Bundle();

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SquareFragment fragment = (SquareFragment) ARouter.getInstance().build(Constants.Router.Square.FRAGMENT_SQUARE).navigation();
        if (findChildFragment(fragment.getClass()) == null) {
            loadRootFragment(R.id.fl_third_container, fragment.newInstance());
        }
    }
//    @Override
//    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
//        super.onLazyInitView(savedInstanceState);
//
//        if (findChildFragment(ShopFragment.class) == null) {
//            // ShopFragment是flow包里的
//            loadRootFragment(R.id.fl_third_container, ShopFragment.newInstance());
//        }
//    }
}

