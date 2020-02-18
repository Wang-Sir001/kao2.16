package com.bawei.kao216.model;

import com.bawei.kao216.api.Api;
import com.bawei.kao216.api.OrderApiServise;
import com.bawei.kao216.contract.IOrderContract;
import com.bawei.kao216.model.entity.OrderEntity;
import com.bawei.kao216.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderformModel implements IOrderContract.IModel {
    @Override
    public void getOrderfromData(int userId, String sessionId, int status, int page, int count, ModelCallback modelCallback) {
        NetUtils.getInstance().getClear(OrderApiServise.class)
                .getOrderformData(userId,sessionId,status,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderEntity orderEntity) {
                        if ("0000".equals(orderEntity.getStatus())){
                            modelCallback.success(orderEntity);
                        }else {
                            modelCallback.failure(new Exception(orderEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
