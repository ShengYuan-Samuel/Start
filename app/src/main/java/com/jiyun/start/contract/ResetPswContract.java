package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;

public interface ResetPswContract {

    interface View{
        void showResetPassWord(String data);

    }
    interface Presenter extends BasePresenter<View>{
        void resetPassword(String phone,String psw);
    }
}
