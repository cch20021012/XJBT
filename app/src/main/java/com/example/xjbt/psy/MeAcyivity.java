package com.example.xjbt.psy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.xjbt.R;
import com.example.xjbt.psy.base.BaseActivity;
import com.example.xjbt.psy.interfaces.IBasePresenter;
import com.example.xjbt.psy.ui.MeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeAcyivity extends BaseActivity {
    @BindView(R.id.me_fragment_vp)
    ViewPager mVp;
    @BindView(R.id.me_fragment_tab)
    TabLayout mTab;
    private ArrayList<Fragment> mFs;
    private String[] name={"我的"};

    @Override
    protected int getLayout() {
        return R.layout.activity_me;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        mFs = new ArrayList<>();
        mFs.add(new MeFragment());
        //创建vp适配器
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager());
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);
    }

    @Override
    protected void initData() {

    }

    class VpAdapter extends FragmentStatePagerAdapter {
        public VpAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFs.get(position);
        }

        @Override
        public int getCount() {
            return mFs.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return name[position];
        }
    }

}
