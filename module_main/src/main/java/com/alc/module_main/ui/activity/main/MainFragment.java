package com.alc.module_main.ui.activity.main;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alc.lib_common.Constants;
import com.alc.lib_common.common.event.KeyCode;
import com.alc.lib_common.ui.base.BaseSupportFragment;
import com.alc.lib_common.uitle.ResUtils;
import com.alc.lib_common.uitle.RouteHelper;
import com.alc.module_main.R;
import com.alc.module_official.ui.official.OfficialFragment;
import com.alc.module_project.ui.project.ProjectFragment;
import com.alc.module_square.ui.square.SquareFragment;
import com.alc.module_use.ui.use.UseFragment;
import com.alibaba.android.arouter.launcher.ARouter;
import com.weikaiyun.fragmentation.SupportHelper;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/27
 */
public class MainFragment extends BaseSupportFragment implements View.OnClickListener {
    private static final int HOME = 0;
    private static final int REMIND = 1;
    private static final int COMMUNITY = 2;
    private static final int MINE = 3;

    ImageView img_home;
    TextView tv_home;

    ImageView img_remind;
    TextView tv_remind;

    ImageView img_community;
    TextView tv_community;

    ImageView img_mine;
    TextView tv_mine;
    ConstraintLayout cl_home, cl_community, cl_remind, cl_mine;
    private ProjectFragment projectFragment;
    private OfficialFragment officialFragment;
    private SquareFragment squareFragment;
    private UseFragment useFragment;

    private int currentTab = HOME;

    private Drawable[] iconArr = {ResUtils.getDrawable(R.drawable.icon_bottom_homepage),
            ResUtils.getDrawable(R.drawable.icon_bottom_remind),
            ResUtils.getDrawable(R.drawable.icon_bottom_community),
            ResUtils.getDrawable(R.drawable.icon_bottom_mine)};
    private Drawable[] selectedIconArr = {
            ResUtils.getDrawable(R.drawable.icon_bottom_homepage_selected),
            ResUtils.getDrawable(R.drawable.icon_bottom_remind_selected),
            ResUtils.getDrawable(R.drawable.icon_bottom_community_selected),
            ResUtils.getDrawable(R.drawable.icon_bottom_mine_selected)};


    private int textColor = ResUtils.getColor(R.color.color_normal);

    private int selectedTextColor = ResUtils.getColor(R.color.color_selected);

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {

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
        img_home = view.findViewById(R.id.img_home);
        tv_home = view.findViewById(R.id.tv_home);
        img_remind = view.findViewById(R.id.img_remind);
        tv_remind = view.findViewById(R.id.tv_remind);
        img_community = view.findViewById(R.id.img_community);
        tv_community = view.findViewById(R.id.tv_community);
        img_mine = view.findViewById(R.id.img_mine);
        tv_mine = view.findViewById(R.id.tv_mine);
        cl_community = view.findViewById(R.id.cl_community);
        cl_community.setOnClickListener(this);
        cl_home = view.findViewById(R.id.cl_home);
        cl_home.setOnClickListener(this);
        cl_remind = view.findViewById(R.id.cl_remind);
        cl_remind.setOnClickListener(this);
        cl_mine = view.findViewById(R.id.cl_mine);
        cl_mine.setOnClickListener(this);
        ProjectFragment homeFragmentInStack = (ProjectFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
        if (homeFragmentInStack != null) {
            projectFragment = homeFragmentInStack;
            officialFragment = SupportHelper.findFragment(getChildFragmentManager(), OfficialFragment.class);
            squareFragment = SupportHelper.findFragment(getChildFragmentManager(), SquareFragment.class);
            useFragment = SupportHelper.findFragment(getChildFragmentManager(), UseFragment.class);
        } else {
            projectFragment = (ProjectFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
            officialFragment = (OfficialFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
            squareFragment = (SquareFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
            useFragment = (UseFragment) ARouter.getInstance().build(Constants.Router.Project.FRAGMENT_PROJECT).navigation();
            loadMultipleRootFragment(R.id.fl_container, currentTab, projectFragment, officialFragment, squareFragment, useFragment);
        }
    }


    private void checkTab(int tab) {
        currentTab = tab;
        if (currentTab == HOME) {
            img_home.setImageDrawable(selectedIconArr[HOME]);
            tv_home.setTextColor(selectedTextColor);
            img_remind.setImageDrawable(iconArr[REMIND]);
            tv_remind.setTextColor(textColor);
            img_community.setImageDrawable(iconArr[COMMUNITY]);
            tv_community.setTextColor(textColor);
            img_mine.setImageDrawable(iconArr[MINE]);
            tv_mine.setTextColor(textColor);
        } else if (currentTab == REMIND) {
            img_home.setImageDrawable(iconArr[HOME]);
            tv_home.setTextColor(textColor);
            img_remind.setImageDrawable(selectedIconArr[REMIND]);
            tv_remind.setTextColor(selectedTextColor);
            img_community.setImageDrawable(iconArr[COMMUNITY]);
            tv_community.setTextColor(textColor);
            img_mine.setImageDrawable(iconArr[MINE]);
            tv_mine.setTextColor(textColor);
        } else if (currentTab == COMMUNITY) {
            img_home.setImageDrawable(iconArr[HOME]);
            tv_home.setTextColor(textColor);
            img_remind.setImageDrawable(iconArr[REMIND]);
            tv_remind.setTextColor(textColor);
            img_community.setImageDrawable(selectedIconArr[COMMUNITY]);
            tv_community.setTextColor(selectedTextColor);
            img_mine.setImageDrawable(iconArr[MINE]);
            tv_mine.setTextColor(textColor);
        } else if (currentTab == MINE) {
            img_home.setImageDrawable(iconArr[HOME]);
            tv_home.setTextColor(textColor);
            img_remind.setImageDrawable(iconArr[REMIND]);
            tv_remind.setTextColor(textColor);
            img_community.setImageDrawable(iconArr[COMMUNITY]);
            tv_community.setTextColor(textColor);
            img_mine.setImageDrawable(selectedIconArr[MINE]);
            tv_mine.setTextColor(selectedTextColor);
        }


    }

    @Override
    public void onClick(View v) {
        //cl_home, cl_community,  cl_remind, cl_mine
        if (v.getId() == R.id.cl_home) {
            if (currentTab != HOME) {
                showHideFragment(projectFragment);
                checkTab(HOME);
            }
        } else if (v.getId() == R.id.cl_community) {
            showHideFragment(officialFragment);
            checkTab(REMIND);
        } else if (v.getId() == R.id.cl_remind) {
            showHideFragment(squareFragment);
            checkTab(COMMUNITY);
        } else if (v.getId() == R.id.cl_mine) {
            showHideFragment(useFragment);
            checkTab(MINE);
        }


    }
}
