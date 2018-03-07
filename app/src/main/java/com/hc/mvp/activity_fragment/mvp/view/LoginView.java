package com.hc.mvp.activity_fragment.mvp.view;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface LoginView {

    //获取昵称/手机号
    public String getUsername();

    //获取密码/验证码
    public String getPassword();

    //登录成功反馈信息
    public void onLoginSuccess(String success);

    //登录失败反馈信息
    public void onLoginError(String error);


}
