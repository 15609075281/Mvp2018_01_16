package com.hc.mvp.activity_fragment.mvp.persenter;

import com.hc.mvp.activity_fragment.mvp.model.PersonModel;
import com.hc.mvp.activity_fragment.mvp.model.PersonModelImp;
import com.hc.mvp.activity_fragment.mvp.view.PersonView;

import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */
public class PersonPersenter<T> {

    private PersonModelImp personModelImp;
    private PersonView<T> personView;

    public PersonPersenter(PersonView<T> personView) {
        this.personView = personView;
        personModelImp = new PersonModelImp();
    }

    /**
     * 获取服务器数据
     */
    public void netWork() {
        personModelImp.Network(new PersonModel.OnPersonLister<T>() {
            @Override
            public void OnSuccess(List list) {
                personView.OnSuccess(list);
            }

            @Override
            public void OnError(String error) {
                personView.OnError(error);
            }
        });
    }


}
