package com.hc.mvp.activity_fragment.ui.mainbody.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/6.
 */
public class HomeOneItemInfo implements Serializable {
    private String url_image;
    private String text_title;

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getText_title() {
        return text_title;
    }

    public void setText_title(String text_title) {
        this.text_title = text_title;
    }

    @Override
    public String toString() {
        return "HomeOneInfo{" +
                "url_image='" + url_image + '\'' +
                ", text_title='" + text_title + '\'' +
                '}';
    }
}
