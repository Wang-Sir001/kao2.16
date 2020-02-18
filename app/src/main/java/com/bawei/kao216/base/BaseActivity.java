package com.bawei.kao216.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.kao216.base.mvp.BasePresenter;
import com.bawei.kao216.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        bind = ButterKnife.bind(this);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initdata();
    }

    protected abstract void initdata();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            bind.unbind();
        }
        if (presenter != null) {
            presenter.detach();
        }
    }
}
