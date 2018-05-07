package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;
import com.jiyun.start.model.entity.RegistUserBean;

import retrofit2.http.Field;

public interface ReigsterContract {

    interface View{
        void showReigsterCode(String data);
        void showReigsterData(RegistUserBean data);


    }
    interface Presenter extends BasePresenter<View>{
        void getReigsterCode(String phone);
        void getReigsterData(String phone,String code);

    }
}
