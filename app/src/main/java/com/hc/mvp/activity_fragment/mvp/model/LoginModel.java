package com.hc.mvp.activity_fragment.mvp.model;

/**
 * Created by Administrator on 2018/2/26.
 * 实现类为LoginModelImpl.相当于MVP模式中的Model层
 */
public interface LoginModel {

    //模拟登陆的操作的接口，
    void LoginModel(String username, String password, OnLoginLister onLoginLister);

    interface OnLoginLister {
        void onSuccess(String Success);

        void onError(String Error);
    }
    //模拟注册操作的接口，
    void RegisterModel(String username, String password, OnRegisterLister onRegisterLister);

    interface OnRegisterLister {
        void onSuccess(String success);

        void onError(String error);

    }


}
