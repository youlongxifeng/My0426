package com.alc.module_main.ui.activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alc.lib_common.Constants;
import com.alc.lib_common.common.event.KeyCode;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.lib_common.uitle.RouteHelper;
import com.alc.module_main.R;
import com.weikaiyun.fragmentation.ISupportFragment;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class MainFragment extends BaseSupportFragment implements View.OnClickListener {
    private Button mButton;
    public static ISupportFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void initData(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initData(view, savedInstanceState);
    }

    @Override
    public void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mButton=view.findViewById(R.id.btn_home);
        Log.i("YYY","mButton=="+(mButton==null));
        //mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_home) {
            RouteHelper.navigateTo(mRouter.build(Constants.Router.Home.F_MAIN)
                    .withString(KeyCode.Discover.PATH, v.getTag().toString()));
        }
    }
}
