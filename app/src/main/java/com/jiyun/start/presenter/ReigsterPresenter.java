package com.jiyun.start.presenter;

import com.jiyun.start.contract.ReigsterContract;
import com.jiyun.start.model.biz.ReigsterService;
import com.jiyun.start.model.entity.RegistUserBean;
import com.jiyun.start.model.http.RetrofitUtils;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ReigsterPresenter implements ReigsterContract.Presenter{
    private ReigsterContract.View view;
    private final ReigsterService reigsterService;

    public ReigsterPresenter() {
        reigsterService = RetrofitUtils.getInstance().getReigsterService();
    }

    @Override
    public void getReigsterCode(String phone) {
        reigsterService.getReigsterCode(phone)
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
                            view.showReigsterCode(string);
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
    public void getReigsterData(String phone, String code) {
        reigsterService.getReigsterData(phone,code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegistUserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegistUserBean responseBody) {

                            view.showReigsterData(responseBody);


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
    public void attachView(ReigsterContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
