package com.jiyun.start.presenter;

import com.jiyun.start.contract.ForgetPswContract;
import com.jiyun.start.model.biz.ForgetPswService;
import com.jiyun.start.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.Scanner;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ForgetPswPresenter implements ForgetPswContract.Presenter{

    private  ForgetPswService forgetPswService;
    private ForgetPswContract.View view;
    public ForgetPswPresenter() {
        forgetPswService = RetrofitUtils.getInstance().getForgetPswService();
    }

    @Override
    public void getForgetPswCode(String phone) {
        forgetPswService.getForgetPswCode(phone)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            view.showForgetPhoneCode(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
    public void getForgetUser(String mobile, String phoneCode) {
        forgetPswService.getForgetUser(mobile,phoneCode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            view.shoeForgetPhone(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

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
    public void attachView(ForgetPswContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
