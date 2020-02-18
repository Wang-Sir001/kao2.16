package com.bawei.kao216.presenter;

import com.bawei.kao216.base.mvp.BasePresenter;
import com.bawei.kao216.contract.ILogContract;
import com.bawei.kao216.contract.IOrderContract;
import com.bawei.kao216.model.OrderformModel;
import com.bawei.kao216.model.entity.OrderEntity;

public class OrderPresenter extends BasePresenter<OrderformModel, IOrderContract.IView> implements IOrderContract.IPresenter {
    @Override
    protected OrderformModel initModel() {
        return new OrderformModel();
    }

    @Override
    public void getOrderfromData(int userId, String sessionId, int status, int page, int count) {
        model.getOrderfromData(userId, sessionId, status, page, count, new IOrderContract.IModel.ModelCallback() {
            @Override
            public void success(OrderEntity orderEntity) {
                getView().orderSuccess(orderEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
