package com.jiyun.start.ui.myview.fragment;


import android.view.View;

import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseFragment;
import com.jiyun.start.ui.HomeActivity;

public class MyFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void updateTitle() {
        ((HomeActivity)(App.context)).getTitleBar().setVisibility(View.GONE);
    }
}
