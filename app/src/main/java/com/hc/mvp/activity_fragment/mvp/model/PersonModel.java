package com.hc.mvp.activity_fragment.mvp.model;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
public interface PersonModel {

    /**
     * 我的主页控件数据接口
     * @param onPersonLister
     */
    void Network(OnPersonLister onPersonLister);

    interface OnPersonLister<T> {

        void OnSuccess(List<T> tList);

        void OnError(String error);

    }
}
