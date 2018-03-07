package com.hc.mvp.activity_fragment.ui.mainbody.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/7.
 * * 我的界面，底部功能区
 */
public class PersonFragmentOneInfo implements Serializable {

    private String image_url;
    private String text_;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getText_() {
        return text_;
    }

    public void setText_(String text_) {
        this.text_ = text_;
    }

    @Override
    public String toString() {
        return "PersonFragmentOneInfo{" +
                "image_url='" + image_url + '\'' +
                ", text_='" + text_ + '\'' +
                '}';
    }
}
