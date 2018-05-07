package com.jiyun.start.presenter;

import com.jiyun.start.contract.MyUserInFoContract;
import com.jiyun.start.model.biz.MyUserInFoService;
import com.jiyun.start.model.entity.LoginUserOkBean;
import com.jiyun.start.model.http.RetrofitUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MyInfoPresenter implements MyUserInFoContract.Presenter{
    private MyUserInFoContract.View view;
    private final MyUserInFoService myUserInFoService;

    public MyInfoPresenter() {
        myUserInFoService = RetrofitUtils.getInstance().getMyUserInFoService();

    }

    @Override
    public void getUsetInfoData(int id) {
        myUserInFoService.getUserInfo(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginUserOkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginUserOkBean responseBody) {
                      view.showUserData(responseBody);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void attachView(MyUserInFoContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
