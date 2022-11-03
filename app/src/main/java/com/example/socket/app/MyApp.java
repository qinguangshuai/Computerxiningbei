package com.example.socket.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

/**
 * @date 2021/7/16 12:53
 */
public class MyApp extends Application {

    public static Context mContext;
    public static int biaoji = 0;
    public static int sendbiaoji = 0;

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(true)
                .setSupportSP(true)
                .setSupportSubunits(Subunits.MM);

        //CrashReport.initCrashReport(getApplicationContext(), getString(R.string.bugly_app_id), false);

        /*TouchEffectsManager.build(TouchEffectsWholeType.SCALE)//设置全局使用哪种效果
                .addViewType(TouchEffectsViewType.ALL)//添加哪些View支持这个效果
                .setListWholeType(TouchEffectsWholeType.RIPPLE)//为父控件为列表的情况下，设置特定效果
                .setAspectRatioType(4f, TouchEffectsWholeType.RIPPLE);//宽高比大于4时启动水波纹
*/

        /*CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                .enabled(true)
                .showErrorDetails(true)
                .showRestartButton(true)
                .trackActivities(true)
                .minTimeBetweenCrashesMs(2000)
                //重新启动后的页面
                .restartActivity(SplashActivity.class)
                //程序崩溃后显示的页面（可以不设置）项目编包后去掉
                //.errorActivity(DefaultErrorActivity.class)
                .apply();
        CustomActivityOnCrash.install(this);*/
    }
}
