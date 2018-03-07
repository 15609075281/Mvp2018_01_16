package com.hc.mvp.activity_fragment.mvp.persenter;

import com.hc.mvp.activity_fragment.mvp.model.HomeModel;
import com.hc.mvp.activity_fragment.mvp.model.HomeModelImpl;
import com.hc.mvp.activity_fragment.mvp.view.HomeView;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public class HomePersenter {


    private HomeModelImpl homeModel;
    private HomeView homeView;

    public HomePersenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModelImpl();
    }

    public void getHomeList( ) {
        homeModel.HomeModel(new HomeModel.OnHomeLister<HomeOneInfo>() {
            @Override
            public void OnSuccess(List<HomeOneInfo> homeOneInfoList) {
                homeView.OnSuccess(homeOneInfoList);
            }

            @Override
            public void OnError(String error) {
                homeView.OnError(error);
            }
        });
    }
}
