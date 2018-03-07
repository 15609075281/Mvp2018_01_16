package com.hc.mvp.activity_fragment.mvp.model;



import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface HomeModel<T> {

    void HomeModel(OnHomeLister<T> onHomeLister);

    interface OnHomeLister<T> {
        void OnSuccess(List<T> tList);

        void OnError(String error);
    }
}
