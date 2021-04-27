package com.alc.lib_common.uitle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: Thomas.<br/>
 * Date: 2019/10/24 15:25<br/>
 * GitHub: https://github.com/TanZhiL<br/>
 * CSDN: https://blog.csdn.net/weixin_42703445<br/>
 * Email: 1071931588@qq.com<br/>
 * Description:页面跳转
 */
public class RouteHelper {
    private static final String TAG = "RouterUtil";
    public static void navigateTo(String path) {
//        navigateTo(ARouter.getInstance().build(path));
        navigateTo(ARouter.getInstance().build(path));
    }

    public static void navigateTo(Postcard postcard) {
       /* if (Constants.Router.Home.F_PLAY_TRACK.equals(postcard.getPath())){
            postcard.withTransition(com.gykj.zhumulangma.common.R.anim.push_bottom_in
                    ,com.gykj.zhumulangma.common.R.anim.push_bottom_out);
        }*/
        postcard.navigation();
    }

    public static void navigateTo(String path, int launchMode) {
        navigateTo(ARouter.getInstance().build(path), launchMode);
    }

    public static void navigateTo(Postcard postcard, int launchMode) {
        navigateTo(postcard);
//        navigateTo(postcard, launchMode, null);
    }

 /*   public static void navigateTo(String path, ExtraTransaction extraTransaction) {
        navigateTo(ARouter.getInstance().build(path), extraTransaction);
    }

    public static void navigateTo(Postcard postcard, ExtraTransaction extraTransaction) {
        navigateTo(postcard, ISupportFragment.SINGLETASK, extraTransaction);
    }

    public static void navigateTo(String path, int launchMode, ExtraTransaction extraTransaction) {
        navigateTo(ARouter.getInstance().build(path), launchMode, extraTransaction);
    }

    public static void navigateTo(Postcard postcard, int launchMode, ExtraTransaction extraTransaction) {
        Object navigation = postcard.navigation();
        NavigateBean navigateBean = new NavigateBean(postcard.getPath(), (SupportFragment) navigation);
        navigateBean.launchMode = launchMode;
        navigateBean.extraTransaction = extraTransaction;
        if (null != navigation) {
            EventBus.getDefault().post(new ActivityEvent(EventCode.Main.NAVIGATE, navigateBean));
        }
    }

    *//**
     * 分发路由
     *
     * @param activity
     * @param navigateBean
     *//*
    public static void dispatcher(SupportActivity activity, NavigateBean navigateBean) {
        Objects.requireNonNull(navigateBean);
        Objects.requireNonNull(navigateBean.fragment);
        switch (navigateBean.path) {
            case Constants.Router.User.F_MESSAGE:
                //登录拦截
                if (!AccessTokenManager.getInstanse().hasLogin()) {
                    LoginHelper.getInstance().login(activity);
                } else {
                    activity.start(navigateBean.fragment);
                }
                break;
            case Constants.Router.Home.F_PLAY_TRACK:
            case Constants.Router.Home.F_PLAY_RADIIO:
                activity.extraTransaction().setCustomAnimations(
                        com.gykj.zhumulangma.common.R.anim.push_bottom_in,
                        com.gykj.zhumulangma.common.R.anim.no_anim,
                        com.gykj.zhumulangma.common.R.anim.no_anim,
                        com.gykj.zhumulangma.common.R.anim.push_bottom_out).start(
                        navigateBean.fragment, ISupportFragment.SINGLETASK);
                break;
            default:
                if (navigateBean.extraTransaction != null) {
                    navigateBean.extraTransaction.start(navigateBean.fragment, navigateBean.launchMode);
                } else {
                    activity.start(navigateBean.fragment, navigateBean.launchMode);
                }
                break;
        }
    }*/
}
