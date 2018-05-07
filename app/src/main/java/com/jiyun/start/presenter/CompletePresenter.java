package com.jiyun.start.presenter;

import android.util.Log;

import com.jiyun.start.contract.ComplteteContract;
import com.jiyun.start.model.biz.ReigsterService;
import com.jiyun.start.model.http.RetrofitUtils;
import com.jiyun.start.model.utils.SavaShareUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class CompletePresenter implements ComplteteContract.Presenter{

    private ComplteteContract.View view;
    private final ReigsterService reigsterService;

    public CompletePresenter() {
        reigsterService = RetrofitUtils.getInstance().getReigsterService();
    }

    @Override
    public void uploadImg(File file) {
       /* Log.d("CompletePresenter", file.getAbsolutePath());
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        builder.addFormDataPart("file",file.getName() , imageBody);
        List<MultipartBody.Part> parts = builder.build().parts();*/
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/jpg"), file)).build();
        reigsterService.uploadImg(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("CompletePresenter", "11111");

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Log.d("CompletePresenter", "22222");
                        try {
                            String string = responseBody.string();
                            view.showUpLoadImgData(string);
                        } catch (IOException e) {


                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("CompletePresenter", "33333");
                        view.showUpLoadImgData(e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d("CompletePresenter", "444444");

                    }
                });

    }

    @Override
    public void upCompleteuser(String nickname, String photo, String mobile, String psw, int sex) {
        reigsterService.upCompleteuser(nickname,photo,mobile,psw,sex)
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
                            view.shoeCompleteUserData(string);

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
    public void attachView(ComplteteContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;

    }
}
