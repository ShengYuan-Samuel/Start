package com.jiyun.start.model.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.start.App;

public class SavaShareUtils {
    private static SavaShareUtils savaShareUtils;
    private final SharedPreferences sharedPreferences;

    public SavaShareUtils() {
        sharedPreferences = App.context.getSharedPreferences("start", Context.MODE_PRIVATE);

    }

    public static SavaShareUtils getInstance(){
        if (savaShareUtils == null){
            synchronized (SavaShareUtils.class){
                if (savaShareUtils == null)
                    savaShareUtils = new SavaShareUtils();
            }
        }
        return savaShareUtils;
    }

    public void saveToken(String token){
        sharedPreferences.edit().putString("token",token).commit();
    }
    public String getToken(){
        return sharedPreferences.getString("token","");
    }

    public void setUserToken(String token){
        sharedPreferences.edit().putString("userToken",token).commit();
    }
    public String getUserToken(){
        return sharedPreferences.getString("userToken","");
    }

    //这是保存userId的方法
    public void setUserId(int id){
        sharedPreferences.edit().putInt("userId",id).commit();
    }
    public int getUserId(){
        return sharedPreferences.getInt("userId",0);
    }
    public void clearId(){
        sharedPreferences.edit().remove("userId").commit();
    }
}
