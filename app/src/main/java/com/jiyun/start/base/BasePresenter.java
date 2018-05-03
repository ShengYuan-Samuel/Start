package com.jiyun.start.base;

public interface BasePresenter<T> {

     void attachView(T t);
     void detachView();
}
