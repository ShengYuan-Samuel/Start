package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;
import com.jiyun.start.model.entity.LoginUserBean;

import retrofit2.http.Field;

public interface LoginContract {

    interface View{
        void showLoginData(LoginUserBean data);


    }
    interface Presenter extends BasePresenter<View> {
        void getLoginData(String phone,  String psw);
    }
}
