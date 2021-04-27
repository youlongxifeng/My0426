package com.alc.module_home.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.alc.module_home.R;
import com.alc.module_home.base.BaseMainFragment;

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

//    @Override
//    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
//        super.onLazyInitView(savedInstanceState);
//
//        if (findChildFragment(FirstHomeFragment.class) == null) {
//            loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
//        }
//    }
}
