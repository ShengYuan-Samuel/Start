package com.jiyun.start.contract;

import android.util.Log;

import com.jiyun.start.base.BasePresenter;
import com.jiyun.start.model.entity.LoginUserOkBean;

public interface MyUserInFoContract {
    interface View{
     void showUserData(LoginUserOkBean userInfo);

    }
    interface Presenter extends BasePresenter<View>{
        void getUsetInfoData(int id);

    }
}
