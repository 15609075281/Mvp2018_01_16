package com.hc.mvp.activity_fragment.ui.mainbody.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.Manager.BaseFragment;

/**
 * Created by Administrator on 2018/3/7.
 * 商城
 */
public class MallFragment extends BaseFragment {

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(context).inflate(R.layout.mallfragment_xml, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
