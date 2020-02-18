package com.bawei.kao216.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.kao216.base.mvp.BasePresenter;
import com.bawei.kao216.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(LayoutId(), container, false);
        bind = ButterKnife.bind(this,inflate);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(inflate);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void initView(View inflate);

    protected abstract P initPresenter();

    protected abstract int LayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
        if (presenter != null) {
            bind.unbind();
        }
    }
}
