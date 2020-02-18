package com.bawei.kao216.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.kao216.R;
import com.bawei.kao216.base.BaseActivity;
import com.bawei.kao216.contract.ILogContract;
import com.bawei.kao216.model.entity.LoginEntity;
import com.bawei.kao216.model.entity.RegisterEntity;
import com.bawei.kao216.presenter.RegisterPresenter;
import com.blankj.utilcode.util.EncryptUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements ILogContract.IView {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.bt_log)
    Button btLog;
    @BindView(R.id.bt_reg)
    Button btReg;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegisterSuccess(RegisterEntity registerEntity) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(LoginEntity loginEntity) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @OnClick({R.id.bt_log, R.id.bt_reg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_log:
                String phone = etPhone.getText().toString();
                String pwd = etPwd.getText().toString();
                //密码需要加密
                String encryptPwd = EncryptUtils.encryptMD5ToString(pwd);
                //因为后台规定了密码长度，所以我们处理一下
                encryptPwd = encryptPwd.substring(0, 6);

                // TODO: 2020/2/13 去登录
                presenter.login(phone, encryptPwd);
                break;
            case R.id.bt_reg:
                String phone1 = etPhone.getText().toString();
                String pwd1 = etPwd.getText().toString();
                //密码需要加密
                String encryptPwd1 = EncryptUtils.encryptMD5ToString(pwd1);
                //因为后台规定了密码长度，所以我们处理一下
                encryptPwd1 = encryptPwd1.substring(0, 6);

                // TODO: 2020/2/13 去注冊
                presenter.register(phone1, encryptPwd1);
                break;
        }
    }
}
