package com.bawei.kao216.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.kao216.R;
import com.bawei.kao216.base.BaseFragment;
import com.bawei.kao216.contract.IOrderContract;
import com.bawei.kao216.model.adabter.OrderAdapter;
import com.bawei.kao216.model.entity.OrderEntity;
import com.bawei.kao216.presenter.OrderPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment<OrderPresenter> implements IOrderContract.IView {

   /* @BindView(R.id.smart)
    SmartRefreshLayout smart;
    @BindView(R.id.recycler_order)
    RecyclerView recyclerOrder;
    private int mStatus;*/

//    private int status = 0;
//    private int page = 1;

//    List<OrderEntity.OrderListBean> list = new ArrayList<>();

    @Override
    protected void initView(View inflate) {
        /*smart.setEnableAutoLoadMore(true);

        smart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page ++;
                presenter.getOrderfromData(27882,"158194679294127882",status,page,5);

                smart.finishLoadMore();
            }
        });*/
    }

    @Override
    protected OrderPresenter initPresenter() {
        return new OrderPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initData() {
//        list.clear();
        Bundle bundle = getArguments();
        if (bundle != null) {
//            status = bundle.getInt("status");
        }

//        presenter.getOrderfromData(27882,"158194679294127882",this.status,page,5);
    }

    @Override
    public void orderSuccess(OrderEntity orderEntity) {
//        list.addAll(orderEntity.getOrderList());

        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerOrder.setLayoutManager(linearLayoutManager);

        OrderAdapter orderAdapter = new OrderAdapter(list);
        recyclerOrder.setAdapter(orderAdapter);*/
    }

    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(getActivity(), "订单失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public static OrderFragment getInstance(int status) {
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("status", status);
        orderFragment.setArguments(bundle);
        return orderFragment;
    }
}
