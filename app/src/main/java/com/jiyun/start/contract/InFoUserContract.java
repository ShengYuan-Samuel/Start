package com.jiyun.start.contract;

import com.jiyun.start.base.BasePresenter;

import java.io.File;

public interface InFoUserContract {

    interface View{
        void showUpLoadImgData(String data);

    }
    interface Presenter extends BasePresenter<View>{
        void uploadImg(File file);
    }
}
