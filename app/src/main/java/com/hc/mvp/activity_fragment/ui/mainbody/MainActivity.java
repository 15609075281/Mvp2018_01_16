package com.hc.mvp.activity_fragment.ui.mainbody;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.Manager.BaseActivity;
import com.hc.mvp.activity_fragment.ui.mainbody.adapter.MainViewPagerAdapter;
import com.hc.mvp.activity_fragment.ui.mainbody.fragment.HomeFragment;
import com.hc.mvp.activity_fragment.ui.mainbody.fragment.MallFragment;
import com.hc.mvp.activity_fragment.ui.mainbody.fragment.PersonFragment;
import com.hc.mvp.activity_fragment.ui.mainbody.fragment.SaysFragment;
import com.jingewenku.abrahamcaijin.commonutil.AppLogMessageMgr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/1.
 */
public class MainActivity extends BaseActivity {

    private ViewPager main_view;

    private LinearLayout home;
    private ImageView home_image;
    private TextView home_text;

    private LinearLayout person;
    private ImageView person_image;
    private TextView person_text;

    private List<Fragment> fragmentList;

    @Override
    public int inti() {
        return R.layout.mainactivity_xml;
    }

    @Override
    public void findview() {
        main_view = (ViewPager) findViewById(R.id.main_viewpager);
        home = (LinearLayout) findViewById(R.id.home);
        home_image = (ImageView) findViewById(R.id.home_image);
        home_text = (TextView) findViewById(R.id.home_text);
        person = (LinearLayout) findViewById(R.id.person);
        person_image = (ImageView) findViewById(R.id.person_image);
        person_text = (TextView) findViewById(R.id.person_text);

        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
//        fragmentList.add(new SaysFragment());
//        fragmentList.add(new MallFragment());
        fragmentList.add(new PersonFragment());
        main_view.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        home_transform();
        main_view.setOnPageChangeListener(onPageChangeListener);
        home.setOnClickListener(listener);
        person.setOnClickListener(listener);

    }

    android.view.View.OnClickListener listener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.home:
                    home_transform();
                    break;
                case R.id.person:
                    person_transform();
                    break;

                default:
            }

        }
    };

    public void home_transform() {
        main_view.setCurrentItem(0);
        home_image.setImageResource(R.drawable.h2);
        home_text.setTextColor(Color.parseColor("#CD0000"));
        person_image.setImageResource(R.drawable.p1);
        person_text.setTextColor(Color.parseColor("#030303"));
    }

    public void person_transform() {
        main_view.setCurrentItem(1);
        home_image.setImageResource(R.drawable.h1);
        home_text.setTextColor(Color.parseColor("#030303"));
        person_image.setImageResource(R.drawable.p2);
        person_text.setTextColor(Color.parseColor("#CD0000"));
    }


    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    home_transform();
                    break;
                case 1:
                    person_transform();
                    break;

                default:
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
