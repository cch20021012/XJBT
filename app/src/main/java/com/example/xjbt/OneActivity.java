package com.example.xjbt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.xjbt.base.BaseActivity;
import com.example.xjbt.cch.VpOneAdapter;
import com.example.xjbt.interfaces.IBasePresenter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.img_go)
    ImageView imgGo;
    String[] str = {"四", "三", "二", "一"};
    int sum = 0;
    private Timer timer;
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
        timer = new Timer();
        VpOneAdapter vpOneAdapter = new VpOneAdapter(views);
        vpMain.setAdapter(vpOneAdapter);
        imgGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OneActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        vpMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    sum=0;
                    imgGo.setVisibility(View.GONE);
                    tvTime.setVisibility(View.GONE);
                    img1.setImageResource(R.drawable.selec);
                    img2.setImageResource(R.drawable.noselect);
                    img3.setImageResource(R.drawable.noselect);
                } else if (position == 1) {
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    sum=0;
                    imgGo.setVisibility(View.GONE);
                    tvTime.setVisibility(View.GONE);
                    img1.setImageResource(R.drawable.noselect);
                    img2.setImageResource(R.drawable.selec);
                    img3.setImageResource(R.drawable.noselect);
                } else {
                    img1.setImageResource(R.drawable.noselect);
                    img2.setImageResource(R.drawable.noselect);
                    img3.setImageResource(R.drawable.selec);

                    imgGo.setVisibility(View.VISIBLE);
                    tvTime.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(OneActivity.this, R.anim.anim_go_item);
                    imgGo.startAnimation(animation);
                    timer=new Timer();
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (sum < 4) {
                                        tvTime.setText(str[sum]);
                                        sum++;
                                    } else {
                                        timer.cancel();
                                    }
                                }
                            });
                        }
                    };
                    timer.schedule(timerTask, 1000, 1000);
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
