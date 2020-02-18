package com.bawei.kao216.api;

import com.bawei.kao216.model.entity.LoginEntity;
import com.bawei.kao216.model.entity.RegisterEntity;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApiServise {
    @POST("small/user/v1/register")
    @FormUrlEncoded
    Observable<RegisterEntity> reg(@Field("phone") String phone,@Field("pwd") String pwd);

    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<LoginEntity> log(@Field("phone") String phone, @Field("pwd")String pwd);
}
