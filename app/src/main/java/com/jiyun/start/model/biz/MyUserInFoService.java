package com.jiyun.start.model.biz;




import com.jiyun.start.model.entity.LoginUserOkBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface MyUserInFoService {
    @FormUrlEncoded
    @POST("v1/m/user/my")
    Observable<LoginUserOkBean> getUserInfo(@Field("loginUserId") Integer id);
}
