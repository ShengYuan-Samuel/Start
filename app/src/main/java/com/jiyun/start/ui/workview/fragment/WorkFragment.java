package com.jiyun.start.ui.workview.fragment;


import android.view.View;

import com.jiyun.start.App;
import com.jiyun.start.R;
import com.jiyun.start.base.BaseFragment;
import com.jiyun.start.ui.HomeActivity;

public class WorkFragment extends BaseFragment {




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void updateTitle() {
        ((HomeActivity)(App.context)).getTitleBar().setVisibility(View.VISIBLE);
        ((HomeActivity)(App.context)).getImageShape().setVisibility(View.VISIBLE);
        ((HomeActivity)(App.context)).getImageValuable().setVisibility(View.INVISIBLE);
        ((HomeActivity)(App.context)).getTitleLogo().setVisibility(View.VISIBLE);
    }
}
