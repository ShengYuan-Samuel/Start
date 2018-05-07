package com.jiyun.start.presenter;

import com.jiyun.start.contract.LoginContract;
import com.jiyun.start.model.biz.LoginServive;
import com.jiyun.start.model.entity.LoginUserBean;
import com.jiyun.start.model.http.RetrofitUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class LoginPresenter implements LoginContract.Presenter{
    LoginContract.View view;
    private final LoginServive loginService;

    public LoginPresenter() {
        loginService = RetrofitUtils.getInstance().getLoginService();

    }

    @Override
    public void getLoginData(String phone, String psw) {
        loginService.getLoginData(phone,psw)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginUserBean responseBody) {
                        view.showLoginData(responseBody);

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
    public void attachView(LoginContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
