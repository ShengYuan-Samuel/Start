package com.jiyun.start.model.biz;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ResetService {
    @FormUrlEncoded
    @POST("/v1/m/user/save/password")
    Observable<ResponseBody> resetPassword(@Field("mobile") String mobile, @Field("password") String password);
}
