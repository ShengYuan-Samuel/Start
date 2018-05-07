package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;
import com.jiyun.start.model.entity.HomeWorkBean;
import com.jiyun.start.model.entity.TokenBean;

public interface HomeWorkContract {

    interface View{
        void showToken(TokenBean tokenBean);
        void showHomeWorkData(HomeWorkBean data);
    }
    interface Presenter extends BasePresenter<View>{
        void getToken();
        void getHomeWorkData(String loginUserId,String page,String sortord);
    }
}
