package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;

import retrofit2.http.Field;

public interface ForgetPswContract {
    interface View{
        void showForgetPhoneCode(String data);
        void shoeForgetPhone(String data);


    }
    interface Presenter extends BasePresenter<View> {
        void getForgetPswCode(String phone);
        void getForgetUser(String mobile,String phoneCode);
    }
}
