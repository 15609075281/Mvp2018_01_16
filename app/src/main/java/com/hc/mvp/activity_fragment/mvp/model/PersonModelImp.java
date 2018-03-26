package com.hc.mvp.activity_fragment.mvp.model;

import android.util.Log;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.PersonFragmentOneInfo;
import com.hc.mvp.tools.NetworkRequest.NetworkInfo;
import com.hc.mvp.tools.NetworkRequest.UtilsNetwork;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
public class PersonModelImp implements PersonModel {

    UtilsNetwork utilsNetwork;

    @Override
    public void Network(OnPersonLister onPersonLister) {
        utilsNetwork = UtilsNetwork.getIntens();
        network(onPersonLister);
    }

    public void network(final OnPersonLister onPersonLister) {

        utilsNetwork.xUtilsPostNull(NetworkInfo.Url_person, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("result",result);
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String msg = jsonObject.getString("msg");
                    String result1 = jsonObject.getString("result");
                    if (msg.equals("200")) {
                        JSONArray jsonArray = new JSONArray(jsonObject.getString("url_image"));
                        List<PersonFragmentOneInfo> oneInfoList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String image_url = jsonObject1.getString("image_url");
                            String text_ = jsonObject1.getString("text_");
                            PersonFragmentOneInfo personFragmentOneInfo = new PersonFragmentOneInfo();
                            personFragmentOneInfo.setImage_url(image_url);
                            personFragmentOneInfo.setText_(text_);
                            oneInfoList.add(personFragmentOneInfo);
                        }
                        onPersonLister.OnSuccess(oneInfoList);
                    } else {
                        onPersonLister.OnError(result1);
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
