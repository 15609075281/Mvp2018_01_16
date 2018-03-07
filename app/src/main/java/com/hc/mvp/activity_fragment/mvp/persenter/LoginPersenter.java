package com.hc.mvp.activity_fragment.mvp.persenter;

import com.hc.mvp.activity_fragment.mvp.model.LoginModel;
import com.hc.mvp.activity_fragment.mvp.model.LoginModelImpl;
import com.hc.mvp.activity_fragment.mvp.view.LoginView;

/**
 * Created by Administrator on 2018/2/26.
 */
public class LoginPersenter {
    private LoginModelImpl loginModel;
    private LoginView loginView;


    public LoginPersenter(LoginView loginView) {
        loginModel = new LoginModelImpl();
        this.loginView = loginView;
    }

    /**
     * 登录
     */
    public void start_Login() {
        loginModel.LoginModel(loginView.getUsername(), loginView.getPassword(), new LoginModel.OnLoginLister() {
            @Override
            public void onSuccess(String Success) {
                loginView.onLoginSuccess(Success);
            }

            @Override
            public void onError(String Error) {
                loginView.onLoginError(Error);
            }
        });
    }

    /**
     * 注册
     */
    public void start_Register() {
        loginModel.RegisterModel(loginView.getUsername(), loginView.getPassword(), new LoginModel.OnRegisterLister() {
            @Override
            public void onSuccess(String Success) {
                loginView.onLoginSuccess(Success);
            }

            @Override
            public void onError(String Error) {
                loginView.onLoginError(Error);
            }
        });
    }

}
