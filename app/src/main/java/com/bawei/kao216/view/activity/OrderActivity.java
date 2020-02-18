package com.bawei.kao216.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.kao216.R;
import com.bawei.kao216.base.BaseActivity;
import com.bawei.kao216.base.mvp.BasePresenter;
import com.bawei.kao216.view.fragment.OrderFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    //Fragment集合
    List<Fragment> fragmentList = new ArrayList<>();
    //标题字符串的集合
    List<String> titleList = new ArrayList<>();

    @Override
    protected void initdata() {

        //0、添加标题
        titleList.add("全部订单");
        titleList.add("待支付");
        titleList.add("待收货");
        titleList.add("待评价");
        titleList.add("已完成");

        //1、构造5个fragment
        OrderFragment allFragment = OrderFragment.getInstance(0);
        OrderFragment waitPayFragment = OrderFragment.getInstance(1);
        OrderFragment waiReceiveFragment = OrderFragment.getInstance(2);
        OrderFragment waitEvaluateFragment = OrderFragment.getInstance(3);
        OrderFragment completeFragment = OrderFragment.getInstance(9);

        //2、添加到fragment集合
        fragmentList.add(allFragment);
        fragmentList.add(waitPayFragment);
        fragmentList.add(waiReceiveFragment);
        fragmentList.add(waitEvaluateFragment);
        fragmentList.add(completeFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });

        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_order;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
