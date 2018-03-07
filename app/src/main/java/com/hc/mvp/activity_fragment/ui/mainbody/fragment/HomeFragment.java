package com.hc.mvp.activity_fragment.ui.mainbody.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.Manager.BaseFragment;
import com.hc.mvp.activity_fragment.mvp.persenter.HomePersenter;
import com.hc.mvp.activity_fragment.mvp.view.HomeView;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.adapter.HomeFragmentOneAdapter;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class HomeFragment extends BaseFragment implements HomeView {

    String TAG = "HomeFragment";
    View view = null;
    private HomePersenter homePersenter;
    private SmartRefreshLayout smartRefreshLayout;

    RecyclerView home_fragment_recyclerview;
    LinearLayoutManager linearLayoutManager;
    List<HomeOneInfo> homeOneInfoList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.homefragment_xml, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        find();
    }

    public void find() {
        homePersenter = new HomePersenter(this);
        //刷新
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        home_fragment_recyclerview = (RecyclerView) view.findViewById(R.id.home_fragment_recyclerview);
        //创建默认的线性LayoutManager
        linearLayoutManager = new LinearLayoutManager(getContext());
        //横向的list
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        home_fragment_recyclerview.setHasFixedSize(true);
        home_fragment_recyclerview.setLayoutManager(linearLayoutManager);
        homePersenter.getHomeList();

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(true);//传入false表示刷新失败
                homePersenter.getHomeList();
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    @Override
    public void OnSuccess(List<HomeOneInfo> homeOneInfoList) {
        this.homeOneInfoList = homeOneInfoList;
        HomeFragmentOneAdapter homeFragmentOneAdapter = new HomeFragmentOneAdapter(homeOneInfoList);
        home_fragment_recyclerview.setAdapter(homeFragmentOneAdapter);
    }

    @Override
    public void OnError(String error) {
        AppToastMgr.Toast(getContext(), error);
    }

}
