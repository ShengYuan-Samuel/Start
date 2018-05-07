package com.jiyun.start.presenter;

import com.jiyun.start.contract.ResetPswContract;
import com.jiyun.start.model.biz.ResetService;
import com.jiyun.start.model.http.RetrofitUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ResetPswPresenter implements ResetPswContract.Presenter {
    private ResetPswContract.View view;
    private final ResetService resetPswService;

    public ResetPswPresenter() {
        resetPswService = RetrofitUtils.getInstance().getResetPswService();
    }

    @Override
    public void resetPassword(String phone, String psw) {
        resetPswService.resetPassword(phone,psw)
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
                            view.showResetPassWord(string);
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
    public void attachView(ResetPswContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
