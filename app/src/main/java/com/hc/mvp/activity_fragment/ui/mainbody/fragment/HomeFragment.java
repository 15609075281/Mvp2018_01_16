package com.hc.mvp.activity_fragment.ui.mainbody.fragment;

import android.content.Context;
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
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.BannerOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.adapter.HomeFragmentOneAdapter;
import com.hc.mvp.tool.image.GlideImageLoader;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class HomeFragment extends BaseFragment implements HomeView {

    String TAG = "HomeFragment";
    private Context context;
    View view = null;
    private HomePersenter homePersenter;
    private SmartRefreshLayout smartRefreshLayout;

    private Banner banner_home;
    private List<String> images;
    private List<String> titles;

    private RecyclerView home_fragment_recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private List<HomeOneInfo> homeOneInfoList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
    }

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

    @Override
    public void onStart() {
        super.onStart();
        homePersenter.getHomeList();
        homePersenter.getBanner();
//        banner_home.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
//        banner_home.stopAutoPlay();
    }

    public void find() {
        homePersenter = new HomePersenter(this);
        //刷新，加载
        SmartRefreshLayout();
        //RecyclerView
        RecyclerView();
    }

    /**
     * Banner 获取数据返回
     *
     * @param oneInfoList
     */
    @Override
    public void OnBannerSuccess(List<BannerOneInfo> oneInfoList) {
        images = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < oneInfoList.size(); i++) {
            images.add(oneInfoList.get(i).getImage_url());
            titles.add(oneInfoList.get(i).getText_name());
        }
        Banner();
    }

    @Override
    public void OnBannerError(String error) {
        AppToastMgr.Toast(context, error);
    }

    /**
     * 主页获取数据返回集
     *
     * @param homeOneInfoList
     */
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

    /**
     * 刷新
     */
    private void SmartRefreshLayout() {
        smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
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

    /**
     * Banner
     */
    private void Banner() {
        banner_home = (Banner) view.findViewById(R.id.banner_home);
        //设置banner样式
        banner_home.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        banner_home.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner_home.setImages(images);
        //设置banner动画效果
        banner_home.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner_home.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner_home.isAutoPlay(true);
        //设置轮播时间
        banner_home.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner_home.setIndicatorGravity(BannerConfig.CENTER);

        banner_home.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                AppToastMgr.Toast(getActivity(), position + "");
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner_home.start();
    }

    /**
     * RecyclerView List横向固定数量
     */
    private void RecyclerView() {
        home_fragment_recyclerview = (RecyclerView) view.findViewById(R.id.home_fragment_recyclerview);
        //创建默认的线性LayoutManager
        linearLayoutManager = new LinearLayoutManager(getContext());
        //横向的list
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        home_fragment_recyclerview.setHasFixedSize(true);
        home_fragment_recyclerview.setLayoutManager(linearLayoutManager);
    }

}
