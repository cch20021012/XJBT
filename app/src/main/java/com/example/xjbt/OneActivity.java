package com.example.xjbt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.xjbt.base.BaseActivity;
import com.example.xjbt.cch.VpOneAdapter;
import com.example.xjbt.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneActivity extends BaseActivity {
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.img_1)
    ImageView img1;
    @BindView(R.id.img_2)
    ImageView img2;
    @BindView(R.id.img_3)
    ImageView img3;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected int getLayout() {
        return R.layout.cch_activity_one;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        View vp1 = LayoutInflater.from(this).inflate(R.layout.cch_vp1_item, null);
        View vp2 = LayoutInflater.from(this).inflate(R.layout.cch_vp2_item, null);
        View vp3 = LayoutInflater.from(this).inflate(R.layout.cch_vp3_item, null);
        ArrayList<View> views = new ArrayList<>();
        views.add(vp1);
        views.add(vp2);
        views.add(vp3);
        VpOneAdapter vpOneAdapter = new VpOneAdapter(views);
        vpMain.setAdapter(vpOneAdapter);
    }

    @Override
    protected void initData() {
        vpMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    img1.setImageResource(R.drawable.selec);
                    img2.setImageResource(R.drawable.noselect);
                    img3.setImageResource(R.drawable.noselect);
                } else if (position==1) {
                    img1.setImageResource(R.drawable.noselect);
                    img2.setImageResource(R.drawable.selec);
                    img3.setImageResource(R.drawable.noselect);
                }else {
                    img1.setImageResource(R.drawable.noselect);
                    img2.setImageResource(R.drawable.noselect);
                    img3.setImageResource(R.drawable.selec);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
