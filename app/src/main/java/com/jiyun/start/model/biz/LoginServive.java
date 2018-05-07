package com.jiyun.start.model.biz;

import com.jiyun.start.model.entity.LoginUserBean;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginServive {

    @FormUrlEncoded
    @POST("v1/m/user/login/mobile")
    Observable<LoginUserBean> getLoginData(@Field("mobile") String phone, @Field("password") String psw);
}
