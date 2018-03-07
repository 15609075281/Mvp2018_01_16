package com.hc.mvp.activity_fragment.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hc.mvp.R;
import com.nobrain.android.permissions.AndroidPermissions;
import com.nobrain.android.permissions.Checker;

/**
 * Created by Administrator on 2018/1/17.
 */
public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_a_xml, null, false);
    }

    public void get() {
        AndroidPermissions.check(getActivity())
                .permissions(Manifest.permission.CALL_PHONE)
                .hasPermissions(new Checker.Action0() {
                    @Override
                    public void call(String[] permissions) {
                        // do something..
                    }
                })
                .noPermissions(new Checker.Action1() {
                    @Override
                    public void call(String[] permissions) {
                        // do something..
                    }
                })
                .check();
    }

}
