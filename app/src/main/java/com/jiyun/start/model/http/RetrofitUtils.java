package com.jiyun.start.model.http;


import android.text.TextUtils;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.start.App;
import com.jiyun.start.model.biz.ForgetPswService;
import com.jiyun.start.model.biz.HomeWorkService;
import com.jiyun.start.model.biz.InFoUserService;
import com.jiyun.start.model.biz.LoginServive;
import com.jiyun.start.model.biz.MyUserInFoService;
import com.jiyun.start.model.biz.ReigsterService;
import com.jiyun.start.model.biz.ResetService;
import com.jiyun.start.model.config.Urls;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils retiofitUtils;
    private final Retrofit retrofit;

    public RetrofitUtils() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(response.cacheControl().toString())) {
                    return response.newBuilder().addHeader("Cache-Control", "max-age=60*60*24").build();
                }
                Headers headers = response.headers();
                Set<String> keys = headers.names();
                for (String key : keys) {
                    String value = headers.get(key);
                    Log.d("RetrofitUtils", key + ":" + value);
                    if (("Set-Cookie").equals(key)){
                        String cookie = headers.get(key);
                        //UserInFoUtils.getInstance().saveVerifycode(headers.get(key));
                        Log.d("RetrofitUtils", cookie);
                    }
                }
                return response;
            }
        };
        Cache cache1 = new Cache(App.context.getCacheDir(), 1024 * 1024 * 20);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cache(cache1)
                .addNetworkInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Urls.APPSERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitUtils getInstance() {
        if (retiofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retiofitUtils == null)
                    retiofitUtils = new RetrofitUtils();
            }
        }
        return retiofitUtils;
    }

    public ReigsterService getReigsterService(){
        return retrofit.create(ReigsterService.class);
    }
    public LoginServive getLoginService(){
        return retrofit.create(LoginServive.class);
    }
    public ForgetPswService getForgetPswService(){
        return retrofit.create(ForgetPswService.class);
    }
    public ResetService getResetPswService(){
        return retrofit.create(ResetService.class);
    }
    public HomeWorkService getHomeWorkService(){
        return retrofit.create(HomeWorkService.class);
    }

    public MyUserInFoService getMyUserInFoService(){
        return retrofit.create(MyUserInFoService.class);
    }

    public InFoUserService getInFoUserService(){
        return retrofit.create(InFoUserService.class);
    }
}
