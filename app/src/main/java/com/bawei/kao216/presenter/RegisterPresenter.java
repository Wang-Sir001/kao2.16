package com.bawei.kao216.presenter;

import com.bawei.kao216.base.mvp.BasePresenter;
import com.bawei.kao216.contract.ILogContract;
import com.bawei.kao216.model.RegisterModel;
import com.bawei.kao216.model.entity.LoginEntity;
import com.bawei.kao216.model.entity.RegisterEntity;

public class RegisterPresenter extends BasePresenter<RegisterModel, ILogContract.IView> implements ILogContract.IPresenter {
    @Override
    protected RegisterModel initModel() {
        return new RegisterModel();
    }

    @Override
    public void register(String phone, String pwd) {
        model.register(phone, pwd, new ILogContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSuccess(RegisterEntity registerEntity) {
                getView().onRegisterSuccess(registerEntity);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                getView().onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginEntity loginEntity) {
                getView().onLoginSuccess(loginEntity);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                getView().onLoginFailure(throwable);
            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        model.login(phone, pwd, new ILogContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSuccess(RegisterEntity registerEntity) {
                getView().onRegisterSuccess(registerEntity);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                getView().onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginEntity loginEntity) {
                getView().onLoginSuccess(loginEntity);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                getView().onLoginFailure(throwable);
            }
        });
    }
}
