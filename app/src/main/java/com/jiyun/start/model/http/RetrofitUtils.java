package com.jiyun.start.model.http;


import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.start.App;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
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
                return response;
            }
        };
        Cache cache1 = new Cache(App.context.getCacheDir(), 1024 * 1024 * 20);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cache(cache1)
                .addNetworkInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("")
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


}
