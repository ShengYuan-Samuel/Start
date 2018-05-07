package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;

import java.io.File;

import retrofit2.http.Field;

public interface ComplteteContract {
    interface View{
        void showUpLoadImgData(String str);
        void shoeCompleteUserData(String data);

    }
    interface Presenter extends BasePresenter<View> {
        //这是上传图片的
        void uploadImg(File file);
        //这是上传信息到服务器的
        void upCompleteuser( String nickname,String photo,String mobile,String psw,int sex );

    }


}
