package com.hc.mvp.activity_fragment.mvp.model;

import com.hc.mvp.tool.NetworkRequest.NetworkInfo;
import com.hc.mvp.tool.NetworkRequest.xUtilsNetwork;
import com.jingewenku.abrahamcaijin.commonutil.AppLogMessageMgr;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpResponse;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/26.
 * 延时模拟登陆（2s），如果名字或者密码为空则登陆失败，否则登陆成功
 */
public class LoginModelImpl implements LoginModel {

    xUtilsNetwork xUtilsNetwork1;

    public LoginModelImpl() {
        xUtilsNetwork1 = xUtilsNetwork.getIntens();
    }

    /**
     * 登录请求操作
     *
     * @param username
     * @param password
     */
    @Override
    public void LoginModel(String username, String password, OnLoginLister  onLoginLister) {
        loginNetwork(username, password, onLoginLister);
    }

    /**
     * 注册请求操作
     *
     * @param username
     * @param password
     */
    @Override
    public void RegisterModel(String username, String password, OnRegisterLister onRegisterLister) {
        registerNetwork(username, password, onRegisterLister);
    }

    /**
     * 登录网络请求
     */
    public void loginNetwork(String username, String password, final OnLoginLister onLoginLister) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", username);
        map.put("password", password);
        xUtilsNetwork1.xutilsGet(NetworkInfo.Url_login, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                AppLogMessageMgr.e("lm", result);
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String msg = jsonObject.getString("msg");
                    String result1 = jsonObject.getString("result");
                    if (msg.equals("200"))
                        onLoginLister.onSuccess(result1);
                    else
                        onLoginLister.onError(result1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 注册网络请求
     */
    public void registerNetwork(String username, String password, final OnRegisterLister onRegisterLister) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", username);
        map.put("password", password);
        xUtilsNetwork1.xUtilsPost(NetworkInfo.Url_register, map, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result.toString());
                    String msg = jsonObject.getString("msg");
                    String result1 = jsonObject.getString("result");
                    if (msg.equals("200")) {
                        onRegisterLister.onSuccess(result1);
                    } else {
                        onRegisterLister.onError(result1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
