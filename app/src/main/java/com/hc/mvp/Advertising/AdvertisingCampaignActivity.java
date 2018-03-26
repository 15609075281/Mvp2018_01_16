package com.hc.mvp.Advertising;

import android.app.Activity;
//import android.os.Bundle;
//import com.hc.mvp.R;
//import com.uuch.adlibrary.AdConstant;
//import com.uuch.adlibrary.AdManager;
//import com.uuch.adlibrary.bean.AdInfo;
//import com.uuch.adlibrary.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/26.
 * <p>
 * 广告活动
 */
public class AdvertisingCampaignActivity extends Activity {
//
//    private List<AdInfo> advList;
//    private AdManager adManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.advertisingcampaign_xml);
//        initData();
//        /**
//         * 创建广告活动管理对象
//         */
//        adManager = new AdManager(AdvertisingCampaignActivity.this, advList);
//        adManager.setOverScreen(true)
//                .setPageTransformer(new DepthPageTransformer());
//
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        try {
//            Thread.sleep(2000);
//            /**
//             * 执行弹窗的显示操作
//             */
//            adManager.showAdDialog(AdConstant.ANIM_DOWN_TO_UP);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 初始化数据
//     */
//    private void initData() {
//        advList = new ArrayList<>();
//        AdInfo adInfo = new AdInfo();
//        adInfo.setActivityImg("https://raw.githubusercontent.com/yipianfengye/android-adDialog/master/images/testImage1.png");
//        advList.add(adInfo);
//
//        adInfo = new AdInfo();
//        adInfo.setActivityImg("https://raw.githubusercontent.com/yipianfengye/android-adDialog/master/images/testImage2.png");
//        advList.add(adInfo);
//    }
}
