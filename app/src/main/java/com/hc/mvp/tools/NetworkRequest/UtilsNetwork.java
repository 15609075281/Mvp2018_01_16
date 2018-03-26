package com.hc.mvp.tools.NetworkRequest;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/26.
 * xUtils 网络请求封装
 */
public class UtilsNetwork {

    public static UtilsNetwork xUtilsNetwork;

    /**
     *
     */
    public static UtilsNetwork getIntens() {

        if (xUtilsNetwork == null) {
            synchronized (UtilsNetwork.class) {
                if (xUtilsNetwork == null) {
                    xUtilsNetwork = new UtilsNetwork();
                }
            }
        }
        return xUtilsNetwork;
    }

    /**
     * Get请求
     *
     * @param url
     * @param map
     * @param callback
     * @param <T>
     */
    public <T> void xutilsGet(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (map != null && map.isEmpty() == false) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), (String) entry.getValue());
            }
        }
        x.http().get(params, callback);
    }

    /**
     * Post请求
     *
     * @param url
     * @param map
     * @param callback
     * @param <T>
     */
    public <T> void xUtilsPost(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (map != null && map.isEmpty() == false) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        x.http().post(params, callback);
    }

    public <T> void xUtilsPostNull(String url, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        x.http().post(params, callback);
    }


}
