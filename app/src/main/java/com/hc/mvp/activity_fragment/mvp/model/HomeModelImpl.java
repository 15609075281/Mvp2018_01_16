package com.hc.mvp.activity_fragment.mvp.model;

import android.util.Log;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.BannerOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.HomeOneItemInfo;
import com.hc.mvp.tools.NetworkRequest.NetworkInfo;
import com.hc.mvp.tools.NetworkRequest.UtilsNetwork;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public class HomeModelImpl implements HomeModel {

    UtilsNetwork xUtilsNetwork;

    public HomeModelImpl() {
        xUtilsNetwork = xUtilsNetwork.getIntens();

    }

    @Override
    public void HomeModel(OnHomeLister onHomeLister) {
        homeNetwork(onHomeLister);
    }

    @Override
    public void HomeBannerModel(OnHomeBannerLister onHomeBannerLister) {
        netBanner(onHomeBannerLister);
    }

    /**
     * 获取首页数据
     *
     * @param onHomeLister
     */
    private void homeNetwork(final OnHomeLister onHomeLister) {
        xUtilsNetwork.xUtilsPostNull(NetworkInfo.Url_home, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result.toLowerCase());
                    String msg = jsonObject.getString("msg");
                    String result1 = jsonObject.getString("result");
                    if (msg.equals("200")) {
                        String jsonList = jsonObject.getString("jsonlist");
                        //第一层集合
                        JSONArray jsonArray = new JSONArray(jsonList);
                        List<HomeOneInfo> homeOneInfoList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            HomeOneInfo homeOneInfo = new HomeOneInfo();
                            String id = jsonObject1.getString("id");
                            String title = jsonObject1.getString("title");
                            String json = jsonObject1.getString("json");
                            homeOneInfo.setId(id);
                            homeOneInfo.setTitle(title);
                            //第二层集合
                            JSONArray jsonArray1 = new JSONArray(json);
                            List<HomeOneItemInfo> homeOneItemInfoList = new ArrayList<>();
                            for (int j = 0; j < jsonArray1.length(); j++) {
                                JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
                                HomeOneItemInfo homeOneItemInfo = new HomeOneItemInfo();
                                homeOneItemInfo.setUrl_image(jsonObject2.getString("image_url"));
                                homeOneItemInfo.setText_title(jsonObject2.getString("text_title"));
                                homeOneItemInfoList.add(homeOneItemInfo);
                            }
                            homeOneInfo.setHomeOneItemInfoList(homeOneItemInfoList);
                            homeOneInfoList.add(homeOneInfo);
                        }
                        onHomeLister.OnSuccess(homeOneInfoList);
                    } else {
                        onHomeLister.OnError(result1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("onError", ex.toString());
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
     * 获取Banner
     */
    public void netBanner(final OnHomeBannerLister onHomeBannerLister) {

        xUtilsNetwork.xUtilsPostNull(NetworkInfo.Url_home_banner, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String msg = jsonObject.getString("msg");
                    String result1 = jsonObject.getString("result");
                    String url_image = jsonObject.getString("url_image");
                    if (msg.equals("200")) {
                        List<BannerOneInfo> list = new ArrayList<>();
                        JSONArray jsonArray=new JSONArray(url_image);
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            JSONObject jsonObject1=jsonArray.getJSONObject(i);
                            BannerOneInfo bannerOneInfo=new BannerOneInfo();
                            bannerOneInfo.setImage_url(jsonObject1.getString("image_url"));
                            bannerOneInfo.setText_name(jsonObject1.getString("text_name"));
                            list.add(bannerOneInfo);
                        }
                        onHomeBannerLister.OnSuccess(list);
                    } else {
                        onHomeBannerLister.OnError(result1);
                    }
                } catch (JSONException e) {

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
