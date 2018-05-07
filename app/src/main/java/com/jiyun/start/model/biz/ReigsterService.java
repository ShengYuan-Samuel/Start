package com.jiyun.start.model.biz;

import com.jiyun.start.model.config.Urls;
import com.jiyun.start.model.entity.RegistUserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ReigsterService {
    @FormUrlEncoded
    @POST(Urls.PHONECODE_URL)
    Observable<ResponseBody> getReigsterCode(@Field("mobile") String phone);

    @FormUrlEncoded
    @POST(Urls.PHONEREGISTER_URL)
    Observable<RegistUserBean> getReigsterData(@Field("mobile") String phone, @Field("mobileValidCode") String code);

   /* //上传头像到服务器
    @Multipart
    @POST("/v1/m/qiniu/qiniuUpload")
    Observable<ResponseBody> uploadImg(@Header("apptoken") String token ,@Part List<MultipartBody.Part> file);*/
   @POST("v1/m/qiniu/qiniuUpload")
   Observable<ResponseBody> uploadImg(@Body RequestBody body);


    //这是把信息提交给服务器
    @FormUrlEncoded
    @POST("/v1/m/user/saveCompleteUser")
    Observable<ResponseBody> upCompleteuser(@Field("nickname") String nickname,
                                                     @Field("photo") String photo,
                                                     @Field("mobile") String mobile,
                                                     @Field("psw") String psw,
                                                     @Field("sex")int sex);
}
