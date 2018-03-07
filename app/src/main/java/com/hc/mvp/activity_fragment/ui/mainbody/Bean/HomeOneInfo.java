package com.hc.mvp.activity_fragment.ui.mainbody.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/2.
 */
public class HomeOneInfo implements Serializable {

    private String id;
    private String title;
    private List<HomeOneItemInfo> homeOneItemInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HomeOneItemInfo> getHomeOneItemInfoList() {
        return homeOneItemInfoList;
    }

    public void setHomeOneItemInfoList(List<HomeOneItemInfo> homeOneItemInfoList) {
        this.homeOneItemInfoList = homeOneItemInfoList;
    }

    @Override
    public String toString() {
        return "HomeOneInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", homeOneItemInfoList=" + homeOneItemInfoList +
                '}';
    }
}
