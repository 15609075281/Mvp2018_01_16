package com.hc.mvp;

import android.app.Application;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Debug;
import com.jingewenku.abrahamcaijin.commonutil.AppNetworkMgr;
import com.jingewenku.abrahamcaijin.commonutil.application.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.*;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/16.
 * xUtils+ AppUtils
 */

public class MyApplication extends Application {
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        xUtilsInitialize();
        AppUtilsInitialize();
    }

    /**
     * xUtils
     */
    private void xUtilsInitialize() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }

    /**
     * 多权限
     */
    private void AppUtilsInitialize() {
        Utils.init(this);
    }

    /**
     * 网络状态
     */
    private void netWork() {
        NetworkInfo.State networkInfo = AppNetworkMgr.getCurrentNetworkState(this);

    }
}
