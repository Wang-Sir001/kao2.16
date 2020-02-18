package com.bawei.kao216.api;

import com.bawei.kao216.model.entity.OrderEntity;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OrderApiServise {
    @GET("small/order/verify/v1/findOrderListByStatus")

    Observable<OrderEntity> getOrderformData(@Header("userId") int userId,
                                             @Header("sessionId") String sessionId,
                                             @Query("status") int status,
                                             @Query("page") int page,
                                             @Query("count") int count);
}
