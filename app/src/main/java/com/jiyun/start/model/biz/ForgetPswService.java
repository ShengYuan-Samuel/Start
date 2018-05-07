package com.jiyun.start.model.biz;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ForgetPswService {
    //这是忘记密码获取手机验证码的
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> getForgetPswCode(@Field("mobile") String mobile);
    //这是将手机号和验证码提交给服务器
    @FormUrlEncoded
    @POST("/v1/m/user/verify/authcode")
    Observable<ResponseBody> getForgetUser(@Field("mobile")String mobile,
                                           @Field("authCode")String authCode);
}
