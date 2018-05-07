package com.jiyun.start.model.biz;

import com.jiyun.start.model.entity.HomeWorkBean;
import com.jiyun.start.model.entity.TokenBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface HomeWorkService {
    //这是请求token
    @POST("v1/m/security/apptoken")
    Observable<TokenBean> getToken();

    //这是获取homework数据的
    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<HomeWorkBean> getHomeWorkData(@Header("apptoken") String token, @FieldMap Map<String,String>patams);

}
