package com.hc.mvp.activity_fragment.ui.mainbody.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.mvp.persenter.PersonPersenter;
import com.hc.mvp.activity_fragment.mvp.view.PersonView;
import com.hc.mvp.activity_fragment.ui.mainbody.Bean.PersonFragmentOneInfo;
import com.hc.mvp.activity_fragment.ui.mainbody.adapter.PersonFragmentOneAdapter;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;

import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class PersonFragment extends Fragment implements PersonView {
    private Context context;
    private PersonPersenter<PersonFragmentOneInfo> fragmentOneInfoPersonPersenter;
    private View view;
    private RecyclerView person_recyclerview;
    private GridLayoutManager gridLayoutManager;
    private List<PersonFragmentOneInfo> personFragmentOneInfoList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.personfragment_xml, null, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        fragmentOneInfoPersonPersenter = new PersonPersenter<>(this);
        person_recyclerview = (RecyclerView) view.findViewById(R.id.person_recyclerview);
        gridLayoutManager = new GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, true);
        person_recyclerview.setLayoutManager(gridLayoutManager);
        fragmentOneInfoPersonPersenter.netWork();
    }


    @Override
    public void OnSuccess(List success) {
        this.personFragmentOneInfoList = success;
        PersonFragmentOneAdapter  personFragmentOneAdapter = new PersonFragmentOneAdapter(personFragmentOneInfoList);
        person_recyclerview.setAdapter(personFragmentOneAdapter);
    }

    @Override
    public void OnError(String error) {
        AppToastMgr.Toast(context, error);
    }
}
