package com.hc.mvp.activity_fragment.ui.mainbody.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/8.
 * Banner
 */
public class BannerOneInfo implements Serializable {


    private String image_url;
    private String text_name;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    @Override
    public String toString() {
        return "BannerOneInfo{" +
                "image_url='" + image_url + '\'' +
                ", text_name='" + text_name + '\'' +
                '}';
    }
}
