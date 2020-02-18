package com.bawei.kao216.contract;

import com.bawei.kao216.base.mvp.IBaseModel;
import com.bawei.kao216.base.mvp.IBaseView;
import com.bawei.kao216.model.entity.LoginEntity;
import com.bawei.kao216.model.entity.RegisterEntity;

public interface ILogContract {
    interface IModel extends IBaseModel {
        void register(String phone,String pwd,IModelCallback iModelCallback);
        void login(String phone,String pwd,IModelCallback iModelCallback);

        interface IModelCallback{
            void onRegisterSuccess(RegisterEntity registerEntity);
            void onRegisterFailure(Throwable throwable);

            void onLoginSuccess(LoginEntity loginEntity);
            void onLoginFailure(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void onRegisterSuccess(RegisterEntity registerEntity);
        void onRegisterFailure(Throwable throwable);

        void onLoginSuccess(LoginEntity loginEntity);
        void onLoginFailure(Throwable throwable);
    }
    interface IPresenter{
        void register(String phone, String pwd);

        void login(String phone, String pwd);
    }
}
