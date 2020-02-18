package com.bawei.kao216.contract;

import com.bawei.kao216.base.mvp.IBaseModel;
import com.bawei.kao216.base.mvp.IBaseView;
import com.bawei.kao216.model.entity.OrderEntity;

public interface IOrderContract {
    interface IModel extends IBaseModel {
        void getOrderfromData(int userId,String sessionId,int status,int page,int count,ModelCallback modelCallback);

        interface ModelCallback{
            void success(OrderEntity orderEntity);

            void failure(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void orderSuccess(OrderEntity orderEntity);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void getOrderfromData(int userId,String sessionId,int status,int page,int count);
    }
}
