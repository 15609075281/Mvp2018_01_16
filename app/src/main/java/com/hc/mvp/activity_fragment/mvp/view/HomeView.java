package com.hc.mvp.activity_fragment.mvp.view;

import com.hc.mvp.activity_fragment.ui.mainbody.Bean.BannerOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface HomeView {


    /**
     * Banner获取数据
     * @param oneInfoList
     */
    public void OnBannerSuccess(List<BannerOneInfo> oneInfoList);

    public void OnBannerError(String error);

    /**
     * 主页获取数据返回
     *
     * @param homeOneInfoList
     */
    public void OnSuccess(List<HomeOneInfo> homeOneInfoList);

    public void OnError(String error);
}
