package com.hc.mvp.activity_fragment.mvp.view;

import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface HomeView  {


    public void OnSuccess(List<HomeOneInfo> homeOneInfoList);

    public void OnError(String error);
}
