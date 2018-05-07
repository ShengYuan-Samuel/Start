package com.jiyun.start.presenter;

import android.util.Log;

import com.jiyun.start.contract.HomeWorkContract;
import com.jiyun.start.model.biz.HomeWorkService;
import com.jiyun.start.model.entity.HomeWorkBean;
import com.jiyun.start.model.entity.TokenBean;
import com.jiyun.start.model.http.RetrofitUtils;
import com.jiyun.start.model.utils.EncryptUtil;
import com.jiyun.start.model.utils.SavaShareUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class HomeWorkPresenter implements HomeWorkContract.Presenter {
    private HomeWorkContract.View view;
    private final HomeWorkService homeWorkService;

    public HomeWorkPresenter() {
        homeWorkService = RetrofitUtils.getInstance().getHomeWorkService();

    }

    @Override
    public void getToken() {
        homeWorkService.getToken()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TokenBean tokenBean) {
                        String apptoken = tokenBean.getData().getApptoken();
                        long time = System.currentTimeMillis();
                        try {
                            String desApptoken= EncryptUtil.decrypt(apptoken);
                            String headerApptoken=EncryptUtil.encrypt(time + desApptoken).replaceAll("\\n","").toUpperCase();
                            String token = headerApptoken + "." + time;
                            Log.d("HomeWorkPresenter", token);
                            SavaShareUtils.getInstance().saveToken(token);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        view.showToken(tokenBean);
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
    public void getHomeWorkData(String loginUserId, String page, final String sortord) {
        Map<String,String> params = new HashMap<>();
        params.put("loginUserId",loginUserId);
        params.put("page",page);
        params.put("sortord",sortord);

        homeWorkService.getHomeWorkData(SavaShareUtils.getInstance().getToken(),params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeWorkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeWorkBean responseBody) {
                        view.showHomeWorkData(responseBody);

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
    public void attachView(HomeWorkContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
