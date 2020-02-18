package com.bawei.kao216.model;

import com.bawei.kao216.api.UserApiServise;
import com.bawei.kao216.contract.ILogContract;
import com.bawei.kao216.model.entity.LoginEntity;
import com.bawei.kao216.model.entity.RegisterEntity;
import com.bawei.kao216.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements ILogContract.IModel {
    @Override
    public void register(String phone, String pwd, IModelCallback iModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .reg(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterEntity registerEntity) {
                        if ("0000".equals(registerEntity.getStatus())){
                            iModelCallback.onRegisterSuccess(registerEntity);
                        }else {
                            iModelCallback.onRegisterFailure(new Exception(registerEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void login(String phone, String pwd, IModelCallback iModelCallback) {
        NetUtils.getInstance().getClear(UserApiServise.class)
                .log(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        if ("0000".equals(loginEntity.getStatus())) {
                            iModelCallback.onLoginSuccess(loginEntity);
                        } else {
                            iModelCallback.onLoginFailure(new Exception(loginEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
