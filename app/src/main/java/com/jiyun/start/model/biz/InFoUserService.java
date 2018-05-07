package com.jiyun.start.model.biz;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface InFoUserService {
    @Multipart
    @POST("/v1/m/qiniu/qiniuUpload")
    Observable<ResponseBody> uploadImg(@Part List<MultipartBody.Part> file);
}
