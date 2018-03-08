package com.hc.mvp.activity_fragment.mvp.model;


import com.hc.mvp.activity_fragment.ui.mainbody.Bean.BannerOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface HomeModel {

    void HomeModel(OnHomeLister onHomeLister);

    interface OnHomeLister {
        void OnSuccess(List<HomeOneInfo> tList);

        void OnError(String error);
    }

    void HomeBannerModel(OnHomeBannerLister onHomeBannerLister);

    interface OnHomeBannerLister {

        void OnSuccess(List<BannerOneInfo> bannerOneInfoList);

        void OnError(String error);

    }
}
