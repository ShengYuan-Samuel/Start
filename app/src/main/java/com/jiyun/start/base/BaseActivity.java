package com.jiyun.start.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.start.App;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayOutId());
        presenter = getPresenter();
        if (presenter!=null){
            presenter.attachView(this);
        }
        init();
        loadData();

    }

    private T getPresenter(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass.equals(BaseActivity.class))
            return null;
        Type[] arguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (arguments.length == 0)
            return null;
        Class<T> argument = (Class<T>) arguments[0];
        try {
            T type = argument.newInstance();
            return type;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.context = null;
        if (presenter!= null){
            presenter.detachView();
        }
    }

    //这是进行id更新的
    protected abstract int getLayOutId();
    //这是初始化组件的
    protected abstract void init();
    //这是更新数据的
    protected abstract void loadData();
    //这是统一管理标题的
    private BaseFragment lastFragment;

    public BaseFragment setContentView(int context, Class<? extends BaseFragment> classFragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String simpleName = classFragment.getSimpleName();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(simpleName);
            try {
                if (fragment == null){
                    fragment = classFragment.newInstance();
                    transaction.add(context,fragment,simpleName);
                }
                if (lastFragment != null){
                    transaction.hide(lastFragment);
                }
                transaction.show(fragment);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            lastFragment =fragment;
            transaction.commit();
             return fragment;

    }
}
