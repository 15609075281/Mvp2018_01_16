package com.hc.mvp.activity_fragment.mvp.view;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
public interface PersonView<T> {


    public void OnSuccess(List<T> success);

    public void OnError(String error);


}
